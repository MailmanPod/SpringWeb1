package web.sph.rz.service;

import java.util.List;

public interface ServiceUserDAO<T> {

	public void addUser(T user);

	public void updateUser(T user);

	public List<T> listAllUsers();

	public T retrieveUser(long id);
	
	public T retrieveUserByName(String userName);

	public void deleteUser(long id);
}
