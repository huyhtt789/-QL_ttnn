package DTO;

public class DTO_khoathi {
	public String makt,tenkt,ngaythi;
	public DTO_khoathi() {
		
	}
	 public  DTO_khoathi(String makt, String tenkt, String ngaythi) {
		this.makt=makt;
		this.tenkt=tenkt;
		this.ngaythi=ngaythi;
		}
	public String getMakt() {
		return makt;
	}
	public void setMakt(String makt) {
		this.makt = makt;
	}
	public String getTenkt() {
		return tenkt;
	}
	public void setTenkt(String tenkt) {
		this.tenkt = tenkt;
	}
	public String getNgaythi() {
		return ngaythi;
	}
	public void setNgaythi(String ngaythi) {
		this.ngaythi = ngaythi;
	}
	 
}
