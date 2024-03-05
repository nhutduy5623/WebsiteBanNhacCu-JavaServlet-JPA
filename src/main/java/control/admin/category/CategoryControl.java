/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control.admin.category;

import dao.impl.ProductDAO;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kusod
 */
@WebServlet(name = "CategoryControl", urlPatterns = {"/category"})
public class CategoryControl extends HttpServlet {

    ProductDAO productDao = new ProductDAO();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int cateID = Integer.parseInt(request.getParameter("cid"));
        //da lay dc category id ve roi
        
        List<Product> list = productDao.findTopProductByCategory(cateID, 1000);
        //in list p day
        PrintWriter out = response.getWriter();
        for (Product o : list) {
            out.println(" <div class=\"product col-12 col-md-6 col-lg-4\">\r\n"
                    + "                                <div class=\"card\">\r\n"
                    + "                                    <img class=\"card-img-top\" src=\"" + o.getImage() + "\" alt=\"Card image cap\">\r\n"
                    + "                                    <div class=\"card-body\">\r\n"
                    + "                                        <h4 class=\"card-title show_txt\"><a href=\"detail?pid=" + o.getId() + "\" title=\"View Product\">" + o.getName() + "</a></h4>\r\n"
                    + "                                        <p class=\"card-text show_txt\">" + o.getTitle() + "</p>\r\n"
                    + "                                        <div class=\"row\">\r\n"
                    + "                                            <div class=\"col\">\r\n"
                    + "                                                <p class=\"btn btn-danger btn-block\">" + o.getPrice() + " $</p>\r\n"
                    + "                                            </div>\r\n"
                    + "                                            <div class=\"col\">\r\n"
                    + "                                                <a href=\"#\" class=\"btn btn-success btn-block\">Add to cart</a>\r\n"
                    + "                                            </div>\r\n"
                    + "                                        </div>\r\n"
                    + "                                    </div>\r\n"
                    + "                                </div>\r\n"
                    + "                            </div>");
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
