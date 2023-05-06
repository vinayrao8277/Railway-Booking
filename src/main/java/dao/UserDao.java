package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.User;

public class UserDao {
	EntityManagerFactory e1= Persistence.createEntityManagerFactory("dev");
	EntityManager m= e1.createEntityManager();
	EntityTransaction t=m.getTransaction();
	
	public void save(User user)
	{
		t.begin();
		m.persist(user);
		t.commit();
	}

	public User find(int id)
	{
		return m.find(User.class, id);
	}

	public void update(User user)
	{
		t.begin();
		m.merge(user);
		t.commit();
	}

	
	
}
