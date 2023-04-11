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

import com.fasterxml.jackson.annotation.JsonView;

import projetQuizz.entities.Theme;
import projetQuizz.exceptions.ThemeException;
import projetQuizz.services.ThemeService;

@RestController
@RequestMapping("api/theme")
public class ThemeRestController {
	
	@Autowired
	private ThemeService themeSrv;
	
	@GetMapping("")
	//@JsonView(JsonViews.ThemeWithQuestion.class)
	public List<Theme> getAll() {
		return themeSrv.getAll();
	}
	
	@GetMapping("")
	//@JsonView(JsonViews.ThemeWithQuestion.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Theme getById(@PathVariable Long id) {
		Theme theme = null;
		try {
			theme = themeSrv.getById(id);
		} catch (ThemeException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);	
		}
		return theme;
	}
	
	@PostMapping("")
	//@JsonVienw(JsonViews.ThemeWthQuestion.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Theme Create(@Valid @RequestBody Theme theme, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);	
		}
		themeSrv.createOrUpdate(theme);
		return themeSrv.getById(theme.getId());
	}
	
	@PutMapping("/{id}")
	//@JsonView(JsonViews.Theme theme, @PathVariable Long id)
	public Theme update(@RequestBody Theme theme, @PathVariable Long id) {
		Theme themeEnBase = themeSrv.getById(id);
		if (theme.getNom() != null) {
			themeEnBase.setNom(theme.getNom());
		}
		themeEnBase.setQuestions(theme.getQuestions());
		themeSrv.createOrUpdate(themeEnBase);
		return themeEnBase;
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code =HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		themeSrv.deleteById(id);
	}	
}
