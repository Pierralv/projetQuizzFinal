package ajc.formation.soprasteria.projetQuizzSB.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajc.formation.soprasteria.projetQuizzSB.entities.Theme;
import ajc.formation.soprasteria.projetQuizzSB.exceptions.ThemeException;
import ajc.formation.soprasteria.projetQuizzSB.repositories.QuestionRepository;
import ajc.formation.soprasteria.projetQuizzSB.repositories.ReponseRepository;
import ajc.formation.soprasteria.projetQuizzSB.repositories.ThemeRepository;

@Service
public class ThemeService {
	@Autowired
	private ThemeRepository themeRepo;
	@Autowired
	private QuestionRepository questionRepo;
	@Autowired
	private ReponseRepository reponseRepo;
	
	public List<Theme> getAll() {
		return themeRepo.findAll();
	}
	
	public Theme getById(Long id) {
		if (id == null) {
			throw new ThemeException("id obligatoire");
		}
		return themeRepo.findById(id).orElseThrow(() -> {
			throw new ThemeException ("id inconnu");
		});
	}
	
	public Theme getIdWithQuestions(Long id) {
		if (id == null) {
			throw new ThemeException("id obligatoire");
		}
		return themeRepo.findByIdFetchQuestions(id).orElseThrow(() -> {
			throw new ThemeException("id inconnu");
		});
	}
	
	public void delete(Theme theme) {
		deleteById(theme.getId());
	}
	
	public void deleteById(Long id) {
		Theme t = getById(id);	
		reponseRepo.deleteReponseByTheme(t);
		questionRepo.deleteByTheme(t);
		themeRepo.delete(getById(id));	
	}
	
	public Theme createOrUpdate(Theme theme) {
		if (theme.getNom() == null || theme.getNom().isBlank()) {
			throw new ThemeException("Nom obligatoire");
		}
		return themeRepo.save(theme);
	}
	
	public List<Theme> getByNom(String nom) {
		return themeRepo.findByNomContaining(nom);
	}
	
	
}
