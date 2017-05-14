package business.control;

//exception for an unsuccessful client registration operations
public class ClientNotAddedException extends EntityNotAddedException {

    public ClientNotAddedException(){
        super("Cliente nao adicionado.");
    }
    
    public ClientNotAddedException(String mensagem){
        super(mensagem);
    }    
}
