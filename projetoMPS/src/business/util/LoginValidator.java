package business.util;

import business.control.InvalidLoginException;


public class LoginValidator implements ClientValidatorCommand{

    @Override
    public void execute(String login) throws InvalidLoginException {
        if (login.length() > 15){
            throw new InvalidLoginException("Login nao pode conter mais de 15 letras.");
        }else{
            if (login.isEmpty()){
                throw new InvalidLoginException("Campo de login esta vazio.");
            }else{
                if (numberCounter(login) > 0){
                    throw new InvalidLoginException("O login nao pode conter numeros.");
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
