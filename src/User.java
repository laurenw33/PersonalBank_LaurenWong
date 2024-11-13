public class User {

    private int balance = 0;
    private String username;
    private int pin;
    String[] userList = {};
    int[] pinList = {};


    public User(String username, int pin)
    {
        this.username = username;
        this.pin = pin;
        pinList = new int[]{pin};
        userList = new String[]{username};
    }
    public String getUsername(String user)
    {
        username = user;
        return username;
    }

    public int getPin(int pinNew)
    {
        pin = pinNew;
        return pin;
    }

    public boolean verifyUser(String user)
    {
        int len = userList.length;
        if (len == 0)
        {
            return false;
        }
        else if (len >= 1)
        {
            for (int i = 1; i <= len; i++)
            {
                if (userList[i] == user)
                {
                    return true;
                }
            }
        }
        return true;
    }

    private boolean verifyPin(int enteredPin) {
        return pin == enteredPin;
    }


    public String deposit(int deposit)
    {
        balance += deposit;
        return "Your balance after depositing " + deposit + " dollars is: " + balance;
    }

    public String withdraw(int withdraw, int enteredPin)
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
