package s25535.Bank;

import org.springframework.stereotype.Component;

@Component
public class BankService {
    private final ClientStorage clientStorage;

    public BankService(ClientStorage clientStorage) {
        this.clientStorage = clientStorage;
    }
    public String registerClient(Client client) {
        //Jak dodalem warunek by spradzic czy klient istnieje to sie sypalo,
        //czasu zabraklo :(
        clientStorage.addClientToStorage(client);
        return "New Client registered";
    }

    public TransferInfo cashTransfer(String client, double ammount) {
        Client c = clientStorage.getClientById(client);
        if (c == null) {
            System.out.println("Client not exists");
            return new TransferInfo(0, TransactionStatus.DECLINED);
        }

        if (ammount <= 0) {
            System.out.println("Amount is too small");
            return new TransferInfo(c.getBalance(), TransactionStatus.DECLINED);
        }
        double newAmmount = c.getBalance() - ammount;
        c.setBalance(newAmmount);
        System.out.println("Sucess transfer");
        return new TransferInfo(c.getBalance(), TransactionStatus.ACCEPTED);
    }

    public TransferInfo addMoneyToBalance(String client, double ammount) {
        Client c = clientStorage.getClientById(client);

        if (c == null) {
            System.out.println("Client not exists");
            return new TransferInfo(0, TransactionStatus.DECLINED);
        }

        if (ammount <= 0) {
            System.out.println("Amount is too small");
            return new TransferInfo(c.getBalance(), TransactionStatus.DECLINED);
        }
        double newAmmount = c.getBalance() + ammount;
        System.out.println("New ammount = " + newAmmount);
        c.setBalance(newAmmount);
        return new TransferInfo(c.getBalance(), TransactionStatus.ACCEPTED);
    }

    public String readClientData(String client) {
        Client c = clientStorage.getClientById(client);
        return "Client: " + c + "balance: " + c.getBalance();

    }
}
