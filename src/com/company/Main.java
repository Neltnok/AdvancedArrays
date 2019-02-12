// The array should hold inventory items and count of items in inventory.
//The user should be able to search for any item and have the item name and amount on hand appear
// on screen (format them nicely).
// The user should be able to add or subtract from any of the inventory. Have an error message if the
// count would become less than 0, and set the count to 0. Display the name of the item, the original amount,
// the amount added or taken away, and the new total.


// Technically the video described using 2 one dimensional arrays rather than a single multi dimensional array
// I will follow the lead from the video as it leads to a simpler solution. A multi-dimensional array would get
// complicated jumping back from ints to strings as the array can be of only one type.


// Pseudo code
// create a method to display inventory items
// create a method to update inventory items
    // display a menu to have the user to select which item to update
    // query the user for the amount to add or subtract
    // if the amount for the item on hand goes negative inform the user and set the impacted item to 0 on hand.

// Create parallel arrays of size 5 to to hold the item description and the item counts
// populate the description array
// populate the itemCount array
// Display a menu that will allow the user to either display the inventory items, update an inventory item or exit



package com.company;
import java.util.Scanner;

public class Main {

    // create an object of type Scanner to manage user input.
    static Scanner scanner = new Scanner(System.in);

    // create a variable to handle user inputs
    static int userSelection = 0;

    // create an attribute to hold the description array
    static String[] description;

    // create an attribute to hold the corresponding item count
    static int[] itemCount;


// method: updateItemCount
// requirements: argument arrays must be initialized prior to calling this method
// results: 1. Display a menu to select which item to update
//          2. Query the user and get their selection
//          3. Display the description and current amount and query the user for the updated amount.
//          4. update the amount and display the updated descriptions and amounts.
//          5. Note: if the amount would go negative set the amount to zero and inform the user.

    public static void updateItemCount(String[] des, int[] items ){

        // create a variable to hold the item count input from the user
        int newItemCount;
        // corresponds to the menu choice of which item to update
        int itemToUpdate;

        // provide feedback to the user
        System.out.println("You selected update item count\n");
        // display the items on hand
        displayItems(des, items);

        // prompt the user for their selection of which item to update
        System.out.println("Please select an item to update 1 .. 5 to update or 0 to exit without updating");
        // get the users selection
        itemToUpdate = scanner.nextInt();

        // check for valid item selection or 0 to exit
        if(itemToUpdate < 6 && itemToUpdate > 0 ){
             System.out.println("You selected " + des[itemToUpdate - 1] + "  " + items[itemToUpdate - 1]);
             System.out.println("Enter the amount to add as a number or negative number to subtract");

             // get the input from the user
             newItemCount = scanner.nextInt();
             items[itemToUpdate - 1] += newItemCount;

             // do an error check for counts going below 0 and set item to 0, negative items not allowed
             if(items[itemToUpdate - 1] + newItemCount < 0){
                 System.out.println("Error, the item on Hand cannot be less then 0");
                 System.out.println("The item on hand for "+ des[itemToUpdate-1] + " will be set to Zero\n");
                 items[itemToUpdate-1] = 0;
             }
            else if(itemToUpdate == 0) {
                    System.out.println("You selected 0, no updates made to inventory");
            }       return;
        }
        System.out.println("You did not select an item between1" +
                " 1 and 5 exiting back to main menu");

    }

//*****************************************************************************
    // method: displayItems()
    // requirements: Items must be initialized, arguments are String and int array respectively
    // results: prints out the item description and corresponding item count.
    // include a numeric descriptor in the line so I can use this in the update item count description
    // prints an extra line to be tidy

    public static void displayItems(String[] des, int[] items){
        for(int i = 0; i < 5; i++) {
            System.out.println(i + 1 + ".." + des[i] + "\t\t" + items[i] + "\ton Hand");
        }
        System.out.println("");
    }
//*****************************************************************************

    public static void main(String[] args) {

        // declare the array of type String with a size of 5
        description = new String[5];

        // declare an array of type int to hold the count of the items in the supplies array
        int []      itemCount = new int[5];

        // initialize the supplies array

        description[0] = "Hot Dogs ";
        description[1] = "Hamburger";
        description[2] = "Fries    ";
        description[3] = "Ketchup  ";
        description[4] = "Mustard  ";


        // initialize the Itemcount array

        itemCount[0] = 5;   // corresponds to the number of Hot Dogs in our store
        itemCount[1] = 5;   // corresponds to the number of Hamburgers in our store
        itemCount[2] = 10;  // corresponds to the number of French fry packages in our store
        itemCount[3] = 10;  // corresponds to the number of Ketchup packs in our store
        itemCount[4] = 10;  // corresponds to the number of Mustard packs in our store


        do {
            System.out.println("\nPlease select one of the following");
            System.out.println("1 .. display an inventory items");
            System.out.println("2 .. update an inventory item count");
            System.out.println("3 .. exit the program");

            // get the users selection
            userSelection = scanner.nextInt();

            // parse the selection
            switch (userSelection) {

                case 1:
                    // call the display items method
                    displayItems(description, itemCount);
                    break;

                case 2:
                    // call the update item count method
                    updateItemCount(description, itemCount);
                    displayItems(description, itemCount);
                    break;

                case 3:
                    System.out.println("Program exiting, thank you");
                    break;

                default:
                    // default to handle incorrect user input
                    System.out.println("You must select 1, 2 or 3 please try again");
            }
        }
        // gracefule exit if the user selects 3 from the main menu
        while (userSelection != 3);
    }
}
