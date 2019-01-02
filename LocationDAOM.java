package 图书查询系统;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import 图书查询系统.Location;
public class LocationDAOM extends DAOBase implements LocationDAO {
			@SuppressWarnings("resource")
			public static void Input(Location stu) throws IOException{
				Scanner ReadStr=new Scanner(System.in);
				System.out.println("请输入一个读者的信息：");
		 		System.out.println("馆藏地：");			 
				stu.setroom(ReadStr.nextLine());
		 		System.out.println("索书号：");
		 		stu.setcallnumber(ReadStr.nextLine());
		 		System.out.println("借阅状态：");
		 		stu.setstate(ReadStr.nextLine());
			}
			private static final String CREATE_LOCATION_SQL ="INSERT INTO LOCATION values(?,?,?,?,?,?)";
			@Override
			public void insertLocation(Location stu) {//实现插入方法（增）
				Connection connection = null;
				PreparedStatement pst = null;
				try{
					connection = getConnection();//连接数据库
					Input(stu);
					pst = connection.prepareStatement(CREATE_LOCATION_SQL);
					pst.setString(1, stu.getroom());
					pst.setString(2, stu.getcallnumber());
					pst.setString(3, stu.getstate());
					int row=pst.executeUpdate();
					System.out.println("成功更新了"+row+"行数据!");
					pst.close();
					connection.close();
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					if(pst!=null)
						try {
							pst.close();
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
			}
			@Override
			public void updateLocation(Location stu) {//实现更新（改）方法
				// TODO Auto-generated method stub
				try{
					Connection connection = null;
					Statement stmt = null;
					int rs;
					try {
						connection = getConnection();//连接数据库
						Scanner ReadStr=new Scanner(System.in);
						System.out.println("请输入要更新的馆藏地：");	 
						stmt = connection.createStatement();
						String sql = "delete from Student where userid=";
						rs= stmt.executeUpdate(sql+ReadStr.nextLine());
						insertLocation(stu);
						stmt.close();		
					}catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						if(stmt!=null)
							try {
								stmt.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					}
				}catch(Exception e){
					e.printStackTrace();
				}			
			}
			@Override
			public void deleteLocation(String sid) {//实现删除方法
				// TODO Auto-generated method stub
				Connection connection = null;
				Statement stmt = null;
				int rs ;
				try {
					connection = getConnection();//连接数据库
					Scanner ReadStr=new Scanner(System.in);
					System.out.println("请输入要删除的馆藏地：");		 
			 		sid=ReadStr.nextLine();
					stmt = connection.createStatement();
					String sql = "delete from Location where userid=";
					rs = stmt.executeUpdate(sql+Integer.parseInt(sid));//返回结果
					System.out.println("成功删除了"+rs+"行数据!");
					stmt.close();		
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					if(stmt!=null)
						try {
							stmt.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
			}
			private static final String SEARCH_LOCATIONC1 = "SELECT userid,password FROM User WHERE userid=";
			@Override
			public Location getLocation(String sid) {
				// TODO Auto-generated method stub
				Connection connection = null;
				Statement stmt = null;
				ResultSet rs = null;
				Location stu = new Location();
				try{
					connection = getConnection();
					stmt = connection.createStatement();			
					Scanner ReadStr=new Scanner(System.in);
					System.out.println("请输入要查询的馆藏地：");		 
					sid=ReadStr.nextLine();
					String endsql = null;
					endsql = SEARCH_LOCATIONC1 +Integer.parseInt(sid);
					rs=stmt.executeQuery(endsql);
					while(rs.next()){				
						stu.setroom(rs.getString("room"));
						stu.setcallnumber(rs.getString("callnumber"));
						stu.setstate(rs.getString("state"));
						System.out.println(stu.getroom()+"     "+stu.getcallnumber()+" "+stu.getstate());
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
					if(stmt!=null)
						try {
							stmt.close();
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
			private static final String SEARCH_LOCATIONC = "SELECT userid,password FROM User";
			@Override
			public List<Location> getLocationByC(String sql) {
				List<Location> locations = new ArrayList<Location>();
				Connection connection = null;
				Statement stmt = null;
				ResultSet rs = null;
				try{
					connection = getConnection();
					stmt = connection.createStatement();
					String endsql = null;
					if(sql.equals("")){
						endsql = SEARCH_LOCATIONC;
					}else{
						endsql = SEARCH_LOCATIONC + " WHERE "+sql;
					}
					rs=stmt.executeQuery(endsql);
					while(rs.next()){
						Location location = new Location();
						location.setroom(rs.getString("room"));
						location.setcallnumber(rs.getString("callnumber"));
						location.setstate(rs.getString("state"));
						locations.add(location);			
					}
					for(int i=0;i<locations.size();i++){
						Location s = new Location();
				 		s=locations.get(i);
				 		System.out.println(s.getroom()+"     "+s.getcallnumber()+" "+s.getstate());
					 }
					rs.close();
					stmt.close();
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
					if(stmt!=null)
						try {
							stmt.close();
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
				return locations;
			}
}
