package infra;

import business.model.BankID;


public class BBrasilBank extends BankChain{
    public BBrasilBank(){
        super(BankID.BBrasil);
    }
    
    protected void pay(){
        System.out.println("BBrasil payment.");
    }
}
