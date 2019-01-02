package com.example.jdbc;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.example.bean.User;
import com.example.daoimp.UserDaoImp;

public class Main {
	@SuppressWarnings("null")
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("您可以使用此数据库查询相关信息，请输入您希望查询的内容：");
		String sql1=in.nextLine();
		String sql2=in.nextLine();
		dsjc DSJC=new dsjc();
		DSJC.search(sql1,sql2);
		
	    int flag=1;
		UserDaoImp imp = new UserDaoImp();
		User user = new User(); 
		System.out.println("请问您是否希望进行评价？(输入1为进行评价)");
		int m=in.nextInt();
		if(m==1)
		{
		System.out.println("请选择您的操作:登录请输入1；注册请输入2");
		m=in.nextInt();
		if(m==1) {
		    System.out.println("请选择您的登录方式:帐号密码请输入1；其他方式请输入2");
			m=in.nextInt();		    
			if(m==1)
		    {
			in.nextLine();
			user.setUserid(in.nextLine());
			user.setPassword(in.nextLine());
			Iterator<User> iter= imp.findAll().iterator();
			int length=imp.findAll().size();
			int i=0;
			while(iter.hasNext()){
				User te=iter.next();
				
				if((te.getUserid().trim()).equals(user.getUserid())&&(te.getPassword().trim()).equals(user.getPassword()))
				{
					System.out.println("您的信息是："+te.getUserid()+" "+te.getPassword()+" "+te.getEmail()+" "+te.getWeChat());
					System.out.println("可以登录！");
					break;
				}
				i++;
				if(i==length)
				{
					System.out.println("登录失败！");
					flag=0;
				}
			}
			System.out.println("请输入您对于该电影的评价！");
			//sql1=in.nextLine();
			sql2=in.nextLine();
			DSJC=new dsjc();
			DSJC.insert(sql2,user.getUserid());
			}
		else
		{
			in.nextLine();
			String tem=in.nextLine();	
			user.setWeChat(tem);
			user.setQQ(tem);
			user.setEmail(tem);
			user.setSina(tem);
			user.setPhonenumber(Integer.parseInt(tem));
			Iterator<User> iter= imp.findAll().iterator();
			int length=imp.findAll().size();
     		int i=0;
			while(iter.hasNext()){
				User te=iter.next();
				if((te.getWeChat().trim()).equals(user.getWeChat())||(te.getQQ().trim()).equals(user.getQQ())||(te.getEmail().trim()).equals(user.getEmail())||(te.getSina().trim()).equals(user.getSina())||te.getPhonenumber()==user.getPhonenumber())
				{
					
					System.out.println("可以登录！");
					System.out.println("您的信息是："+te.getUserid()+" "+te.getPassword()+" "+te.getEmail()+" "+te.getWeChat());
					break;
				}
				i++;
				if(i==length)
				{
					System.out.println("登录失败！");
					flag=0;
					
				}
			}
			System.out.println("请输入您对于该电影的评价！");
			//sql1=in.nextLine();
			sql2=in.nextLine();
			DSJC=new dsjc();
			DSJC.insert(sql2,user.getUserid());
	     }
		
		}
		else
		{
			System.out.println("请设定您的用户ID:");
			int flag1=1;
			User user1=new User();
			while(flag1==1)
			{
				user1.setUserid(in.nextLine());
				Iterator<User> iter= imp.findAll().iterator();
				int length1=imp.findAll().size();
				int i=0;
				while(iter.hasNext()){
					User te=iter.next();
					if((te.getUserid().trim()).equals(user1.getUserid()))
					{
						
						System.out.println("不可以用此用户名！");
						break;
					}
					i++;
					if(i==length1)
					{
						System.out.println("可以使用此用户名！");
						flag1=0;
					}
				}

			}
			System.out.println("请设定您的密码：20位以内");
			user1.setPassword(in.nextLine());
			System.out.println("请问是否绑定微信帐号？绑定请输入1；不绑定请输入2");
			int n=in.nextInt();
			if(n==1)
			{
				System.out.println("请输入您的微信帐号");
				user1.setWeChat(in.nextLine());
				Iterator<User> iter= imp.findAll().iterator();
				int length1=imp.findAll().size();
				int i=0;
				while(iter.hasNext()){
					User te=iter.next();
					if((te.getWeChat().trim()).equals(user1.getWeChat()))
					{
						
						System.out.println("不可以绑定此微信帐号！");
						break;
					}
					i++;
					if(i==length1)
					{
						System.out.println("可以绑定此微信帐号！");
						flag1=0;
					}
				}
			}
			
			System.out.println("请问是否绑定新浪帐号？绑定请输入1；不绑定请输入2");
			n=in.nextInt();
			if(n==1)
			{
				System.out.println("请输入您的新浪帐号");
				user1.setSina(in.nextLine());
				Iterator<User> iter= imp.findAll().iterator();
				int length1=imp.findAll().size();
				int i=0;
				while(iter.hasNext()){
					User te=iter.next();
					if((te.getSina().trim()).equals(user1.getSina()))
					{
						
						System.out.println("不可以绑定此新浪帐号！");
						break;
					}
					i++;
					if(i==length1)
					{
						System.out.println("可以绑定此新浪帐号！");
						flag1=0;
					}
				}
			}
			
			System.out.println("请问是否绑定QQ帐号？绑定请输入1；不绑定请输入2");
			n=in.nextInt();
			if(n==1)
			{
				System.out.println("请输入您的QQ帐号");
				user1.setQQ(in.nextLine());
				Iterator<User> iter= imp.findAll().iterator();
				int length1=imp.findAll().size();
				int i=0;
				while(iter.hasNext()){
					User te=iter.next();
					if((te.getQQ().trim()).equals(user1.getQQ()))
					{
						
						System.out.println("不可以绑定此QQ帐号！");
						break;
					}
					i++;
					if(i==length1)
					{
						System.out.println("可以绑定此QQ帐号！");
						flag1=0;
					}
				}
			}
			
			System.out.println("请问是否绑定E-mail帐号？绑定请输入1；不绑定请输入2");
			n=in.nextInt();
			if(n==1)
			{
				System.out.println("请输入您的E-mail帐号");
				user1.setEmail(in.nextLine());
				Iterator<User> iter= imp.findAll().iterator();
				int length1=imp.findAll().size();
				int i=0;
				while(iter.hasNext()){
					User te=iter.next();
					if((te.getEmail().trim()).equals(user1.getEmail()))
					{
						
						System.out.println("不可以绑定此E-mail帐号！");
						break;
					}
					i++;
					if(i==length1)
					{
						System.out.println("可以绑定此E-mail帐号！");
						flag1=0;
					}
				}
			}
			
			System.out.println("请问是否绑定手机号？绑定请输入1；不绑定请输入2");
			n=in.nextInt();
			if(n==1)
			{
				System.out.println("请输入您的手机号");
				user1.setPhonenumber(in.nextInt());
				Iterator<User> iter= imp.findAll().iterator();
				int length1=imp.findAll().size();
				int i=0;
				while(iter.hasNext()){
					User te=iter.next();
					String s=String.valueOf(user1.getPhonenumber());
					String s1=String.valueOf(te.getPhonenumber());
					if((s1.trim()).equals(s))
					{
						
						System.out.println("不可以绑定此手机号！");
						break;
					}
					i++;
					if(i==length1)
					{
						System.out.println("可以绑定此手机号！");
						flag1=0;
					}
				}
			}
			
			imp.add(user1);
			
		}
	  }
	else
	{
		exit(0);
	}
   }

	private static void exit(int i) {
		// TODO Auto-generated method stub
		
	}
}
