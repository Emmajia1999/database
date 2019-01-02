package 图书查询系统;
public class DAOF {
	private static DAOF instance;	//声明instance为工厂类
	static{
		instance = new DAOF();	//new一个工厂类的instance
	}	
	private DAOF(){//构造函数
	}	
	public static DAOF getInstance(){
		return instance;					//返回一个工厂类的instance
	}	
	public static BookDAO getBookDAO(){
		BookDAO bookDAO = new BookDAOM();
		return bookDAO;
	}
	public static LocationDAO getLocationDAO(){
				LocationDAO locationDAO = new LocationDAOM();
				return locationDAO;
			}
	public static UserDAO getUserDAO(){
				UserDAO userDAO = new UserDAOM();
				return userDAO;
			}
	public static BillDAO getBillDAO(){
		BillDAO billDAO = new BillDAOM();
		return billDAO;
	}
}
