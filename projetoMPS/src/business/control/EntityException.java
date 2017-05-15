package business.control;


public class EntityException extends Exception {


    public EntityException() {
        super("Excecao de entidade.");
    }

    
    public EntityException(String msg) {
        super(msg);
    }
}
