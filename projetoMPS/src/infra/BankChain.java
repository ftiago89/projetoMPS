package infra;

import business.model.BankID;


public abstract class BankChain {
    protected BankChain next;
    protected BankID bankId;
    
    public BankChain(BankID id){
        next = null;
        this.bankId = id;
    }
    
    public void setNext(BankChain param) {
        if (next == null) {
            next = param;
        } else {
            next.setNext(param);
        }
    }
    
    public void executePayment(BankID id) throws InfraException {
    if (canExecutePayment(id)) {
        pay();
    } else {
        if (next == null) {
            throw new InfraException("Bank not registered");
        }
        next.executePayment(id);
    }
}
 
private boolean canExecutePayment(BankID id) {
    if (this.bankId == id) {
        return true;
    }
    return false;
}
 
protected abstract void pay();
}
