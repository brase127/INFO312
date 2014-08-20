/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import domain.Product;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Kendall Lauren Chin
 */
public class DaoTest {
    private ProductDAO dao = new ProductCollectionDAO();
    
    private int ballId = 1234;
    private String ballDescription = "Round";
    private String ballCategory = "Toy";
    private Double ballPrice = 5.20;
    private int ballQuantity = 1000;
    private Product ball;
    
    private int dollId = 4567;
    private String dollDescription = "Pretty";
    private String dollCategory = "Antique";
    private Double dollPrice = 35.80;
    private int dollQuantity = 2000;
    private Product doll;
    
    public DaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ball = new Product(ballId, "Ball", ballDescription, ballCategory, ballPrice, ballQuantity);
        doll = new Product(dollId, "Doll", dollDescription, dollCategory, dollPrice, dollQuantity);
        dao.save(doll);
        dao.save(ball);
    }
    
    @After
    public void tearDown() {
        dao.delete(doll);
        dao.delete(ball);
    }

    @Test
    public void testDaoSaveAndDelete() {
// create student for testing
        Product Lipstick = new Product(7891, "Lipstick", "Red, matte", "Makeup", 40.50, 6054);
// save the student using DAO
        dao.save(Lipstick);
// retrieve the same student via DAO
        Product retrieved = dao.getById(7891);
// ensure that the student we saved is the one we got back
        assertEquals("Retrieved student should be the same as the saved one",
                Lipstick, retrieved);
// delete the student via the DAO
        dao.delete(Lipstick);
// try to retrieve the deleted student
        retrieved = dao.getById(7891);
// ensure that the student was not retrieved (should be null)
        assertNull("Product should no longer exist", retrieved);
    }
}
