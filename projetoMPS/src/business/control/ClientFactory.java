package business.control;

import business.model.Address;
import business.model.Client;
import business.model.Entity;


public class ClientFactory implements EntityFactory{
    private String login, password, name, cpf, email;
    private Address address;

    public ClientFactory(String login, String password, String name, String cpf, String email, Address address) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.address = address;
    }

    @Override
    public Entity createEntity() {
        return new Client(login, password, name, cpf, email, address);
    }
    
}
