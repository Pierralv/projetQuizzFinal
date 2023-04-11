package projetQuizz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetQuizz.entities.Question;
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

    public void delete(Reponse reponse) {
		deleteById(reponse.getId());
	}

	public void deleteById(Long id) {
		reponseRepo.delete(getById(id));
	}

	// creation et mise a ensemble ou pas???
	public void createOrUpdate(Reponse reponse) {
		if (reponse.getEnonce() == null || reponse.getEnonce().isBlank()) {
			throw new ReponseException("énoncé obligatoire");
		}
		reponseRepo.save(reponse);
	}

    List<Reponse> getByEnonce(String enonce){
        return reponseRepo.findByEnonce(enonce);
    }

    List<Reponse> getByEnonceContaining(String enonce){
        return reponseRepo.findByEnonceContaining(enonce);
    }

    List<Reponse> deleteByQuestion(Question question){
        return null;
    }
}
