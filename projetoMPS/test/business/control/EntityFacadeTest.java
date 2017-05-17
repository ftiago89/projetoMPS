package business.control;

import business.model.Client;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;


public class EntityFacadeTest {
    
    EntityFacade testFacade;
    
    @Rule
    public final ExpectedException exception = ExpectedException.none();
    
    
    @Before
    public void setUp() {
        testFacade = EntityFacade.getInstance();
    }

    @Test
    public void testAddClient() throws Exception {
        testFacade.addClient("login", "123456789", "Joao", "11111111111", "joao@gmail.com", 
                "rua 1", "casa", "Altiplano", "Joao Pessoa", "pb", "58000-111");        
    }
    
    @Test
    public void testAddClientSame() throws Exception {
        //adding a client that already exists should launch an exception.
        exception.expect(ClientNotAddedException.class);
        testFacade.addClient("login", "123456789", "Joao", "11111111111", "joao@gmail.com", 
                "rua 1", "casa", "altiplano", "joao pessoa", "pb", "58000-111");       
    }
    
    @Test
    public void testAddClientWrongLogin() throws Exception {
        //invalid logins should launch an exception.
        exception.expect(InvalidLoginException.class);
        testFacade.addClient("login1", "123456789", "Maria", "22222222222", "maria@gmail.com", 
                "rua 2", "casa", "Bancarios", "Joao pessoa", "pb", "58000-222");       
    }
    
    @Test
    public void testAddClientWrongPassword() throws Exception {
        //invalid passwords should launch an exception.
        exception.expect(InvalidPasswordException.class);
        testFacade.addClient("login", "abc", "Maria", "22222222222", "maria@gmail.com", 
                "rua 2", "casa", "Bancarios", "Joao pessoa", "pb", "58000-222");       
    }
    
    @Test
    public void testEditClient() throws Exception {
        testFacade.editClient("login", "123456789", "Joao", "11111111111", "joao@gmail.com", 
                "rua bancario", "apartamento 201", "Bancarios", "Joao Pessoa", "pb", "58000-444");
    }
    
    @Test
    public void testEditClientNotFound() throws Exception {
        //the system should not allow to edit a client that is not registered.
        //an exception must be launched.
        exception.expect(ClientNotFoundException.class);
        testFacade.editClient("login", "123456789", "Maria", "22222222222", "maria@gmail.com", 
                "rua 2", "casa", "Bancarios", "Joao pessoa", "pb", "58000-222");
    }

    @Test
    public void testSelectClient() throws Exception {
        assertEquals("Joao", testFacade.selectClient("joao@gmail.com").getName());
    }
    
    @Test
    public void testSelectClientNotFound() throws Exception {
        //the system should not select a client that is not registered.
        //an exception must be launched.
        exception.expect(ClientNotFoundException.class);
        assertNotNull(testFacade.selectClient("maria@gmail.com"));
    }
    
     @Test
    public void testRemoveClient() throws Exception {
        testFacade.removeClient("joao@gmail.com");
    }
    
    @Test
    public void testRemoveClientNotFound() throws Exception {
        //the system should not remove a client that is not registered.
        //an exception must be launched.
        exception.expect(ClientNotFoundException.class);
        testFacade.removeClient("maria@gmail.com");
    }
}
