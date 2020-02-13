package edu.elsmancs.Enzilum.domain;

import org.junit.Test;
import static org.junit.Assert.*;


public class AddressTest {

    @Test
    public void generarAddressTest() {
        Address address = new Address();
        address.generateKeyPair();
        assertNotNull(address.getPK());
        assertNotNull(address.getSK());
        assertEquals(0, address.getBalance(), 0);
    }

    @Test
    public void
}
