package projetQuizz.repositories;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ContextJpa {
    private static ContextJpa singleton;
    private EntityManagerFactory emf;
    private ContextJpa() {
        emf = Persistence.createEntityManagerFactory("projet_quizz");
    }
    private static DaoQuestion daoQuestion = new DaoQuestionImpl();
    
    public static DaoQuestion getDaoQuestion() {
		return daoQuestion;
	}
    
    public static ContextJpa getInstance() {
        if (singleton == null) {
            singleton = new ContextJpa();
        }
        return singleton;
    }
    
    public EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
    
    public static void destroy() {
        if (singleton != null) {
            singleton.getEntityManagerFactory().close();
            singleton = null;
        }
    }
}
    