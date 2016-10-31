package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import extras.ConectionManager;
import model.Content;

public class ContentDao {
	private EntityManager em;

	public ContentDao() {
		em = ConectionManager.getConection();
	}

	public void save(Content content) {
		initTransaction();
		em.persist(content);
		closeTransaction();
	}

	public void atualizar(Content content) {
		initTransaction();
		em.merge(content);
		closeTransaction();
	}

	public List<Content> getContents() {
		List<Content> contents = null;
		// TODO retorna todos os conteúdos cadastrados no banco
		try {
			initTransaction();
			contents = (List<Content>) em.createQuery("from Content ").getResultList();
			closeTransaction();
		} catch (NoResultException ex) {
			System.out.println("nenhum conteúdo foi encontrado");
		}
		return contents;
	}

	private void initTransaction() {

		em.getTransaction().begin();
	}

	private void closeTransaction() {
		em.getTransaction().commit();
	}

}
