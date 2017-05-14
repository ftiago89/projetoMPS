package business.control;


public class EntityNotFoundException extends Exception {

    public EntityNotFoundException() {
        super("Nao foi possivel encontrar.");
    }

    
    public EntityNotFoundException(String msg) {
        super(msg);
    }
}
