package web.sph.rz.service;

import java.util.List;

import web.sph.rz.dao.UserDAO;
import web.sph.rz.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServiceUserDAOImpl implements ServiceUserDAO<UserEntity> {

	@Autowired
	private UserDAO<UserEntity> userDAO;
	
	@Override
	public void addUser(UserEntity user) {
		userDAO.addUser(user);
		
	}

	@Override
	public void updateUser(UserEntity user) {
		userDAO.updateUser(user);
		
	}

	@Override
	public List<UserEntity> listAllUsers() {
		return userDAO.listAllUsers();
	}

	@Override
	public UserEntity retrieveUser(long id) {
		return userDAO.retrieveUser(id);
	}

	@Override
	public void deleteUser(long id) {
		userDAO.deleteUser(id);
	}

	@Override
	public UserEntity retrieveUserByName(String userName) {
		// TODO Auto-generated method stub
		return userDAO.retrieveUserByName(userName);
	}

}
