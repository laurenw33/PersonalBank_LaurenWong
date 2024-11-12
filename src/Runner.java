import java.util.Scanner;


public class Runner {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] usernames = {};
        int[] pins = {};
        User U = new User();

        System.out.print("Would you like to create a new account? ");
        String answer = s.nextLine();

        if (answer.equals("yes"))
        {
            System.out.print("What would you like your username to be? ");
            String user = s.nextLine();
            usernames = new String[]{user};
            U.createUsername(user);
            System.out.print("What would you like your four-digit pin to be? ");
            int pin = s.nextInt();
            int lenPin = String.valueOf(pin).length();
            U.createPin(pin);

            if (lenPin == 4)
            {
                pins = new int[]{pin};
                System.out.println("Account created successfully with username: " + user);
            }

            else if (lenPin != 4)
           {
            System.out.println("Error! Please enter a four-digit pin.");
            System.out.println("What would you like your four-digit pin to be?");
            int pin1 = s.nextInt();
            pins = new int[]{pin1};
           }

        }
        else if (answer.equals("no")) {
            if (usernames.length == 0) {
                System.out.println("No accounts found. Please create an account first.");
            } else {
                System.out.print("Please enter your username: ");
                String access = s.nextLine();


                if (access.equals(usernames[0])) {
                    System.out.println("Access granted. Welcome, " + access + "!");
                } else {
                    System.out.println("Username not found.");
                }
            }
        }

        System.out.print("Would you like to withdraw or deposit money? ");
        String money = s.nextLine();
        if (money.equals("withdraw"));
        {
            System.out.print("Please re-enter your pin: ");
            int enteredPin = s.nextInt();

        }

    }
}

