package ajc.formation.soprasteria.projetQuizzSB.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ajc.formation.soprasteria.projetQuizzSB.services.ReponseService;
import ajc.formation.soprasteria.projetQuizzSB.entities.Reponse;

@RestController
@RequestMapping("/api/reponse")
public class ReponseRestController {
    
    @Autowired
    private ReponseService reponseSrv;

    @GetMapping("/all")
	//@JsonView(JsonViews.?.class)
	public List<Reponse> getAll() {
		return reponseSrv.getAll();
	}

    @GetMapping("/{id}")
	//@JsonView(JsonViews.?.class)
	public Reponse getById(@PathVariable Long id) {
        Reponse reponse = reponseSrv.getById(id);
		return reponse;
	}

    @PostMapping("")
	// @JsonView(JsonViews.?.class)
	public void create(@RequestBody Reponse reponse) {
		reponseSrv.createOrUpdate(reponse);
	}

	@PutMapping("/{id}")
	// @JsonView(JsonViews.?.class)
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
