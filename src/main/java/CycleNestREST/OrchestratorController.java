package CycleNestREST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrchestratorController {

    private final StorageService storageService;

    @Autowired
    public OrchestratorController(StorageService storageService) {
        System.out.println(">>> OrchestratorController INITIALIZED <<<");
        this.storageService = storageService;
    }

    @GetMapping("/")
    public String home() {
        return "CycleNest Orchestrator is running! Try /api/items to see items.";
    }

    @GetMapping("/items")
    public List<Item> getItems(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) String location) {
        if (keyword == null && maxPrice == null && location == null) {
            return storageService.getAllItems();
        }
        return storageService.searchItems(keyword, maxPrice, location);
    }

    @PostMapping("/requests")
    public ResponseEntity<RentalRequest> createRequest(@RequestBody RentalRequest request) {
        try {
            RentalRequest created = storageService.createRequest(request.getItemId(), request.getRequesterId());
            return ResponseEntity.ok(created);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/requests/{id}/cancel")
    public ResponseEntity<Void> cancelRequest(@PathVariable String id) {
        storageService.cancelRequest(id);
        return ResponseEntity.ok().build();
    }
}
