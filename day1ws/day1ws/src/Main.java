import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // To Run It:
    // javac -d classes src/*.java
    // java -cp classes Main
    public static void main(String[] args) {
        // add multiple items inside.
        ShoppingCart shopCart = new ShoppingCart();
        // private the cart member variable, dont allow access.
        // shopCart.cart.add("appple");
        shopCart.addCart("apple");

        ArrayList<String> items = new ArrayList<String>();
        items.add("apple");
        items.add("durian");
        ShoppingCart shopCart2 = new ShoppingCart(items);

        startShopping();
    }

    public static void printArray(String[] arr) {
        for (String s : arr) {
            System.out.println(s);
        }
    }

    public static void startShopping() {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart shopCart = new ShoppingCart();
        // list, add, delete, exit
        // all program is a loop
        // while (true) means infinite, inside the loop can break to stop.
        System.out.println("Welcome to your shopping cart");
        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();
            // substring can extract just the first one.
            int firstSpaceIndex = command.indexOf(' ', 0);
            // "add orange, pear"
            String firstToken = command;
            String secondPart = "";
            if (firstSpaceIndex != -1) {
                // add
                firstToken = command.substring(0, firstSpaceIndex);
                // take the rest, +1 to skip the first spacebar.
                secondPart = command.substring(firstSpaceIndex + 1);
            }

            // System.out.println("firstToken=>'" + firstToken + "'");
            // System.out.println("secondPart=>'" + secondPart + "'");

            if (firstToken.equals("list")) {
                System.out.println(shopCart);
            } else if (firstToken.equals("add")) {
                // "orange, pear, lemon".split(", ") => ["orange", "pear", "lemon"]
                String tokens[] = secondPart.split(", ");

                // for range, for each loop
                for (String item : tokens) {
                    shopCart.addCart(item);
                }

                // for (int i = 0; i < tokens.length; ++i) {
                // String item = tokens[i];
                // shopCart.addCart(item);
                // }

            } else if (firstToken.equals("delete")) {
                // converting string to number.
                int removeIndex = Integer.parseInt(secondPart);
                String removedItem = shopCart.removeCart(removeIndex);
                if (removedItem != null) {
                    System.out.println(removedItem + " removed from cart");
                } else {
                    System.out.println("Incorrect item index");
                }
            } else if (firstToken.equals("exit")) {
                System.out.println("Come back and shop again! Bye!");
                break; // stop the infinite loop
            } else {
                System.out.println("Unknown command try again!");
            }

            // "list".split(" ") => ["list"]
            // "add apple".split(" ") => ["add", "apple"]
            // "add orange, pear".split(" ") => ["add", "orange,", "pear"] Problem
            // String tokens[] = command.split(" ");
            // printArray(tokens);

        }
    }
}