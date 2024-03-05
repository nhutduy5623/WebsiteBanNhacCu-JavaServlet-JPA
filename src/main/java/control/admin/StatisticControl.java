/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control.admin;

import dao.impl.OrderDAO;
import dao.impl.ProductDAO;
import dao.impl.ReviewDAO;
import dao.impl.UserDAO;
import entity.Account;
import entity.EntityOrder;
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
@WebServlet(name = "StatisticControl", urlPatterns = {"/admin"})
public class StatisticControl extends HttpServlet {

    UserDAO userDao = new UserDAO();
    OrderDAO orderDao = new OrderDAO();
    ReviewDAO reviewDao = new ReviewDAO();
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
        
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        int uID;
        
        if(a == null) {
        	response.sendRedirect("login");
        	return;
        }
        uID= a.getId();
 	   int checkIsAdmin = userDao.checkAccountAdmin(uID);
       if(checkIsAdmin == 0)
       {
       		response.sendRedirect("login");
       		return;
       }
        	
        	
       
        double totalMoney1 = orderDao.totalMoneyDay(1);
        double totalMoney2 = orderDao.totalMoneyDay(2);
        double totalMoney3 = orderDao.totalMoneyDay(3);
        double totalMoney4 = orderDao.totalMoneyDay(4);
        double totalMoney5 = orderDao.totalMoneyDay(5);
        double totalMoney6 = orderDao.totalMoneyDay(6);
        double totalMoney7 = orderDao.totalMoneyDay(7);
        
        double totalMoneyMonth1 = orderDao.totalMoneyMonth(1);
        double totalMoneyMonth2 = orderDao.totalMoneyMonth(2);
        double totalMoneyMonth3 = orderDao.totalMoneyMonth(3);
        double totalMoneyMonth4 = orderDao.totalMoneyMonth(4);
        double totalMoneyMonth5 = orderDao.totalMoneyMonth(5);
        double totalMoneyMonth6 = orderDao.totalMoneyMonth(6);
        double totalMoneyMonth7 = orderDao.totalMoneyMonth(7);
        double totalMoneyMonth8 = orderDao.totalMoneyMonth(8);
        double totalMoneyMonth9 = orderDao.totalMoneyMonth(9);
        double totalMoneyMonth10 = orderDao.totalMoneyMonth(10);
        double totalMoneyMonth11 = orderDao.totalMoneyMonth(11);
        double totalMoneyMonth12 = orderDao.totalMoneyMonth(12);
        
        Long allReview = reviewDao.countAll();
        Long allProduct = reviewDao.countAll();
        double sumAllInvoice = orderDao.sumAllOrder();
        
        List<EntityOrder> listAllInvoice = orderDao.findAll();
        List<Account> listAllAccount = userDao.findAll();
        
        request.setAttribute("listAllInvoice", listAllInvoice);
        request.setAttribute("listAllAccount", listAllAccount);
        request.setAttribute("sumAllInvoice", sumAllInvoice);

        
        request.setAttribute("allReview", allReview);
        request.setAttribute("allProduct", allProduct);
        
        request.setAttribute("totalMoney1", totalMoney1);
        request.setAttribute("totalMoney2", totalMoney2);
        request.setAttribute("totalMoney3", totalMoney3);
        request.setAttribute("totalMoney4", totalMoney4);
        request.setAttribute("totalMoney5", totalMoney5);
        request.setAttribute("totalMoney6", totalMoney6);
        request.setAttribute("totalMoney7", totalMoney7);
        
        request.setAttribute("totalMoneyMonth1", totalMoneyMonth1);
        request.setAttribute("totalMoneyMonth2", totalMoneyMonth2);
        request.setAttribute("totalMoneyMonth3", totalMoneyMonth3);
        request.setAttribute("totalMoneyMonth4", totalMoneyMonth4);
        request.setAttribute("totalMoneyMonth5", totalMoneyMonth5);
        request.setAttribute("totalMoneyMonth6", totalMoneyMonth6);
        request.setAttribute("totalMoneyMonth7", totalMoneyMonth7);
        request.setAttribute("totalMoneyMonth8", totalMoneyMonth8);
        request.setAttribute("totalMoneyMonth9", totalMoneyMonth9);
        request.setAttribute("totalMoneyMonth10", totalMoneyMonth10);
        request.setAttribute("totalMoneyMonth11", totalMoneyMonth11);
        request.setAttribute("totalMoneyMonth12", totalMoneyMonth12);
        
       
    
        request.getRequestDispatcher("Statistic.jsp").forward(request, response);
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
