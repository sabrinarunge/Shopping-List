import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class PetHotel
{
    private final int MIN_ROOM_NUMBER = 100;
    private final int MAX_ROOM_NUMBER = 109;

    private Map<Integer, String> myMap = new TreeMap<>();

    public static void main(String[] args)
    {
        PetHotel petHotel = new PetHotel();
        petHotel.run();
    }

    private void run()
    {
        System.out.println("Welcome to the pet hotel!\n");
        printMenu();

        Scanner in = new Scanner(System.in);

        boolean hotelOpen = true;

        do
        {
            System.out.println("Enter your command.");
            String commandLine = in.nextLine();
            String[] words = commandLine.split(" ");

            String command = words[0].toUpperCase();
            int roomNumber;

            switch (command)
            {

                case "CHECKIN":
                    try
                    {
                        String petName = words[1];
                        roomNumber = Integer.parseInt(words[2]);
                        checkIn(roomNumber, petName);
                    }
                    catch (Exception e)
                    {
                        System.out.println("Please enter a valid command.");
                    }
                    break;
                case "CHECKOUT":
                    try
                    {
                        String petName = words[1];
                        roomNumber = Integer.parseInt(words[2]);
                        checkOut(roomNumber, petName);
                    }
                    catch (Exception e)
                    {
                        System.out.println("Please enter a valid command.");
                    }
                    break;
                case "MOVE":
                    try
                    {
                        int fromRoomNumber = Integer.parseInt(words[1]);
                        int toRoomNumber = Integer.parseInt(words[2]);
                        move(fromRoomNumber, toRoomNumber);
                    }
                    catch (Exception e)
                    {
                        System.out.println("Please enter a valid command.");
                    }
                    break;
                case "OCCUPANCY":
                    try
                    {
                        occupancy();
                    }
                    catch (Exception e)
                    {
                        System.out.println("Please enter a valid command.");
                    }
                    break;
                case "ROOMS":
                    try
                    {
                        rooms();
                    }
                    catch (Exception e)
                    {
                        System.out.println("Please enter a valid command.");
                    }
                    break;
                case "CLOSEFORSEASON":
                    try
                    {
                        closeForSeason();
                    }
                    catch (Exception e)
                    {
                        System.out.println("Please enter a valid command.");
                    }
                    break;
                case "EXIT":
                    hotelOpen = false;
                    break;
            }

        } while (hotelOpen);
    }

    private void checkIn(int roomNumber, String petName)
    {
        if (roomNumber >= 100 && roomNumber <= 109)
        {
            if(myMap.containsKey(roomNumber))
            {
                System.out.println("That room is already occupied. Please choose another.");
            }

            else
            {
                myMap.put(roomNumber, petName);
                System.out.println("Your pet, " + petName + ", is in room " + roomNumber + ".");
            }
        }

        else
        {
            System.out.println("Please enter a valid room number between 100 and 109.");
        }
    }

    private void checkOut(int roomNumber, String petName)
    {
        if (roomNumber >= 100 && roomNumber <= 109)
        {
            myMap.remove(roomNumber);
            System.out.println("Your pet, " + petName + ", has been checked out from room " + roomNumber + ".");
        }

        else
        {
            System.out.println("Please enter a valid room number between 100 and 109.");
        }
    }

    private void move(int fromRoomNumber, int toRoomNumber)
    {
        if (fromRoomNumber >= 100 && fromRoomNumber <= 109 && toRoomNumber >= 100 && toRoomNumber <= 109)
        {
            if(myMap.containsKey(toRoomNumber))
            {
                System.out.println("That room is already occupied. Please choose another.");
            }

            else
            {
                String petName = myMap.remove(fromRoomNumber);
                myMap.put(toRoomNumber, petName);
                System.out.println("Your pet, " + petName + ", has been moved from " + fromRoomNumber + " to " + toRoomNumber + ".");
            }
        }

        else
        {
            System.out.println("Please enter a valid room number between 100 and 109.");
        }
    }

    private void occupancy()
    {
        Set<Map.Entry<Integer, String>> entries = myMap.entrySet();

        for (Map.Entry<Integer, String> entry : entries)
        {
            Integer roomNumber = entry.getKey();
            String petName = entry.getValue();

            System.out.println(roomNumber + " : " + petName);
        }
    }

    private void rooms()
    {
        for (int roomNumber = MIN_ROOM_NUMBER; roomNumber <= MAX_ROOM_NUMBER; roomNumber++)
        {

            boolean petInRoom = myMap.containsKey(roomNumber);
            System.out.print(roomNumber + " ");

            if (petInRoom)
            {
                String petName = myMap.get(roomNumber);
                System.out.print(petName);
            }

            System.out.println();


        }
    }

    private void closeForSeason()
    {
        myMap.clear();
        System.out.println("The hotel has been closed for the season and all pets have been checked out.");
    }

    private void printMenu()
    {
        System.out.println("Please enter one of the following commands: ");
        System.out.println("CheckIn <Pet name> <Room number>");
        System.out.println("CheckOut <roomNumber>");
        System.out.println("Move <From room number> <To room number>");
        System.out.println("Occupancy (list room numbers and name of pet in room");
        System.out.println("Rooms (list all room numbers, empty or not)");
        System.out.println("Close for season (remove all pets from hotel)");
        System.out.println("Exit\n");


    }
}
