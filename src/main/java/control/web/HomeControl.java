/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control.web;


import dao.impl.CategoryDAO;
import dao.impl.ProductDAO;
import entity.Category;
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
@WebServlet(name = "HomeControl", urlPatterns = {"/home"})
public class HomeControl extends HttpServlet {

    ProductDAO productDAO = new ProductDAO();
    CategoryDAO categoryDAO = new CategoryDAO();
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
        //b1: get data from dao

//        List<Product> list = dao.getAllProduct();
        List<Category> listC = categoryDAO.findAll();
        List<Product> list = productDAO.getTop3();
        List<Product> list8Last = productDAO.getLast(8);
        List<Product> list4GuitarLast = productDAO.findTopProductByCategory(2, 4);
        List<Product> list4DrumLast = productDAO.findTopProductByCategory(3, 4);
        
        Product last = productDAO.getLast(1).get(0);
        
        //b2: set data to jsp
        request.setAttribute("listP", list);
        request.setAttribute("listCC", listC);
        request.setAttribute("list8Last", list8Last);
        request.setAttribute("list4GuitarLast", list4GuitarLast);
        request.setAttribute("list4DrumLast", list4DrumLast);
        request.setAttribute("p", last);
        request.getRequestDispatcher("Home.jsp").forward(request, response);
        //404 -> url
        //500 -> jsp properties
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
