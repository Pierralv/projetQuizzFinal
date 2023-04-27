package ajc.formation.soprasteria.projetQuizzSB.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.soprasteria.projetQuizzSB.entities.jsonviews.JsonViews;

@Embeddable
public class Statistique {
	@Column
	@JsonView(JsonViews.Simple.class)
	private Integer scoreMax = 0;
	@Column
	@JsonView(JsonViews.Simple.class)
	private Integer scoreMoyen = 0;
	@Column(nullable = true)
	private String themePref;
	@Column(nullable = true)
	private Double tempsMoyenReponse;
	@Column(nullable = true)
	private Integer partiesGagnees;
	@Column(nullable = true)
	private Double ratioVainqueur;
	
	
	public Statistique() {
	}


	public Statistique(Integer scoreMax, Integer scoreMoyen, String themePref, Double tempsMoyenReponse, Integer partiesGagnees,
	Double ratioVainqueur) {
		this.scoreMax = scoreMax;
		this.scoreMoyen = scoreMoyen;
		this.themePref = themePref;
		this.tempsMoyenReponse = tempsMoyenReponse;
		this.partiesGagnees = partiesGagnees;
		this.ratioVainqueur = ratioVainqueur;
	}


	public Integer getScoreMax() {
		return scoreMax;
	}


	public void setScoreMax(Integer scoreMax) {
		this.scoreMax = scoreMax;
	}


	public Integer getScoreMoyen() {
		return scoreMoyen;
	}


	public void setScoreMoyen(Integer scoreMoyen) {
		this.scoreMoyen = scoreMoyen;
	}


	public String getThemePref() {
		return themePref;
	}


	public void setThemePref(String themePref) {
		this.themePref = themePref;
	}


	public Double getTempsMoyenReponse() {
		return tempsMoyenReponse;
	}


	public void setTempsMoyenReponse(Double tempsMoyenReponse) {
		this.tempsMoyenReponse = tempsMoyenReponse;
	}


	public Integer getPartiesGagnees() {
		return partiesGagnees;
	}


	public void setPartiesGagnees(Integer partiesGagnees) {
		this.partiesGagnees = partiesGagnees;
	}


	public Double getRatioVainqueur() {
		return ratioVainqueur;
	}


	public void setRatioVainqueur(Double ratioVainqueur) {
		this.ratioVainqueur = ratioVainqueur;
	}
	
}
