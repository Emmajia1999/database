package Billbao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Bookbao.DAOBase;
public class BillDAOM extends DAOBase implements BillDAO {
			public Bill Search (String sid){
				    String sql= "SELECT * FROM Bill WHERE userid=?";
				    PreparedStatement pStatement=null;
				    Connection connection = null;
				    DAOBase base=new DAOBase();
				    ResultSet rs = null;
				    try {
				    	   connection=base.getConnection();
				           pStatement=connection.prepareStatement(sql);
				           pStatement.setString(1,sid);
					       rs=pStatement.executeQuery();
					while(rs.next()){
						Bill bill = new Bill();
						bill.setbillid(rs.getString("billid"));
						bill.setmoney(rs.getString("money"));
						bill.setdate(rs.getString("date"));	
						bill.setuserid(rs.getString("userid"));	
				 		System.out.println("罚单号： "+bill.getbillid()+"\n"+"罚金： "+bill.getmoney()+"\n"+"日期： "+bill.getdate()+"\n"+"用户名： "+bill.getuserid());
					 }
					rs.close();
					pStatement.close();
					connection.close();
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
					if(pStatement!=null)
						try {
							pStatement.close();
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

