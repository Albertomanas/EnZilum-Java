package edu.elsmancs.Enzilum.domain;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;


import edu.elsmancs.Enzilum.domain.*;

public class TokenContract {

    private PublicKey ownerPK = null;
    private Address owner = null;  //owner de Address inicializado en null
    private String name = null;
    private String symbol = null;
    private double totalSupply = 0d;
    private Double totalTokensSold = 0d;
    private Double tokenPrice = 0d;
    private final Map<PublicKey, Double> balances = new HashMap<>();

    /* Concepto Mapas EXPLICACIÓN Libro JavaNoresForProfessionals CAP 60.
     *  Map<PublicKey, Double> balances
     *          KeyType(Public key) y ValueType(Double) será la estructura lógica
     *          de nuestro mapa.
     *             balances: Es el nombre que recibirá el mapa
     */


    public TokenContract (Address owner) { // Constructor
        this.owner = owner;
        this.ownerPK = owner.getPK();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String name() {
        return this.name = name;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String symbol() {
        return this.symbol = symbol;
    }

    public void setTotalSupply(double totalSupply) {
        this.totalSupply = totalSupply;
    }

    public double totalSupply() {
        return this.totalSupply;
    }

    public void setTokenPrice(Double tokenPrice) {
        this.tokenPrice = tokenPrice;
    }

    public Double getTokenPrice() {
        return this.tokenPrice;
    }

    public Address owner(){
        return this.owner;
    }

    public Map<PublicKey, Double> getBalance() { // getter mapa de balances
        return this.balances;
    }

     /*
      * Sobreescribir a toString()
      */
     @Override
     public String toString() {
         // Contrato de los Ricknillos
         return "\n" + "name = " + name() + "\n" +
                 "symbol = " + symbol() + "\n" +
                 "Total supply = " + totalSupply() +
                 "Owner PK = " + this.ownerPK.hashCode() +
                 "\n";
     }

     public void addOwner(PublicKey PK, Double units) {
         getBalance().putIfAbsent(PK, units);
         /* Me pasa las pk que están ausentes
          * Así que me da una PK que no tiene un cliente asignado
          */
     }

     public int numOwners() {
         return getBalance().size();
         /* Devuelve la longitud de Balances en el mapa
          * Así que devuelve el número de owners
          */
     }

     public Double balanceOf(PublicKey owner) {
         // Te devuelve las entradas que tiene cada owner
         return getBalance().getOrDefault(owner, 0d);
     }

     private void require(Boolean holds) throws Exception{
         // Booleano que si holds es distinto a lo esperado, salta exception
         if (! holds) {
             throw new Exception();
         }
     }

     public void transfer(PublicKey recipient, Double units) {
        try {
            require(balanceOf(ownerPK) >= units);
            // si el dinero del comprador es >= que units
            this.getBalance().compute(ownerPK , (pk, tokens) -> tokens - units);
            //Estructura compute pag 369 libro JavaNotesForProfessionals
            this.getBalance().put(recipient, balanceOf(recipient) + units);
            // se suma el dinero de las entradas del comprador.
        } catch (Exception e) {}
     }

     public void transfer (PublicKey recipients, PublicKey senders, Double units) {
         try {
             require(balanceOf(senders) >= units);
             this.getBalance().put(senders, balanceOf(senders) - units);
             this.getBalance().put(recipients, balanceOf(recipients) + units);
         } catch (Exception e){}
     }

     public void owners() {
         for (PublicKey pk : this.getBalance().keySet()) {
             // pk de tipo PublicKey de todas las key
             if (!pk.equals(this.ownerPK)) {
                 // si pk.equals es distinto al ownerPK, imprime los compradores
                 System.out.println( "Owner: " + pk.hashCode() + " " + getBalance().get(pk) +
                         " " + this.symbol());
             }
         }
     }

     public int totalTokensSold() {
         this.getBalance().forEach((pk, units) -> this.totalTokensSold += units);
         /*forEach es para todos
          * Coje getBalance de todos las pk y añade las unidades
          */
         this.totalTokensSold -= balanceOf(ownerPK);
         // las vendidas se le restan al vendedor
         return this.totalTokensSold.intValue();
     }

      void payable(PublicKey recipient, Double enziniums) { //nivel paquete
         try {
             require(enziniums >= this.getTokenPrice());
             Double units = Math.floor(enziniums / tokenPrice);
             /*Math.floor es una función matemática, nos permite en este caso
              * dividir enziniums con tokenPrice
              */
             transfer(recipient, units);
             this.owner.transferEZI(enziniums);
         } catch (Exception e) {}
     }



}
