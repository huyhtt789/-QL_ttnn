package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import DTO.DTO_thisinh;



public class DAL_thisinh {
    Connect a=new Connect();
    Connection conn=a.getConnection();
    static Statement statement;
    static ResultSet rs;
   public ArrayList docDSthisinh() throws SQLException
    {
	  
        ArrayList dsts=new ArrayList<DTO_thisinh>();
         try{
            String qry="Select * from thisinh";
          
            Statement st=(Statement) conn.createStatement();
            rs= st.executeQuery(qry);
         }
         catch (SQLException e) {
             System.out.println(e.getMessage());
         }

            while (rs.next())
            {
                DTO_thisinh ts=new DTO_thisinh();
                ts.mathisinh=rs.getString(1);
                ts.hoten=rs.getString(2);
                ts.gioitinh=rs.getString(3);
                ts.ngaysinh=rs.getString(4);
                ts.noisinh=rs.getString(5);
                ts.cmnd=rs.getString(6);
                ts.ngaycap=rs.getString(7);
                ts.noicap=rs.getString(8);
                ts.sdt=rs.getString(9);
                ts.email=rs.getString(10);
                
                dsts.add(ts);
            }

    
    return dsts;
    }
   public void ThemTS(DTO_thisinh ts)
    {
	   JFrame frame = new JFrame("JOptionPane showMessageDialog example");
        try {
            String qry="INSERT INTO THISINH VALUES(";
            qry=qry+"'"+ts.mathisinh+"'";
            qry=qry+",'"+ts.hoten+"'";
           
            qry=qry+",'"+ts.gioitinh+"'";
            qry=qry+",'"+ts.ngaysinh+"'";
            qry=qry+",'"+ts.noisinh+"'";
            qry=qry+",'"+ts.cmnd+"'";
            qry=qry+",'"+ts.ngaycap+"'";
            qry=qry+",'"+ts.noicap+"'";
            qry=qry+",'"+ts.sdt+"'";
            qry=qry+",'"+ts.email+"'";
            qry=qry+")";
            Statement st= conn.createStatement();
             st.executeUpdate(qry);
         	JOptionPane.showMessageDialog(frame, "Them thanh cong"," ", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e){
        	 JOptionPane.showMessageDialog(frame, "Sai dinh dang ngay yeu cau nhap lai","Error Title", JOptionPane.ERROR_MESSAGE);
            }
    }
}
