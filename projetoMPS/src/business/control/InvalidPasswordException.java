package business.control;

import business.control.ValidateException;


public class InvalidPasswordException extends ValidateException {


    public InvalidPasswordException() {
        super("Senha invalida.");
    }


    public InvalidPasswordException(String msg) {
        super(msg);
    }
}
