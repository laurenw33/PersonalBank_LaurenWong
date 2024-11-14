import java.util.Scanner;


public class Runner {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        User account1 = null;

        System.out.println("Welcome to your personal banking system!");
        System.out.println("Please create an account.");

        System.out.print("Please enter a username: ");
        String user = s.nextLine();

        System.out.print("Please enter a four-digit pin: ");
        int pin = s.nextInt();
        int lenPin = String.valueOf(pin).length();

        if (lenPin != 4)
        {
            System.out.print("Error! Please enter a four-digit pin: ");
            pin = s.nextInt();
        }

        account1 = new User(user, pin);
        account1.getPin(pin);

        System.out.println("Account created successfully with username: " + user);

        System.out.print("What would you like to do? Withdraw, Deposit, Balance, or Exit: ");
        String answer = s.nextLine();

        while (!(answer.equalsIgnoreCase("exit"))) {

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
                }

                else
                {
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
                }

                else {
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
                }

                else {
                    System.out.println("That account does not exist!");
                }
            }

            System.out.print("What would you like to do? Withdraw, Deposit, Balance, or Exit: ");
            answer = s.nextLine();
        }

    }
}

