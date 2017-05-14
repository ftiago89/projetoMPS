package business.control;

//Singleton Facade with CRUD services implemented with Command pattern.

import business.model.Client;

//only client methods are implemented
public class EntityFacade {
    private static EntityFacade singleton = null;
    private ClientRegisterControl control = new ClientRegisterControl();
    private ClientCrudCommand command;
    
    private EntityFacade(){}
    
    public static synchronized EntityFacade getInstance(){
        if (singleton == null){
            singleton = new EntityFacade();
        }
        return singleton;
    }
    
    public void addClient(String login, String password, String name, String cpf,
            String email, String street, String complement, String ngbhood, String city,
            String state, String cep) throws EntityNotAddedException, EntityNotFoundException {
        this.command = new NewClientCommand(this.control,login, password, name, cpf, email, street,
                                            complement, ngbhood, city, state, cep);
        this.command.execute();
    }
    
    public void removeClient(String cpf) throws EntityNotAddedException, EntityNotFoundException {
        this.command = new RemoveClientCommand(this.control, cpf);
        this.command.execute();
    }
    
    public void editClient(String login, String password, String name, String cpf,
            String email, String street, String complement, String ngbhood, String city,
            String state, String cep) throws EntityNotAddedException, EntityNotFoundException {
        this.command = new EditClientCommand(this.control, name, cpf, email, street,
                                            complement, ngbhood, city, state, cep);
        this.command.execute();
    }
    
    public Client selectClient(String cpf) throws ClientNotFoundException{
        return this.control.selectClient(cpf);
    }
}
