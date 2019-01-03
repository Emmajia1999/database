package Userbao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DAOBase implements DAO {
			@Override
			public Connection getConnection() {
				Connection connection = null;		
				try {
					String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
					String dbURL = "jdbc:sqlserver://192.168.124.38:1433; databaseName=Library Inquiry System";
					String userName = "Emma"; 
					String userPwd = "123456";
					try{
						Class.forName(driverName);
					}catch (ClassNotFoundException e) {
					System.out.println("无法找到驱动类!");
					e.printStackTrace();
					}
					connection = DriverManager.getConnection(dbURL,userName,userPwd);
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return connection;
			}
			public static void release(Connection connection,Statement st,ResultSet rs){
				if(rs!=null)
				{
					try{
						rs.close();
					   }catch(Exception e) {
						   e.printStackTrace();
					   }
					rs=null;
					}
				if(st!=null) {
					try {
						st.close();
					}catch(Exception e) {
						   e.printStackTrace();
					   }
					st=null;
					}
				if(connection!=null) {
					try {
						connection.close();
					}catch(Exception e) {
						   e.printStackTrace();
				}
					connection=null;
				}
			}
}


