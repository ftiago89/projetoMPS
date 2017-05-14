package business.control;

//concrete Command implementation for a client removal operation
public class RemoveClientCommand implements ClientCrudCommand{
    private ClientRegisterControl control;
    String cpf;

    public RemoveClientCommand(ClientRegisterControl control, String cpf) {
        this.control = control;
        this.cpf = cpf;
    }
    
    @Override
    public void execute() throws ClientNotFoundException {
        this.control.removeClient(cpf);
    }
}
