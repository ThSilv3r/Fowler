package test;

import main.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    private Customer customer;

    @Before
    public void setUp() {
        customer = new Customer("Sarah");
    }

    @Test
    public void getName() {
        assertEquals("Sarah", customer.getName());
    }
}
