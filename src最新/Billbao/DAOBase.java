package Billbao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DAOBase implements DAO {
			@Override
			public Connection getConnection() {
				Connection connection = null;		
				try {
					String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
					String dbURL = "jdbc:sqlserver://192.168.124.37:1433; databaseName=Library Inquiry System";
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
}


