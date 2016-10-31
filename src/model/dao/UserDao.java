package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import extras.ConectionManager;
import model.User;

public class UserDao {
	private EntityManager em;

	public UserDao() {
		em = ConectionManager.getConection();
	}

	public void save(User user) {

		initTransaction();
		em.persist(user);
		closeTransaction();

	}

	public User findUser(String login) {
		User user = null;
		try {
			initTransaction();
			user = (User) em.createQuery("from User u where u.login = :login").setParameter("login", login)
					.getSingleResult();
			closeTransaction();
		} catch (NoResultException ex) {
			System.out.println("usuario " + login + " não encontrado");
			user = null;

		}
		return user;
	}

	/**
	 * verifica se tem um usuário um cadastrado com dado login
	 * 
	 * @param login
	 * @return true se tiver um usuário cadastrado com dado login
	 */
	public boolean hasUser(String login) {
		User user = findUser(login);
		if (user != null) {
			return user.getLogin().equals(login);
		}
		return false;
	}

	private void initTransaction() {

		em.getTransaction().begin();
	}

	private void closeTransaction() {
		em.getTransaction().commit();
	}
}
