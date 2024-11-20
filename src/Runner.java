import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        StringStorage users = new StringStorage();
        StringStorage pins = new StringStorage();
        User user = new User();
        Admin admin1 = new Admin("admin1", 8976);

        System.out.println("Welcome to your personal banking system!");
        System.out.println("----------------------------------------------------");
        System.out.println("!! IMPORTANT INFO !!");
        System.out.println("Admin username: admin1");
        System.out.println("Admin password: 8976");
        System.out.println("-----------------------------------------------------");

        while (true) {
            System.out.println("MAIN MENU");
            System.out.println("1. Create A New Account");
            System.out.println("2. Enter Admin Mode");
            System.out.println("3. Enter User Mode");
            System.out.println("4. Exit");
            System.out.println("-----------------------------------------------------");
            System.out.print("Choose an option: ");
            String mode = s.nextLine();

            if (mode.equals("1")) {
                System.out.print("Enter a username: ");
                String username = s.nextLine();

                int pin;
                boolean pinValid = false;
                while (!pinValid) {
                  System.out.print("Enter a 4-digit pin: ");
                    pin = s.nextInt();
                    s.nextLine();

                    if (String.valueOf(pin).length() == 4) {
                    pinValid = true;
                    } 

                    else {
                        System.out.println("Error! The pin must be exactly 4 digits.");
                    }
                }

                User newUser = new User(username, pin);
                users.addUser(username);
                pins.addPin(pin);
                System.out.println("Account created successfully for username: " + newUser);
                System.out.println("-----------------------------------------------------");

            }

            else if (mode.equals("2")) {
                System.out.print("Please enter admin username: ");
                String admin = s.nextLine();

                if (!admin1.verifyAdmin(admin)) {
                    System.out.println("Incorrect username.");
                }

                System.out.print("Please enter the admin pin: ");
                String adminPin = s.nextLine();
                boolean pinVer = false;
                pinVer = admin1.verifyPin(Integer.parseInt(adminPin));

                while (admin1.verifyAdmin(admin) && admin1.verifyPin(Integer.parseInt(adminPin))) {
                    System.out.println("What would you like to do? ");
                    System.out.print("1. Update Pin");
                    System.out.print("2. Update Balance");
                    System.out.println("3. Delete All Accounts");
                    System.out.println("4. Exit");
                    System.out.print("Choose an option: ");
                    String answer = s.nextLine();


                    if (answer.equals("1")) {
                        System.out.print("Please enter your username to update pin: ");
                        String username = s.nextLine();
                        int userIdx = users.findUser(users, username);
                        String userFind = users.getUser(userIdx);

                        if (userFind.equals(username)) {
                            System.out.println("Enter the new pin: ");
                            int newPin = s.nextInt();
                            s.nextLine();
                            admin1.updatePin(users, newPin);

                        }

                        if (user != null) {
                            System.out.println("Enter the new pin: ");
                            int newPin = s.nextInt();
                            s.nextLine();
                            admin1.updatePin(users, newPin);
                        }

                        else {
                            System.out.println("User not found.");
                        }


                    }

                    else if (answer.equals("2")) {
                        System.out.print("Please enter your username to update balance: ");
                        String username = s.nextLine();
                        StringStorage user = user.findUser(users, username);

                        if (user != null) {
                            System.out.print("Enter the new balance for the user: ");
                            int newBalance = s.nextInt();
                            s.nextLine();
                            admin1.updateBalance(user, newBalance);
                        }
                    }

                    else if (answer.equals("3")) {
                        user = null;
                        System.out.println("User account deleted successfully.");
                    }

                    else {
                        System.out.println("Invalid option. Please try again.");
                    }

                }
                System.out.println("----------------------------------------------------");
                s.nextLine();
            }

            else if (mode.equals("3")) {

                while (true) {
                    System.out.print("Please enter your username: ");
                    String username1 = s.nextLine();
                    int userIdx = users.findUser(users, username1);

                    if (userIdx == -1) {
                        System.out.println("User not found.");
                    }

                    System.out.print("Please enter your pin: ");
                    String pin = s.nextLine();

                    if (pins.getPin(userIdx).equals(pin)) {
                        System.out.println("Welcome, " + username1);


                        System.out.println("USER MENU");
                        System.out.print("1. Withdraw");
                        System.out.println("2. Deposit");
                        System.out.println("3. Balance");
                        System.out.println("4. Exit");
                        System.out.print("Choose an option: ");
                        String answer = s.nextLine();

                        if (answer.equalsIgnoreCase("1")) {
                            System.out.print("Please enter your withdraw amount: ");
                            int withdrawAmt = s.nextInt();
                            System.out.println(user.withdraw(withdrawAmt));
                        }

                        else {
                            System.out.println("That account does not exist!");
                        }


                        if (answer.equalsIgnoreCase("2")) {
                            System.out.print("Please enter your deposit amount: ");
                            int depositAmt = s.nextInt();
                            System.out.println(user.deposit(depositAmt, newPin));
                        }

                        else {
                            System.out.println("That account does not exist!");
                        }


                        if (answer.equalsIgnoreCase("3")) {
                            System.out.println(user.balance());
                        }


                        if (answer.equalsIgnoreCase("4")) {
                            System.out.println("Thank you for using the banking system. Goodbye!");
                            break;
                        }

                        System.out.println("----------------------------------------------------");
                        s.nextLine();
                    }
                }



            }
        }
    }
}
