package edu.elsmancs.Enzilum.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TokenContractTest {

    private Address rick = null;
    private Address morty = null;
    private TokenContract ricknillos = null;

     @Before
    public void conjuntoContratosTest() {
        rick = new Address();
        rick.generateKeyPair();
        ricknillos = new TokenContract(rick);
        ricknillos.addOwner(rick.getPK(), 100d);
        assertEquals(1, ricknillos.getBalance().size());

        ricknillos.setTokenPrice(5d);

        morty = new Address();
        morty.generateKeyPair();
    }

   @Test
    public void comprobarAddOwnerTest() {
         ricknillos.addOwner(morty.getPK(),0d);
         assertEquals(2, ricknillos.getBalance().size());

         assertEquals(2, ricknillos.getBalance().size(),0d);

         ricknillos.addOwner(rick.getPK(), 500d);
         assertEquals(100, ricknillos.getBalance().get(rick.getPK()), 0d);
   }

    @Test
    public void balanceOfTest() {
         assertEquals(100d, ricknillos.balanceOf(rick.getPK()), 0d);
         assertEquals(0d, ricknillos.balanceOf(morty.getPK()), 0d);
    }

    @Test
    public void comprobarTransferenciaTest() {
         ricknillos.transfer(morty.getPK(), 2d);
         assertEquals(2d, ricknillos.balanceOf(morty.getPK()),0d);
         assertEquals(98d, ricknillos.balanceOf(rick.getPK()), 0d);
    }


}
