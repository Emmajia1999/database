package Userbao;
public class User {
	private String userid;
	private String password;
	public String getuserid() {
		return userid;
	}
	public void setuserid(String userid) {
		if(userid==null){
			System.out.println("用户名不能为空!");
		}
		this.userid = userid;
	}
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		if(password==null){
			System.out.println("密码不能为空!");
		}
		this.password = password;
	}
}

