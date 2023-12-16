package Servlets;
import static Servlets.DBUtils.updateSanpham;
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
@WebServlet("/SanPhamfix")
public class SanPhamfix extends HttpServlet {
    // ...
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {
        Connection conn = null;
        try {
            conn = MySQLConntUtils.getMySQLConnection();
            
			String ma_san_pham=request.getParameter("ma_san_pham");
			String ten_san_pham=request.getParameter("ten_san_pham");
			double gia = Double.parseDouble(request.getParameter("gia"));
			int so_luong_trong_kho=Integer.parseInt(request.getParameter("so_luong_trong_kho"));
			String nha_san_xuat=request.getParameter("nha_san_xuat");
			String ma_danh_muc=request.getParameter("ma_danh_muc");
            
            Sanpham category = new Sanpham(ma_san_pham, ten_san_pham, gia, so_luong_trong_kho, nha_san_xuat, ma_danh_muc);
            DBUtils.updateSanpham(conn, category);
            
            response.sendRedirect("SanPham.jsp"); // Chuyển hướng sau khi sửa thành công
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); // Xử lý hoặc ghi log lỗi
        } finally {
            // Đóng kết nối
        }
    }
}
