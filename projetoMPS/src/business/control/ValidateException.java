package business.control;


public class ValidateException extends Exception {


    public ValidateException() {
        super("Opcao nao valida.");
    }


    public ValidateException(String msg) {
        super(msg);
    }
}
