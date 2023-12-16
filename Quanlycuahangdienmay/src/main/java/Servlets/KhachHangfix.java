package Servlets;
import static Servlets.DBUtils.updateKhachhang;
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
@WebServlet("/KhachHangfix")
public class KhachHangfix extends HttpServlet {
    // ...
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {
        Connection conn = null;
        try {
            conn = MySQLConntUtils.getMySQLConnection();
            
			String ma_khach_hang=request.getParameter("ma_khach_hang");
			String ten_khach_hang=request.getParameter("ten_khach_hang");
			String dia_chi=request.getParameter("dia_chi");
			String dien_thoai=request.getParameter("dien_thoai");
			String email=request.getParameter("email");
            
            Khachhang category = new Khachhang(ma_khach_hang, ten_khach_hang, dia_chi, dien_thoai, email);
            DBUtils.updateKhachhang(conn, category);
            
            response.sendRedirect("KhachHang.jsp"); // Chuyển hướng sau khi sửa thành công
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); // Xử lý hoặc ghi log lỗi
        } finally {
            // Đóng kết nối
        }
    }
}
