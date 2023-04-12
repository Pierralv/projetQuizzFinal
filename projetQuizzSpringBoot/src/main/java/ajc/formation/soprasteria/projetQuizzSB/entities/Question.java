package ajc.formation.soprasteria.projetQuizzSB.entities;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.soprasteria.projetQuizzSB.entities.jsonviews.JsonViews;

@Entity
@Table(name = "question")
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="question_id")
	@JsonView(JsonViews.Question.class)
	private Long id;
	@Column(name = "question_enonce", columnDefinition = "TEXT")
	@Lob
	@JsonView(JsonViews.Question.class)
	private String enonceQuestion;
	@ManyToOne
	@JoinColumn(name = "question_id_theme", foreignKey = @ForeignKey(name = "question_id_theme_fk"))
	@JsonView(JsonViews.QuestionsWithTheme.class)
	private Theme theme;
	@OneToMany(mappedBy = "question")
	@JsonView(JsonViews.QuestionWithReponses.class)
	Set<Reponse> reponses;
	@ManyToOne
	@JoinColumn(name = "question_id_createur", foreignKey = @ForeignKey(name="question_id_createur_fk"))
	@JsonView(JsonViews.QuestionsWithCompte.class)
	private Compte createur;

	public Question() {

	}
	
	

	public Question(String enonceQuestion, Theme theme, Compte createur) {
		super();
		this.enonceQuestion = enonceQuestion;
		this.theme = theme;
		this.createur = createur;
	}



	public Question(String enonceQuestion, Theme theme) {
		super();
		this.enonceQuestion = enonceQuestion;
		this.theme = theme;
	}
	
	

	public Compte getCreateur() {
		return createur;
	}



	public void setCreateur(Compte createur) {
		this.createur = createur;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEnonceQuestion() {
		return enonceQuestion;
	}

	public void setEnonceQuestion(String enonceQuestion) {
		this.enonceQuestion = enonceQuestion;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public Set<Reponse> getReponses() {
		return reponses;
	}

	public void setReponses(Set<Reponse> reponses) {
		this.reponses = reponses;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		return Objects.equals(id, other.id);
	}

}
