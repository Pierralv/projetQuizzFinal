package projetQuizz.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projetQuizz.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long> {
	
	@Query("select c from compte c left join fetch q.question where c.id=:id")
	Optional<Compte> findByIdFetchQuestions(@Param ("id") Long id);

}
