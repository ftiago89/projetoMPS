package business.control;

import business.model.Client;
import business.model.Entity;
import infra.ClientDaoAdapter;
import infra.InfraException;
import infra.PersistenceAdapter;

//singleton facade for communication with persistence adapters
public class EntityPersistenceFacade {
    private static EntityPersistenceFacade singleton = null;
    private PersistenceAdapter adapter;
    
    private EntityPersistenceFacade(){}
    
    public static synchronized EntityPersistenceFacade getInstance(){
        if (singleton == null){
            singleton = new EntityPersistenceFacade();
        }
        return singleton;
    }
    
    public void addClient(Client c) throws ClientNotAddedException{
        try {
            this.adapter = new ClientDaoAdapter(c);
            adapter.add();
        } catch (InfraException ex) {
            throw new ClientNotAddedException("Nao foi possivel realizar o registro, por favor"
                    + " contacte algum administrador do sistema.");
        }
    }
    
    public void removeClient(String email) throws ClientNotFoundException{
        try {
            this.adapter = new ClientDaoAdapter(email);
            adapter.remove();
        } catch (InfraException ex) {
            throw new ClientNotFoundException("Registro procurado nao encontrado, por favor"
                    + " verifique se o dado esta correto.");
        }
    }
    
    public void editClient(Client c) throws ClientNotFoundException{
        try {
            this.adapter = new ClientDaoAdapter(c);
            adapter.edit();
        } catch (InfraException ex) {
            throw new ClientNotFoundException("Erro ao editar o registro, por favor"
                    + "contacte algum administrador do sistema.");
        }
    }
    
    public Entity selectClient(String email) throws ClientNotFoundException{
        try {
            this.adapter = new ClientDaoAdapter(email);
            return adapter.select();
        } catch (InfraException ex) {
            throw new ClientNotFoundException("Registro procurado nao encontrado, por favor"
                    + "verifique se o dado esta correto.");
        }
    }
}
