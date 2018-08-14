import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BingoNumbers
{
    private Set<Integer> myNumbers = new HashSet<>();

    public static void main(String[] args)
    {
        BingoNumbers bingoNumbers = new BingoNumbers();
        bingoNumbers.run();
    }

    private void run()
    {
        System.out.println("Starting Bingo Numbers!");
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
                case "CALL":
                    try
                    {
                        int calledNumber = Integer.parseInt(words[1]);
                        call(calledNumber);
                    }
                    catch (Exception e)
                    {
                        System.out.println("Please enter a number.");
                    }

                    break;

                case "CALLED":
                    try
                    {
                        called();
                    }
                    catch (Exception e)
                    {
                        System.out.println("Please enter a valid command.");
                    }
                    break;

                case "VERIFY":
                    try
                    {
                        int calledNumber = Integer.parseInt(words[1]);
                        verify(calledNumber);
                    }
                    catch (Exception e)
                    {
                        System.out.println("Please enter a valid command..");
                    }
                    break;

                case "CHALLENGE":
                    try
                    {
                        int calledNumber = Integer.parseInt(words[1]);
                        challenge(calledNumber);
                    }
                    catch (Exception e)
                    {
                        System.out.println("Please enter a valid command.");
                    }
                    break;

                case "BINGO":
                    try
                    {
                        bingo();
                    }
                    catch (Exception e)
                    {
                        System.out.println("Please enter a valid command.");
                    }
                    break;
                case "EXIT":
                    exit = true;
            }
        } while (!exit);
    }

    private void call (int number)
    {
        if (myNumbers.contains(number))
        {
            System.out.println("That number has already been called. Please try another.");
        }

        else if (number > 1 && number <= 75)
        {
            myNumbers.add(number);
            System.out.println("Added <" + number + ">");
        }

        else if (number < 1 || number > 75)
        {
            System.out.println("Please enter a number between 1-75");
        }
    }

    private void called()
    {
        System.out.println(myNumbers);
    }

    private void verify (int number)
    {
        if (number > 1 && number <= 75)
        {
            if (myNumbers.contains(number))
            {
                System.out.println("That number has already been called.");
            }

            else
            {
                System.out.println("That number has not been called yet.");
            }
        }

        else if (number < 1 || number > 75)
        {
            System.out.println("Please enter a number between 1-75");
        }

    }

    private void challenge (int number)
    {
        if (myNumbers.contains(number) && number > 1 && number <= 75)
        {
            myNumbers.remove(number);
            System.out.println("That number has been removed.");
        }

        else
        {
            System.out.println("That number has not yet been called.");
        }
    }

    private void bingo()
    {
        if(myNumbers.size() >= 4)
        {
            System.out.println("Congratulations, you win a fruitcake!");
            myNumbers.clear();
        }

        else
        {
            System.out.println("Cheater!");
        }
    }

    private void printMenu()
    {
        System.out.println("Please enter one of the following commands:");
        System.out.println("Call (add a number between <1 - 75>)");
        System.out.println("Called (print the numbers)");
        System.out.println("Verify (check to see if a number between <1 - 75> has been called or not)");
        System.out.println("Challenge (remove a number between <1 - 75> from called numbers)");
        System.out.println("Bingo! (to reset the list of numbers)\n");
    }
}
