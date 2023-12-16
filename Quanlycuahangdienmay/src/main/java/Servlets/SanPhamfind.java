package Servlets;
import static Servlets.DBUtils.findSanpham;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation. WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/SanPhamfind")
public class SanPhamfind extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String keyword = request.getParameter("keyword"); // Lấy từ khóa tìm kiếm từ form

        Connection conn = null;
        List<Sanpham> sanPhamlist = new ArrayList<>();
        
        try {
            conn = MySQLConntUtils.getMySQLConnection();
            

            sanPhamlist = DBUtils.findSanpham(conn, keyword);
            
            request.setAttribute("sanPhamlist", sanPhamlist);
            request.getRequestDispatcher("/SanPhamfind.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
