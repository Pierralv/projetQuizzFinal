package projetQuizz.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Statistique {
	private int scoreMax;
	private int scoreMoyen;
	private String themePref;
	private double tempsMoyenReponse;
	private int partiesGagnees;
	private double ratioVainqueur;
	
	
	public Statistique() {
	}


	public Statistique(int scoreMax, int scoreMoyen, String themePref, double tempsMoyenReponse, int partiesGagnees,
			double ratioVainqueur) {
		this.scoreMax = scoreMax;
		this.scoreMoyen = scoreMoyen;
		this.themePref = themePref;
		this.tempsMoyenReponse = tempsMoyenReponse;
		this.partiesGagnees = partiesGagnees;
		this.ratioVainqueur = ratioVainqueur;
	}


	public int getScoreMax() {
		return scoreMax;
	}


	public void setScoreMax(int scoreMax) {
		this.scoreMax = scoreMax;
	}


	public int getScoreMoyen() {
		return scoreMoyen;
	}


	public void setScoreMoyen(int scoreMoyen) {
		this.scoreMoyen = scoreMoyen;
	}


	public String getThemePref() {
		return themePref;
	}


	public void setThemePref(String themePref) {
		this.themePref = themePref;
	}


	public double getTempsMoyenReponse() {
		return tempsMoyenReponse;
	}


	public void setTempsMoyenReponse(double tempsMoyenReponse) {
		this.tempsMoyenReponse = tempsMoyenReponse;
	}


	public int getPartiesGagnees() {
		return partiesGagnees;
	}


	public void setPartiesGagnees(int partiesGagnees) {
		this.partiesGagnees = partiesGagnees;
	}


	public double getRatioVainqueur() {
		return ratioVainqueur;
	}


	public void setRatioVainqueur(double ratioVainqueur) {
		this.ratioVainqueur = ratioVainqueur;
	}
	
}
