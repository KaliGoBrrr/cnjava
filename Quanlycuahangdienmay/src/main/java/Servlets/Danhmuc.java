package Servlets;

public class Danhmuc {

	private String ma_danh_muc;

	private String ten_danh_muc;

	public Danhmuc(String ma_danh_muc, String ten_danh_muc) {
		this.ma_danh_muc = ma_danh_muc;
		this.ten_danh_muc = ten_danh_muc;
	}
	
	public Danhmuc() {
	}

	public Danhmuc(Danhmuc us) {
		this.ma_danh_muc = us.ma_danh_muc;
		this.ten_danh_muc = us.ten_danh_muc;
	}

	public String getMa_danh_muc() {
		return ma_danh_muc;
	}

	public void setMa_danh_muc(String ma_danh_muc) {
		this.ma_danh_muc = ma_danh_muc;
	}

	public String getTen_danh_muc() {
		return ten_danh_muc;
	}

	public void setTen_danh_muc(String ten_danh_muc) {
		this.ten_danh_muc = ten_danh_muc;
	}
	
}
