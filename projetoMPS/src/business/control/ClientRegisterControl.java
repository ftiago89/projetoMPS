package business.control;

import business.model.Client;
import business.model.Address;

//controls clients registrations and communications with EntityFacade and 
//EntityPersistenceFacade
public class ClientRegisterControl {
    private EntityPersistenceFacade entPFacade;
    private Client tempClient;
    private Address tempAddress;
    
    public void addClient(String login, String password, String name, String cpf, 
                            String email, String street, String complement, String ngbhood,
                            String city, String state, String cep) throws ClientNotAddedException{
        this.entPFacade = EntityPersistenceFacade.getInstance();
        this.tempAddress = new Address(street, complement, ngbhood, city, state, cep);
        this.tempClient = new Client(login, password, name, cpf, email, tempAddress);
        entPFacade.addClient(tempClient);
    }
    
    public void removeClient(String cpf) throws ClientNotFoundException{
        this.entPFacade = EntityPersistenceFacade.getInstance();
        this.entPFacade.removeClient(cpf);
    }
    
    //login and password does not change with this operation
    public void editClient(String name, String cpf, String email, String street, 
                            String complement, String ngbhood, String city, 
                            String state, String cep) throws ClientNotFoundException{
        this.entPFacade = EntityPersistenceFacade.getInstance();
        this.tempAddress = new Address(street, complement, ngbhood, city, state, cep);
        this.tempClient = new Client(selectClient(cpf).getLogin(), selectClient(cpf).getPassword() , name, cpf, email, tempAddress);
        this.entPFacade.editClient(tempClient);
    }
    
    public Client selectClient(String cpf) throws ClientNotFoundException{
        this.entPFacade = EntityPersistenceFacade.getInstance();
        tempClient = (Client)this.entPFacade.selectClient(cpf);
        return tempClient;
    }
}
