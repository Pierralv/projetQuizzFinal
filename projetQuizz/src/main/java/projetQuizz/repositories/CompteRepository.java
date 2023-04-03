package projetQuizz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import projetQuizz.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long> {

}
