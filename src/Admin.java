public class Admin {
    private String username = "admin1";
    private int pin = 8976;

    public Admin() {
    }

    public boolean verifyAdmin(String admin)
    {
        return username.equals(admin);
    }

    public boolean verifyPin(int enteredPin) {
        return pin == enteredPin;
    }

    public void updateBalance() {

    }

    public int updatePin() {
    return 1;
    }

}
