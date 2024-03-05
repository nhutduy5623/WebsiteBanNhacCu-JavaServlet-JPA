/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control.admin.product;

import dao.impl.ProductDAO;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Color;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kusod
 */
@WebServlet(name = "EditControl", urlPatterns = {"/edit"})
public class EditControl extends HttpServlet {

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
        int pid = Integer.parseInt(request.getParameter("id"));
        Product productOld = productDao.findById(pid);

        String pname = request.getParameter("name");
        String pimage = request.getParameter("image");
        String pimage2 = request.getParameter("image2");
        String pimage3 = request.getParameter("image3");
        String pimage4 = request.getParameter("image4");
        String pmodel = request.getParameter("model");
        String pcolor = request.getParameter("color");
        String pdelivery = request.getParameter("delivery");

        double pprice = Double.parseDouble(request.getParameter("price"));
        String ptitle = request.getParameter("title");
        String pdescription = request.getParameter("description");
        int pcategory = Integer.parseInt(request.getParameter("category"));

        pimage = methodUpdateImg(pimage, productOld.getImage(), request, response);
        pimage2 = methodUpdateImg(pimage2, productOld.getImage2(), request, response);
        pimage3 = methodUpdateImg(pimage3, productOld.getImage3(), request, response);
        pimage4 = methodUpdateImg(pimage4, productOld.getImage4(), request, response);

        Product product = new Product(pid, pname, pimage, pprice, ptitle, pdescription, pmodel, pcolor, pdelivery, pimage2, pimage3, pimage4, pcategory);
        productDao.update(product);
        request.setAttribute("mess", "Edited!");
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

    String methodUpdateImg(String currentImg, String oldImg, HttpServletRequest request, HttpServletResponse response) throws ServletException {
        if (!currentImg.equals("")) {
            currentImg = "uploads/" + currentImg;
//            String urlDeleteFile = "/UploadFile?imgFileName=" + oldImg;
//            try {
//                request.getRequestDispatcher(urlDeleteFile).forward(request, response);
//            } catch (IOException ex) {
//                Logger.getLogger(EditControl.class.getName()).log(Level.SEVERE, null, ex);
//            }
        } else {
            currentImg = oldImg;
        }
        return currentImg;
    }
}
