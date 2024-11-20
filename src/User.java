public class User {
    private int balance = 0;
    private String username;
    private int pin;

    public User() {

    }

    public User(String username, int pin) {
        if (String.valueOf(pin).length() == 4) {
            this.username = username;
            this.pin = pin;
            this.balance = 0;
        }
    }

    public void setPin(int pin) {
        if (String.valueOf(pin).length() == 4) {
            this.pin = pin;
        } else {
            throw new IllegalArgumentException("Pin must be exactly four digits.");
        }
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
        if (withdraw <= balance) {
            balance -= withdraw;
            return "Your balance after withdrawing " + withdraw + " dollars is: " + balance;
        }

        else {
            return "Insufficient balance. Your current balance is: " + balance;
        }
    }

    public String balance()
    {
        return "Your balance is: " + balance;
    }

    public int setBalance(int balanceNew) {
        balance = balanceNew;
        return balance;
    }

}
