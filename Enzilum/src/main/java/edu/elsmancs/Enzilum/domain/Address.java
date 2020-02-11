package edu.elsmancs.Enzilum.domain;


import java.security.PrivateKey;
import java.security.PublicKey;

public class Address {

    private PublicKey PK;
    private PrivateKey SK;
    private double balance = 0;
    private String symbol = "EZI";


    public Address(){ // La instancia está en App.java
        Address user =  new Address();

        this.PK = null;
        this.SK = null;
    }

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

    public double getBalance() {  //GETTER BALANCE
        return this.balance;
    }

    public String toString() {
        return "Address de " + this.getPK() +
                "Y el balance de dicho usuario es: " + this.getBalance();
    }


}
