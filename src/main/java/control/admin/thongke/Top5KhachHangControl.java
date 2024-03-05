package control.admin.thongke;

import dao.impl.TongChiTieuDAO;
import dao.impl.UserDAO;
import entity.Account;
import entity.TongChiTieuBanHang;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "Top5KhachHangControl", urlPatterns = {"/top5khachhang"})
public class Top5KhachHangControl extends HttpServlet {
    
    UserDAO userDao = new UserDAO();
    TongChiTieuDAO tctDao = new TongChiTieuDAO();
    
    
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

        List<Account> listAllAccount = userDao.findAll();
        List<TongChiTieuBanHang> listTop5KhachHang = tctDao.findTopKhachHang(5);


        request.setAttribute("listAllAccount", listAllAccount);
        request.setAttribute("listTop5KhachHang", listTop5KhachHang);
        request.getRequestDispatcher("Top5KhachHang.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}