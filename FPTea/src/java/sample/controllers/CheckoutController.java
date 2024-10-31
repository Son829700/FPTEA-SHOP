/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.shopping.Cart;
import sample.product.ProductDAO;
import sample.product.ProductDTO;
import sample.user.UserDTO;
import sample.utils.Email;

/**
 *
 * @author User
 */
@WebServlet(name = "CheckoutController", urlPatterns = {"/CheckoutController"})
public class CheckoutController extends HttpServlet {

    private static final String ERROR = "viewCart.jsp";
    private static final String SUCCESS = "viewCart.jsp";
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("CART");
            String cartMessage = "";
            String email = request.getParameter("email");
            //check email checkout
            if (Pattern.matches(EMAIL_PATTERN, email)) {
                //            check cart
                if (cart != null) {
                    ProductDAO dao = new ProductDAO();
                    int count = 0;
                    boolean checkQuantity = false;
                    boolean checkQuantityTotal = true;
                    boolean checkUpdateQuantity = false;
                    boolean checkCreateNewOrder = false;
                    boolean checkCreateNewOrderDetail = false;
                    boolean checkCreateNewOrderDetailTotal = true;
//                check Quantity
                    for (ProductDTO tea : cart.getCart().values()) {
                        String productID = tea.getProductID();
                        int quantity = tea.getQuantity();
                        checkQuantity = dao.checkQuantity(productID, quantity);
                        if (!checkQuantity) {
                            checkQuantityTotal = false;
                            if (count == 0) {
                                cartMessage += "The quantity of " + tea.getProductName();
                                count++;
                            } else {
                                cartMessage += ", " + tea.getProductName();
                                count++;
                            }
                        }
                    }
                    //check Total Quantity
                    if (checkQuantityTotal) {
                        //Update Quantity
                        for (ProductDTO tea : cart.getCart().values()) {
                            String productID = tea.getProductID();
                            int quantity = tea.getQuantity();
                            checkUpdateQuantity = dao.checkUpdateQuantity(productID, quantity);
                            if (!checkUpdateQuantity) {
                                cartMessage = "Update quantity fail. Try agian!";
                                break;
                            }
                        }
                        //Create Order
                        if (checkUpdateQuantity) {
                            double total = Double.parseDouble(request.getParameter("total"));
                            UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
                            String userID = user.getUserID();
                            checkCreateNewOrder = dao.createNewOrder(total, userID);
                            if (checkCreateNewOrder) {
                                //Create new OrderDetail
                                for (ProductDTO tea : cart.getCart().values()) {
                                    int orderID = dao.getLastOrderID();
                                    String productID = tea.getProductID();
                                    int quantity = tea.getQuantity();
                                    double price = tea.getPrice();
                                    checkCreateNewOrderDetail = dao.createNewOrderDetail(orderID, productID, price, quantity);
                                    if (!checkCreateNewOrderDetail) {
                                        checkCreateNewOrderDetailTotal = false;
                                        break;
                                    }
                                }
                                if (checkCreateNewOrderDetailTotal) {
                                    cartMessage += "Ordered successfully! Check your email";
                                  
                                    url = SUCCESS;
                                    session.removeAttribute("CART");
                                    Email.sendMail(email, "CONFIRM ORDER MAIL", "Thank you for buying our products ! (Your Order Number is: " + dao.getLastOrderID() + ")");
                                } else {
                                    cartMessage += "Create OrderDetail fail. Try again!";
                                }

                            } else {
                                //check create order fail
                                cartMessage += "Create new order fail. Try agian!";
                            }
                        }

                    } else {
                        //check totalQuantity fail
                        if (count == 1) {
                            cartMessage += " in our stock is not enough!";
                        } else {
                            cartMessage += " in our stock are not enough!";
                        }
                    }

                } else {
                    //CART NULL
                    cartMessage = "Your cart has no products!";
                }

            } else {
                //Worng email
              cartMessage = "Please enter a valid email for checkout!";
            }

            request.setAttribute("CART_MESSAGE", cartMessage);
        } catch (ClassNotFoundException | NumberFormatException | SQLException | NamingException e) {
            log("Error at CheckOutController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }

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
        } catch (SQLException ex) {
            Logger.getLogger(CheckoutController.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(CheckoutController.class.getName()).log(Level.SEVERE, null, ex);
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
