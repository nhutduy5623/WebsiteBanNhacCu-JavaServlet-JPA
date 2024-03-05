/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control.admin.util;

import dao.impl.OrderDAO;
import dao.impl.UserDAO;
import entity.Account;
import entity.EntityOrder;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author kusod
 */
@WebServlet(name = "XuatExcelControl", urlPatterns = {"/xuatExcelControl"})
public class XuatExcelControl extends HttpServlet {

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

        String s_ngayXuat = request.getParameter("dateHoaDon");
        String s_tinhtrang = request.getParameter("tinhTrangXuatfile");
        List<EntityOrder> list = null;
        int tinhtrang = 2;
        if (s_tinhtrang == null || s_tinhtrang.equals("")) {
            s_tinhtrang = "2";
        }
        tinhtrang = Integer.parseInt(s_tinhtrang);
        if (s_ngayXuat == null || s_ngayXuat.equals("")) {
            list = orderDao.findOrderByTinhTrang(tinhtrang);
        } else {
            Date ngayXuat = Date.valueOf(s_ngayXuat);
            list = orderDao.findOrderByTinhTrang_ngayXuat(tinhtrang, ngayXuat);
        }

        List<Account> listAllAccount = userDao.findAll();

        int maximum = 2147483647;
        int minimum = 1;

        Random rn = new Random();
        int range = maximum - minimum + 1;
        int randomNum = rn.nextInt(range) + minimum;

        FileOutputStream file = new FileOutputStream("D:\\ExcelWebBanNhacCu\\" + "hoa-don-" + Integer.toString(randomNum) + ".xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet workSheet = workbook.createSheet("1");
        XSSFRow row;
        XSSFCell cell0;
        XSSFCell cell1;
        XSSFCell cell2;
        XSSFCell cell3;
        XSSFCell cell4;
        XSSFCell cell5;
        XSSFCell cell6;
        row = workSheet.createRow(0);
        cell0 = row.createCell(0);
        cell0.setCellValue("Mã Hóa Đơn");
        cell1 = row.createCell(1);
        cell1.setCellValue("Account");
        cell2 = row.createCell(2);
        cell2.setCellValue("Tổng Giá($)");
        cell3 = row.createCell(3);
        cell3.setCellValue("Ngày Xuất");
        cell4 = row.createCell(4);
        cell4.setCellValue("Số Điện Thoại");
        cell5 = row.createCell(5);
        cell5.setCellValue("Địa Chỉ");
        cell6 = row.createCell(6);
        cell6.setCellValue("Tình Trạng");

        double tongGia;
        int i = 0;
        String tinhTrang = "";
        for (EntityOrder o : list) {
            i = i + 1;
            for (Account a : listAllAccount) {
                if (o.getAccount().getId() == a.getId()) {
                    tongGia = Math.round((o.getTongGia()) * 100.0) / 100.0;
                    row = workSheet.createRow(i);
                    cell0 = row.createCell(0);
                    cell0.setCellValue(o.getId());
                    cell1 = row.createCell(1);
                    cell1.setCellValue(a.getUser());
                    cell2 = row.createCell(2);
                    cell2.setCellValue(tongGia);
                    cell3 = row.createCell(3);
                    cell3.setCellValue(o.getNgayXuat().toString());
                    cell4 = row.createCell(4);
                    cell4.setCellValue(o.getPhoneNumber());
                    cell5 = row.createCell(5);
                    cell5.setCellValue(o.getDiachi());
                    cell6 = row.createCell(6);
                    tinhTrang = "Đã Xử Lý";
                    if (o.getTinhTrang() == 0) {
                        tinhTrang = "Chưa Xử Lý";
                    }
                    cell6.setCellValue(tinhTrang);
                }
            }
        }
        workbook.write(file);
        workbook.close();
        file.close();

        request.setAttribute("mess", "Đã xuất file Excel thành công!");
        request.getRequestDispatcher("hoaDon").forward(request, response);
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
