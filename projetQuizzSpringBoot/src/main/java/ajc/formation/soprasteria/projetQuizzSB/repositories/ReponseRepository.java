package ajc.formation.soprasteria.projetQuizzSB.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ajc.formation.soprasteria.projetQuizzSB.entities.Question;
import ajc.formation.soprasteria.projetQuizzSB.entities.Reponse;
import ajc.formation.soprasteria.projetQuizzSB.entities.Theme;

public interface ReponseRepository extends JpaRepository<Reponse, Long>{
    public List<Reponse> findByEnonceReponse(String enonceReponse);

	public List<Reponse> findByEnonceReponseContaining(String enonceReponse);
    
    @Transactional
    @Modifying
	public void deleteByQuestion(Question question);
    
    @Transactional
    @Modifying
    @Query("delete from Reponse r where r.question in (select q from Question q where q.theme=:theme) ")
    public void deleteReponseByTheme(@Param("theme") Theme theme);
}
