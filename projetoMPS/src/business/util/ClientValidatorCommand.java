package business.util;

import business.control.ValidateException;


public interface ClientValidatorCommand {
    void execute(String s) throws ValidateException;
}
