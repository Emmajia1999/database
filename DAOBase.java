package 图书查询系统;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DAOBase implements DAO {//实现DAO接口中的连接方法
			@Override
			public Connection getConnection() {//实现连接
				Connection connection = null;		
				try {
					//加载JDBC驱动
					String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
					//连接服务器和数据库sample
					String dbURL = "jdbc:sqlserver://10.0.2.15:1433; databaseName=Library Inquiry System;user=;password=";
//构建url=数据库管理系统的标识+数据库管理系统的地址（ip+端口）+使用的数据库实例名称
					String userName = "sa"; //默认用户名
					String userPwd = "123456"; //密码
					try{
						Class.forName(driverName);//加载驱动
					}catch (ClassNotFoundException e) {
					System.out.println("无法找到驱动类!");
					e.printStackTrace();
					}
					//建立连接
					connection = DriverManager.getConnection(dbURL,userName,userPwd);
					System.out.println("Connection Successful!"); //如果连接成功 控制台输出
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return connection;
			}
}

