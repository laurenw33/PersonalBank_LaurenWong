import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        User account1 = null;
        Admin admin1 = null;

        System.out.println("Welcome to your personal banking system!");
        System.out.println("Please follow the steps below to create an account!");

        System.out.print("Please enter a username: ");
        String user = s.nextLine();

        int pin;
        while (true) {
            System.out.print("Please enter a four-digit pin: ");
            pin = s.nextInt();
            if (String.valueOf(pin).length() == 4) {
                break;
            }
            System.out.println("Error! The pin must be exactly four digits.");
        }


        account1 = new User(user, pin);
        account1.getPin(pin);

        System.out.println("Account created successfully with username: " + user);
        s.nextLine();

        System.out.print("Would you like to enter User or Admin mode? ");
        String mode = s.nextLine();

        if (mode.equalsIgnoreCase("admin"))
        {
            while (true) {
                System.out.print("What would you like to do? Update pin, update balance, or delete account?");
                String answer = s.nextLine();

                if (answer.equalsIgnoreCase("update pin"))
                {

                }

                if (answer.equalsIgnoreCase("update balance"))
                {

                }

                if (answer.equalsIgnoreCase("delete account"))
                {

                }

            }
        }

        if (mode.equalsIgnoreCase("user")) {

            while (true) {

                System.out.print("What would you like to do? Withdraw, Deposit, Balance, or Exit: ");
                String answer = s.nextLine();


                if (answer.equalsIgnoreCase("withdraw")) {
                    System.out.print("Please re-enter your username: ");
                    String newUser = s.nextLine();
                    boolean userVer = account1.verifyUser(newUser);

                    if (userVer) {
                        System.out.print("Please re-enter your pin: ");
                        int newPin = s.nextInt();
                        System.out.print("Please enter your withdraw amount: ");
                        int withdrawAmt = s.nextInt();
                        System.out.println(account1.withdraw(withdrawAmt, newPin));
                    } else {
                        System.out.println("That account does not exist!");
                    }
                }


                if (answer.equalsIgnoreCase("deposit")) {
                    System.out.print("Please re-enter your username: ");
                    String newUser = s.nextLine();
                    boolean userVer = account1.verifyUser(newUser);


                    if (userVer) {
                        System.out.print("Please re-enter your pin: ");
                        int newPin = s.nextInt();
                        System.out.print("Please enter your deposit amount: ");
                        int depositAmt = s.nextInt();
                        System.out.println(account1.deposit(depositAmt, newPin));
                    } else {
                        System.out.println("That account does not exist!");
                    }
                }


                if (answer.equalsIgnoreCase("balance")) {
                    System.out.print("Please re-enter your username: ");
                    String newUser = s.nextLine();
                    boolean userVer = account1.verifyUser(newUser);


                    if (userVer) {
                        System.out.print("Please re-enter your pin: ");
                        int newPin = s.nextInt();
                        System.out.println(account1.balance(newPin));
                    } else {
                        System.out.println("That account does not exist!");
                    }
                }
                if (answer.equalsIgnoreCase("exit")) {
                    System.out.println("Thank you for using the banking system. Goodbye!");
                    break;
                }
            }

            s.nextLine();

        }
    }
}

