package Servlets;
import static Servlets.DBUtils.deleteDonhang;
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
@WebServlet("/DonHangxoa")
public class DonHangxoa extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma_don_hang = request.getParameter("ma_don_hang");
        Connection conn = null;

        try {
            conn = MySQLConntUtils.getMySQLConnection();
            // Thực hiện xóa dữ liệu từ CSDL dựa trên mã danh mục
            DBUtils.deleteDonhang(conn, ma_don_hang);
            // Sau khi xóa, chuyển hướng người dùng đến trang danh sách danh mục
            response.sendRedirect("DonHang.jsp");
        } catch (ClassNotFoundException | SQLException ex) {
            // Xử lý lỗi nếu có
            ex.printStackTrace();
            // Hoặc chuyển hướng người dùng đến trang lỗi
            response.sendRedirect("Error.jsp");
        } finally {
            // Đóng kết nối CSDL
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
