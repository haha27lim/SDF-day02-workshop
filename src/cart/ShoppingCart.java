package cart;

import java.util.LinkedList;
import java.util.List;

public class ShoppingCart {

    // Constants for item names
    public static final String APPLE = "apple";
    public static final String ORANGE = "orange";

    // A list to store the items in the cart
    private List<Item> cart;

    /**
     * Constructs a new empty ShoppingCart.
     */
    public ShoppingCart() {
        this.cart = new LinkedList<>();
    }

    // Lists the contents of the cart
    public void listContents() {
        // Check if the cart is empty
        if (cart.size() <= 0) {
            System.out.println("Your shopping cart is empty");
            return;
        }

        // Print the items in the cart
        System.out.println("Your shopping cart has the following items:");
        for (Integer i = 0; i < cart.size(); i++) {
            Item item = cart.get((int)i);
            System.out.printf("%d: %s, %d, $%.2f\n", i + 1, item.getName(), item.getQuantity(), item.getPrice());
        }
    }

    /**
     * Adds an item to the shopping cart.
     * @param item the name of the item to add (e.g., APPLE, ORANGE)
     * @param quantity the number of items to add
     * @param price the price of one item
     * @return true if the item was added successfully, false otherwise
     */
    public Boolean addToCart(String item, Integer quantity, Float price) {
        // Create an instance of the item to be added
        Item toAdd = null;
        switch (item) {
            case APPLE:
                toAdd = new Apple();
                break;

            case ORANGE:
                toAdd = new Orange();
                break;

            default:
                return false;
        }

        // Set quantity and price
        toAdd.setQuantity(quantity);
        toAdd.setPrice(price);
        this.cart.add(toAdd);

        return true;
    }

    // Removes an item from the cart
    public Boolean removeFromCart(Integer index) {
        // Check if the index is in the list range
        if ((index < 0) || (index >= this.cart.size()))
            return false;

        // return true if the item was removed successfully, false otherwise    
        this.cart.remove((int)index);
        return true;
    }
    // Calculates the total cost of the items in the shopping cart.
    public void calculate() {
        this.calculate(0f);
    }
    
    /**
    * Calculates the total cost of the items in the shopping cart, applying
    * a discount if specified.
    * @param discount the discount to apply, as a percentage (e.g., 0.1 for 10%)
    */
    public void calculate(Float discount) {
        Float total = 0f;
        // This is called the for-each loop. 
        // An alternative for loop, used only for arrays and collection
        // The for-each loops loops the contents
        for (Item item: this.cart) {
            Float subtotal = item.getPrice() * item.getQuantity();
            System.out.printf("%s [%s] %d@%.2f=$%.2f\n", 
                    item.getName(), item.getCode(), item.getQuantity(), item.getPrice(), subtotal);
            total += subtotal;
        }

        if (0 != discount) {
            System.out.printf("Applying a %2.2f%% discount to %f\n", discount, total);
            total -= (total * discount);
        }

        System.out.printf("Grand total: $%.2f\n", total);
    }
}