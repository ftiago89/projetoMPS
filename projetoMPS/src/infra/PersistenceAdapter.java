package infra;

import business.model.Entity;


public interface PersistenceAdapter {
    void add() throws InfraException;
    void remove()throws InfraException;
    void edit()throws InfraException;
    Entity select()throws InfraException;
}
