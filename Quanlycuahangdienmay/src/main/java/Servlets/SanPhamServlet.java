package Servlets;

import static Servlets.DBUtils.insertSanpham;
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

@WebServlet(name = "SanPhamServlet", urlPatterns = {"/SanPhamServlet"}) 
public class SanPhamServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, IOException { 
		Connection conn = null; //connect SQL
		try {
			conn = MySQLConntUtils.getMySQLConnection();
			String ma_san_pham=request.getParameter("ma_san_pham");
			String ten_san_pham=request.getParameter("ten_san_pham");
			double gia = Double.parseDouble(request.getParameter("gia"));
			int so_luong_trong_kho=Integer.parseInt(request.getParameter("so_luong_trong_kho"));
			String nha_san_xuat=request.getParameter("nha_san_xuat");
			String ma_danh_muc=request.getParameter("ma_danh_muc");
			
			Sanpham usr=new Sanpham(ma_san_pham, ten_san_pham, gia, so_luong_trong_kho, nha_san_xuat, ma_danh_muc);
			
			DBUtils.insertSanpham(conn, usr);
			request.setAttribute("ma_san_pham", ma_san_pham);
			request.getRequestDispatcher("/SanPhamnew.jsp").forward(request, response);
		} catch (ClassNotFoundException ex) {
            Logger.getLogger(SanPhamServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamServlet.class.getName()).log(Level.SEVERE, null, ex);
       // } catch (NumberFormatException ex) {
       //     Logger.getLogger(SanPhamServlet.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
					Logger.getLogger(SanPhamServlet.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}
}