package Servlets;
import static Servlets.DBUtils.updateDonhang;
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
@WebServlet("/DonHangfix")
public class DonHangfix extends HttpServlet {
    // ...
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {
        Connection conn = null;
        try {
            conn = MySQLConntUtils.getMySQLConnection();
            
            String ma_don_hang=request.getParameter("ma_don_hang");
            String ma_khach_hang=request.getParameter("ma_khach_hang");
			String ma_san_pham=request.getParameter("ma_san_pham");			
			String ngay_mua_hang=request.getParameter("ngay_mua_hang");
            
            Donhang category = new Donhang(ma_don_hang, ma_khach_hang, ma_san_pham ,ngay_mua_hang);
            DBUtils.updateDonhang(conn, category);
            
            response.sendRedirect("DonHang.jsp"); // Chuyển hướng sau khi sửa thành công
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); // Xử lý hoặc ghi log lỗi
        } finally {
            // Đóng kết nối
        }
    }
}
