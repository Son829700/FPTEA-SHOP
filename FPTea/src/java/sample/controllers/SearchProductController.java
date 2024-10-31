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

/**
 *
 * @author User
 */
@WebServlet(name="SearchProductController", urlPatterns={"/SearchProductController"})
public class SearchProductController extends HttpServlet {
   
     private static final String ERROR="shopping.jsp";
    private static final String US_SUCCESS="shopping.jsp";
    private static final String AD_SUCCESS="admin.jsp";
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       String url = ERROR;
        try {
            String search = request.getParameter("searchProduct");   
            ProductDAO dao = new ProductDAO();
            List<ProductDTO> listProduct = dao.getListProduct(search); 
            int size = listProduct.size();
            int numberOfPage = size%8==0?size/8 : size/8+1;
            int page, numPerPage=8;
            String xPage = request.getParameter("page");
            if(xPage == null){
                page = 1;
            }else{
                page = Integer.parseInt(xPage);
            }
            int start, end;
            start = (page-1)*numPerPage;
            end = Math.min(page*numPerPage, size);
            List<ProductDTO> listProductByPage = dao.getListByPage(listProduct, start, end);
            HttpSession ss = request.getSession();
            UserDTO loginUser = (UserDTO) ss.getAttribute("LOGIN_USER");
            if(listProduct.size()>0){
                request.setAttribute("LIST_PRODUCT", listProduct);                
                request.setAttribute("LIST_PRODUCT_BY_PAGE", listProductByPage);                
                request.setAttribute("PAGE", page);                
                request.setAttribute("NUMBER_OF_PAGE", numberOfPage);                
                if("AD".equals(loginUser.getRoleID())){
                    url = AD_SUCCESS;
                }else if("US".equals(loginUser.getRoleID())){
                    url=US_SUCCESS;
                }                            
            }  
        } catch (Exception e) {
            log("Error at SearchController"+e.toString());
            
        }finally{
            request.getRequestDispatcher(url).forward(request, response);
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
