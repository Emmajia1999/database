package Userbao;
public interface UserDAO
{
	public User login(String username,String password);
	public boolean check(String username,String password);
}