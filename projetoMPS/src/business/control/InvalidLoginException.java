package business.control;

import business.control.ValidateException;


public class InvalidLoginException extends ValidateException {


    public InvalidLoginException() {
        super("Login invalido.");
    }

    
    public InvalidLoginException(String msg) {
        super(msg);
    }
}
