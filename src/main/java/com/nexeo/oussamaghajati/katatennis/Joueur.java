package com.nexeo.oussamaghajati.katatennis;

import java.util.ArrayList;
import java.util.List;

public class Joueur {


	private String nom;
	private List<String> scores;
	private List<Integer> setScores;
	private String currentScore = "0";
	private int finalScore;

	public String getNom() {
		return nom;
	}

	public void setFinalScore(int finalScore) {

		this.finalScore = finalScore;

	}

	public void addLastScore(String lastScore) {

		this.scores.add(lastScore);

	}

	public String getCurrentScore() {

		return currentScore;

	}

	public void setCurrentScore(String currentScore) {

		this.currentScore = currentScore;

	}

	public Joueur(String nom) {

		this.nom = nom;

		this.scores = new ArrayList<String>();

		this.setScores = new ArrayList<Integer>();

		finalScore = 0;

		setScores.add(0);

	}

	public List<Integer> getSetScores() {

		return setScores;

	}

	public List<String> getScores() {

		return scores;

	}

	public void addScore(String score) {

		scores.add(score);

	}

	public void addSetScore(int currentSetScore) {

		setScores.add(currentSetScore);

	}

	public int getFinalScore() {

		return finalScore;

	}

	public String getLastScore() {

		return scores.get(scores.size() - 1);

	}

	public int getLastSetScore() {

		return setScores.get(setScores.size() - 1);

	}

}