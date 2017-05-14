package infra;

import business.model.Client;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

//this class loads and saves a clients' hashmap from and to a file.
public class ClientDAO {
    private static ClientDAO singleton = null;
    private File file = new File("clientes");;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    
    private ClientDAO(){}
    
    public static synchronized ClientDAO getInstance(){
        if (singleton == null){
            singleton = new ClientDAO();
        }
        return singleton;
    }
    //save a client hashmap information to a file
    public void save(HashMap<String, Client> u) throws InfraException{

        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
        } catch (FileNotFoundException ex) {
            throw new InfraException("Arquivo nao encontrado ao tentar salvar entidades.");
        } catch (IOException ex) {
            throw new InfraException("Problema de IO ao tentar salvar entidade.");
        }
            
        try {
            oos.writeObject(u);
            oos.flush();
            oos.close();
        } catch (IOException ex) {
            throw new InfraException("Problema de IO ao tentar fechar a stream de dados.");
        }
    }
    
    //load file information to a hashmap.
    public HashMap<String, Client> load() throws InfraException{
        
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
        } catch (FileNotFoundException ex) {
            throw new InfraException("Arquivo nao encontrado ao tentar carregar entidades.");
        } catch (IOException ex) {
            throw new InfraException("Problema de IO ao tentar carregar entidades.");
        }
            
            
        HashMap<String, Client> fileMap = new HashMap();
        try {
            fileMap = (HashMap<String, Client>) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            throw new InfraException("Problema de IO ao tentar carregar entidades no mapa.");
        }
            
            
        try {
            ois.close();
        } catch (IOException ex) {
            throw new InfraException("Problema de IO ao carregar entidades ao tentar fechar a stream"
                    + "de dados.");
        }
        
        //in case there is a null object in the file
        if (fileMap == null){
            fileMap = new HashMap();
        }
        
        return fileMap;            
    }
}
