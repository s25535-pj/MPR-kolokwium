package s25535.s25535Bank;

public class Client {
    private final String accid;
    private double balance;

    public Client(String accid, double balance) {
        this.accid = accid;
        this.balance = balance;
    }

    public String getAccid() {
        return accid;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return " Client id: " + accid;
    }
}
