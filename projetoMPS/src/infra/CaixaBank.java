package infra;

import business.model.BankID;


public class CaixaBank extends BankChain{
    public CaixaBank(){
        super(BankID.Caixa);
    }
    
    protected void pay(){
        System.out.println("Caixa payment.");
    }
}
