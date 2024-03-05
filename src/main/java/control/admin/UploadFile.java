package control.admin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadFile
 */
@WebServlet("/UploadFile")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 50, // 50MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class UploadFile extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int fileQuantity = Integer.parseInt(request.getParameter("fileQuantity"));
        String realPath = getServletContext().getRealPath("/");
        String pathFolderProject = realPath.substring(0, realPath.indexOf("\\target\\"));
        File theDir = new File(pathFolderProject + "\\uploads\\");
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
        String pathUpload = pathFolderProject + "\\uploads\\";
        String pathUploadServer = getServletContext().getRealPath("") + "\\uploads\\";
        theDir = new File(pathUploadServer);
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
//        List<String> ListName = new ArrayList<>();
//        List<Part> ListFilePart = new ArrayList<>();
        String path = "";
        Part filePart;  
        Part ClonefilePart;
        String fileName = "";
        ;
        for (int i = 1; i <= fileQuantity; i++) {
            filePart = request.getPart("file" + i);
            if (!filePart.getSubmittedFileName().equals("")) {
                fileName = filePart.getSubmittedFileName();
                ClonefilePart = filePart;
                path = pathUploadServer + fileName;
                filePart.write(path);
                path = pathUpload + fileName;
                ClonefilePart.write(path);
                System.out.println(path);
            }
//            ListFilePart.add(request.getPart("file" + i));
//            ListName.add(ListFilePart.get(i).getSubmittedFileName());
//            path = getServletContext().getRealPath("/uploads/");

//            path = path + ListName.get(i);
//            ListFilePart.get(i).write(path);
        }
    }

    /**
     * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
     */
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
     */
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
    }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String imgFileName = request.getParameter("imgFileName");  // Lấy tên tệp từ request
        String uploadsPath = getServletContext().getRealPath("");

        File fileToDelete = new File(uploadsPath + File.separator + imgFileName);

        if (fileToDelete.exists() && fileToDelete.isFile()) {
            if (fileToDelete.delete()) {
                response.getWriter().println("Image deleted successfully.");
            } else {
                response.getWriter().println("Failed to delete the image.");
            }
        } else {
            response.getWriter().println("Image does not exist.");
        }
    }
    

}
