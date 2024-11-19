import java.util.ArrayList;

public class User {
    private int balance = 0;
    private String username;
    private int pin;

    public User(String username, int pin) {
        if (String.valueOf(pin).length() == 4) {
            this.username = username;
            this.pin = pin;
            this.balance = 0;
        }
    }

    public static User findUser(ArrayList<User> users, String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public String getUsername()
    {
        return username;
    }

    public void setPin(int pin) {
        if (String.valueOf(pin).length() == 4) {
            this.pin = pin;
        } else {
            throw new IllegalArgumentException("Pin must be exactly four digits.");
        }
    }

    public void getPin(int pinNew)
    {
        pin = pinNew;
    }

    public boolean verifyUser(String user)
    {
        return username.equals(user);
    }

    public boolean verifyPin(int enteredPin) {
        return pin == enteredPin;
    }


    public String deposit(int deposit, int enteredPin)
    {
        if (verifyPin(enteredPin)) {
            balance += deposit;
            return "Your balance after depositing " + deposit + " dollars is: " + balance;
        }

        else {
            return "Incorrect pin. Access denied.";
        }
    }

    public String withdraw(int withdraw, int enteredPin)
    {

        if (verifyPin(enteredPin)) {
            if (withdraw <= balance) {
                balance -= withdraw;
                return "Your balance after withdrawing " + withdraw + " dollars is: " + balance;
            }

            else {
                return "Insufficient balance. Your current balance is: " + balance;
            }
        }

        else {
            return "Incorrect pin. Access denied.";
        }
    }

    public String balance(int enteredPin)
    {
        if (verifyPin(enteredPin)) {
            return "Your balance is: " + balance;
        }

        else {
            return "Incorrect pin. Access denied.";
        }
    }

    public void setBalance(int newBalance)
    {
        balance = newBalance;
    }

}
