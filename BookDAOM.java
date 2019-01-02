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
import 图书查询系统.Book;
public class BookDAOM extends DAOBase implements BookDAO {
			@SuppressWarnings("resource")
			public static void Input(Book stu) throws IOException{
				Scanner ReadStr=new Scanner(System.in);
				System.out.println("请输入一个图书的信息：");
		 		System.out.println("条码号：");			 
				stu.setbarcode(ReadStr.nextLine());
		 		System.out.println("书名：");
		 		stu.setbookname(ReadStr.nextLine());
		 		System.out.println("责任者：");			 
				stu.setreponsible(ReadStr.nextLine());
				System.out.println("出版商：");			 
				stu.setpublisher(ReadStr.nextLine());
				System.out.println("价格：");			 
				stu.setprice(ReadStr.nextLine());
				System.out.println("目录：");			 
				stu.setcatalog(ReadStr.nextLine());
				System.out.println("ISBN：");			 
				stu.setISBN(ReadStr.nextLine());
				System.out.println("内容：");			 
				stu.setcontent(ReadStr.nextLine());
				System.out.println("光盘服务联系方式：");			 
				stu.setCDservice(ReadStr.nextLine());
				System.out.println("载体形态项：");			 
				stu.setcarrier(ReadStr.nextLine());
				System.out.println("个人责任者：");			 
				stu.setprimeresonsible(ReadStr.nextLine());
				System.out.println("个人次要责任者：");			 
				stu.setsecresonsible(ReadStr.nextLine());
				System.out.println("学科主题：");			 
				stu.settheme(ReadStr.nextLine());
				System.out.println("中图法分类号：");			 
				stu.setCLclassification(ReadStr.nextLine());
			}
			private static final String CREATE_BOOK_SQL ="INSERT INTO BOOK values(?,?,?,?,?,?)";
			@Override
			public void insertBook(Book stu) {//实现插入方法（增）
				Connection connection = null;
				PreparedStatement pst = null;
				try{
					connection = getConnection();//连接数据库
					Input(stu);
					pst = connection.prepareStatement(CREATE_BOOK_SQL);
					pst.setString(1, stu.getbarcode());
					pst.setString(2, stu.getbookname());
					pst.setString(3, stu.getreponsible());
					pst.setString(4, stu.getpublisher());
					pst.setString(5, stu.getprice());
					pst.setString(6, stu.getcatalog());
					pst.setString(7, stu.getISBN());
					pst.setString(8, stu.getcontent());
					pst.setString(9, stu.getCDservice());
					pst.setString(10, stu.getcarrier());
					pst.setString(11, stu.getprimeresonsible());
					pst.setString(12, stu.getsecresonsible());
					pst.setString(13, stu.gettheme());
					pst.setString(14, stu.getCLclassification());
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
			public void updateBook(Book stu) {//实现更新（改）方法
				// TODO Auto-generated method stub
				try{
					Connection connection = null;
					Statement stmt = null;
					int rs;
					try {
						connection = getConnection();//连接数据库
						Scanner ReadStr=new Scanner(System.in);
						System.out.println("请输入要更新的条码号：");	 
						stmt = connection.createStatement();
						String sql = "delete from Student where barcode=";
						rs= stmt.executeUpdate(sql+ReadStr.nextLine());
						insertBook(stu);
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
			public void deleteBook(String sid) {//实现删除方法
				// TODO Auto-generated method stub
				Connection connection = null;
				Statement stmt = null;
				int rs ;
				try {
					connection = getConnection();//连接数据库
					Scanner ReadStr=new Scanner(System.in);
					System.out.println("请输入要删除的条码号：");		 
			 		sid=ReadStr.nextLine();
					stmt = connection.createStatement();
					String sql = "delete from User where barcode=";
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
			private static final String SEARCH_BOOKC1 = "SELECT private String barcode,bookname,reponsible,publisher,price,catalog,ISBN,content,CDservice,carrier,primeresonsible,secresonsible,theme,CLclassification FROM Book WHERE barcode=";
			@Override
			public Book getBook(String sid) {
				// TODO Auto-generated method stub
				Connection connection = null;
				Statement stmt = null;
				ResultSet rs = null;
				Book stu = new Book();
				try{
					connection = getConnection();
					stmt = connection.createStatement();			
					Scanner ReadStr=new Scanner(System.in);
					System.out.println("请输入要查询的条码号：");		 
					sid=ReadStr.nextLine();
					String endsql = null;
					endsql = SEARCH_BOOKC1 +Integer.parseInt(sid);
					rs=stmt.executeQuery(endsql);
					while(rs.next()){				
						stu.setbarcode(rs.getString("barcode"));
						stu.setbookname(rs.getString("bookname"));
						stu.setreponsible(rs.getString("reponsible"));
						stu.setpublisher(rs.getString("publisher"));
						stu.setprice(rs.getString("price"));
						stu.setcatalog(rs.getString("catalog"));
						stu.setISBN(rs.getString("ISBN"));
						stu.setcontent(rs.getString("content"));
						stu.setCDservice(rs.getString("CDservice"));
						stu.setcarrier(rs.getString("carrier"));
						stu.setprimeresonsible(rs.getString("primeresonsible"));
						stu.setsecresonsible(rs.getString("secresonsible"));
						stu.settheme(rs.getString("theme"));
						stu.setCLclassification(rs.getString("CLclassification"));
						System.out.println(stu.getbarcode()+"     "+stu.getbookname()+" "+stu.getreponsible()+" "+stu.getpublisher()+" "+stu.getprice()+" "+stu.getcatalog()
						+" "+stu.getISBN()+" "+stu.getcontent()+" "+stu.getCDservice()+" "+stu.getcarrier()+" "+stu.getprimeresonsible()+" "+stu.getsecresonsible()+" "+stu.gettheme()+" "+stu.getCLclassification());
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
			private static final String SEARCH_BOOKC = "SELECT barcode,bookname,reponsible,publisher,price,catalog,ISBN,content,CDservice,carrier,primeresonsible,secresonsible,theme,CLclassification FROM Book ";
			@Override
			public List<Book> getBookByC(String sql) {
				List<Book> books = new ArrayList<Book>();
				Connection connection = null;
				Statement stmt = null;
				ResultSet rs = null;
				try{
					connection = getConnection();
					stmt = connection.createStatement();
					String endsql = null;
					if(sql.equals("")){
						endsql = SEARCH_BOOKC;
					}else{
						endsql = SEARCH_BOOKC + " WHERE "+sql;
					}
					rs=stmt.executeQuery(endsql);
					while(rs.next()){
						Book book = new Book();
						book.setbarcode(rs.getString("barcode"));
						book.setbookname(rs.getString("bookname"));
						book.setreponsible(rs.getString("reponsible"));
						book.setpublisher(rs.getString("publisher"));
						book.setprice(rs.getString("price"));
						book.setcatalog(rs.getString("catalog"));
						book.setISBN(rs.getString("ISBN"));
						book.setcontent(rs.getString("content"));
						book.setCDservice(rs.getString("CDservice"));
						book.setcarrier(rs.getString("carrier"));
						book.setprimeresonsible(rs.getString("primeresonsible"));
						book.setsecresonsible(rs.getString("secresonsible"));
						book.settheme(rs.getString("theme"));
						book.setCLclassification(rs.getString("CLclassification"));
						books.add(book);			
					}
					for(int i=0;i<books.size();i++){
				 		Book s = new Book();
				 		s=books.get(i);
				 		System.out.println(s.getbarcode()+"     "+s.getbookname()+" "+s.getreponsible()+" "+s.getpublisher()+" "+s.getprice()+" "+s.getcatalog()
						+" "+s.getISBN()+" "+s.getcontent()+" "+s.getCDservice()+" "+s.getcarrier()+" "+s.getprimeresonsible()+" "+s.getsecresonsible()+" "+s.gettheme()+" "+s.getCLclassification());
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
				return books;
			}
}

