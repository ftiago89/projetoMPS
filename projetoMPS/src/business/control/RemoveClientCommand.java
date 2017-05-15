package business.control;

//concrete Command implementation for a client removal operation
public class RemoveClientCommand implements ClientCrudCommand{
    private ClientRegisterControl control;
    String email;

    public RemoveClientCommand(ClientRegisterControl control, String email) {
        this.control = control;
        this.email = email;
    }
    
    @Override
    public void execute() throws ClientNotFoundException {
        this.control.removeClient(email);
    }
}
