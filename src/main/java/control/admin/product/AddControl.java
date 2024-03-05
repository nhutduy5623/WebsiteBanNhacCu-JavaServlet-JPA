/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control.admin.product;

import dao.impl.ProductDAO;
import entity.Account;
import entity.Product;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kusod
 */
@WebServlet(name = "AddControl", urlPatterns = {"/add"})
public class AddControl extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
                
        String pname = request.getParameter("name");
        String pimage = "uploads/"+request.getParameter("image");

        String pimage2 = "uploads/"+request.getParameter("image2");
        String pimage3 = "uploads/"+request.getParameter("image3");
        String pimage4 = "uploads/"+request.getParameter("image4");
        String pmodel = request.getParameter("model");
        String pcolor = request.getParameter("color");
        String pdelivery = request.getParameter("delivery");

        double pprice = Double.parseDouble(request.getParameter("price"));
        String ptitle = request.getParameter("title");
        String pdescription = request.getParameter("description");
        int pcategory = Integer.parseInt(request.getParameter("category"));
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        int sid = a.getId();
        Product product = new Product(pname, pimage, pprice, ptitle, pdescription, pmodel, pcolor, pdelivery, pimage2, pimage3, pimage4, pcategory, 1);
        productDao.save(product);
        request.setAttribute("mess", "Product Added!");
        request.getRequestDispatcher("manager").forward(request, response);
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
