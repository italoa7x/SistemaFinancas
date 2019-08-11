package daoJPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class FactoryEntity {

private static EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("bd");
	
	public EntityManager getIntity() {
		return fabrica.createEntityManager();
	}
	

}
