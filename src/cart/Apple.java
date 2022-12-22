package cart;

public class Apple extends Item {

    // Private member variable for storing the type of apple
    private String type;

    // Constructor for initializing an apple with its code and name
    public Apple() {
        super("c-apple", "Apple");
    }

    // Getters and setters for accessing and updating the type of apple
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

}