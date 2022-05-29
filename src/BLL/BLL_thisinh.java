package BLL;

import java.sql.SQLException;
import java.util.ArrayList;

import DAL.DAL_thisinh;
import DTO.DTO_thisinh;


public class BLL_thisinh {
	 public static ArrayList <DTO_thisinh> dsts;
	  
	    public void docDSTS() throws SQLException
	    {
	        DAL_thisinh data=new DAL_thisinh();
	        if (dsts==null) 
	            dsts=new ArrayList<DTO_thisinh>();
	        dsts=data.docDSthisinh();

	    }
	    public void ThemTS(DTO_thisinh ts)
	    {
	    	try {
	        DAL_thisinh data=new DAL_thisinh();
	        data.ThemTS(ts);
	        dsts.add(ts);}
	    	catch (Exception e) {
				System.out.println("Sai");
			}
	    }
}
