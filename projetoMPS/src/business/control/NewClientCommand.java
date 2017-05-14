package business.control;

//concrete Command implementation for a client registration operation
public class NewClientCommand implements ClientCrudCommand{
    private ClientRegisterControl control;
    private String login, password, name, cpf, email, street, complement, ngbhood,
                    city, state, cep;

    public NewClientCommand(ClientRegisterControl control, String login, String password,
                            String name, String cpf, String email, String street, 
                            String complement, String ngbhood, String city, String state, String cep) {
        this.control = control;
        this.login = login;
        this.password = password;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.street = street;
        this.complement = complement;
        this.ngbhood = ngbhood;
        this.city = city;
        this.state = state;
        this.cep = cep;
    }

        
    
    @Override
    public void execute() throws ClientNotAddedException {
        this.control.addClient(login, password, name, cpf, email, street,
                                complement, ngbhood, city, state, cep);
    }
}
