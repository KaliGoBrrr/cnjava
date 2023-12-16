package Servlets;
import static Servlets.DBUtils.updateChitietdonhang;
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
@WebServlet("/ChiTietDonHangfix")
public class ChiTietDonHangfix extends HttpServlet {
    // ...
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {
        Connection conn = null;
        try {
            conn = MySQLConntUtils.getMySQLConnection();
            
			String ma_chi_tiet_don_hang=request.getParameter("ma_chi_tiet_don_hang");
			String ma_don_hang=request.getParameter("ma_don_hang");
			String ma_san_pham=request.getParameter("ma_san_pham");
			int so_luong=Integer.parseInt(request.getParameter("so_luong"));
			double don_gia=Double.parseDouble(request.getParameter("don_gia"));
			double tong_tien=Double.parseDouble(request.getParameter("tong_tien"));
            
			Chitietdonhang category = new Chitietdonhang(ma_chi_tiet_don_hang, ma_don_hang, ma_san_pham, so_luong, don_gia, tong_tien);
            DBUtils.updateChitietdonhang(conn, category);
            
            response.sendRedirect("ChiTietDonHang.jsp"); // Chuyển hướng sau khi sửa thành công
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); // Xử lý hoặc ghi log lỗi
        } finally {
            // Đóng kết nối
        }
    }
}
