package CycleNestREST;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;

@Service
public class MockStorageService implements StorageService {
    private List<Item> items;
    private List<RentalRequest> requests;

    public MockStorageService() {
        items = new ArrayList<>();
        requests = new ArrayList<>();
    }

    @PostConstruct
    public void initData() {
        // Data from cycle_nest_items06 - city.json
        items.add(new Item("i002", "u002", "4-Person Tent", "Camping", "Leeds", 8.0, true, "Excellent",
                "Spacious and waterproof tent, perfect for family camping trips."));
        items.add(new Item("i003", "u003", "Electric Scooter", "Transport", "Nottingham", 10.0, false, "Fair",
                "Foldable electric scooter with a 25km range. Great for city commuting."));
        items.add(new Item("i004", "u004", "DSLR Camera", "Photography", "Birmingham", 15.0, true, "Like New",
                "Canon EOS 80D with 18-135mm lens. Ideal for events and travel."));
        items.add(new Item("i005", "u005", "Electric Drill", "Tools", "Sheffield", 5.0, true, "Good",
                "Cordless drill with multiple bits. Suitable for home DIY projects."));
        items.add(new Item("i006", "u006", "Inflatable Kayak", "Water Sports", "Liverpool", 20.0, true, "Very Good",
                "Two-person inflatable kayak with paddles and pump included."));
    }

    @Override
    public List<Item> getAllItems() {
        return items;
    }

    @Override
    public Item getItem(String id) {
        return items.stream()
                .filter(i -> i.getItem_id().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Item> searchItems(String keyword, Double maxPrice, String location) {
        return items.stream()
                .filter(i -> {
                    boolean matches = true;
                    if (keyword != null && !keyword.isEmpty()) {
                        String k = keyword.toLowerCase();
                        matches = matches && (i.getName().toLowerCase().contains(k)
                                || i.getDescription().toLowerCase().contains(k)
                                || i.getCategory().toLowerCase().contains(k));
                    }
                    if (maxPrice != null) {
                        matches = matches && (i.getDaily_rate() <= maxPrice);
                    }
                    if (location != null && !location.isEmpty()) {
                        matches = matches && i.getLocation().equalsIgnoreCase(location);
                    }
                    return matches;
                })
                .collect(Collectors.toList());
    }

    @Override
    public RentalRequest createRequest(String itemId, String requesterId) {
        // Verify item exists
        Item item = getItem(itemId);
        if (item == null) {
            throw new IllegalArgumentException("Item not found: " + itemId);
        }

        String reqId = UUID.randomUUID().toString();
        RentalRequest req = new RentalRequest(reqId, itemId, requesterId, "pending");
        requests.add(req);
        return req;
    }

    @Override
    public RentalRequest getRequest(String requestId) {
        return requests.stream()
                .filter(r -> r.getRequestId().equals(requestId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void cancelRequest(String requestId) {
        RentalRequest req = getRequest(requestId);
        if (req != null) {
            req.setStatus("cancelled");
        }
    }
}
