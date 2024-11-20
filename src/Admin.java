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

    public void updateBalance(User user, int newBalance) {
        user.setBalance(newBalance);
    }

    public String updatePin(User user, int newPin) {
        if (String.valueOf(newPin).length() == 4) {
            user.setPin(newPin); // Set pin for the passed user
            return "Pin updated successfully to: " + newPin;
        } else {
            return "Error: Pin must be exactly four digits.";
        }
    }

}
