package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

//import BLL.BLL_khoathi;
import DTO.DTO_khoathi;
//import java.sql.Statement;

public class DAL_khoathi {

	    Connect a=new Connect();
	    Connection conn=a.getConnection();
	    static Statement statement;
	    static ResultSet rs;
	   public ArrayList docDSkhoathi() throws SQLException
	    {
		  
	        ArrayList dskt=new ArrayList<DTO_khoathi>();
	         try{
	            String qry="Select * from KHOATHI";
	          
	            Statement st=(Statement) conn.createStatement();
	            rs= st.executeQuery(qry);
	         }
	         catch (SQLException e) {
	             System.out.println(e.getMessage());
	         }
//	            System.out.println("ngut ");
	            while (rs.next())
	            {
	                DTO_khoathi kt=new DTO_khoathi();
	                kt.makt=rs.getString(1);
	                kt.tenkt=rs.getString(2);
	                kt.ngaythi=rs.getString(3);
//	                System.out.println("makt "+kt.makt);
//			           
//		            System.out.println("tenn "+kt.tenkt);
//		           
//		            System.out.println("ngay "+kt.ngaythi);
	                
	                dskt.add(kt);
	            }

	    
	    return dskt;
	    }
	   public void ThemKT(DTO_khoathi kt)
	    {
		   JFrame frame = new JFrame("JOptionPane showMessageDialog example");
	        try {
	            String qry="INSERT INTO KHOATHI VALUES(";
	            qry=qry+"'"+kt.makt+"'";
	            qry=qry+",'"+kt.tenkt+"'";
	           
	            qry=qry+",'"+kt.ngaythi+"'";
	            qry=qry+")";
	            Statement st= conn.createStatement();
	             st.executeUpdate(qry);
	             JOptionPane.showMessageDialog(frame, "Them thanh cong"," ", JOptionPane.INFORMATION_MESSAGE);
//	             return "huy";
	        } catch (Exception e){
	        	JOptionPane.showMessageDialog(frame, "Nhap sai dinh dang ngay yeu cau nhap lai","Error Title", JOptionPane.ERROR_MESSAGE);
	            }
//			return null;
	    }
	   
//	   //tu dong them so thu tu vao ten phong thi
//	   public int capnhatSTT(String trinhdo, String makt) throws SQLException {
//		   JFrame frame = new JFrame("JOptionPane showMessageDialog example");
//		   try{
//			   int max=0;
//	            String qry="Select TENPT from PHONGTHI where MAKT like '"+makt+"'";
//	          
//	            Statement st=(Statement) conn.createStatement();
//	            rs= st.executeQuery(qry);
//	            while(rs.next()) {
//	            	String s1;
//	            	s1 = rs.getString(1);
//	            	
//	            	String[] words = s1.split("P");
//	            	String word=words[0];
//	            	if(word.equalsIgnoreCase(trinhdo)) {
//	            	String word1=words[1];
//	            	if(Integer.parseInt(word1)>max) max=Integer.parseInt(word1);
////	            	System.out.println(word);
//	            	}
//	            	
////	            	int sothutu=Integer.valueOf(tong);
////	            	if(sothutu>max) max=sothutu;
////	            			+s1.charAt(3)+s1.charAt(4));
//	            	}
//	            
//	            
//	            System.out.println(max);
//            	return max;
//
//	         }
//	         catch (SQLException e) {
//	        	 JOptionPane.showMessageDialog(frame, "Khong co mã phong thi","Error Title", JOptionPane.ERROR_MESSAGE);
//	         }
//		  
//			return 0;
//	
//	   }
//	    public static void main(String[] args) throws SQLException {
//	    	DAL_khoathi da=new DAL_khoathi();
//	    	
//	    	da.capnhatSTT("A2","KT01");
//	    	
//	    }
	    }
	 

