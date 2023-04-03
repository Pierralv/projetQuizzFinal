package projetQuizz.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projetQuizz.entities.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
	List<Question> findByCreateurContaining(String createur);
}
