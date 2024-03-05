package control.admin.Supplier;

import dao.impl.SupplierDAO;
import dao.impl.UserDAO;
import entity.Supplier;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AddSupplierControl", urlPatterns = {"/addSupplier"})
public class AddSupplierControl extends HttpServlet {
    
    UserDAO userDao = new UserDAO();
    SupplierDAO supplierDao = new SupplierDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String nameSupplier = request.getParameter("nameSupplier");
        String phoneSupplier = request.getParameter("phoneSupplier");
        String emailSupplier = request.getParameter("emailSupplier");
        String addressSupplier = request.getParameter("addressSupplier");
        String cateID = request.getParameter("cateID");
        
        Supplier sp = new Supplier(nameSupplier, phoneSupplier, emailSupplier, addressSupplier, Integer.parseInt(cateID));
        supplierDao.save(sp);
        request.setAttribute("mess", "Supplier Added!");
        request.getRequestDispatcher("managerSupplier").forward(request, response);
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
