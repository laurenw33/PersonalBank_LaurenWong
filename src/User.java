public class User {

    private int balance = 0;
    private String username;
    private int pin;
    String[] usernames = {};
    int[] pins = {};

    public User()
    {

    }
    public String createUsername(String user)
    {
        username = user;
        return username;
    }

    public int createPin(int pinNew)
    {
        pin = pinNew;
        return pin;
    }

    public boolean checkPinLen(int pinLen)
    {
        if (pinLen == 4)
        {
            pins = new int[]{pin};
            System.out.print("Account created successfully with username: " + username);
        }
        else if (pinLen != 4)
        {
            System.out.println("Error! Please enter a four-digit pin.");
        }
        return true;
    }

    private boolean verifyPin(int enteredPin) {
        return pin == enteredPin;
    }


    public String depositMoney(int deposit)
    {
        balance += deposit;
        return "Your balance after depositing " + deposit + " dollars is: " + balance;
    }

    public String withdrawMoney(int withdraw, int enteredPin)
    {
        if (verifyPin(enteredPin)) {
            if (withdraw <= balance) {
                balance -= withdraw;
                return "Your balance after withdrawing " + withdraw + " dollars is: " + balance;
            } else {
                return "Insufficient balance. Your current balance is: " + balance;
            }
        }

        else {
            return "Incorrect pin. Access denied.";
        }
    }

    public String checkBalance(int enteredPin)
    {
        if (verifyPin(enteredPin)) {
            return "Your balance is: " + balance;
        } else {
            return "Incorrect pin. Access denied.";
        }

    }


}
