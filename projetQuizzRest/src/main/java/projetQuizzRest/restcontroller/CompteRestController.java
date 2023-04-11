package projetQuizzRest.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import projetQuizz.entities.Compte;
import projetQuizz.services.CompteService;

@RestController
@RequestMapping("/api/compte")
public class CompteRestController {
	
	@Autowired
	CompteService compteSrv;
	
	@PostMapping("")
	//jsonviews
	public List<Compte> getAll(){
		return compteSrv.getAll();
	}
	
	@GetMapping("/{id}")
	//jsonviews
	public Compte getById(@PathVariable Long id) {
		Compte compte = null;
		compte = compteSrv.getById(id);
		return compte;
	}
	
	@GetMapping("/{id}/questions")
	//jsonviews
	public Compte getByIdWithQuestions(@PathVariable Long id) {
		Compte compte = null;
		compte = compteSrv.getByIdWithQuestions(id);
		return compte;
	}
	
	@PostMapping("")
	//jsonviews
	@ResponseStatus(code = HttpStatus.CREATED)
	public Compte create(@Valid @RequestBody Compte compte, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		compteSrv.createOrUpdate(compte);
		return compte;
	}
	
	@PutMapping("/{id}")
	//JsonView
	public Compte update(@RequestBody Compte compte, @PathVariable Long id) {
		Compte compteEnBase = compteSrv.getById(id);
		if (compte.getEmail() != null) {
			compteEnBase.setEmail(compte.getEmail());
		}
		if (compte.getPseudo() != null) {
			compteEnBase.setPseudo(compte.getPseudo());
		}
		compteEnBase.setAvatar(compte.getAvatar());
		compteEnBase.setNom(compte.getNom());
		compteEnBase.setPrenom(compte.getPrenom());
		compteSrv.createOrUpdate(compteEnBase);
		return compteEnBase;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		compteSrv.deleteById(id);
	}
	
	
	

}
