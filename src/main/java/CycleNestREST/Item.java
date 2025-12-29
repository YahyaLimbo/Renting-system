package CycleNestREST;

public class Item {
    private String item_id;
    private String owner_id;
    private String name;
    private String category;
    private String location;
    private double daily_rate;
    private boolean available;
    private String condition;
    private String description;

    public Item() {
    }

    public Item(String item_id, String owner_id, String name, String category, String location, double daily_rate,
            boolean available, String condition, String description) {
        this.item_id = item_id;
        this.owner_id = owner_id;
        this.name = name;
        this.category = category;
        this.location = location;
        this.daily_rate = daily_rate;
        this.available = available;
        this.condition = condition;
        this.description = description;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(String owner_id) {
        this.owner_id = owner_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getDaily_rate() {
        return daily_rate;
    }

    public void setDaily_rate(double daily_rate) {
        this.daily_rate = daily_rate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
