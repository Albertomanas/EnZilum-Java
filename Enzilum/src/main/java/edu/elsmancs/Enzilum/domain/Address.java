package edu.elsmancs.Enzilum.domain;


import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.KeyPair;

public class Address {

    private PublicKey PK;
    private PrivateKey SK;
    private double balance = 0;
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

    public double getBalance() {  //GETTER BALANCE
        return this.balance;
    }

    public void generateKeyPair() {
        KeyPair pair = GenSig.generateKeyPair();
        this.setSK(pair.getPrivate());
        this.setPK(pair.getPublic());
    }

    boolean isSKpresent() { //Nivel paquete
        return this.getPK() != null ? true : false;
        /* Elvis operator
        * Si getPK es != null devuelve true, sino false
        * Es una forma de ahorrrte un condicional
         */
    }

    @Override
    public String toString() {
        return "\n" + "PK = " + getPK().hashCode() + "\n" +
                "Balance = " + getBalance() + " " +
                this.symbol + "\n";
    }

    void transferEZI(double enziniums) {
        this.balance += enziniums;
    }  /* Meter dentro de balance(cartera)
        * enziniums
        */


}
