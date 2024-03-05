/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control.web.order_cart;

import dao.impl.CartDAO;
import dao.impl.OrderDAO;
import dao.impl.ProductDAO;
import dao.impl.TongChiTieuDAO;
import entity.Account;
import entity.Cart;
import entity.Email;
import entity.EmailUtils;
import entity.EntityOrder;
import entity.Product;
import entity.TongChiTieuBanHang;
import entity.orderDetail;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "OrderControl", urlPatterns = {"/order"})
public class OrderControl extends HttpServlet {

    private CartDAO cartDao = new CartDAO();
    private OrderDAO orderDao = new OrderDAO();
    private ProductDAO productDao = new ProductDAO();
    private TongChiTieuDAO tctDao = new TongChiTieuDAO();

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OrderControl</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OrderControl at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        if (a == null) {
            response.sendRedirect("login");
            return;
        }
        int accountID = a.getId();

        PrintWriter out = response.getWriter();
        List<Cart> listProductCart = cartDao.getCartByAccountID(accountID);
        if (listProductCart.isEmpty()) {
            request.setAttribute("error", "Thất Bại! Giỏ hàng của bạn không có sản phẩm!");
            out.print("<script>alert('Thất bại! không có sản phẩm trong giỏ hàng') </script>");
            response.sendRedirect("ManagerCartControl");
            return;
        }

//        List<Cart> list = dao.getCartByAccountID(accountID);
//        List<Product> list2 = dao.getAllProduct();
//        double totalMoney = 0;
//        for (Cart c : list) {
//            for (Product p : list2) {
//                if (c.getProductID() == p.getId()) {
//                    totalMoney = totalMoney + (p.getPrice() * c.getAmount());
//                }
//            }
//        }
//        double totalMoneyVAT = totalMoney + totalMoney * 0.1;
//
//        double tongTienBanHangThem = 0;
//        int sell_ID;
//        for (Cart c : list) {
//            for (Product p : list2) {
//                if (c.getProductID() == p.getId()) {
//                    tongTienBanHangThem = 0;
//                    sell_ID = dao.getSellIDByProductID(p.getId());
//                    tongTienBanHangThem = tongTienBanHangThem + (p.getPrice() * c.getAmount());
//                    TongChiTieuBanHang t2 = dao.checkTongChiTieuBanHangExist(sell_ID);
//                    if (t2 == null) {
//                        dao.insertTongChiTieuBanHang(sell_ID, 0, tongTienBanHangThem);
//                    } else {
//                        dao.editTongBanHang(sell_ID, tongTienBanHangThem);
//                    }
//                }
//            }
//        }
//
//        for (Cart c : list) {
//            for (Product p : list2) {
//                if (c.getProductID() == p.getId()) {
//                    SoLuongDaBan s = dao.checkSoLuongDaBanExist(p.getId());
//                    if (s == null) {
//                        dao.insertSoLuongDaBan(p.getId(), c.getAmount());
//                    } else {
//                        dao.editSoLuongDaBan(p.getId(), c.getAmount());
//                    }
//                }
//            }
//        }
//
//        TongChiTieuBanHang t = dao.checkTongChiTieuBanHangExist(accountID);
//        if (t == null) {
//            dao.insertTongChiTieuBanHang(accountID, totalMoneyVAT, 0);
//        } else {
//            dao.editTongChiTieu(accountID, totalMoneyVAT);
//        }
        List<Cart> list = cartDao.getCartByAccountID(accountID);
        request.getRequestDispatcher("DatHang.jsp").forward(request, response);
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

        String emailAddress = request.getParameter("email");
        String name = request.getParameter("name");
        String phoneNumber = request.getParameter("phoneNumber");
        String deliveryAddress = request.getParameter("deliveryAddress");

        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        if (a == null) {
            response.sendRedirect("login");
            return;
        }
        int accountID = a.getId();

        List<Cart> listProductCart = cartDao.getCartByAccountID(accountID);
        if (listProductCart.isEmpty()) {
            request.setAttribute("error", "Thất Bại! Giỏ hàng của bạn không có sản phẩm!");
        } else {
            String mess = "";
            List<orderDetail> ListorderDetail = new ArrayList<>();
            Product product = new Product();
            double totalMoney = 0;
            System.out.println("List GH: ");
            mess = mess + "List GH: /n";
            for (Cart c : listProductCart) {
//                mess = mess + " " + c.getAccountID() + "-" + c.getProductID() + "-" + c.getAmount();
                orderDetail orderDetail = new orderDetail();
                product = productDao.findById(c.getProduct().getId());
                orderDetail.setProduct(product);
                orderDetail.setAmount(c.getAmount());
                ListorderDetail.add(orderDetail);

                product.setSoluongdaban(product.getSoluongdaban() + orderDetail.getAmount());
                productDao.update(product);

                totalMoney = totalMoney + (product.getPrice() * c.getAmount());
            }
            double totalMoneyVAT = totalMoney + totalMoney * 0.1;
            EntityOrder order = new EntityOrder();
            order.setDiachi(name);
            order.setEmail(emailAddress);
            order.setPhoneNumber(phoneNumber);
            order.setDiachi(deliveryAddress);
            order.setAccount(a);
            order.setListOrderDetail(ListorderDetail);
            order.setTongGia(totalMoneyVAT);
            orderDao.saveOrder(order);
            request.setAttribute("mess", mess);
            cartDao.deleteCartByAccountID(accountID);

            
            
            TongChiTieuBanHang t = tctDao.checkTCT(accountID);
            if (t == null) {
                t = new TongChiTieuBanHang();
                t.setTongBanHang(0);
                t.setTongChiTieu(totalMoneyVAT);
                t.setUser(a);
                tctDao.save(t);
            } else {
                t.setTongChiTieu(totalMoneyVAT+t.getTongChiTieu());
                tctDao.update(t);
            }

            response.sendRedirect(request.getContextPath() + "/UserOrder");

            //Gửi Mail xác nhận cho khách hàng
            List<Cart> list = cartDao.getCartByAccountID(accountID);
            List<Product> list2 = productDao.findAll();

            Email email = new Email();
            email.setFrom("chibaodang2002@gmail.com"); //chinh lai email quan tri tai day [chu y dung email con hoat dong]
            email.setFromPassword("uzra uyep fqdv kffo"); //mat khau ung dung 2 lop
            email.setTo(emailAddress);
            email.setSubject("Dat hang thanh cong tu SGU Music");
            StringBuilder sb = new StringBuilder();
            sb.append("Dear ").append(name).append("<br>");
            sb.append("Ban vua dat dang tu SGU Music. <br> ");
            sb.append("Dia chi nhan hang cua ban la: <b>").append(deliveryAddress).append(" </b> <br>");
            sb.append("So dien thoai khi nhan hang cua ban la: <b>").append(phoneNumber).append(" </b> <br>");
            sb.append("Cac san pham ban dat la: <br>");
            for (Cart c : list) {
                for (Product p : list2) {
                    if (c.getProduct().getId() == p.getId()) {
                        sb.append(p.getName()).append(" | ").append("Price:").append(p.getPrice()).append("$").append(" | ").append("Amount:").append(c.getAmount()).append(" | ").append("<br>");
                    }
                }
            }
            sb.append("Tong Tien: ").append(String.format("%.02f", totalMoneyVAT)).append("$").append("<br>");
            sb.append("Cam on ban da dat hang tai SGU Music<br>");
            sb.append("Chu cua hang");

            email.setContent(sb.toString());
            try {
                EmailUtils.send(email);
                //request.setAttribute("mess", "Dat hang thanh cong!");
            } catch (Exception ex) {
                Logger.getLogger(OrderControl.class.getName()).log(Level.SEVERE, null, ex);
                //request.setAttribute("error", "Dat hang that bai!");
            }

            return;
        }

        request.getRequestDispatcher("DatHang.jsp").forward(request, response);
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
