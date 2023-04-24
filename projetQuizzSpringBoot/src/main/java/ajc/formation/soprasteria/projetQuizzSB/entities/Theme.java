package ajc.formation.soprasteria.projetQuizzSB.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.soprasteria.projetQuizzSB.entities.jsonviews.JsonViews;

@Entity
@Table( name="theme" )
public class Theme {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "theme_id")
	@JsonView(JsonViews.Theme.class)
	private long id;
	@Column(name = "theme_nom")
	@JsonView(JsonViews.Theme.class)
	private String nom;
	@OneToMany(mappedBy="theme")
	@JsonView(JsonViews.ThemeWithQuestions.class)
	private Set<Question> questions;
	
    public Theme() {
    	
    }
    
    public Theme(String nom) {
		this.nom = nom;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
    
	
}


