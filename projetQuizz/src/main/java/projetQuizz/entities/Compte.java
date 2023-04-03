package projetQuizz.entities;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="compte")
public class Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="compte_id")
	private Long id;
	@Column(name="compte_nom")
	private String nom;
	@Column(name="compte_prenom")
	private String prenom;
	@Column(name="compte_pseudo")
	private String pseudo;
	@Column(name="compte_avatar")
	private String avatar;
	@Column(name="compte_email")
	private String email;
	@Column(name="compte_motDePasse")
	private String motDePasse;
	@Column(name="compte_role")
	private Role role;
	@OneToMany(mappedBy = "createur")
	private Set<Question> questions;
	@Embedded
	private Statistique statistique;
	
	public Compte() {
	}

	public Compte(String nom, String prenom, String pseudo, String avatar, String email, String motDePasse, Role role) {
		this.nom = nom;
		this.prenom = prenom;
		this.pseudo = pseudo;
		this.avatar = avatar;
		this.email = email;
		this.motDePasse = motDePasse;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, pseudo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compte other = (Compte) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(pseudo, other.pseudo);
	}
    
	
	
}
