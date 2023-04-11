package projetQuizz.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projetQuizz.entities.Reponse;

public interface ReponseRepository extends JpaRepository<Reponse, Long>{
    List<Reponse> findByEnonceReponse(String enonceReponse);

	List<Reponse> findByEnonceReponseContaining(String enonceReponse);
    
	// void deleteByQuestion(Question question);
}
