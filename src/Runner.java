import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        User account1 = null;
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

            int pin = 0;
            String username = null;
            if (mode.equals("1")) {
                System.out.print("Enter a username: ");
                username = s.nextLine();
                boolean pinValid = false;

                while (!pinValid) {
                    System.out.println("How would you like to create your pin? ");
                    System.out.println("1. Create your own pin");
                    System.out.println("2. Randomly generate a pin");
                    System.out.print("Choose an option: ");
                    String answer = s.nextLine();

                    if (answer.equals("1")) {
                        System.out.print("Enter a 4-digit pin: ");
                        pin = s.nextInt();
                        s.nextLine();

                        if (String.valueOf(pin).length() == 4) {
                            pinValid = true;
                        } else {
                            System.out.println("Error! The pin must be exactly 4 digits.");
                        }
                    }

                    if (answer.equals("2")) {
                        pin = (int) (10000 * Math.random() + 1);
                        pinValid = true;
                        System.out.println("Your randomized pin is: " + pin);
                    }

                    account1 = new User(username, pin);
                }
            }

                System.out.println("Account created successfully for username: " + username);
                System.out.println("-----------------------------------------------------");

            if (mode.equals("2")) {
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
                        String username1 = s.nextLine();
                        boolean userVer = account1.verifyUser(username1);

                        if (userVer) {
                            System.out.println("Enter the new pin: ");
                            int newPin = s.nextInt();
                            s.nextLine();
                            admin1.updatePin(account1, newPin);

                        }

                        else {
                            System.out.println("User not found.");
                        }


                    }

                    else if (answer.equals("2")) {
                        System.out.print("Please enter your username to update balance: ");
                        String username2 = s.nextLine();

                        if (account1 != null) {
                            System.out.print("Enter the new balance for the user: ");
                            int newBalance = s.nextInt();
                            s.nextLine();
                            admin1.updateBalance(account1, newBalance);
                        }
                    }

                    else if (answer.equals("3")) {
                        account1 = null;
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
                System.out.print("Please enter your username: ");
                String username3 = s.nextLine();
                boolean verifyUser = account1.verifyUser(username3);

                if (verifyUser) {
                    System.out.print("Please enter your pin: ");
                    String pin1 = s.nextLine();
                    boolean verifyPin = account1.verifyPin(Integer.parseInt(pin1));

                    if (verifyPin) {
                        System.out.println("Welcome, " + username);

                        while (true) {
                            System.out.print("Please enter your username: ");
                            String username1 = s.nextLine();
                            boolean verify = account1.verifyUser(username1);

                            if (!verify) {
                                System.out.println("User not found.");
                            }

                            System.out.print("Please enter your pin: ");
                            String pin2 = s.nextLine();

                            boolean verifyPin1 = account1.verifyPin(Integer.parseInt(pin2));

                            if (verifyPin1) {
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
                                    System.out.println(account1.withdraw(withdrawAmt));
                                } else {
                                    System.out.println("That account does not exist!");
                                }


                                if (answer.equalsIgnoreCase("2")) {
                                    System.out.print("Please enter your deposit amount: ");
                                    int depositAmt = s.nextInt();
                                    System.out.println(account1.deposit(depositAmt));
                                } else {
                                    System.out.println("That account does not exist!");
                                }


                                if (answer.equalsIgnoreCase("3")) {
                                    System.out.println(account1.balance());
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
    }
}
