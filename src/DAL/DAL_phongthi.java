package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import DTO.DTO_phongthi;

public class DAL_phongthi {
	 Connect a=new Connect();
	    Connection conn=a.getConnection();
	  
	   public ArrayList docDSphongthi()
	    {
	        ArrayList dspt=new ArrayList<DTO_phongthi>();
	        
	        try{
	            String qry="Select * from phongthi";
	            Statement st=(Statement) conn.createStatement();
	            ResultSet rs= st.executeQuery(qry);
	            while (rs.next())
	            {
	                DTO_phongthi pt=new DTO_phongthi();
	                pt.maphongthi=rs.getString(1);
	                pt.tenphongthi=rs.getString(2);
	                pt.makt=rs.getString(3);
	                pt.magt1=rs.getString(4);
	                pt.magt2=rs.getString(5);
	                pt.sothisinh=rs.getInt(6);
	                
	                dspt.add(pt);
	            }
	        }catch (Exception e){
	            System.out.println(e.toString());
	            }
	        return dspt;
	    	}
	   public void ThemPT(DTO_phongthi pt)
	    {
		   JFrame frame = new JFrame("JOptionPane showMessageDialog example");
	        try {
	            String qry="INSERT INTO phongthi VALUES(";
	            qry=qry+"'"+pt.maphongthi+"'";
	            qry=qry+",'"+pt.tenphongthi+"'";
	            qry=qry+",'"+pt.makt+"'";
	            qry=qry+",'"+pt.magt1+"'";
	            qry=qry+",'"+pt.magt2+"'";
	            qry=qry+",'"+pt.sothisinh+"'";
	            qry=qry+")";
	            Statement st=(Statement) conn.createStatement();
	            st.executeUpdate(qry);
	          
	            JOptionPane.showMessageDialog(frame, "Them thanh cong"," ", JOptionPane.INFORMATION_MESSAGE);
	        } catch (Exception e){
	        	JOptionPane.showMessageDialog(frame, "ma giam thi da co yeu cau nhap lai","Error Title", JOptionPane.ERROR_MESSAGE);
	        	System.out.println(e.getMessage());
	            }
	    }
	   public String docMAgiamthi(String magt) throws SQLException {
			 
		   try{
			   int k=0;
			   
	            String qry="Select MAGT from giamthi where MAGT like '"+magt+"'";
	          
	            Statement st=(Statement) conn.createStatement();
	            ResultSet rs= st.executeQuery(qry);
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
	   public String docMAgiamthiTuphongthi(String magt) throws SQLException {
			 
		   try{
			   int k=0;
			   int g=0;
			   
	            String qry="Select MAGT1 from phongthi where MAGT1 like '"+magt+"'";
	          
	            Statement st=(Statement) conn.createStatement();
	            ResultSet rs= st.executeQuery(qry);
	            while(rs.next()) {
	            	k=k+1;
	            }
	            if(k==0) 
//	            return "dung";
	            {
	            	String qry1="Select MAGT2 from phongthi where MAGT2 like '"+magt+"'";
	            	Statement st1=(Statement) conn.createStatement();
		            ResultSet rs1= st.executeQuery(qry1);
		            while(rs1.next()) {
		            	g=g+1;
		            }
		            if(g>0) return "sai";
		            else
	            	return "dung";
	         }else return "sai";
	            }
	         catch (SQLException e) {
	        	System.out.println("sai"); 
	        	return "sai";
	         }

	   }
	   //tu dong them so thu tu vao ten phong thi
	   public int capnhatSTT(String trinhdo, String makt) throws SQLException {
		   JFrame frame = new JFrame("JOptionPane showMessageDialog example");
		   try{
			   int max=0;
	            String qry="Select TENPT from PHONGTHI where MAKT like '"+makt+"'";
	          
	            Statement st=(Statement) conn.createStatement();
	            ResultSet rs= st.executeQuery(qry);
	            while(rs.next()) {
	            	String s1;
	            	s1 = rs.getString(1);
	            	
	            	String[] words = s1.split("P");
	            	String word=words[0];
	            	if(word.equalsIgnoreCase(trinhdo)) {
	            	String word1=words[1];
	            	if(Integer.parseInt(word1)>max) max=Integer.parseInt(word1);
//	            	System.out.println(word);
	            	}
	            	
//	            	int sothutu=Integer.valueOf(tong);
//	            	if(sothutu>max) max=sothutu;
//	            			+s1.charAt(3)+s1.charAt(4));
	            	}
	            
	            
	            System.out.println(max);
            	return max;

	         }
	         catch (SQLException e) {
	        	 JOptionPane.showMessageDialog(frame, "Khong co mã phong thi","Error Title", JOptionPane.ERROR_MESSAGE);
	         }
		  
			return 0;
	
	   }
	   
//	    public static void main(String[] args) throws SQLException {
//   	DAL_phongthi da=new DAL_phongthi();
//   	
//   System.out.println(da.docMAgiamthiTuphongthi("4"));	}
   	
	  
}
