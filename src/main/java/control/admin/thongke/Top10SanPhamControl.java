package control.admin.thongke;

import dao.impl.ProductDAO;
import dao.impl.UserDAO;
import entity.Account;
import entity.Product;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Top10SanPhamControl", urlPatterns = {"/top10"})
public class Top10SanPhamControl extends HttpServlet {
    
    UserDAO userDao = new UserDAO();
    ProductDAO productDao = new ProductDAO();
    
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
        
       
        List<Product> listTop10Product = productDao.getTopBanChay(10);
        request.setAttribute("listTop10Product", listTop10Product);

        request.getRequestDispatcher("Top10SanPhamBanChay.jsp").forward(request, response);
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