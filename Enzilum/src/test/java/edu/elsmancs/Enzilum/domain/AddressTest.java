package edu.elsmancs.Enzilum.domain;

import org.junit.Test;
import static org.junit.Assert.*;
import edu.elsmancs.Enzilum.domain.Address;


public class AddressTest {

    @Test
    public void constructorTest() { //CONSTRUCTOR DEL TEST
        Address address = new Address();
        assertNotNull(address);
        double delta = 0d; //0d significa 0 y decimal
        assertEquals(0d, address.getBalance(), delta);
    }

    @Test
    public void generarAddressTest() {
        Address address = new Address();
        address.generateKeyPair();
        double delta = 0d;
        assertNotNull(address.getPK());
        assertNotNull(address.getSK());
        assertEquals(0, address.getBalance(), 0d);
    }

    @Test
    public void comprobarInserccionEnziniumsTest() {
        Address address = new Address();
        double enziniums = 0d;
        address.transferEZI(enziniums);
        //assertNotNull(address.transferEZI(enziniums));
    }
}
