package cart;

public class Item {

    // Private member variables for storing item information
    private String code = "";
    private String name = "";
    private Float price = 0f;
    private Integer quantity = 0;

    // Constructor for initializing an item with its code and name
    public Item(String code, String name) {
        this.code = code;
        this.name = name;
    }

    // Getters and setters for accessing and updating item information
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Float getPrice() { return price; }
    public void setPrice(Float price) { this.price = price; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    // Method for calculating the total price of the item
    public Float totalPrice() {
        return this.price * this.quantity;
    }
    
}