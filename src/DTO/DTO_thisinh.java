package DTO;



public class DTO_thisinh {
	public String mathisinh, hoten, ngaysinh, gioitinh,noisinh,cmnd,ngaycap,noicap,sdt,email, mapt, sbd;

	public DTO_thisinh()	{
		
	}
	public DTO_thisinh(String mathisinh,String hoten,String gioitinh,String ngaysinh,String cmnd,String ngaycap,String noicap,String sdt,String email,String mapt,String sbd) {
		this.mathisinh=mathisinh;
		this.hoten=hoten;
		this.gioitinh=gioitinh;
		this.ngaysinh=ngaysinh;
		this.cmnd=cmnd;
		this.ngaycap=ngaycap;
		this.noicap=noicap;
		this.sdt=sdt;
		this.email=email;
		this.mapt=mapt;
		this.sbd=sbd;
	}
	
	public String getMapt() {
		return mapt;
	}
	public void setMapt(String mapt) {
		this.mapt = mapt;
	}
	public String getSbd() {
		return sbd;
	}
	public void setSbd(String sbd) {
		this.sbd = sbd;
	}
	public String getMathisinh() {
		return mathisinh;
	}
	public void setMathisinh(String mathisinh) {
		this.mathisinh = mathisinh;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	
	
	public String getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public String getNoisinh() {
		return noisinh;
	}
	public void setNoisinh(String noisinh) {
		this.noisinh = noisinh;
	}
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	public String getNgaycap() {
		return ngaycap;
	}
	public void setNgaycap(String ngaycap) {
		this.ngaycap = ngaycap;
	}
	public String getNoicap() {
		return noicap;
	}
	public void setNoicap(String noicap) {
		this.noicap = noicap;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
