package BLL;

import java.sql.SQLException;
import java.util.ArrayList;

import DAL.DAL_khoathi;
import DTO.DTO_khoathi;
import DTO.DTO_phongthi;

public class BLL_khoathi {
	  public static ArrayList <DTO_khoathi> dskt;
	  
	    public void docDSKT() throws SQLException
	    {
	        DAL_khoathi data=new DAL_khoathi();
	        if (dskt==null) 
	            dskt=new ArrayList<DTO_khoathi>();
	        dskt=data.docDSkhoathi();
//	        for (DTO_khoathi nv : dskt) {
//	    		 System.out.println("makt "+nv.makt);
//		           
//		            System.out.println("tenn "+nv.tenkt);
//		           
//		            System.out.println("ngay "+nv.ngaythi);}
	    }
	    public void ThemKH(DTO_khoathi kt)
	    {
	        DAL_khoathi data=new DAL_khoathi();
	        data.ThemKT(kt);
	       
	    }
	   
//	    public static void main(String[] args) {
//	    	BLL_khoathi kt=new BLL_khoathi();
//	    	kt.docDSKT();
//	    	
//	    	 
//	    }
}
