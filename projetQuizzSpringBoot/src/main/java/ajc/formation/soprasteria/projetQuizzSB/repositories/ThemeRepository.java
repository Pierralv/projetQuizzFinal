package ajc.formation.soprasteria.projetQuizzSB.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ajc.formation.soprasteria.projetQuizzSB.entities.Theme;

public interface ThemeRepository extends JpaRepository<Theme, Long> {
	@Query("select t from Theme t left join fetch t.questions where t.id=:id")
	Optional<Theme>findByIdFetchQuestions(@Param("id") Long id);

	List<Theme> findByNomContaining(String nom);
}
