package infra;

import business.model.BankID;


public class SantanderBank extends BankChain{
    public SantanderBank(){
        super(BankID.Santander);
    }
    
    protected void pay(){
        System.out.println("Santander payment.");
    }
}
