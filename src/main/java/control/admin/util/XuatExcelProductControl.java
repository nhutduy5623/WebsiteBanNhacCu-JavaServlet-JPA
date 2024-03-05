/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control.admin.util;


import dao.impl.ProductDAO;
import entity.Product;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "XuatExcelProductControl", urlPatterns = {"/xuatExcelProductControl"})
public class XuatExcelProductControl extends HttpServlet {

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
        
        List<Product> list = productDao.findAll();

        System.out.print(list.get(0));

        int maximum = 2147483647;
        int minimum = 1;

        Random rn = new Random();
        int range = maximum - minimum + 1;
        int randomNum = rn.nextInt(range) + minimum;

        FileOutputStream file = new FileOutputStream("D:\\ExcelWebBanNhacCu\\" + "san-pham" + Integer.toString(randomNum) + ".xlsx");
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
        XSSFCell cell7;
        XSSFCell cell8;
        XSSFCell cell9;
        XSSFCell cell10;
        XSSFCell cell11;

        row = workSheet.createRow(0);
        cell0 = row.createCell(0);
        cell0.setCellValue("ID");
        cell1 = row.createCell(1);
        cell1.setCellValue("Name");
        cell2 = row.createCell(2);
        cell2.setCellValue("Image");
        cell3 = row.createCell(3);
        cell3.setCellValue("Price");
        cell4 = row.createCell(4);
        cell4.setCellValue("Title");
        cell5 = row.createCell(5);
        cell5.setCellValue("Description");
        cell5 = row.createCell(6);
        cell5.setCellValue("Model");
        cell5 = row.createCell(7);
        cell5.setCellValue("Color");
        cell5 = row.createCell(8);
        cell5.setCellValue("Delivery");
        cell5 = row.createCell(9);
        cell5.setCellValue("Image");
        cell5 = row.createCell(10);
        cell5.setCellValue("Image");
        cell5 = row.createCell(11);
        cell5.setCellValue("Image");

        int i = 0;

        for (Product pro : list) {
            i = i + 1;
            row = workSheet.createRow(i);
            cell0 = row.createCell(0);
            cell0.setCellValue(pro.getId());
            cell1 = row.createCell(1);
            cell1.setCellValue(pro.getName());
            cell2 = row.createCell(2);
            cell2.setCellValue(pro.getImage());
            cell3 = row.createCell(3);
            cell3.setCellValue(pro.getPrice());
            cell4 = row.createCell(4);
            cell4.setCellValue(pro.getTitle());
            cell4 = row.createCell(5);
            cell4.setCellValue(pro.getDescription());
            cell4 = row.createCell(6);
            cell4.setCellValue(pro.getModel());
            cell4 = row.createCell(7);
            cell4.setCellValue(pro.getColor());
            cell4 = row.createCell(8);
            cell4.setCellValue(pro.getDelivery());
            cell4 = row.createCell(9);
            cell4.setCellValue(pro.getImage2());
            cell4 = row.createCell(10);
            cell4.setCellValue(pro.getImage3());
            cell4 = row.createCell(11);
            cell4.setCellValue(pro.getImage4());
        }

        workbook.write(file);
        workbook.close();
        file.close();

        request.setAttribute("mess", "Đã xuất file Excel thành công!");
        request.getRequestDispatcher("manager").forward(request, response);
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
