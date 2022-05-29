package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import DTO.DTO_chiaphongthi;


public class DAL_nhapdiem {
	 Connect a=new Connect();
	    Connection conn=a.getConnection();
	    static Statement statement;
	    static ResultSet rs;
	   public ArrayList docMAPT() throws SQLException
	    {
		  
	        ArrayList dspt=new ArrayList<DTO_chiaphongthi>();
	         try{
	            String qry="Select MAPT from PHONGTHI";
	          
	            Statement st=(Statement) conn.createStatement();
	            rs= st.executeQuery(qry);
	         }
	         catch (SQLException e) {
	             System.out.println(e.getMessage());
	         }
//	            System.out.println("ngut ");
	            while (rs.next())
	            {
	                DTO_chiaphongthi kt=new DTO_chiaphongthi();
	                kt.mapt=rs.getString(1);
	 
	                
	                dspt.add(kt);
	            }

	    
	    return dspt;
	    }
	   public ArrayList docMATS(String mapt) throws SQLException
	    {
		   JFrame frame = new JFrame("JOptionPane showMessageDialog example");
		  int k=0;
	        ArrayList dsts=new ArrayList<DTO_chiaphongthi>();
	         try{
	            String qry="Select MATS from CHIAPHONGTHI where MAPT like '"+mapt+"'";
	          
	            Statement st=(Statement) conn.createStatement();
	            rs= st.executeQuery(qry);
	            while(rs.next()) {
	            	 DTO_chiaphongthi kt=new DTO_chiaphongthi();
		             kt.mats=rs.getString(1);
		             dsts.add(kt);
		             k=k+1;
	            }
	            if(k==0) JOptionPane.showMessageDialog(frame, "ma phong nay chua co thong tin thi sinh","Error Title", JOptionPane.ERROR_MESSAGE);
	         }
	         catch (SQLException e) {
	             System.out.println(e.getMessage());
	         }

	    return dsts;
	    }
	   
	   public ArrayList docDSchiaphongthi() throws SQLException
	    {
		  
	        ArrayList dschiapt=new ArrayList<DTO_chiaphongthi>();
	         try{
	            String qry="Select MATS,SBD, NGHE,NOI,DOC,VIET from chiaphongthi";
	          
	            Statement st=(Statement) conn.createStatement();
	            rs= st.executeQuery(qry);
	         }
	         catch (SQLException e) {
	             System.out.println(e.getMessage());
	         }

	            while (rs.next())
	            {
	                DTO_chiaphongthi ts=new DTO_chiaphongthi();
	                ts.mats=rs.getString(1);
	                
	                ts.sbd=rs.getString(2);
	                ts.nghe=rs.getFloat(3);
	                ts.noi=rs.getFloat(4);
	                ts.doc=rs.getFloat(5);
	                ts.viet=rs.getFloat(6);	
	                dschiapt.add(ts);
	            }
	            return dschiapt;

	    }
	   
	   public void updateDiem(String mats,float nghe,float noi,float doc,float viet) {
		 
			   JFrame frame = new JFrame("JOptionPane showMessageDialog example");
		
			   try {
				   String qry="Update CHIAPHONGTHI set NGHE='";
		           qry=qry+nghe+"', NOI='";
		           qry=qry+noi+"', DOC='";
		           qry=qry+doc+"', VIET='";
		           qry=qry+viet+"'";
		           qry=qry+"where MATS='"+mats+"'";
		           Statement st=conn.createStatement();
		           st.executeUpdate(qry);
				   
			   }catch (Exception e) {
				   JOptionPane.showMessageDialog(frame, e.getMessage(),"Error Title", JOptionPane.ERROR_MESSAGE);
			}
	           
		   }
	   
}
