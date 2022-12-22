package prog;

import java.io.Console;

import cart.ShoppingCart;

public class Main {

    // This is how you declare constant
    // Declare constants for the commands
    public static final String CHECKOUT = "checkout";
    public static final String ADD = "add";
    public static final String REMOVE = "remove";
    public static final String LIST = "list";

    public static void main(String[] args) {
        // Get an instance of Console object
        Console cons = System.console();

        // Boolean to control the command line loop
        Boolean stop = false;

        // Create a new ShoppingCart object
        ShoppingCart shoppingCart = new ShoppingCart();

        while (!stop) {
            // Read a line from the console
            String line = cons.readLine("> ");
            // Split the line into an array of terms
            String[] terms = line.trim().split(" ");

            // Check the first term to determine the command
            switch (terms[0]) {
                // checkout or checkout .03
                case CHECKOUT:
                    Float discount = 0f;
                    // Check if discount is applied
                    if (terms.length > 0)
                        discount = Float.parseFloat(terms[1]);
                    // Calculate the total cost of the items in the shopping cart, applying the discount if provided
                    shoppingCart.calculate(discount);
                    // Set stop to true to exit the loop
                    stop = true;
                    break;

                // add apple quantity price
                case ADD:
                    // Get the item, quantity, and price from the command line
                    String item = terms[1];
                    Integer quantity = Integer.parseInt(terms[2]);
                    Float price = Float.parseFloat(terms[3]);
                    // Add the item to the shopping cart
                    if (shoppingCart.addToCart(item, quantity, price))
                        System.out.printf("%s added to your shopping cart\n", item);
                    else
                        System.err.printf("%s is not in our inventory.\n", item);
                    break;

                // remove 3
                case REMOVE:
                    // Get the index of the item to remove
                    Integer index = Integer.parseInt(terms[1]);
                    // Remove the item from the shopping cart
                    if (shoppingCart.removeFromCart(index))
                        System.out.println("Item removed from shopping cart");
                    else
                        System.out.println("Cannot find item in the shopping cart");
                    break;

                // list
                case LIST:
                    // List the contents of the shopping cart
                    shoppingCart.listContents();
                    break;

                default:
                    // Unknown command
                    System.out.printf("Unknown command: %s\n", terms[0]);
            }
            // Add a blank line for readability
            System.out.println();
        }
        // End of the command line loop
        System.out.println("Thank you for shopping with us");
    }
    
}