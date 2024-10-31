/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.shopping.Cart;
import sample.product.ProductDTO;

/**
 *
 * @author User
 */
@WebServlet(name = "EditController", urlPatterns = {"/EditController"})
public class EditController extends HttpServlet {

    private static final String ERROR = "viewCart.jsp";
    private static final String SUCCESS = "viewCart.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String[] arrayProductID;
            arrayProductID = request.getParameterValues("productID");
            String[] arrayNewQuantity;
            arrayNewQuantity = request.getParameterValues("quantity");

            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("CART");
            if (cart != null) {
                boolean checkEdit = false;
                for (int i = 0; i < arrayProductID.length; i++) {
                    String productID = arrayProductID[i];
                    int newQuantity;
                    newQuantity = Integer.parseInt(arrayNewQuantity[i]);
                    if (cart.getCart().containsKey(productID)) {
                        ProductDTO tea = cart.getCart().get(productID);
                        tea.setQuantity(newQuantity);
                        checkEdit = cart.edit(productID, tea);
                    }
                }
                if (checkEdit) {
                    url = SUCCESS;
                    session.setAttribute("CART", cart);
                }

            }
        } catch (Exception e) {
            log("Error at Edit Controller: " + e.toString());
            request.setAttribute("MESSAGE", "Quantity must be in number and more than 0");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
