package projetQuizz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetQuizz.entities.Reponse;
import projetQuizz.exceptions.ReponseException;
import projetQuizz.repositories.ReponseRepository;

@Service
public class ReponseService {

    @Autowired
    private ReponseRepository reponseRepo;

    public List<Reponse> getAll(){
        return reponseRepo.findAll();
    }

    public Reponse getById(Long id) {
		if (id == null) {
			throw new ReponseException("id obligatoire");
		}
		return reponseRepo.findById(id).orElseThrow(() -> {
			throw new ReponseException("id inconnu");
		});
	}

	// PAS BESOIN DE SUPPRIMER DES REPONSES SEULES
    // public void delete(Reponse reponse) {
	// 	deleteById(reponse.getId());
	// }

	// public void deleteById(Long id) {
	// 	reponseRepo.delete(getById(id));
	// }

	public void createOrUpdate(Reponse reponse) {
		if (reponse.getEnonceReponse() == null || reponse.getEnonceReponse().isBlank()) {
			throw new ReponseException("Enoncé obligatoire");
		}
		reponseRepo.save(reponse);
	}

    public List<Reponse> getByEnonce(String enonce){
        return reponseRepo.findByEnonceReponse(enonce);
    }

    public List<Reponse> getByEnonceContaining(String enonce){
        return reponseRepo.findByEnonceReponseContaining(enonce);
    }

}
