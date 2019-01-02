package 图书查询系统;
import java.util.List;
public interface LocationDAO{
			public void insertLocation(Location stu);//声明插入（增）方法
			public void updateLocation(Location stu);//声明更新（改）方法
			public void deleteLocation(String sid);//声明删除方法
			public Location getLocation(String sid);
			public List<Location> getLocationByC(String sql);
}
