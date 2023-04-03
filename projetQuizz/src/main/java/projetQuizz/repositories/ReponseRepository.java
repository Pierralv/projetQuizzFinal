package projetQuizz.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import projetQuizz.entities.Question;
import projetQuizz.entities.Reponse;

public interface ReponseRepository extends JpaRepository<Reponse, Long>{
    List<Reponse> findByEnonce(String enonce);

	List<Reponse> findByEnonceContaining(String enonce);
    
    @Transactional
	@Modifying
	void deleteByQuestion(Question question);
}
