package DTO;

public class DTO_chiaphongthi {
public String mats, mapt,sbd,tenpt,hoten,sdt;
public float nghe,noi,doc,viet;
 public DTO_chiaphongthi() {
	// TODO Auto-generated constructor stub

	
}
public DTO_chiaphongthi(String mats,String mapt,String sbd,float nghe, float noi, float doc, float viet,String tenpt,String hoten,String sdt) {
	this.mats=mats;
	this.mapt=mapt;
	this.sbd=sbd;
	this.nghe=nghe;
	this.noi=noi;
	this.doc=doc;
	this.viet=viet;
	this.tenpt=tenpt;
	this.hoten=hoten;
	this.sdt=sdt;
}

public String getTenpt() {
	return tenpt;
}
public void setTenpt(String tenpt) {
	this.tenpt = tenpt;
}
public String getMats() {
	return mats;
}
public void setMats(String mats) {
	this.mats = mats;
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
public float getNghe() {
	return nghe;
}
public void setNghe(float nghe) {
	this.nghe = nghe;
}
public float getNoi() {
	return noi;
}
public void setNoi(float noi) {
	this.noi = noi;
}
public float getDoc() {
	return doc;
}
public void setDoc(float doc) {
	this.doc = doc;
}
public float getViet() {
	return viet;
}
public void setViet(float viet) {
	this.viet = viet;
}

}
