package business.control;

//Command pattern interface for clients CRUD operations


public interface ClientCrudCommand {
    void execute() throws EntityNotAddedException, EntityNotFoundException;
}
