/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control.admin.thongke;

import dao.impl.OrderDAO;
import dao.impl.UserDAO;
import entity.Account;
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
@WebServlet(name = "DoanhThuTheoThangControl", urlPatterns = {"/doanhThuTheoThang"})
public class DoanhThuTheoThangControl extends HttpServlet {

    OrderDAO orderDao = new OrderDAO();
    UserDAO userDao = new UserDAO();
    
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
        
         System.out.println(totalMoneyMonth1);
         System.out.println(totalMoneyMonth2);
         System.out.println(totalMoneyMonth3);
         System.out.println(totalMoneyMonth4);
         System.out.println(totalMoneyMonth5);
         System.out.println(totalMoneyMonth6);
         System.out.println(totalMoneyMonth7);
         System.out.println(totalMoneyMonth8);
         System.out.println(totalMoneyMonth9);
         System.out.println(totalMoneyMonth10);
         System.out.println(totalMoneyMonth11);
         System.out.println(totalMoneyMonth12);
         
         
         
        
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
        
       
    
        request.getRequestDispatcher("DoanhThuTheoThang.jsp").forward(request, response);
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
