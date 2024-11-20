import java.util.ArrayList;

public class StringStorage {
    ArrayList<User> users = new ArrayList<>();
    ArrayList<User> pins = new ArrayList<>();

    public StringStorage() {
        users = new ArrayList<>();
        pins = new ArrayList<>();
    }

    public void addUser(String value) {
        users.add(value);
    }

    public void addPin(int pin) {
        pins.add(pin);
    }

    public void displayStrings() {
        System.out.println("Stored Strings: " + users);
    }


    public int findUser(StringStorage array, Object value) {
        for (int i = 0; i < users.size(); i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public static int findPin(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public String getUser(int index) {
        if (index >= 0 && index < users.size()) {
            return users.get(index);
        }
        return null;
    }

    public String getPin(int index) {
        if (index >= 0 && index < pins.size()) {
            return pins.get(index);
        }
        return null;
    }

}
