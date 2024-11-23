public class Admin {
    private String username;
    private int pin;

    public Admin(String username, int pin) {
        this.username = username;
        this.pin = pin;
    }

    public boolean verifyAdmin(String admin)
    {
        return username.equals(admin);
    }

    public boolean verifyPin(int enteredPin) {
        return pin == enteredPin;
    }

    public String updateBalance(User user, int newBalance) {
        if (newBalance >= 0) {
            user.setBalance(newBalance);
            return "Your new balance is: $" + newBalance;
        }
        else {
            return "You must enter a positive value!";
        }
    }

    public String updatePin(User user, int newPin) {
        if (String.valueOf(newPin).length() == 4) {
            user.setPin(newPin);
            return "Pin updated successfully to: " + newPin;
        }
        else {
            return "Error: Pin must be exactly four digits.";
        }
    }

}
