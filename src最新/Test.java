import java.util.Scanner;
import Billbao.*;
import Bookbao.*;
import Locationbao.*;
import Userbao.*;
public class Test {
	   public static void main(String args[]) {
	    	System.out.println("�������û���(ѧ�Ż�����)��");
	    	Scanner ReadStr=new Scanner(System.in);
	    	String username=ReadStr.nextLine();
	    	System.out.println("���������룺");
	    	String pass=ReadStr.nextLine();    	
	    	UserDAOM userdx=new UserDAOM();
	    	if(userdx.check(username,pass))
	    {
	    	userdx.login(username,pass);
	    	System.out.println("������Ҫ��ѯ��������");	
		    String bookn=ReadStr.nextLine();
		    BookDAOM bookdx=new BookDAOM();
		    if(bookdx.check(bookn))
		    {
		    	    bookdx.Search(bookn);
				    System.out.println("������Ҫ��ѯλ�õ�ͼ�������ţ�");	
					String code=ReadStr.nextLine();
					LocationDAOM locationdx=new LocationDAOM();
					locationdx.getLocation(code);
					System.out.println("�Ƿ�Ҫ��ѯ�˻�������������'Yes',��������'No'");
					String judge=ReadStr.nextLine();
					   if(judge.equals("Yes"))
					  {
				        System.out.println("������Ҫ��ѯ���û��˺ţ�");
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
		    	System.out.println("����������󣡲�ѯʧ�ܣ�");
		    }
	   }
	    	
	    	else
    	 { 
	    		System.out.println("��¼ʧ��");	
	     }
	    	
	}
}
