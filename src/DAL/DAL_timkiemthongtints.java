package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.DTO_chiaphongthi;


public class DAL_timkiemthongtints {
	 Connect a=new Connect();
	    Connection conn=a.getConnection();
	   
	 public  ArrayList docTimkiemthisinh(String hoten, String sdt) {
	        ArrayList dsts = new ArrayList<DTO_chiaphongthi>();
	        try {
	        	 String qry;
	        	if(hoten.equalsIgnoreCase(""))
	        		qry="Select SBD,MAPT,NGHE,NOI,DOC,VIET,HOTEN,SDT from thisinh INNER JOIN chiaphongthi ON thisinh.MATS=chiaphongthi.MATS Where thisinh.SDT like '" + sdt + "'  ";
	        	else if(sdt.equalsIgnoreCase(""))
	        		qry = "Select SBD,MAPT,NGHE,NOI,DOC,VIET,HOTEN,SDT from chiaphongthi,thisinh Where thisinh.HOTEN like '%" 
	        		        + hoten + "%'and thisinh.MATS=chiaphongthi.MATS ";
	        	else {
	             qry = "Select SBD,MAPT,NGHE,NOI,DOC,VIET,HOTEN,SDT from chiaphongthi,thisinh Where thisinh.HOTEN like '%" 
	        + hoten + "%' and thisinh.SDT like '" + sdt + "' and thisinh.MATS=chiaphongthi.MATS";}
	            Statement st = conn.createStatement();
	            ResultSet rs = st.executeQuery(qry);
	            while (rs.next()) {
	                DTO_chiaphongthi ts = new DTO_chiaphongthi();
	                ts.sbd = rs.getString(1);
	                ts.mapt = rs.getString(2);
	                System.out.println(ts.sbd+"# "+ts.mapt);
	                ts.nghe = rs.getFloat(3);
	                ts.noi = rs.getFloat(4);
	                ts.doc = rs.getFloat(5);
	                ts.viet = rs.getFloat(6);
	                ts.hoten = rs.getString(7);
	                ts.sdt=rs.getString(8);
	                dsts.add(ts);
	            }

	        } catch (Exception e) {
	            System.out.println(e.toString());
	        }
	        return dsts;
	    }
	    public static void main(String[] args) {
 	DAL_timkiemthongtints da=new DAL_timkiemthongtints();
 	
 	da.docTimkiemthisinh("","asf");}
}
