/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.OrderJdbcDAO;
import domain.Customer;
import domain.Order;
import domain.OrderItem;
import domain.Product;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author Kendall Lauren Chin
 */
@WebServlet(name = "ConfirmOrderServlet", urlPatterns = {"/ConfirmOrderServlet"})
public class ConfirmOrderServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws org.apache.commons.mail.EmailException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, EmailException {

        HttpSession session = request.getSession();
        Order order = (Order) session.getAttribute("order");
        OrderJdbcDAO dao = new OrderJdbcDAO();
        dao.save(order);

        Customer cust = (Customer) session.getAttribute("customer");

        List<OrderItem> orderItems = order.getItems();

        String customerHeader = "Dear " + cust.getName() + "\n" + "\n";
        String confirm = "This is a confirmation of your order #" + order.getOrderId() + ", processed " + order.getDate() + ".\n\n\n";
        String items = "\tYour order contains: \n";
        for (OrderItem orderitems : orderItems) {
            Product product = orderitems.getaProduct();
            items += "\t\t" + product.getName() + ", $" + product.getPrice() + ", quantity: " + orderitems.getQuantityPurchased() + ", total: $" + orderitems.getItemTotal() + ".\n";
        }
        
        String total = "\n\tOrder total: $" + String.valueOf(order.getTotal()) + "\n\n\n";
        String goodbye = "If you have any questions contact us or send an email to BeautyBox@gmail.com \n" + "Beauty Box Crew!";
        String message = customerHeader + confirm + items + total + goodbye;
String subject = "Beauty Box Order #" +order.getOrderId()+" Confirmation";
        Email email = new SimpleEmail();
        email.setHostName("localhost");
        email.setSmtpPort(2525);
        email.setFrom("BeautyBox@gmail.com");
        email.setSubject(subject);
        email.setMsg(message);
        email.addTo(cust.getEmail());
        email.send();

        session.setAttribute("order", new Order(cust));
        response.sendRedirect("/shopping/restricted/Thanks.jsp");
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (EmailException ex) {
            Logger.getLogger(ConfirmOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (EmailException ex) {
            Logger.getLogger(ConfirmOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
