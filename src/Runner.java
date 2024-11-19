import java.util.Scanner;
import java.util.ArrayList;

public class Runner {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>();
        Admin admin1 = null;


        System.out.println("Welcome to your personal banking system!");
        System.out.println("----------------------------------------------------");
        System.out.println("!! IMPORTANT INFO !!");
        System.out.println("Admin username: admin1");
        System.out.println("Admin password: 8976");
        System.out.println("-----------------------------------------------------");
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

        User currentUser = new User(user, pin);
        users.add(currentUser);
        System.out.println("Account created successfully with username: " + user);
        s.nextLine();

        System.out.println("-----------------------------------------------------");

        while (true) {
            System.out.println("MAIN MENU ");
            System.out.println("1. Create A New Account");
            System.out.println("2. Enter User Mode");
            System.out.println("3. Enter Admin Mode");
            System.out.println("-----------------------------------------------------");
            System.out.print("What would you like to do? ");
            String mode = s.nextLine();

            if (mode.equals("1")) {
                System.out.print("Enter a username: ");
                String userNew = s.nextLine();

                int pinNew;
                while (true) {
                    System.out.print("Enter a 4-digit pin: ");
                    pinNew = s.nextInt();
                    s.nextLine();
                    if (String.valueOf(pinNew).length() == 4) {
                        break;
                    }
                    System.out.println("Error! The pin must be exactly 4 digits.");
                }

                User newUser = new User(userNew, pinNew);
                users.add(newUser);
                System.out.println("Account created successfully for username: " + userNew);
                System.out.println("-----------------------------------------------------");

            }

            else if (mode.equals("3")) {
                System.out.print("Please enter the admin username: ");
                String admin = s.nextLine();
                if (!admin1.verifyAdmin(admin)) {
                    System.out.println("Incorrect username.");
                }

                System.out.print("Please enter the admin pin: ");
                String adminPin = s.nextLine();
                boolean pinVer = false;
                pinVer = admin1.verifyPin(Integer.parseInt(adminPin));

                while (admin1.verifyAdmin(admin) && admin1.verifyPin(Integer.parseInt(adminPin))) {
                    System.out.print("What would you like to do? Update pin, update balance, or delete account?");
                    String answer = s.nextLine();


                    if (answer.equalsIgnoreCase("update pin")) {
                        System.out.print("Please enter your username: ");
                        System.out.print("Enter the new pin for the user: ");
                        int newPin = s.nextInt();
                        s.nextLine();
                        admin1.updatePin(currentUser, newPin);

                    } else if (answer.equalsIgnoreCase("update balance")) {
                        System.out.print("Enter the new balance for the user: ");
                        int newBalance = s.nextInt();
                        s.nextLine();
                        admin1.updateBalance(currentUser, newBalance);
                    } else if (answer.equalsIgnoreCase("delete account")) {
                        currentUser = null;
                        System.out.println("User account deleted successfully.");
                    } else {
                        System.out.println("Invalid option. Please try again.");
                    }

                }
                System.out.println("----------------------------------------------------");
                s.nextLine();
            }

            else if (mode.equals("2")) {

                while (true) {
                    System.out.print("Please enter your username: ");
                    String username1 = s.nextLine();
                    User currentUser = User.findUser(users, username1);

                    if (currentUser == null) {
                        System.out.println("User not found.");
                    }
                    else {
                        System.out.println("Welcome, " + username1);
                    }

                    System.out.print("What would you like to do? Withdraw, Deposit, Balance, or Exit: ");
                    String answer = s.nextLine();


                    if (answer.equalsIgnoreCase("withdraw")) {
                        System.out.print("Please re-enter your username: ");
                        String newUser = s.nextLine();
                        boolean userVer = currentUser.verifyUser(newUser);

                        if (userVer) {
                            System.out.print("Please re-enter your pin: ");
                            int newPin = s.nextInt();
                            System.out.print("Please enter your withdraw amount: ");
                            int withdrawAmt = s.nextInt();
                            System.out.println(currentUser.withdraw(withdrawAmt, newPin));
                        } else {
                            System.out.println("That account does not exist!");
                        }
                    }


                    if (answer.equalsIgnoreCase("deposit")) {
                        System.out.print("Please re-enter your username: ");
                        String newUser = s.nextLine();
                        boolean userVer = currentUser.verifyUser(newUser);


                        if (userVer) {
                            System.out.print("Please re-enter your pin: ");
                            int newPin = s.nextInt();
                            System.out.print("Please enter your deposit amount: ");
                            int depositAmt = s.nextInt();
                            System.out.println(currentUser.deposit(depositAmt, newPin));
                        } else {
                            System.out.println("That account does not exist!");
                        }
                    }


                    if (answer.equalsIgnoreCase("balance")) {
                        System.out.print("Please re-enter your username: ");
                        String newUser = s.nextLine();
                        boolean userVer = currentUser.verifyUser(newUser);


                        if (userVer) {
                            System.out.print("Please re-enter your pin: ");
                            int newPin = s.nextInt();
                            System.out.println(currentUser.balance(newPin));
                        } else {
                            System.out.println("That account does not exist!");
                        }
                    }
                    if (answer.equalsIgnoreCase("exit")) {
                        System.out.println("Thank you for using the banking system. Goodbye!");
                        break;
                    }
                    System.out.println("----------------------------------------------------");
                    s.nextLine();
                }

                s.nextLine();
                s.close();

            }
        }
    }
}

