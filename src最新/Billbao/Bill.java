package Billbao;
public class Bill {
	private String billid;
	private String money;
	private String date;
	private String userid;
	public String getuserid() {
		return userid;
	}
	public void setuserid(String userid) {
		if(userid==null){
			System.out.println("用户名不能为空!");
		}
		this.userid = userid;
	}
	public String getbillid() {
		return billid;
	}
	public void setbillid(String billid) {
		if(billid==null){
			System.out.println("罚单号不能为空!");
		}
		this.billid = billid;
	}
	public String getmoney() {
		return money;
	}
	public void setmoney(String money) {
		if(money==null){
			System.out.println("罚金不能为空!");
		}
		this.money =money;
	}
	public String getdate() {
		return date;
	}
	public void setdate(String date) {
		if(date==null){
			System.out.println("日期不能为空!");
		}
		this.date =date;
	}
}
