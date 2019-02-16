package VirtualGroceryStore;

import java.util.Scanner;

/**
 * Basic shopping program with items, prices and a cart.
 *
 * @author James Clark
 * @version 12/11/2016
 */
public class VirtualGroceryStore {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //intitializing items list, cart, and number of items
        Item[] availableItems = new Item[5];
        Cart cart = new Cart();
        int items = 0;

        //Available Items
        availableItems[0] = new Item("Eggs", 2.99);
        availableItems[1] = new Item("Milk", 3.99);
        availableItems[2] = new Item("Broccoli", 2.75);
        availableItems[3] = new Item("Bread", 3.25);
        availableItems[4] = new Item("Apple", 1.25);

        //Greeting message
        System.out.println("Welcome to the virtual grocery store!");

        //User input variable
        int main = 0;

        //loop continues until User says to quit
        while (main != 5) {

            //list of actions
            System.out.println("What would you like to do?");
            System.out.println("1: View available items");
            System.out.println("2: View your cart");
            System.out.println("3: Add an item to you cart");
            System.out.println("4: Remove an item from your cart");
            System.out.println("5: Check out");
            System.out.print("Enter your choice: ");

            main = input.nextInt();

            //bound check
            while (main >= 6 || main <= 0) {
                System.out.println("Invalid choice. Please re-enter choice: ");
                main = input.nextInt();
            }

            System.out.println();

            //Carrys out requested action
            switch (main) {

                //prints list of available items
                case 1:
                    System.out.println("Available Items:");
                    for (int i = 0; i < availableItems.length; i++) {
                        System.out.print(i + ": ");
                        availableItems[i].print();
                    }
                    break;

                //Prints cart inventory and total price
                case 2:
                    cart.printItems();
                    System.out.println();
                    System.out.println("Your total: $" + cart.getTotal());
                    break;

                //Allows user to add something to cart
                case 3:
                    System.out.print("Please enter the number of the item desired: ");
                    int pick = input.nextInt();

                    //bound check
                    while (pick < 0 || pick >= 5) {
                        System.out.print("Invalid choice. Please select again: ");
                        pick = input.nextInt();
                    }
                    cart.addItem(availableItems[pick]);
                    items++;
                    System.out.println("Item added.");
                    break;

                //Allows user to remove something from cart.
                case 4:
                    //bound check
                    if (items == 0) {
                        System.out.println("You have no items in your cart to remove.");
                        break;
                    } else {
                        System.out.println("What is the number of the item would you like to remove?");
                        cart.printItems();

                        System.out.print("Your choice: ");
                        //number of item wanted to be removed
                        int remove = input.nextInt();
                        //bound check
                        while (remove >= items || remove < 0) {
                            System.out.print("Invalid choice. Please re-enter: ");
                            remove = input.nextInt();
                        }
                        cart.removeItem(remove);
                        items--;
                        System.out.println("Item Removed.");
                        break;
                    }

                //prints out total price and exits program
                case 5:
                    System.out.println("That will be $" + cart.getTotal());
                    System.out.println("Thank You!");
                    break;
            }
            System.out.println();
        }
    }

}

class Item {

    //Item name
    private String name;
    //Item price
    private double price;

    /**
     * Item Constructor
     *
     * @param newName name of new item
     * @param newPrice price of new item
     */
    public Item(String newName, double newPrice) {
        name = newName;
        price = newPrice;
    }

    /**
     * Prints item in proper format
     */
    public void print() {
        System.out.println(name + ": $" + price);
    }

    /**
     * @return price of item
     */
    public double getPrice() {
        return price;
    }
}

class Cart {

    //Array to hold items in cart
    private Item[] items;
    //number of items in cart
    private int numItems;

    /**
     * Cart Constructor
     */
    public Cart() {
        items = new Item[100];
        numItems = 0;
    }

    /**
     * Adds item to cart
     *
     * @param item item being added
     */
    public void addItem(Item item) {
        items[numItems] = item;
        numItems++;
    }

    /**
     * Prints all items in cart
     */
    public void printItems() {
        if (numItems == 0) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Your Cart:");
            for (int i = 0; i < numItems; i++) {
                System.out.print(i + ": ");
                items[i].print();
            }
        }
    }

    /**
     * @return total price
     */
    public double getTotal() {
        double total = 0;
        for (int i = 0; i < numItems; i++) {
            total += items[i].getPrice();
        }
        return total;
    }

    /**
     * Allows user to remove an item from their cart.
     * @param item number corresponding to the item the user wants removed
     */
    public void removeItem(int item) {
        items[item] = items[numItems - 1];
        numItems--;

    }
}
