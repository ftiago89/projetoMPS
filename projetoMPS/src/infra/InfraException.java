package infra;

//exception class for infra package exceptions
public class InfraException extends Exception {
     public InfraException(){
        super("Erro em I/O.");
    }
    
    public InfraException(String mensagem){
        super(mensagem);
    }
}
