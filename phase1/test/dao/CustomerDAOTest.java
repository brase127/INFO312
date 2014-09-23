/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import dao.CustomerJdbcDAO;
import domain.Customer;
import domain.Product;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chike189
 */
public class CustomerDAOTest {
    private CustomerJdbcDAO dao = new CustomerJdbcDAO();
    
    private String aUsername = "abcd1234";
    private String aName = "abcd";
    private String aAddress = "1234 Abcd Street";
    private String aCreditCardDetails = "1234ABCD1234";
    private String aPassword = "ABCD1234ABCD";
    private String aEmail = "ABCD@gmail.com";
    private Customer a;
    
    private String bUsername = "efgh5678";
    private String bName = "efgh";
    private String bAddress = "5678 Efgh Street";
    private String bCreditCardDetails = "5678EFGH5678";
    private String bPassword = "5678EFGH5678";
    private String bEmail = "EFGH@gmail.com";
    private Customer b;
    
    public CustomerDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        a = new Customer(aUsername, aName, aAddress, aCreditCardDetails, aPassword, aEmail);
        b = new Customer(bUsername, bName, bAddress, bCreditCardDetails, bPassword, bEmail);
        dao.save(a);
        dao.save(b);
    }
    
    @After
    public void tearDown() {
        dao.delete(a);
        dao.delete(b);
    }

    @Test
    public void testDaoSaveAndDelete() {
        Customer c = new Customer("ijkl9101", "ijkl", "9101 Ijkl Road", "9101IJKL9101", "IJKLMNOP", "IJKL@gmail.com");
        dao.save(c);
        Customer retrieved = dao.login("ijkl9101", "IJKLMNOP");
        assertEquals("Retrieved student should be the same as the saved one",
                c, retrieved);
        dao.delete(c);
        retrieved = dao.login("ijkl9101", "IJKLMNOP");
        assertNull("Customer should no longer exist", retrieved);
    }
    
}
