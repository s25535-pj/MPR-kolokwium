package s25535.Bank;

public class TransferInfo {
    private final double ammount;
    private final TransactionStatus transactionStatus;

    public TransferInfo(double ammount, TransactionStatus transactionStatus) {
        this.ammount = ammount;
        this.transactionStatus = transactionStatus;
    }

    @Override
    public String toString() {
        return "TransferInfo{" +
                "currentAmmount=" + ammount +
                ", transactionStatus=" + transactionStatus +
                '}';
    }
}
