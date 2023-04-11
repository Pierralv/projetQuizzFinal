package projetQuizz.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import projetQuizz.entities.Question;
import projetQuizz.entities.Reponse;

public interface ReponseRepository extends JpaRepository<Reponse, Long>{
    public List<Reponse> findByEnonceReponse(String enonceReponse);

	public List<Reponse> findByEnonceReponseContaining(String enonceReponse);
    
    @Transactional
    @Modifying
	public List<Reponse> findByQuestion(Question question);
}
