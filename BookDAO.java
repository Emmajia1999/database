package 图书查询系统;
import java.util.List;
public interface BookDAO{
			public void insertBook(Book stu);//声明插入（增）方法
			public void updateBook(Book stu);//声明更新（改）方法
			public void deleteBook(String sid);//声明删除方法
			public Book getBook(String sid);//声明查询一个学生信息的方法
			public List<Book> getBookByC(String sql);// 声明查询多个学生信息的方法
}