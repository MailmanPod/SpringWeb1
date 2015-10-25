package web.sph.rz.dao;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import web.sph.rz.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDAOImpl implements UserDAO<UserEntity> {

	@Autowired
	private SessionFactory factory;

	@Override
	@Transactional
	public void addUser(UserEntity user) {
		// TODO Auto-generated method stub
		Session session = this.factory.getCurrentSession();
		session.save(user);
	}

	@Override
	@Transactional
	public void updateUser(UserEntity user) {
		// TODO Auto-generated method stub
		Session session = this.factory.getCurrentSession();
		session.update(user);
	}

	@Override
	@Transactional
	public List<UserEntity> listAllUsers() {
		// TODO Auto-generated method stub
		Session session = this.factory.getCurrentSession();
		String statement = "FROM UserEntity";
		List<UserEntity> resultset = session.createQuery(statement).list();
		return resultset;
	}

	@Override
	@Transactional
	public UserEntity retrieveUser(long id) {
		// TODO Auto-generated method stub
		return getUserById(id);
	}

	private UserEntity getUserById(long id) {
		Session session = this.factory.getCurrentSession();

		String statement = "FROM UserEntity WHERE usr_id = :userId";
		Query query = session.createQuery(statement);
		query.setParameter("userId", id);

		List<UserEntity> resultset = query.list();

		if (resultset != null && !resultset.isEmpty()) {
			return resultset.get(0);
		}

		return null;
	}

	@Override
	@Transactional
	public void deleteUser(long id) {
		// TODO Auto-generated method stub
		Session session = this.factory.getCurrentSession();
		UserEntity result = getUserById(id);
		session.delete(result);
	}

	@Override
	public UserEntity retrieveUserByName(String userName) {
		// TODO Auto-generated method stub
		Session session = this.factory.getCurrentSession();
		String statement = "FROM UserEntity WHERE userId = :userName";
		Query query = session.createQuery(statement);
		query.setParameter("userName", userName);
		
		List<UserEntity> resultSet = query.list();
		
		if (resultSet != null && !resultSet.isEmpty()) {
			return resultSet.get(0);
		}
		
		return null;
	}
}
