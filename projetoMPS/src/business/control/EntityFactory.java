package business.control;

//Factory interface for entities creation.
import business.model.Entity;

public interface EntityFactory {
    Entity createEntity();
}
