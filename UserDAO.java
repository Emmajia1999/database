package 图书查询系统;
import java.util.List;
public interface UserDAO{
			public void insertUser(User stu);//声明插入（增）方法
			public void updateUser(User stu);//声明更新（改）方法
			public void deleteUser(String sid);//声明删除方法
			public User getUser(String sid);//声明查询一个学生信息的方法
			public List<User> getUserByC(String sql);// 声明查询多个学生信息的方法
}