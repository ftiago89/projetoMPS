package business.control;

import business.model.Client;
import business.model.Address;
import business.util.LoginValidator;
import business.util.PasswordValidator;
import business.util.ClientValidatorCommand;

//controls clients registrations and communications with EntityFacade and 
//EntityPersistenceFacade
public class ClientRegisterControl {
    private EntityPersistenceFacade entPFacade;
    private Client tempClient;
    private Address tempAddress;
    private ClientValidatorCommand validator;
    private EntityFactory clientFactory;
    
    public void addClient(String login, String password, String name, String cpf, 
                            String email, String street, String complement, String ngbhood,
                            String city, String state, String cep) throws ClientNotAddedException, ValidateException{
        
        try {
            selectClient(email);
            throw new ClientNotAddedException("Email ja cadastrado no sistema. Por favor, informe os dados corretamente.");
        } catch (ClientNotFoundException ex) {
            //validating login and password restrictions
            this.validator = new LoginValidator();
            this.validator.execute(login);
            this.validator = new PasswordValidator();
            this.validator.execute(password);
            
            this.tempAddress = new Address(street, complement, ngbhood, city, state, cep);
            this.clientFactory = new ClientFactory(login, password, name, cpf, email, tempAddress);
            this.tempClient = (Client)clientFactory.createEntity();
        
            this.entPFacade = EntityPersistenceFacade.getInstance();
            this.entPFacade.addClient(tempClient);
        }
    }
    
    public void removeClient(String email) throws ClientNotFoundException{
        this.entPFacade = EntityPersistenceFacade.getInstance();
        this.entPFacade.removeClient(email);
    }
    
    //login and password does not change with this operation
    public void editClient(String name, String cpf, String email, String street, 
                            String complement, String ngbhood, String city, 
                            String state, String cep) throws ClientNotFoundException{
        
        this.tempAddress = new Address(street, complement, ngbhood, city, state, cep);
        this.clientFactory = new ClientFactory(selectClient(email).getLogin(), selectClient(email ).getPassword(), name, cpf, email, tempAddress);
        this.tempClient = (Client)clientFactory.createEntity();
        
        this.entPFacade = EntityPersistenceFacade.getInstance();
        this.entPFacade.editClient(tempClient);
    }
    
    public Client selectClient(String email) throws ClientNotFoundException{
        this.entPFacade = EntityPersistenceFacade.getInstance();
        this.tempClient = (Client)this.entPFacade.selectClient(email);
        return this.tempClient;
    }
}
