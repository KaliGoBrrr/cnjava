package Servlets;



import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.util.ArrayList; 
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBUtils {
//////////////////////////////////////////////////////////////////////////////////////////////
	public static UserAccount findUser(Connection conn, String Username, String PassWord) throws SQLException {
	
		String sql = "SELECT a.Username, a.PassWord, a.Gender FROM UserAccount a WHERE a.Username = ? AND a.PassWord = ?";

	
	PreparedStatement pstm = conn.prepareStatement(sql);
	
	pstm.setString(1, Username);
	
	pstm.setString(2, PassWord);
	
	ResultSet rs = pstm.executeQuery();
	
	
	if (rs.next()) {
		String Gender = rs.getString("Gender");
		UserAccount user = new UserAccount();
		user.setUsername(Username);
		user.setPassWord(PassWord);
		user.setGender(Gender);
		return user;
	}
	
	return null;
}
		
public static UserAccount findUser(Connection conn, String Username) throws SQLException { 
	String sql = "SELECT a.Username, a.PassWord, a.Gender FROM UserAccount a WHERE a.Username = ?";

		
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, Username);
		
		ResultSet rs = pstm.executeQuery();
		
		
		if (rs.next()) {
			String PassWord=rs.getString("PassWord");
			String Gender = rs.getString("Gender");
			UserAccount user = new UserAccount();
			user.setUsername(Username);
			user.setPassWord(PassWord);
			user.setGender(Gender);
			
			return user;
		}
		return null;
	}
	public static void insertUserAccount(Connection conn, UserAccount user) throws SQLException {
		String sql = "INSERT INTO UserAccount(Username, Gender, PassWord) VALUES (?,?,?)";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, user.getUsername());
		pstm.setString(2, user.getGender());
		pstm.setString(3, user.getPassWord());
		pstm.executeUpdate ();
		}
///////////////////////////////////////////////////////////////////////////////////////////////
public static Danhmuc findDanh(Connection conn, String ma_danh_muc, String ten_danh_muc) throws SQLException {
	
	String sql = "SELECT a.ma_danh_muc, a.ten_danh_muc FROM Danhmuc a WHERE a.ma_danh_muc = ? AND a.ten_danh_muc = ?";


PreparedStatement pstm = conn.prepareStatement(sql);

pstm.setString(1, ma_danh_muc);

pstm.setString(2, ten_danh_muc);

ResultSet rs = pstm.executeQuery();


if (rs.next()) {
	Danhmuc user = new Danhmuc();
	user.setMa_danh_muc(ma_danh_muc);
	user.setTen_danh_muc(ten_danh_muc);
	return user;
}

return null;
}
	
public static Danhmuc findDanh(Connection conn, String ma_danh_muc) throws SQLException { 
String sql = "SELECT a.ma_danh_muc, a.ten_danh_muc FROM Danhmuc a WHERE a.ma_danh_muc = ?";

	
	PreparedStatement pstm = conn.prepareStatement(sql);
	pstm.setString(1, ma_danh_muc);
	
	ResultSet rs = pstm.executeQuery();
	
	
	if (rs.next()) {
		String ten_danh_muc=rs.getString("Ten_danh_muc");
		Danhmuc user = new Danhmuc();
		user.setMa_danh_muc(ma_danh_muc);
		user.setTen_danh_muc(ten_danh_muc);
		
		return user;
	}
	return null;
}
public static void insertDanhmuc(Connection conn, Danhmuc user) throws SQLException {
	String sql = "INSERT INTO Danhmuc(ma_danh_muc, ten_danh_muc) VALUES (?,?)";
	
	PreparedStatement pstm = conn.prepareStatement(sql);
	pstm.setString(1, user.getMa_danh_muc());
	pstm.setString(2, user.getTen_danh_muc());
	pstm.executeUpdate ();
	}
public static void updateDanhmuc(Connection conn, Danhmuc danhMuc) throws SQLException {
    String sql = "UPDATE Danhmuc SET ten_danh_muc = ? WHERE ma_danh_muc = ?";
    
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setString(1, danhMuc.getTen_danh_muc());
    pstm.setString(2, danhMuc.getMa_danh_muc());
    
    pstm.executeUpdate();
}

public static void deleteDanhmuc(Connection conn, String ma_danh_muc) throws SQLException {
    String sql = "DELETE FROM Danhmuc WHERE ma_danh_muc = ?";
    
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setString(1, ma_danh_muc);
    
    pstm.executeUpdate();
}

public static List<Danhmuc> findDanhmuc(Connection conn, String keyword) throws SQLException {
    List<Danhmuc> danhMucList = new ArrayList<>();
    String sql = "SELECT ma_danh_muc, ten_danh_muc FROM Danhmuc WHERE ten_danh_muc LIKE ?";
    
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setString(1, "%" + keyword + "%");
    
    ResultSet rs = pstm.executeQuery();
    
    while (rs.next()) {
        Danhmuc danhMuc = new Danhmuc();
        danhMuc.setMa_danh_muc(rs.getString("ma_danh_muc"));
        danhMuc.setTen_danh_muc(rs.getString("ten_danh_muc"));

        danhMucList.add(danhMuc);
    }
    
    return danhMucList;
}

}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
