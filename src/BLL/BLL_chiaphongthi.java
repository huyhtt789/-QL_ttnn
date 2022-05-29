package BLL;

import java.sql.SQLException;
import java.util.ArrayList;

import DAL.DAL_xepphongthi;
import DTO.DTO_chiaphongthi;
import DTO.DTO_thisinh;



public class BLL_chiaphongthi {
	 public static ArrayList <DTO_chiaphongthi> dsts;
	 public static ArrayList <DTO_thisinh> dsts1;
	  
	    public void docDSchiaphongthi() throws SQLException
	    {
	        DAL_xepphongthi data=new DAL_xepphongthi();
	        if (dsts==null) 
	            dsts=new ArrayList<DTO_chiaphongthi>();
	        dsts=data.docDSchiaphongthi();

	    }
	    public void docDSthisinh(String mapt) throws SQLException
	    {
	        DAL_xepphongthi data=new DAL_xepphongthi();
	        if (dsts1==null) 
	            dsts1=new ArrayList<DTO_thisinh>();
	        dsts1=data.docDSthisinh(mapt);

	    }
	    public void ThemThisinh(DTO_chiaphongthi ts)
	    {
	    	try {
	        DAL_xepphongthi data=new DAL_xepphongthi();
	        data.Themthisinh(ts);
	        dsts.add(ts);}
	    	catch (Exception e) {
				System.out.println("Sai");
			}
	    }
	    public String LoaiPhongthi(String mapt) throws SQLException {
	    	 DAL_xepphongthi data=new DAL_xepphongthi();
	    	 
				return data.loaiphongthi(mapt);
		
	    }
	    public String doctenphongthi(String mapt) throws SQLException {
	    	DAL_xepphongthi data=new DAL_xepphongthi();
	    	return data.doctenphongthi(mapt);
	    }
	    public String docmathisinh(String mats) throws SQLException {
	    	DAL_xepphongthi data=new DAL_xepphongthi();
	    	return data.docmats(mats);
	    }
	    public String docmaphongthi(String mapt) throws SQLException {
	    	DAL_xepphongthi data=new DAL_xepphongthi();
	    	return data.docmapt(mapt);
	    }
	    public void updateSothisinh(String mapt,int sts) throws SQLException {
	    	DAL_xepphongthi data=new DAL_xepphongthi();
	    	data.updateSothisinh(mapt,sts);
	    }
	    public void Xoa(String mats) {
	    	DAL_xepphongthi data=new DAL_xepphongthi();
	    	data.Xoa(mats);
	    }
	    public int capnhatSTT(String trinhdo,String mapt) throws SQLException {
	    	DAL_xepphongthi data=new DAL_xepphongthi();
	    	return data.capnhatSTT(trinhdo,mapt);
	    }
	    
}
