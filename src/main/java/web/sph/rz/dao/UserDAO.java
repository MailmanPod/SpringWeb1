package web.sph.rz.dao;

import java.util.List;

public interface UserDAO<T> {

	public void addUser(T user);

	public void updateUser(T user);

	public List<T> listAllUsers();

	public T retrieveUser(long id);
	
	public T retrieveUserByName(String userName);

	public void deleteUser(long id);
}
