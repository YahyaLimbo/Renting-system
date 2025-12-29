package CycleNestREST;

import java.util.List;

public interface StorageService {
    List<Item> getAllItems();

    Item getItem(String id);

    List<Item> searchItems(String keyword, Double maxPrice, String location);

    RentalRequest createRequest(String itemId, String requesterId);

    RentalRequest getRequest(String requestId);

    void cancelRequest(String requestId);
}
