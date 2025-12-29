package CycleNestREST;

public class RentalRequest {
    private String requestId;
    private String itemId;
    private String requesterId;
    private String status; // "pending", "cancelled", "approved"

    public RentalRequest() {
    }

    public RentalRequest(String requestId, String itemId, String requesterId, String status) {
        this.requestId = requestId;
        this.itemId = itemId;
        this.requesterId = requesterId;
        this.status = status;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(String requesterId) {
        this.requesterId = requesterId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
