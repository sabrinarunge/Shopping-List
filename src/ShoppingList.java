import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ShoppingList
{

    private ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args)
    {
        ShoppingList myList = new ShoppingList();
        myList.run();
    }

    private void run()
    {
        System.out.println("Starting shopping list\n");
        printMenu();

        Scanner in = new Scanner(System.in);

        boolean exit = false;


        do
        {
            System.out.println("Enter your command");
            String commandLine = in.nextLine();
            String[] words = commandLine.split(" ");

            String command = words[0].toUpperCase();


            switch (command)
            {

                case "ADD":
                    list.add(words[1]);
                    break;
                case "PRINT":
                    printList();
                    break;
                case "REMOVE":
                    list.remove(words[1]);
                    break;
                case "CLEAR":
                    list.clear();
                    break;
                case "EXIT":
                    exit = true;
                default:
                    System.out.println("Please enter a valid command");
                    break;

            }

        } while (!exit);

        Collections.sort(list);
        System.out.println("List after sorting alphabetically: " + list);

        System.out.println("What item do you want to find in the list?");
        String item = in.nextLine();

        if (list.contains(item))
        {
            System.out.println("Found it!");
        }

        else
        {
            System.out.println("No such item!");
        }

    }


    private void printList()
    {
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(i + " : " + list.get(i));
        }
    }
    private void printMenu()
    {

        System.out.println("Please enter one of the following commands: \n");
        System.out.println("Add <item name>");
        System.out.println("Print");
        System.out.println("Remove <index>");
        System.out.println("Clear");
        System.out.println("Exit");
    }
}
