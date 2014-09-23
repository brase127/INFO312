package dao;

import domain.Product;
import java.util.Collection;
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
        Product Lipstick = new Product(7891, "Lipstick", "Red, matte", "Makeup", 40.50, 6054);
        dao.save(Lipstick);
        Product retrieved = dao.getById(7891);
        assertEquals("Retrieved student should be the same as the saved one",
                Lipstick, retrieved);
        dao.delete(Lipstick);
        retrieved = dao.getById(7891);
        assertNull("Product should no longer exist", retrieved);
    }

    @Test
    public void testDaoGetAll() {
        Collection<Product> products = dao.getAll();
        assertTrue("Doll should exist in the result", products.contains(doll));
        assertTrue("Ball should exist in the result", products.contains(ball));
        for (Product s : products) {
            if (s.equals(doll)) {
                assertEquals(doll.getId(), s.getId());
                assertEquals(doll.getName(), s.getName());
                assertEquals(doll.getCategory(), s.getCategory());
                assertEquals(doll.getDescription(), s.getDescription());
                assertEquals(doll.getPrice(), s.getPrice());
                assertEquals(doll.getQuantity(), s.getQuantity());
            }
        }
    }

    @Test
    public void testDaoGetById() {
        Product retrieved = dao.getById(dollId);
        assertEquals("Retrieved student should be the same as the saved one",
                doll, retrieved);
        Collection<Product> products = dao.getAll();
        for (Product s : products) {
            if (s.equals(doll)) {
                assertEquals(doll.getId(), s.getId());
                assertEquals(doll.getName(), s.getName());
                assertEquals(doll.getCategory(), s.getCategory());
                assertEquals(doll.getDescription(), s.getDescription());
                assertEquals(doll.getPrice(), s.getPrice());
                assertEquals(doll.getQuantity(), s.getQuantity());
            }
        }
        Integer fakeId = 999999999;
        assertEquals("Making sure a non existant ID returns a null", dao.getById(fakeId), null);
    }
    
    @Test
    public void testDaoGetCategories() {
        Collection<String> retrieved = dao.getCategories();
        assertTrue("Ball category should exist in the result", retrieved.contains(ball.getCategory()));
        assertTrue("Doll category should exist in the result", retrieved.contains(doll.getCategory()));
    }

    @Test
    public void testDaoGetByCategories() {
        Collection<Product> retrieved = dao.getByCategories(ballCategory);
        assertTrue("Ball should exist in the result", retrieved.contains(ball));
        assertEquals("Doll should not exist in the result", retrieved.contains(doll), false);

        Collection<Product> products = dao.getAll();
        for (Product s : products) {
            if (s.equals(doll)) {
                assertEquals(doll.getId(), s.getId());
                assertEquals(doll.getName(), s.getName());
                assertEquals(doll.getCategory(), s.getCategory());
                assertEquals(doll.getDescription(), s.getDescription());
                assertEquals(doll.getPrice(), s.getPrice());
                assertEquals(doll.getQuantity(), s.getQuantity());
            }
        }
        String fakeCategory = "Clothing";
        assertNull("Making sure a non existant category returns a null", dao.getByCategories(fakeCategory));
    }

    @Test
    public void testDaoSaveEdit() {
        Product p = dao.getById(ballId);
        String newName = "Bell";
        p.setName(newName);
        dao.save(p);
        Product s = dao.getById(ballId);
        assertEquals(p.getId(), s.getId());
        assertEquals(p.getName(), s.getName());
        assertEquals(p.getCategory(), s.getCategory());
        assertEquals(p.getDescription(), s.getDescription());
        assertEquals(p.getPrice(), s.getPrice());
        assertEquals(p.getQuantity(), s.getQuantity());
    }
}
