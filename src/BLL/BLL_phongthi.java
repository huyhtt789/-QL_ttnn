package BLL;

import java.sql.SQLException;
import java.util.ArrayList;

import DAL.DAL_khoathi;
import DAL.DAL_phongthi;
import DTO.DTO_khoathi;
import DTO.DTO_phongthi;

public class BLL_phongthi {
	 public static ArrayList <DTO_phongthi> dspt;
	  
	    public void docDSPT() throws SQLException
	    {
	        DAL_phongthi data=new DAL_phongthi();
	        if (dspt==null) 
	            dspt=new ArrayList<DTO_phongthi>();
	        dspt=data.docDSphongthi();

	    }
	    public void ThemPT(DTO_phongthi pt)
	    {
	        DAL_phongthi data=new DAL_phongthi();
	        data.ThemPT(pt);
	        dspt.add(pt);
	    }
	    public String docMAgiamthi(String magt) throws SQLException {
	    	DAL_phongthi data=new DAL_phongthi();
	    	return data.docMAgiamthi(magt);
	    }
	    public String docMAgiamthiTuphongthi(String magt) throws SQLException {
	    	DAL_phongthi data=new DAL_phongthi();
	    	return data.docMAgiamthiTuphongthi(magt);
	    }
	    public int capnhatSTT(String trinhdo, String makt) throws SQLException {
	    	DAL_phongthi data=new DAL_phongthi();
	    	return data.capnhatSTT(trinhdo, makt);
	    }

}
