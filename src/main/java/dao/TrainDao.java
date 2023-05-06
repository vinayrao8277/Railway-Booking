package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Train;

public class TrainDao {
	EntityManagerFactory e1= Persistence.createEntityManagerFactory("dev");
	EntityManager m= e1.createEntityManager();
	EntityTransaction t=m.getTransaction();
	
	
	public void save(Train train) {
		t.begin();
		m.persist(train);
		t.commit();
	}
	
	public List<Train> fetchAll()
	{
		return m.createQuery("select x from Train x").getResultList();
	}
	
	public Train find(int trainNumber)
	{
		return m.find(Train.class, trainNumber);
	}
	
	public void delete(int trainNumber) {
		t.begin();
		m.remove(m.find(Train.class, trainNumber));
		t.commit();
	}

	public void edit(int trainNumber) {
		t.begin();
		m.merge(m.find(Train.class, trainNumber));
		t.commit();
		
	}

	
	
}
