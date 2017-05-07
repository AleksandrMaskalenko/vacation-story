import java.util.HashMap;

public class Friend {
    private String name;
    private HashMap<String, Integer> services;
    private int totalAmount;
    private int debt;

    public Friend(String name, HashMap<String, Integer> services) {
        this.name = name;
        this.services = services;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Integer> getServices() {
        return services;
    }

    public void setServices(HashMap<String, Integer> services) {
        this.services = services;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getDebt() {
        return debt;
    }

    public void setDebt(int debt) {
        this.debt = debt;
    }
}
