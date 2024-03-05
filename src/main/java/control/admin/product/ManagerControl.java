/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control.admin.product;

import dao.impl.CategoryDAO;
import dao.impl.ProductDAO;
import dao.impl.UserDAO;
import entity.Account;
import entity.Category;
import entity.Product;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "ManagerControl", urlPatterns = {"/manager"})
public class ManagerControl extends HttpServlet {

    ProductDAO productDao = new ProductDAO();
    UserDAO userDao = new UserDAO();
    CategoryDAO ctgDao = new CategoryDAO();
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

        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        if (a == null) {
            response.sendRedirect("login");
            return;
        }
        // Thêm kiểm tra quyền Admin ở đây
        int id = a.getId();
        int checkIsAdmin = userDao.checkAccountAdmin(id);

        if (checkIsAdmin == 0) {
            // Nếu không phải Admin, chuyển hướng về trang login hoặc trang khác tùy ý
            response.sendRedirect("login");
            return;
        }
        
        String index = request.getParameter("index");
        if (index == null) {
            index = "1";
        }
        int indexPage = Integer.parseInt(index);
        
        List<Product> list = productDao.getProductByIndex(indexPage, 9);
        List<Category> listC = ctgDao.findAll();
        Long allProductBySellID = productDao.countAll();
        Long endPage = allProductBySellID/9;
        if (allProductBySellID %9 != 0) {
            endPage++;
        }

        request.setAttribute("tag", indexPage);
        request.setAttribute("endPage", endPage);
        request.setAttribute("listCC", listC);
        request.setAttribute("listP", list);
        
         System.out.println("List Product: ");
        for(Product p : list) {
            System.out.println(p.getName());
        }

        request.getRequestDispatcher("QuanLySanPham.jsp").forward(request, response);
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
