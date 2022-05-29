package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import DTO.DTO_chiaphongthi;
import DTO.DTO_thisinh;



public class DAL_xepphongthi {
	 Connect a=new Connect();
	    Connection conn=a.getConnection();
	    static Statement statement;
	    static ResultSet rs;
	   public ArrayList docDSchiaphongthi() throws SQLException
	    {
		  
	        ArrayList dschiapt=new ArrayList<DTO_chiaphongthi>();
	         try{
	        	 
	            String qry="Select MATS,MAPT,SBD from chiaphongthi";
	          
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
	                ts.mapt=rs.getString(2);
	                ts.sbd=rs.getString(3);
	               
	                
	                dschiapt.add(ts);
	            }
	            return dschiapt;

	    }
	   public ArrayList docDSthisinh(String mapt) throws SQLException
	    {
		  
	        ArrayList dsthisinh=new ArrayList<DTO_thisinh>();
	         try{
//	        	 "Select SBD,MAPT,NGHE,NOI,DOC,VIET,HOTEN,SDT from  Where thisinh.SDT like '" + sdt + "'  "
	            String qry="Select HOTEN,GIOITINH,thisinh.MATS,SBD from thisinh INNER JOIN chiaphongthi ON thisinh.MATS=chiaphongthi.MATS Where chiaphongthi.MAPT like '" + mapt + "'  ";
	          
	            Statement st=(Statement) conn.createStatement();
	            rs= st.executeQuery(qry);
	         }
	         catch (SQLException e) {
	             System.out.println(e.getMessage());
	         }

	            while (rs.next())
	            {
	                DTO_thisinh ts=new DTO_thisinh();
	                ts.hoten=rs.getString(1);
	                ts.gioitinh=rs.getString(2);
	                ts.mathisinh=rs.getString(3);
	                ts.sbd=rs.getString(4);
//	                ts.sbd=rs.getString(3);
//	               System.out.println(ts.hoten+"#"+ts.gioitinh);
	                
	                dsthisinh.add(ts);
	            }
	            return dsthisinh;

	    }
	   public String loaiphongthi(String mapt) throws SQLException {
		   JFrame frame = new JFrame("JOptionPane showMessageDialog example");
		   try{
	            String qry="Select SOTHISINH from phongthi Where MAPT like '"+mapt+"'";
	          
	            Statement st=(Statement) conn.createStatement();
	            rs= st.executeQuery(qry);
	            while(rs.next()) {
	            	String n=String.valueOf(rs.getInt(1));
	            if(rs.getInt(1)>=35) return "huy";
	            else return n;
	            }
	         }
	         catch (SQLException e) {
	        	 JOptionPane.showMessageDialog(frame, "Khong co mã phong thi","Error Title", JOptionPane.ERROR_MESSAGE);
	         }
		   
		   
		return "";
		   
		   
	   }
	   public void Themthisinh(DTO_chiaphongthi ts)
	    {
	        try {
	            String qry="INSERT INTO CHIAPHONGTHI VALUES(";
	            qry=qry+"'"+ts.mats+"'";
	            qry=qry+",'"+ts.mapt+"'";
	           
	            qry=qry+",'"+ts.sbd+"'";
	            qry=qry+",'"+ts.nghe+"'";
	            qry=qry+",'"+ts.noi+"'";
	            qry=qry+",'"+ts.doc+"'";
	            qry=qry+",'"+ts.viet+"'";
	            qry=qry+")";
	            Statement st= conn.createStatement();
	             st.executeUpdate(qry);
	        } catch (Exception e){
	            System.out.println(e.toString());
	            }
	    }
	   public String doctenphongthi(String mapt) throws SQLException {
		   JFrame frame = new JFrame("JOptionPane showMessageDialog example");
		   try{
	            String qry="Select TENPT from PHONGTHI where MAPT like '"+mapt+"'";
	          
	            Statement st=(Statement) conn.createStatement();
	            rs= st.executeQuery(qry);
	            while(rs.next()) {
	            	String s1;
	            	s1 = rs.getString(1);
	            	String[] words = s1.split("P");
	            	String word=words[0];
//	            	System.out.println(word);
	            	return word;
	            }

	         }
	         catch (SQLException e) {
	        	 JOptionPane.showMessageDialog(frame, "Khong co mã phong thi","Error Title", JOptionPane.ERROR_MESSAGE);
	         }
		  
			return "";
	
	   }
	   
	   //tu dong cap nhat so thu tu
	   public int capnhatSTT(String trinhdo, String mapt) throws SQLException {
		   JFrame frame = new JFrame("JOptionPane showMessageDialog example");
		   try{
			   int max=0;
	            String qry="Select SBD from CHIAPHONGTHI where MAPT like '"+mapt+"'";
	          
	            Statement st=(Statement) conn.createStatement();
	            rs= st.executeQuery(qry);
	            while(rs.next()) {
	            	String s1;
	            	s1 = rs.getString(1);
	            	String e=String.valueOf(s1.charAt(0));
	            	String f=String.valueOf(s1.charAt(1));
	            	String matrinhdo=e+f;
	            	if(matrinhdo.equalsIgnoreCase(trinhdo)) {
	            	String a=String.valueOf(s1.charAt(2));
	            	String b=String.valueOf(s1.charAt(3));
	            	String c=String.valueOf(s1.charAt(4));
	            	String tong=a+b+c;
	            	int sothutu=Integer.valueOf(tong);
	            	if(sothutu>max) max=sothutu;
//	            			+s1.charAt(3)+s1.charAt(4));
	            	}
	            }
	            
	            System.out.println(max);
            	return max;

	         }
	         catch (SQLException e) {
	        	 JOptionPane.showMessageDialog(frame, "Khong co mã phong thi","Error Title", JOptionPane.ERROR_MESSAGE);
	         }
		  
			return 0;
	
	   }
	   
	   public String docmats(String mats) throws SQLException {
		 
		   try{
			   int k=0;
			   
	            String qry="Select HOTEN from THISINH where MATS like '"+mats+"'";
	          
	            Statement st=(Statement) conn.createStatement();
	            rs= st.executeQuery(qry);
	            while(rs.next()) {
	            	k=k+1;
	            }
	            if(k>0) 
	            return "dung";
	            else return "sai";
	         }
	         catch (SQLException e) {
	        	System.out.println("sai"); 
	        	return "sai";
	         }

	   }
	   public String docmapt(String mapt) throws SQLException {
			 
		   try{
			   int k=0;
			   
	            String qry="Select TENPT from PHONGTHI where MAPT like '"+mapt+"'";
	          
	            Statement st=(Statement) conn.createStatement();
	            rs= st.executeQuery(qry);
	            while(rs.next()) {
	            	k=k+1;
	            }
	            if(k>0) 
	            return "dung";
	            else return "sai";
	           
	         }
	         catch (SQLException e) {
	        	System.out.println("sai"); 
	        	return "sai";
	         }
		

	   }
	   public void updateSothisinh(String mapt,int sts) {
		   JFrame frame = new JFrame("JOptionPane showMessageDialog example");
	
		   try {
			   String qry="Update PHONGTHI set SOTHISINH='";
	           qry=qry+sts+"'";
	          
	           qry=qry+"where MAPT='"+mapt+"'";
	           Statement st=conn.createStatement();
	           st.executeUpdate(qry);
			   
//		   String qry=" UPDATE PHONGTHI SET SOTHISINH = "+sts+" WHERE MAPT like "+mapt;
//	          
//           Statement st=(Statement) conn.createStatement();
//           rs= st.executeQuery(qry);
		   }catch (Exception e) {
			   JOptionPane.showMessageDialog(frame, e.getMessage(),"Error Title", JOptionPane.ERROR_MESSAGE);
		}
           
	   }
	  public void Xoa(String mats) {
		  JFrame frame = new JFrame("JOptionPane showMessageDialog example");
	        try {
	            String qry = "Delete from  CHIAPHONGTHI where MATS='" + mats + "'";
	            Statement st = conn.createStatement();
	            st.executeUpdate(qry);
	        } catch (Exception e) {
	        	 JOptionPane.showMessageDialog(frame, e.getMessage(),"Error Title", JOptionPane.ERROR_MESSAGE);
	        }
	    }

//	   public static void main(String[]args) throws SQLException {
//		   DAL_xepphongthi da=new DAL_xepphongthi();
//		   da.capnhatSTT("B1");
//	   }
	   

}
