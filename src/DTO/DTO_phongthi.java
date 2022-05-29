package DTO;

public class DTO_phongthi {
	public String maphongthi,tenphongthi,makt,magt1,magt2;
	public int sothisinh;
	public DTO_phongthi() {
	}
	public DTO_phongthi(String maphongthi, String tenphongthi, int sothisinh,String makt,String magt1,String magt2) {
		this.maphongthi=maphongthi;
		this.tenphongthi=tenphongthi;
		this.sothisinh=sothisinh;
		this.makt=makt;
		this.magt1=magt1;
		this.magt2=magt2;
	}
	
	public String getMagt1() {
		return magt1;
	}
	public void setMagt1(String magt1) {
		this.magt1 = magt1;
	}
	public String getMagt2() {
		return magt2;
	}
	public void setMagt2(String magt2) {
		this.magt2 = magt2;
	}
	public String getMakt() {
		return makt;
	}
	public void setMakt(String makt) {
		this.makt = makt;
	}
	public String getMaphongthi() {
		return maphongthi;
	}
	public void setMaphongthi(String maphongthi) {
		this.maphongthi = maphongthi;
	}
	public String getTenphongthi() {
		return tenphongthi;
	}
	public void setTenphongthi(String tenphongthi) {
		this.tenphongthi = tenphongthi;
	}
	public int getSothisinh() {
		return sothisinh;
	}
	public void setSothisinh(int sothisinh) {
		this.sothisinh = sothisinh;
	}
	
}
