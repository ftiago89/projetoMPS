package business.control;

//exception for when the client searched does not exist
public class ClientNotFoundException extends EntityNotFoundException {

    public ClientNotFoundException(){
        super("Cliente nao encontrado.");
    }
    
    public ClientNotFoundException(String mensagem){
        super(mensagem);
    }   
}
