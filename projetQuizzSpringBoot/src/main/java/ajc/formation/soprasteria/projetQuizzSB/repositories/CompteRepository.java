package ajc.formation.soprasteria.projetQuizzSB.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ajc.formation.soprasteria.projetQuizzSB.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long> {
	
	@Query("select c from Compte c left join fetch c.questions where c.id=:id")
	Optional<Compte> findByIdFetchQuestions(@Param ("id") Long id);

}
