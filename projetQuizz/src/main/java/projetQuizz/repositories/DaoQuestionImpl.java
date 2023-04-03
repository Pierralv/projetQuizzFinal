package projetQuizz.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import projetQuizz.entities.Question;

public class DaoQuestionImpl implements DaoQuestion {

	@Override
	public Question save(Question obj) {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Question obj) {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(obj));
		tx.commit();
		em.close();
	}

	@Override
	public void deleteByKey(Long key) {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Question.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public Question findByKey(Long key) {
		Question question = null;
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		question = em.find(Question.class, key);
		em.close();
		return question;
	}

	@Override
	public List<Question> findAll() {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		// requete JPQL
		// select instance from Entity instance where ...
		// TypedQuery<Question> query = em.createQuery("select p from Question p",
		// Question.class);
		TypedQuery<Question> query = em.createQuery("from Question p", Question.class);
		List<Question> questions = query.getResultList();
		em.close();
		return questions;
	}
}
