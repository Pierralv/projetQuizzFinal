package projetQuizz;

import projetQuizz.entities.Question;
import projetQuizz.repositories.ContextJpa;
import projetQuizz.repositories.DaoQuestion;

public class AppTest {
    public static void main(String[] args) {
    	DaoQuestion daoQuestion = ContextJpa.getDaoQuestion();
    	
    	Question question = new Question("Bonjour je suis une question", null);
    	question = daoQuestion.save(question);
    }
}
