package extras;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConectionManager {

	static EntityManagerFactory factory;

	public static EntityManager getConection() {
		factory = Persistence.createEntityManagerFactory("NerdFlix");
		return factory.createEntityManager();
	}

	public static void closeConection() {
		if (factory != null)
			factory.close();
	}

}
