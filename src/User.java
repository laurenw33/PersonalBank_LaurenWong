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

    public void setPin(int pinNew) {
        pin = pinNew;
    }


    public boolean verifyPin(int enteredPin) {
        return pin == enteredPin;
    }

    public String deposit(int deposit)
    {
       if (deposit >= 0) {
           balance += deposit;
           return "Your balance after depositing " + deposit + " dollars is: $" + balance;
       }
       else {
           return "You must deposit a positive value!";
       }
    }

    public String withdraw(int withdraw)
    {
        if (withdraw <= balance) {
            if (withdraw >= 0) {
                balance -= withdraw;
                return "Your balance after withdrawing " + withdraw + " dollars is: $" + balance;
            }
            else {
                return "You must deposit a positive value!";
            }
        }
        else {
            return "Insufficient balance. Your current balance is: $" + balance;
        }
    }

    public String balance()
    {
        return "Your balance is: $" + balance;
    }

    public int setBalance(int balanceNew) {
        balance = balanceNew;
        return balance;
    }

    public boolean verifyUser(String user)
    {
        return username.equals(user);
    }
}
