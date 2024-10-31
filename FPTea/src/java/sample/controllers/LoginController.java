/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.product.ProductDAO;
import sample.product.ProductDTO;
import sample.user.UserDTO;
import sample.user.UserDAO;

/**
 *
 * @author User
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    private static final String ERROR = "login.jsp";

    private static final String US = "US";
    private static final String AD = "AD";

    private static final String USER_PAGE = "home.jsp";
//    private static final String ADMIN_PAGE = "admin.jsp";
    private static final String ADMIN_PAGE = "MainController?action=Search&search=";

    private static final String ERROR_MESSAGE = "Your role is not support yet !";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = ERROR;
        try {
            String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
            if (!gRecaptchaResponse.equals("")) {
                String userID = request.getParameter("userID");
                String password = request.getParameter("password");
                UserDAO userDao = new UserDAO();
                ProductDAO productDao = new ProductDAO();
                List<ProductDTO> list8Product = productDao.getFirst8Products();
                UserDTO loginUser = userDao.checkLogin(userID, password);
                request.setAttribute("LOGIN_USER", loginUser);
                HttpSession session = request.getSession();
                session.setAttribute("LOGIN_USER", loginUser);
                //Xac thuc 
                if (loginUser != null) {
                    //phan quyen
                    String roleID = loginUser.getRoleID();
                    if (AD.equals(roleID)) {
                        url = ADMIN_PAGE;
                    } else if (US.equals(roleID)) {
                        request.setAttribute("LIST_8PRODUCT", list8Product);
                        url = USER_PAGE;
                    } else {
                        request.setAttribute("ERROR", ERROR_MESSAGE);
                    }
                } else {
                    request.setAttribute("ERROR", "Incorrect UserID or Password !");

                }
            } else {
                request.setAttribute("ERROR", "Please verify you are not a robot!");
            }

        } catch (Exception e) {
            log("Error at LoginController: " + e.toString());

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
