/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.ProductDAO;
import domain.Product;
import java.util.Collection;
import java.util.TreeSet;
import javax.swing.text.DefaultEditorKit;
import static org.fest.swing.core.matcher.DialogMatcher.withTitle;
import static org.fest.swing.core.matcher.JButtonMatcher.withText;
import org.fest.swing.fixture.DialogFixture;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.*;

/**
 *
 * @author Kendall Lauren Chin
 */
public class ProductDialogTest {

    public ProductDialogTest() {
    }
    private ProductDAO dao;
    private DialogFixture fest;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        Collection<String> categories = new TreeSet<>();
        categories.add("Knitting");
        categories.add("Ninjitsu");
        categories.add("Tools");
        dao = mock(ProductDAO.class);
        when(dao.getCategories()).thenReturn(categories);
    }

    @After
    public void tearDown() {
        fest.cleanUp();
    }

    @Test
    public void testEdit() {
        Product hairbrush = new Product(9638, "Hairbrush", "round barrel", "Accessories", 15.65, 6543);
        ProductDialog dialog = new ProductDialog(null, true, hairbrush, dao);
        fest = new DialogFixture(dialog);
        fest.show();
        fest.robot.settings().delayBetweenEvents(100);

        // ensure that the UI components contains hairbursh's details
        fest.textBox("txtId").requireText("9638");
        fest.textBox("txtName").requireText("Hairbrush");
        fest.textBox("txtDescription").requireText("round barrel");
        fest.comboBox("cmbCategory").requireSelection("Accessories");
        fest.textBox("txtPrice").requireText("15.65");
        fest.textBox("txtQuantity").requireText("6543");

        // edit the name, price and description
        fest.textBox("txtName").enterText("").selectAll().enterText("Round Barrel Hairbrush");
        fest.textBox("txtDescription").enterText("").selectAll().enterText("Large round barrel hairbrush for blow drying");
        fest.comboBox("cmbCategory").enterText("").selectAllText().enterText("Tools");
        fest.textBox("txtPrice").enterText("").selectAll().enterText("26.70");
        fest.textBox("txtQuantity").enterText("").selectAll().enterText("1000");

        // click the save button
        fest.button("btnSave").click();
        // create a captor to use to retrieve the passed product from the mocked DAO
        ArgumentCaptor<Product> argument
                = ArgumentCaptor.forClass(Product.class);
        // ensure that the DAO save method was called, and capture the passed product
        verify(dao).save(argument.capture());
        // retrieve the passed product from the captor
        Product edited = argument.getValue();
        // ensure that the changes were saved
        assertEquals("Ensure the name changed", "Round Barrel Hairbrush", edited.getName());
        assertEquals("Ensure the Description changed", "Large round barrel hairbrush for blow drying", edited.getDescription());
        assertEquals("Ensure Categoy changed", "Tools", edited.getCategory());
        assertEquals("Ensure the price changed", new Double(26.70), edited.getPrice());        
        assertEquals("Ensure the quantity changed", new Integer(1000), edited.getQuantity());
    }

    @Test
    public void testSave() {
        ProductDialog dialog = new ProductDialog(null, true, dao);
        fest = new DialogFixture(dialog);
        fest.show();
        fest.robot.settings().delayBetweenEvents(75);

        // TODO: enter some details into the UI components (use enterText and selectItem)
        Product newProduct;
        fest.textBox("txtId").enterText("8527");
        fest.textBox("txtName").enterText("Dog");
        fest.textBox("txtDescription").enterText("Small and fluffy");
        fest.comboBox("cmbCategory").enterText("Animals");
        fest.textBox("txtPrice").enterText("156.70");
        fest.textBox("txtQuantity").enterText("123456");

        // TODO: click the save button
        fest.button("btnSave").click();
        // create a captor to use to retrieve the passed student from the mocked DAO
        ArgumentCaptor<Product> argument
                = ArgumentCaptor.forClass(Product.class);
        // TODO: verify that the DAO save method was called, and capture the passed student
        verify(dao).save(argument.capture());
        // TODO: retrieve the passed student from the captor
        Product edited = argument.getValue();
        // TODO: ensure that the student's ID, name, and major were properly saved 
        assertEquals("Ensure the id saved", new Integer(8527), edited.getId());
        assertEquals("Ensure the name saved", "Dog", edited.getName());
        assertEquals("Ensure the description saved", "Small and fluffy", edited.getDescription());
        assertEquals("Ensure the category saved", "Animals", edited.getCategory());
        assertEquals("Ensure the price saved", new Double(156.70), edited.getPrice());
        assertEquals("Ensure the quantity saved", new Integer(123456), edited.getQuantity());
    }
}
