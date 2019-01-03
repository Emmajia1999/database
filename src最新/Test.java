import java.util.Scanner;
import Billbao.*;
import Bookbao.*;
import Locationbao.*;
import Userbao.*;
public class Test {
	   public static void main(String args[]) {
	    	System.out.println("请输入用户名(学号或邮箱)：");
	    	Scanner ReadStr=new Scanner(System.in);
	    	String username=ReadStr.nextLine();
	    	System.out.println("请输入密码：");
	    	String pass=ReadStr.nextLine();    	
	    	UserDAOM userdx=new UserDAOM();
	    	if(userdx.check(username,pass))
	    {
	    	userdx.login(username,pass);
	    	System.out.println("请输入要查询的书名：");	
		    String bookn=ReadStr.nextLine();
		    BookDAOM bookdx=new BookDAOM();
		    if(bookdx.check(bookn))
		    {
		    	    bookdx.Search(bookn);
				    System.out.println("请输入要查询位置的图书的条码号：");	
					String code=ReadStr.nextLine();
					LocationDAOM locationdx=new LocationDAOM();
					locationdx.getLocation(code);
					System.out.println("是否要查询账户罚单，是请输'Yes',否请输入'No'");
					String judge=ReadStr.nextLine();
					   if(judge.equals("Yes"))
					  {
				        System.out.println("请输入要查询的用户账号：");
			    	    String usern=ReadStr.nextLine();
			    	    BillDAOM billdx=new BillDAOM();
			    	    billdx.Search(usern);
					  }
					   
					   else
					  {
					    System.out.println("finish");
					  }
				
		    }
		    else 
		    {
		    	System.out.println("书名输入错误！查询失败！");
		    }
	   }
	    	
	    	else
    	 { 
	    		System.out.println("登录失败");	
	     }
	    	
	}
}
