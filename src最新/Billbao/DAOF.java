package Billbao;
public class DAOF {
	private static DAOF instance;	
	static{
		instance = new DAOF();	
	}	
	private DAOF(){
	}	
	public static DAOF getInstance(){
		return instance;					
	}	
	public static BillDAO getBillDAO(){
		BillDAO billDAO = new BillDAOM();
		return billDAO;
	}
}