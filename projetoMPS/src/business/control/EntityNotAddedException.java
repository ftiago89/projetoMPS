package business.control;


public class EntityNotAddedException extends Exception {

    
    public EntityNotAddedException() {
        super("Nao foi possivel adicionar.");
    }

    
    public EntityNotAddedException(String msg) {
        super(msg);
    }
}
