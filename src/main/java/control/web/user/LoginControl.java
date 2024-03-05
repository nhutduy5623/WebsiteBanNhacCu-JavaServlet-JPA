/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control.web.user;

import dao.impl.UserDAO;
import entity.Account;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kusod
 */
@WebServlet(name = "LoginControl", urlPatterns = {"/login"})
public class LoginControl extends HttpServlet {

    private UserDAO userDao = new UserDAO();
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
//        processRequest(request, response);
//b1 get user,pass from cookie
        Cookie arr[] = request.getCookies();
        if (arr != null) {
            for (Cookie o : arr) {
                if (o.getName().equals("userC")) 
                    request.setAttribute("username", o.getValue());
                if (o.getName().equals("passC")) 
                    request.setAttribute("password", o.getValue());
                
            }
        }
        //b2: set user,pass to login form
        request.getRequestDispatcher("Login.jsp").forward(request, response);
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
//        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("user");
        String password = request.getParameter("pass");
        String remember = request.getParameter("remember");
        
        Account a = userDao.login(username, password);
        if (a == null) {
            request.setAttribute("error", "Sai username hoac password!");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        } else {
            if(a.getTinhTrang()!=1) {
                request.setAttribute("error", "Account is locked");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
                return;
            }                
            HttpSession session = request.getSession();
            session.setAttribute("acc", a);
            session.setMaxInactiveInterval(60 * 60 * 24);
            //luu account len tren cookie
            Cookie u = new Cookie("userC", username);
            Cookie p = new Cookie("passC", password);
            if (remember != null) {
                p.setMaxAge(60 * 60 * 24);
            } else {
                p.setMaxAge(0);
            }

            u.setMaxAge(60 * 60 * 24 * 365);//1 nam

            response.addCookie(u);//luu u va p len Chrome
            response.addCookie(p);

            response.sendRedirect("home");
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
