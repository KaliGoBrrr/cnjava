package Servlets;

public class Sanpham {
	
	private String ma_san_pham;
	private String ten_san_pham;
	private Double gia;
	private int so_luong_trong_kho;
	private String nha_san_xuat;
	private String ma_danh_muc;
	
	public Sanpham(String ma_san_pham, String ten_san_pham, Double gia, int so_luong_trong_kho, String nha_san_xuat,
			String ma_danh_muc) {		
		this.ma_san_pham = ma_san_pham;
		this.ten_san_pham = ten_san_pham;
		this.gia = gia;
		this.so_luong_trong_kho = so_luong_trong_kho;
		this.nha_san_xuat = nha_san_xuat;
		this.ma_danh_muc = ma_danh_muc;
	}
	public Sanpham() {
	}
	public Sanpham(Sanpham us) {
		this.ma_san_pham = us.ma_san_pham;
		this.ten_san_pham = us.ten_san_pham;
		this.gia = us.gia;
		this.so_luong_trong_kho = us.so_luong_trong_kho;
		this.nha_san_xuat = us.nha_san_xuat;
		this.ma_danh_muc = us.ma_danh_muc;
	}
	public String getMa_san_pham() {
		return ma_san_pham;
	}
	public void setMa_san_pham(String ma_san_pham) {
		this.ma_san_pham = ma_san_pham;
	}
	public String getTen_san_pham() {
		return ten_san_pham;
	}
	public void setTen_san_pham(String ten_san_pham) {
		this.ten_san_pham = ten_san_pham;
	}
	public Double getGia() {
		return gia;
	}
	public void setGia(Double gia) {
		this.gia = gia;
	}
	public int getSo_luong_trong_kho() {
		return so_luong_trong_kho;
	}
	public void setSo_luong_trong_kho(int so_luong_trong_kho) {
		this.so_luong_trong_kho = so_luong_trong_kho;
	}
	public String getNha_san_xuat() {
		return nha_san_xuat;
	}
	public void setNha_san_xuat(String nha_san_xuat) {
		this.nha_san_xuat = nha_san_xuat;
	}
	public String getMa_danh_muc() {
		return ma_danh_muc;
	}
	public void setMa_danh_muc(String ma_danh_muc) {
		this.ma_danh_muc = ma_danh_muc;
	}
	
}
