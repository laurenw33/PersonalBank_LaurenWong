public class User {

    private int balance = 0;
    private String username;
    private int pin;

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

    public void accessAccount()
    {

    }

    public String depositMoney(int deposit)
    {
        balance += deposit;
        return "Your balance after depositing " + deposit + " dollars is: " + balance;
    }

    public String withdrawMoney(int withdraw)
    {
        balance -= withdraw;
        return "Your balance after withdrawing " + withdraw + " dollars is: " + balance;
    }

    public String checkBalance()
    {
        return "Your balance is: " + balance;
    }


}
