/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control.web.order_cart;

import dao.impl.CartDAO;
import dao.impl.ProductDAO;
import entity.Account;
import entity.Cart;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "TotalMoneyCartControl", urlPatterns = {"/totalMoneyCart"})
public class TotalMoneyCartControl extends HttpServlet {

    private CartDAO cartDao = new CartDAO();
    private ProductDAO productDao = new ProductDAO();
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
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        int accountID = a.getId();
        
        List<Cart> list = cartDao.getCartByAccountID(accountID);
        List<Product> list2 = productDao.findAll();

        double totalMoney = 0;
        for (Cart o : list) {
            for (Product p : list2) {
                if (o.getProduct().getId() == p.getId()) {
                    totalMoney = totalMoney + p.getPrice() * o.getAmount();
                }
            }
        }

        double totalMoneyVAT = totalMoney + totalMoney * 0.1;

        PrintWriter out = response.getWriter();
        out.println(" <li class=\"d-flex justify-content-between py-3 border-bottom\"><strong class=\"text-muted\">Tổng tiền hàng</strong><strong>" + totalMoney + "</strong></li>\r\n"
                + "                                        <li class=\"d-flex justify-content-between py-3 border-bottom\"><strong class=\"text-muted\">Phí vận chuyển</strong><strong>Free ship</strong></li>\r\n"
                + "                                        <li class=\"d-flex justify-content-between py-3 border-bottom\"><strong class=\"text-muted\">VAT</strong><strong>10 %</strong></li>\r\n"
                + "                                        <li class=\"d-flex justify-content-between py-3 border-bottom\"><strong class=\"text-muted\">Tổng thanh toán</strong>\r\n"
                + "                                            <h5 class=\"font-weight-bold\">" + totalMoneyVAT + "</h5>\r\n"
                + "                                        </li>");

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
