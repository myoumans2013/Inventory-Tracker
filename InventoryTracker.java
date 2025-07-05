import java.util.ArrayList;
import java.util.Scanner;


public class InventoryTracker {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> inventory = new ArrayList<>();

        boolean running = true;
        try {
            // Create inventory menu
            while (running) {
                System.out.println("\n-- Inventory Menu --");
                System.out.println("1. Add Item");
                System.out.println("2. Remove Item");
                System.out.println("3. View inventory");
                System.out.println("4. Exit");
                System.out.print("Please select a choice: ");
                int choice = scan.nextInt(); // Read user choice
                scan.nextLine(); // Allows reading of the next user input

                // Choice cannot be greater than 4
                if (choice > 4) {
                    System.out.println("Please choose choices 1-4.");
                }

                switch (choice) {
                    case 1:
                        System.out.print("Enter the name of the item: ");
                        String item = scan.nextLine().toLowerCase().trim();
                        // Apply lower case to name of item
                        // Checking if item is in inventory
                        boolean item_duplicate = inventory.contains(item);
                        // If true, don't add item to inventory
                        if (item_duplicate) {
                            System.out.print("Cannot add duplicate items.");
                            System.out.println();
                        }
                        else {
                            // Add item to inventory
                            inventory.add(item);
                            System.out.println("Item added to inventory.");
                        }
                        break;

                    case 2:
                        System.out.print("What item do you want to remove? ");
                        String remove_item = scan.nextLine().toLowerCase().trim();
                        // Checks if item is in inventory array
                        boolean item_check = inventory.contains(remove_item);
                        // If item is in inventory remove the item
                        if (item_check) {
                            inventory.remove(remove_item);
                            System.out.println("Item removed.");
                        }
                        else {
                            System.out.println("Item not found.");
                        }
                        break;

                    case 3:
                        // Iterate through inventory array and print out inventory
                        int counter = 1;
                        for (int i = 0; i < inventory.size(); i++) {
                        String list = inventory.get(i);
                        System.out.println(counter + ". " + list);
                        counter += 1;
                    }
                        break;

                    case 4:
                        // Exit program
                        running = false;
                        System.out.println("Exiting InventoryTracker...");

                    default:
                        break;
                }


            }
        }
        catch (Exception e) {
            System.out.println("An error occurred, please retry.");


        }
    }
}
