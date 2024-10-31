/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.user.UserDAO;
import sample.user.UserDTO;
import sample.user.UserError;

/**
 *
 * @author User
 */
@WebServlet(name = "CreateController", urlPatterns = {"/CreateController"})
public class CreateController extends HttpServlet {

    private static final String ERROR = "create.jsp";
    private static final String SUCCESS = "create.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        UserError userError = new UserError();
        boolean checkValidation = true;
        UserDAO dao = new UserDAO();
        String inform = "OOPS..! Try again!";
        try {
            String userID = request.getParameter("userID");
            String fullName = request.getParameter("fullName");
            String roleID = request.getParameter("roleID");
            String password = request.getParameter("password");
            String confirm = request.getParameter("confirm");

//            validation
            if (userID.length() < 4 || userID.length() > 10) {
                userError.setUserIDError("UserID must be in [4,10] characters");
                checkValidation = false;
            }
            if (fullName.length() < 5 || fullName.length() > 11) {
                userError.setFullNameError("Full Name must be in [5,10] characters");
                checkValidation = false;
            }
            if (!confirm.equals(password)) {
                userError.setConfirmError("The password does not match!");
                checkValidation = false;
            }
//            Check Duplicate
//            boolean checkDuplicate = dao.checkDuplicate(userID);
//            if(checkDuplicate){
//                userError.setUserIDError("UserID can not duplicate !");
//            }
            if (checkValidation) {
                UserDTO user = new UserDTO(userID, fullName, roleID, password);
                boolean checkInsert = dao.insert(user);
                if (checkInsert) {
                    inform = "Success";
                    request.setAttribute("MESSAGE", "Created account successfully. Login now!");
                    url = SUCCESS;
                } else {
                    userError.setErorr("Insert fail, unknow error!");
                }
            } else {
                request.setAttribute("USER_ERROR", userError);
            }

        } catch (ClassNotFoundException | SQLException e) {
            log("Error at CreateController: " + e.toString());
            if (e.toString().contains("duplicate")) {
                userError.setUserIDError("UserID already exists!");
                request.setAttribute("USER_ERROR", userError);
            }
        } finally {
            request.setAttribute("INFORM", inform);
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
        } catch (NamingException ex) {
            Logger.getLogger(CreateController.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (NamingException ex) {
            Logger.getLogger(CreateController.class.getName()).log(Level.SEVERE, null, ex);
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
