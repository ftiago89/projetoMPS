package business.control;

//concrete Command implementation for a client edit operation
public class EditClientCommand implements ClientCrudCommand{
    private ClientRegisterControl control;
    private String name, cpf, email, street, complement, ngbhood,
                    city, state, cep;

    public EditClientCommand(ClientRegisterControl control, String name, String cpf, String email, String street, String complement, String ngbhood, String city, String state, String cep) {
        this.control = control;
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
    public void execute() throws ClientNotFoundException {
        this.control.editClient(name, cpf, email, street, complement, ngbhood,
                                city, state, cep);
    }
}
