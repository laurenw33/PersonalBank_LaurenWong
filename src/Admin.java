public class Admin {
    private String username;
    private int pin;

    public Admin() {
        this.username = "admin1";
        this.pin = 8976;
    }

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
        if (user != null) {
            user.setBalance(newBalance);
            return "Balance updated successfully to $" + newBalance;
        } else {
            return "Error: User does not exist.";
        }
    }

    public String updatePin(User user, int newPin) {
        if (user != null) {
            if (String.valueOf(newPin).length() == 4) {
                user.setPin(newPin);
                return "Pin updated successfully to: " + newPin;
            }
            else {
               return "Error: Pin must be exactly four digits.";
            }
        }
        else {
            return "Error: User does not exist.";
        }
    }

}
