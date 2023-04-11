package projetQuizz.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projetQuizz.entities.Question;
import projetQuizz.entities.Reponse;
import projetQuizz.entities.Theme;

public interface ReponseRepository extends JpaRepository<Reponse, Long>{
    public List<Reponse> findByEnonceReponse(String enonceReponse);

	public List<Reponse> findByEnonceReponseContaining(String enonceReponse);
    
    @Transactional
    @Modifying
	public void deleteByQuestion(Question question);
    
    @Transactional
    @Modifying
    @Query("delete r from Reponse r where r.question.theme=:theme ")
    public void deleteReponseByTheme(@Param("theme") Theme theme);
}
