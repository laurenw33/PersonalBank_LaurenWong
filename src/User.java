public class User {

    private int balance = 0;
    private String username;
    private int pin;
    String[] userList = {};
    int[] pinList = {};


    public User(String username, int pin) {
        if (String.valueOf(pin).length() == 4) {
            this.username = username;
            this.pin = pin;
            this.balance = 0;
        }
    }

    public String getUsername(String user)
    {
        username = user;
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
