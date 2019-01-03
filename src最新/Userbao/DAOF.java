package Userbao;
public class DAOF {
	private static DAOF instance;	
	static{
		instance = new DAOF();	
	}	
	private DAOF(){//¹¹Ôìº¯Êý
	}	
	public static DAOF getInstance(){
		return instance;					
	}	
	public static UserDAO getUserDAO(){
				UserDAO userDAO = new UserDAOM();
				return userDAO;
			}
}
