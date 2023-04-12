package ajc.formation.soprasteria.projetQuizzSB.restcontrollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.soprasteria.projetQuizzSB.services.ReponseService;
import ajc.formation.soprasteria.projetQuizzSB.entities.Reponse;
import ajc.formation.soprasteria.projetQuizzSB.entities.jsonviews.JsonViews;

@RestController
@RequestMapping("/api/reponse")
public class ReponseRestController {
    
    @Autowired
    private ReponseService reponseSrv;

    @GetMapping("")
	@JsonView(JsonViews.Reponse.class)
	public List<Reponse> getAll() {
		return reponseSrv.getAll();
	}

	@GetMapping("/detail")
	@JsonView(JsonViews.ReponseDetail.class)
	public List<Reponse> getAllWithDetail() {
		return reponseSrv.getAll();
	}

    @GetMapping("/{id}/detail")
	@JsonView(JsonViews.ReponseDetail.class)
	public Reponse getById(@PathVariable Long id) {
        Reponse reponse = reponseSrv.getById(id);
		return reponse;
	}

	@GetMapping("/{id}/questionreponses")
	@JsonView(JsonViews.ReponsesWithQuestion.class)
	public Reponse getByIdDetail(@PathVariable Long id) {
        Reponse reponse = reponseSrv.getById(id);
		return reponse;
	}

    @PostMapping("")
	@JsonView(JsonViews.Reponse.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Reponse create(@Valid @RequestBody Reponse reponse, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}	
		reponseSrv.createOrUpdate(reponse);
		return reponse;
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Reponse.class)
	public Reponse update(@RequestBody Reponse reponse, @PathVariable Long id) {
		Reponse reponseEnBase = reponseSrv.getById(id);
		if (reponse.getEnonceReponse() != null) {
			reponseEnBase.setEnonceReponse(reponse.getEnonceReponse());
		}
			reponseEnBase.setBonneReponse(reponse.isBonneReponse());
		if (reponse.getQuestion() != null) {
			reponseEnBase.setQuestion(reponse.getQuestion());
		}
		reponseSrv.createOrUpdate(reponseEnBase);
		return reponseEnBase;
	}
}
