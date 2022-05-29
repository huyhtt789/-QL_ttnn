package BLL;

import java.sql.SQLException;
import java.util.ArrayList;

import DAL.DAL_timkiemthongtints;
import DAL.DAL_xepphongthi;
import DTO.DTO_chiaphongthi;
import DTO.DTO_thisinh;

public class BLL_timkiem {
	 public static ArrayList <DTO_chiaphongthi> dsts;
	  
	    public void docDSTS(String hoten,String sbd) throws SQLException
	    {
	        DAL_timkiemthongtints data=new DAL_timkiemthongtints();
	        if (dsts==null) 
	            dsts=new ArrayList<DTO_chiaphongthi>();
	        dsts=data.docTimkiemthisinh(hoten,sbd);

	    }
}
