package Servlets;
import static Servlets.DBUtils.updateDanhmuc;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation. WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/DanhMucfix")
public class DanhMucfix extends HttpServlet {
    // ...
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {
        Connection conn = null;
        try {
            conn = MySQLConntUtils.getMySQLConnection();
            
            String maDanhMuc = request.getParameter("ma_danh_muc");
            String tenDanhMuc = request.getParameter("ten_danh_muc");
            
            Danhmuc category = new Danhmuc(maDanhMuc, tenDanhMuc);
            DBUtils.updateDanhmuc(conn, category);
            
            response.sendRedirect("DanhMuc.jsp"); // Chuyển hướng sau khi sửa thành công
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); // Xử lý hoặc ghi log lỗi
        } finally {
            // Đóng kết nối
        }
    }
}
