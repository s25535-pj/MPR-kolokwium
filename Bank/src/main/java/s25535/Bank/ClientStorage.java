package s25535.Bank;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientStorage {
    private final List<Client> clientList = new ArrayList<>();

    public ClientStorage(){
        clientList.add(new Client("Maria", 1000));

    }
    public List<Client>getClientList(){
        return clientList;
    }
    public void addClientToStorage(Client client){
        clientList.add(client);
    }

    public Client getClientById(String id){
        for (Client c: clientList) {
            if(c.getAccid().equals(id)){
                return c;
            }
        }
        return null;
    }
}
