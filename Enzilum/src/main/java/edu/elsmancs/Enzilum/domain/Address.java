package edu.elsmancs.Enzilum.domain;


import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.KeyPair;

public class Address {

    private PublicKey PK;
    private PrivateKey SK;
    private int balance = 0;
    private String symbol = "EZI";


    public void setPK(PublicKey PK) { //SETTER
        this.PK = PK;
    }

    public PublicKey getPK() { //GETTER
        return this.PK;
    }

    public void setSK(PrivateKey SK) { //SETTER
        this.SK = SK;
    }

    public PrivateKey getSK() { //SETTER
        return this.SK;
    }

    public int getBalance() {  //GETTER BALANCE
        return this.balance;
    }

    public void generateKeyPair() {
        KeyPair pair = GenSig.generateKeyPair();
        this.setSK(pair.getPrivate());
        this.setPK(pair.getPublic());
    }




    @Override

    public String toString() {
        return "\n" + "PK = " + getPK().hashCode() + "\n" +
                "Balance = " + getBalance() + " " +
                this.symbol + "\n";
    }
}
