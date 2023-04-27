package ajc.formation.soprasteria.projetQuizzSB.entities;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.soprasteria.projetQuizzSB.entities.jsonviews.JsonViews;

@Entity
@Table(name="compte")
public class Compte implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="compte_id")
	@JsonView(JsonViews.Simple.class)
	private Long id;
	@Column(name="compte_nom")
	@JsonView(JsonViews.Simple.class)
	private String nom;
	@Column(name="compte_prenom")
	@JsonView(JsonViews.Simple.class)
	private String prenom;
	@Column(name="compte_pseudo", unique = true, nullable = false)
	@JsonView(JsonViews.Simple.class)
	private String pseudo;
	@Column(name="compte_avatar")
	@JsonView(JsonViews.Simple.class)
	private String avatar;
	@Column(name="compte_email")
	@JsonView(JsonViews.Simple.class)
	private String email;
	@Column(name="compte_motDePasse", length = 255, nullable = false)
	private String motDePasse;
	@Column(name="compte_role", nullable = false)
	@Enumerated(EnumType.STRING)
	@JsonView(JsonViews.Simple.class)
	private Role role;
	@OneToMany(mappedBy = "createur")
	@JsonView(JsonViews.CompteWithQuestions.class)
	private Set<Question> questions;
	@Embedded
	@JsonView(JsonViews.Compte.class)
	private Statistique statistique = new Statistique();
	
	

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

	public Statistique getStatistique() {
		return statistique;
	}

	public void setStatistique(Statistique statistique) {
		this.statistique = statistique;
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


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority(role.toString()));
	}

	@Override
	public String getPassword() {
		return motDePasse;
	}

	@Override
	public String getUsername() {
		return pseudo;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
