package Bookbao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Userbao.DAOBase;
public class BookDAOM extends DAOBase implements BookDAO {
	      
		    
		    public Book Search (String sid){
		    String sql= "SELECT * FROM Book WHERE bookname=?";
		    PreparedStatement pStatement=null;
		    Connection connection = null;
		    ResultSet rs = null;
		    DAOBase base=new DAOBase();
		    Book stu=new Book();
		    try { 
                   connection = base.getConnection();
		           pStatement=connection.prepareStatement(sql);
			       pStatement.setString(1,sid);
			       rs=pStatement.executeQuery();
			while(rs.next()){				
				stu.setbarcode(rs.getString("barcode"));
				stu.setbookname(rs.getString("bookname"));
				stu.setreponsible(rs.getString("responsible"));
				stu.setpublisher(rs.getString("publisher"));
				stu.setprice(rs.getString("price"));
				stu.setcatalog(rs.getString("catalog"));
				stu.setISBN(rs.getString("ISBN"));
				stu.setcontent(rs.getString("content"));
				stu.setCDservice(rs.getString("CDservice"));
				stu.setcarrier(rs.getString("carrier"));
				stu.setprimeresonsible(rs.getString("primeresponsible"));
				stu.setsecresonsible(rs.getString("secresonsible"));
				stu.settheme(rs.getString("theme"));
				stu.setCLclassification(rs.getString("CLclassification"));
				System.out.println("条形码: "+stu.getbarcode()+"\n"+"书名: "+stu.getbookname()+"\n"+"责任人: "+stu.getreponsible()+"\n"+"出版商: "+stu.getpublisher()+"\n"+"价格: "+stu.getprice()+"\n"+"目录: "+stu.getcatalog()
				+"\n"+"ISBN: "+stu.getISBN()+"\n"+"内容简介: "+stu.getcontent()+"\n"+"光盘服务联系: "+stu.getCDservice()+"\n"+"载体形态相: "+stu.getcarrier()+"\n"+"主要负责人: "+stu.getprimeresonsible()+"\n"+"次要负责人: "+stu.getsecresonsible()+"\n"+"分类: "+stu.gettheme()+"\n"+"中图索号: "+stu.getCLclassification());
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
		    public boolean check(String bookn) {
		    	 // TODO Auto-generated method stub
				String sql="SELECT * FROM Book WHERE bookname=?";
				DAOBase util=new DAOBase();
				Connection connection = null;
				PreparedStatement pStatement =null;
				ResultSet rSet =null;

		        try {
		        	connection = util.getConnection();
		            pStatement = connection.prepareStatement(sql);
		            pStatement.setString(1, bookn);
		            rSet = pStatement.executeQuery();

		            if(rSet.next()){
		                return true;
		            }
		        } catch (SQLException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        } finally {
		        	util.release(connection,pStatement,rSet);
		        }
		        return false;
		    }
}