package Locationbao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Bookbao.DAOBase;
public class LocationDAOM extends DAOBase implements LocationDAO {

	public Location getLocation(String sid) {
		// TODO Auto-generated method stub
		String SEARCH_LOCATIONC1 = "SELECT state,room,callnumber,barcode FROM Location WHERE barcode=?";
		java.sql.Statement st=null; 
	    Connection connection = null;
	    ResultSet rs = null;
	    PreparedStatement pStatement=null;
	    Location stu=new Location();
	    DAOBase base=new DAOBase();
		try{
			connection = base.getConnection();
	        pStatement=connection.prepareStatement(SEARCH_LOCATIONC1);
		    pStatement.setString(1,sid);                                                                                                                                                                                                                                                                                                                                            
		    rs=pStatement.executeQuery();		
			while(rs.next()){				
				stu.setroom(rs.getString("room"));
				stu.setcallnumber(rs.getString("callnumber"));
				stu.setstate(rs.getString("state"));
				stu.setbarcode(rs.getString("barcode"));
				System.out.println("所在位置： "+stu.getroom()+"\n"+"索书号：  "+stu.getcallnumber()+"\n"+"状态：  "+stu.getstate()+"\n"+"条码号： "+stu.getbarcode());
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(st!=null)
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(connection!=null)
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return null;
	}
	
}