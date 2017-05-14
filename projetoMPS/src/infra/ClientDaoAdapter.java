package infra;

import business.model.Client;
import business.model.Entity;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

//this is the concrete adapter for file persistence
public class ClientDaoAdapter implements PersistenceAdapter{
    private Client c;
    private String cpf;
    private HashMap<String, Client> clients;
    private ClientDAO clientDAO;
    
    //constructor for add and edit operations
    public ClientDaoAdapter(Client c) throws InfraException {
        this.c = c;
        this.clientDAO = ClientDAO.getInstance();
        try {
            this.clients = clientDAO.load();
        } catch (InfraException ex) {
            this.clients = new HashMap();
            this.clientDAO.save(this.clients);
            this.clients = clientDAO.load();
        }
    }
    
    //constructor for remove and select operations
    public ClientDaoAdapter(String cpf) throws InfraException{
        this.cpf = cpf;
        this.clientDAO = ClientDAO.getInstance();
        this.clients = clientDAO.load();
    }

    
    @Override
    public void add() throws InfraException{
        this.clients.put(c.getCpf(), c);
        try {
            this.clientDAO.save(this.clients);
        } catch (InfraException ex) {
            System.out.println(ex.getMessage());
            throw new InfraException(ex.getMessage()+"/Erro de infra ao adicionar cliente pelo adaptador.");
        }
    }

    @Override
    public void remove() throws InfraException {      
        for (Client c: this.clients.values()){
            if ((this.cpf.equals(c.getCpf()))){
                this.clients.values().remove(c);
            }
        }
        
        try {
            this.clientDAO.save(this.clients);
        } catch (InfraException ex) {
            throw new InfraException(ex.getMessage()+"/Erro de infra ao remover cliente pelo adaptador.");
        }
    }

    @Override
    public void edit() throws InfraException {
        for (Client c: this.clients.values()){
            if ((this.c.getCpf().equals(c.getCpf()))){
                c.setName(this.c.getName());
                c.setCpf(this.c.getCpf());
                c.setEmail(this.c.getEmail());
                c.setAddress(this.c.getAddress());
            }
        }
        
        try {
            this.clientDAO.save(this.clients);
        } catch (InfraException ex) {
            ex.printStackTrace();
            throw new InfraException(ex.getMessage()+"/Erro de infra ao editar cliente no adaptador.");
        }
    }

    @Override
    public Entity select() throws InfraException {
        for (Client c: this.clients.values()){
            if ((this.cpf.equals(c.getCpf()))){
                return c;
            }
        }
        throw new InfraException("Erro de infra ao tentar encontrar "
                + "cliente no adaptador.");
    }
    
}
