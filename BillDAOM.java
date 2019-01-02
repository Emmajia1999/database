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
import 图书查询系统.Bill;
public class BillDAOM extends DAOBase implements BillDAO {
			@SuppressWarnings("resource")
			public static void Input(Bill stu) throws IOException{
				Scanner ReadStr=new Scanner(System.in);
				System.out.println("请输入一个读者的信息：");
		 		System.out.println("馆藏地：");			 
				stu.setbillid(ReadStr.nextLine());
		 		System.out.println("索书号：");
		 		stu.setmoney(ReadStr.nextLine());
		 		System.out.println("借阅状态：");
		 		stu.setdate(ReadStr.nextLine());
			}
			private static final String CREATE_BILL_SQL ="INSERT INTO BILL values(?,?,?,?,?,?)";
			@Override
			public void insertBill(Bill stu) {//实现插入方法（增）
				Connection connection = null;
				PreparedStatement pst = null;
				try{
					connection = getConnection();//连接数据库
					Input(stu);
					pst = connection.prepareStatement(CREATE_BILL_SQL);
					pst.setString(1, stu.getbillid());
					pst.setString(2, stu.getmoney());
					pst.setString(3, stu.getdate());
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
			public void updateBill(Bill stu) {//实现更新（改）方法
				// TODO Auto-generated method stub
				try{
					Connection connection = null;
					Statement stmt = null;
					int rs;
					try {
						connection = getConnection();//连接数据库
						Scanner ReadStr=new Scanner(System.in);
						System.out.println("请输入要更新的罚单号：");	 
						stmt = connection.createStatement();
						String sql = "delete from Student where billid=";
						rs= stmt.executeUpdate(sql+ReadStr.nextLine());
						insertBill(stu);
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
			public void deleteBill(String sid) {//实现删除方法
				// TODO Auto-generated method stub
				Connection connection = null;
				Statement stmt = null;
				int rs ;
				try {
					connection = getConnection();//连接数据库
					Scanner ReadStr=new Scanner(System.in);
					System.out.println("请输入要删除的罚单号：");		 
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
			private static final String SEARCH_BILLC1 = "SELECT billid,money,date FROM Bill WHERE billid=";
			@Override
			public Bill getBill(String sid) {
				// TODO Auto-generated method stub
				Connection connection = null;
				Statement stmt = null;
				ResultSet rs = null;
				Bill stu = new Bill();
				try{
					connection = getConnection();
					stmt = connection.createStatement();			
					Scanner ReadStr=new Scanner(System.in);
					System.out.println("请输入要查询的罚单号：");		 
					sid=ReadStr.nextLine();
					String endsql = null;
					endsql = SEARCH_BILLC1 +Integer.parseInt(sid);
					rs=stmt.executeQuery(endsql);
					while(rs.next()){				
						stu.setbillid(rs.getString("billid"));
						stu.setmoney(rs.getString("money"));
						stu.setdate(rs.getString("date"));
						System.out.println(stu.getbillid()+"     "+stu.getmoney()+" "+stu.getdate());
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
			private static final String SEARCH_BILLC = "SELECT billid,money,date FROM Bill";
			@Override
			public List<Bill> getBillByC(String sql) {
				List<Bill> bills = new ArrayList<Bill>();
				Connection connection = null;
				Statement stmt = null;
				ResultSet rs = null;
				try{
					connection = getConnection();
					stmt = connection.createStatement();
					String endsql = null;
					if(sql.equals("")){
						endsql = SEARCH_BILLC;
					}else{
						endsql = SEARCH_BILLC + " WHERE "+sql;
					}
					rs=stmt.executeQuery(endsql);
					while(rs.next()){
						Bill bill = new Bill();
						bill.setbillid(rs.getString("billid"));
						bill.setmoney(rs.getString("money"));
						bill.setdate(rs.getString("date"));
						bills.add(bill);			
					}
					for(int i=0;i<bills.size();i++){
						Bill s = new Bill();
				 		s=bills.get(i);
				 		System.out.println(s.getbillid()+"     "+s.getmoney()+" "+s.getdate());
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
				return bills;
			}
}

