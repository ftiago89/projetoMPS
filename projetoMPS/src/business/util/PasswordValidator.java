package business.util;

import business.control.InvalidPasswordException;


public class PasswordValidator implements ClientValidatorCommand{

    @Override
    public void execute(String pass) throws InvalidPasswordException {
        if (pass.length() > 12){
            throw new InvalidPasswordException("Senha nao pode conter mais de 12 letras.");
        }else{
            if ((pass.length()) < 8){
                throw new InvalidPasswordException("A senha precisa ter pelo menos 8 caracteres alfanumericos.");
            }else{
                if (numberCounter(pass) < 2){
                    throw new InvalidPasswordException("A senha precisa ter pelo menos 2 numeros.");
                }
            }
        }
    }
    
    public int numberCounter(String s){
        int i = 0;
        for(int c = 0; c < s.length(); ++c){
            if (Character.isDigit(s.charAt(c))){
                ++i;
            }
        }
        return i;
    }
}
