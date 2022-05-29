package BLL;

import java.sql.SQLException;
import java.util.ArrayList;

import DAL.DAL_nhapdiem;
import DAL.DAL_xepphongthi;
import DTO.DTO_chiaphongthi;
import DTO.DTO_thisinh;

public class BLL_nhapdiem {
	 public static ArrayList <DTO_chiaphongthi> dspt;
	 public static ArrayList <DTO_chiaphongthi> dsts;
	 public static ArrayList <DTO_chiaphongthi> dsdiem;
	    public void docDSphongthi() throws SQLException
	    {
	        DAL_nhapdiem data=new DAL_nhapdiem();
	        if (dspt==null) 
	            dspt=new ArrayList<DTO_chiaphongthi>();
	        dspt=data.docMAPT();

	    }
	    public void docDSthisinh(String mapt) throws SQLException
	    {
	        DAL_nhapdiem data=new DAL_nhapdiem();
	        if (dsts==null) 
	            dsts=new ArrayList<DTO_chiaphongthi>();
	        dsts=data.docMATS(mapt);

	    }
	    public void updateDiem(String mats,float nghe,float noi,float doc,float viet) {
	    	DAL_nhapdiem data=new DAL_nhapdiem();
	    	data.updateDiem(mats, nghe, noi, doc, viet);
	    }
	    public void docDSchiaphongthi() throws SQLException
	    {
	        DAL_nhapdiem data=new DAL_nhapdiem();
	        if (dsdiem==null) 
	            dsdiem=new ArrayList<DTO_chiaphongthi>();
	        dsdiem=data.docDSchiaphongthi();

	    }
}
