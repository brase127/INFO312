/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.ProductDAO;
import domain.Product;
import gui.helpers.SimpleListModel;
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
public class ProductReportDialogTest {

    public ProductReportDialogTest() {
    }

    private Collection<Product> products;
    private Product ball;
    private Product doll;
    private ProductDAO dao;
    private ProductReportDialog dialog;
    private DialogFixture fest;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        // create some students for testing with
        ball = new Product(123456, "Ball", "Round and bouncy", "Toy", 15.35, 1234);
        doll = new Product(456789, "Doll", "Small and pretty", "Antique", 25.35, 4567);
// add the students to a collection for testing with
        products = new TreeSet<>();
        products.add(ball);
        products.add(doll);
// create a mock for the DAO
        dao = mock(ProductDAO.class);
// stub the getAll method to return the test students collection
        when(dao.getAll()).thenReturn(products);
// stub the getById method to return the appropriate test student based on the passed ID
        when(dao.getById(123456)).thenReturn(ball);
        when(dao.getById(456789)).thenReturn(doll);
// create dialog passing mocked DAO
        dialog = new ProductReportDialog(null, true, dao);
    }

    @After
    public void tearDown() {
                fest.cleanUp();

    }
@Test
    public void testReportView() {
        fest = new DialogFixture(dialog);
        fest.show();
        fest.robot.settings().delayBetweenEvents(75);
        verify(dao
        ).getAll();
        SimpleListModel model
                = (SimpleListModel) fest.list().component().getModel();
// check that the model actually contains the students
        assertTrue("Ensure list contain Jack", model.contains(ball));
        assertTrue("Ensure list contain Jill", model.contains(doll));
        assertTrue("Ensure list contains the correct number of students",
                model.getSize() == products.size());
    }
    @Test
    public void testReportDelete() {
        fest = new DialogFixture(dialog);
        fest.show();
        fest.robot.settings().delayBetweenEvents(75);
// select doll in the list
        fest.list().selectItem(doll.toString());
// click the delete button
        fest.button("btnDelete").click();
// ensure a conrmation dialog is displayed
        DialogFixture confirmDialog
                = fest.dialog(withTitle("Select an Option")
                        .andShowing()).requireVisible();
// click the No button on the conrmation dialog
        confirmDialog.button(withText("No")).click();
// verify that the delete method did NOT get called on the mock DAO
        verify(dao, never()).delete(null);
// select doll again
        fest.list().selectItem(doll.toString());
// click the delete button again
        fest.button("btnDelete").click();
// ensure a conrmation dialog is displayed again
        confirmDialog
                = fest.dialog(withTitle("Select an Option")
                        .andShowing()).requireVisible();
// click the Yes button on the conrmation dialog
        confirmDialog.button(withText("Yes")).click();
// create a captor to use to retrieve the passed product from the mocked DAO
        ArgumentCaptor<Product> argument
                = ArgumentCaptor.forClass(Product.class);
// verify that the DAO delete method was called, and capture the passed product
        verify(dao).delete(argument.capture());
// retrieve the passed product from the captor
        Product deletedStudent = argument.getValue();
// ensure that the correct product was deleted
        assertEquals("Deleted product should be doll", doll, deletedStudent);
    }
    
    @Test
    public void testReportSearch() {
// use FEST to control the dialog
        fest = new DialogFixture(dialog);
        fest.show();
// slow down the FEST robot a bit − default is 30 millis
        fest.robot.settings().delayBetweenEvents(75);
// TODO: enter ball's into the search box
        fest.textBox("txtSearchById").enterText("123456");
// TODO: click the search button
        fest.button("btnSearch").click();
// ensure that getById was called and was passed ball's ID
        verify(dao).getById(ball.getId());
// TODO: get the JList's model
        SimpleListModel model
                = (SimpleListModel) fest.list().component().getModel();
// TODO: ensure that the list is displaying ONLY ball
        assertTrue("Model should only contain ball", model.contains(ball));
        assertFalse("Model should not contain doll", model.contains(doll));
    }

    @Test
    public void testReportEdit() {
// use FEST to control the dialog
        fest = new DialogFixture(dialog);
        fest.show();
// slow down the FEST robot a bit − default is 30 millis
        fest.robot.settings().delayBetweenEvents(75);
// TODO: select Jill in the list
        fest.list().clickItem(doll.toString());
// TODO: click the edit button
        fest.button("btnEdit").click();
// ensure that the StudentDialog appears
        DialogFixture editDialog = fest.dialog("productDialog").requireVisible();
// TODO: ensure the StudentDialog contains the correct student
        editDialog.textBox("txtId").requireText(String.valueOf(doll.getId()));
// (make sure the ID text eld has Jill's ID in it)
      //  assertEquals("The ID text held has Jill's ID in it", jill.getId(), new Integer("4321"));
    }
 }
