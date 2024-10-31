/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class MainController extends HttpServlet {

    public static final String WELCOME_PAGE = "login.html";
    public static final String LOGIN = "Login";
    public static final String LOGIN_CONTROLLER = "LoginController";
    public static final String SEARCH = "Search";
    public static final String SEARCH_CONTROLLER = "SearchController";
    public static final String DELETE = "Delete";
    public static final String DELETE_CONTROLLER = "DeleteController";
    public static final String LOGOUT = "Logout";
    public static final String LOGOUT_CONTROLLER = "LogoutController";
    public static final String UPDATE = "Update";
    public static final String UPDATE_CONTROLLER = "UpdateController";
    public static final String CREATE = "Create";
    public static final String CREATE_CONTROLLER = "CreateController";
    public static final String SHOPPING_PAGE = "Shopping_Page";
    public static final String SHOPPING_PAGE_VIEW = "MainController?action=Search_Product&searchProduct=";
    public static final String ADD = "Add";
    public static final String ADD_CONTROLLER = "AddController";
    public static final String VIEW = "View";
    public static final String VIEW_PAGE = "viewCart.jsp";
    public static final String REMOVE = "Remove";
    public static final String REMOVE_CONTROLLER = "RemoveController";
    public static final String UPDATE_CART = "Update Cart";
    public static final String EDIT_CONTROLLER = "EditController";
    public static final String SEARCH_PRODUCT = "Search_Product";
    public static final String SEARCH_PRODUCT_CONTROLLER = "SearchProductController";
    public static final String CHECKOUT = "Checkout";
    public static final String CHECKOUT_CONTROLLER = "CheckoutController";
    public static final String CREATE_PRODUCT_PAGE = "Create_Product_Page";
    public static final String CREATE_PRODUCT_PAGE_VIEW = "createProduct.jsp";
    public static final String CREATE_PRODUCT = "Create_Product";
    public static final String CREATE_PRODUCT_CONTROLLER = "CreateProductController";
    public static final String UPDATE_PRODUCT = "Update_Product";
    public static final String UPDATE_PRODUCT_CONTROLLER = "UpdateProductController";
    public static final String PROFILE_PAGE = "Profile_Page";
    public static final String PROFILE_PAGE_VIEW = "viewProfile.jsp";
    public static final String BACK_HOME = "Back_Home";
    public static final String BACK_HOME_CONTROLLER = "BackHomeController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = WELCOME_PAGE;
        try {
            String action = request.getParameter("action");

            if (LOGIN.equals(action)) {
                url = LOGIN_CONTROLLER;
            } else if (SEARCH.equals(action)) {
                url = SEARCH_CONTROLLER;
            } else if (DELETE.equals(action)) {
                url = DELETE_CONTROLLER;
            } else if (LOGOUT.equals(action)) {
                url = LOGOUT_CONTROLLER;
            } else if (UPDATE.equals(action)) {
                url = UPDATE_CONTROLLER;
            } else if (CREATE.equals(action)) {
                url = CREATE_CONTROLLER;
            } else if (SHOPPING_PAGE.equals(action)) {
                url = SHOPPING_PAGE_VIEW;
            } else if (ADD.equals(action)) {
                url = ADD_CONTROLLER;
            } else if (VIEW.equals(action)) {
                url = VIEW_PAGE;
            } else if (REMOVE.equals(action)) {
                url = REMOVE_CONTROLLER;
            } else if (UPDATE_CART.equals(action)) {
                url = EDIT_CONTROLLER;
            } else if (SEARCH_PRODUCT.equals(action)) {
                url = SEARCH_PRODUCT_CONTROLLER;
            } else if (CHECKOUT.equals(action)) {
                url = CHECKOUT_CONTROLLER;
            } else if (CREATE_PRODUCT_PAGE.equals(action)) {
                url = CREATE_PRODUCT_PAGE_VIEW;
            } else if (CREATE_PRODUCT.equals(action)) {
                url = CREATE_PRODUCT_CONTROLLER;
            } else if (UPDATE_PRODUCT.equals(action)) {
                url = UPDATE_PRODUCT_CONTROLLER;
            } else if (PROFILE_PAGE.equals(action)) {
                url = PROFILE_PAGE_VIEW;
            } else if (BACK_HOME.equals(action)) {
                url = BACK_HOME_CONTROLLER;
            }

        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
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
