package projetQuizz.repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projetQuizz.entities.Compte;
import projetQuizz.entities.Question;
import projetQuizz.entities.Theme;

public interface QuestionRepository extends JpaRepository<Question, Long> {
	@Query("select q from Question q left join fetch q.reponses where q.id=:id")
	Optional<Question>findByIdFetchReponses(@Param("id") Long id);
	

	@Query("update Question q set q.createur=null where q.createur=:createur")
	@Transactional
	@Modifying
	void setCreateurToNullByCreateur(@Param("createur") Compte compte);
	
	List<Question> findByCreateurContaining(String createur);
	@Transactional
	@Modifying
	void deleteByTheme(Theme theme);
}


