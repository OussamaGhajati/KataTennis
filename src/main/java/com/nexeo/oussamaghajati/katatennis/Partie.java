package com.nexeo.oussamaghajati.katatennis;

public class Partie {

	private Joueur joueur1;
	private Joueur joueur2;
	private Joueur gagnantJeu;


	public Partie(Joueur joueur1, Joueur joueur2) {
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
	}

	public void play(Joueur joueur) {

		Joueur gagnant, perdant;

		if (joueur.getNom().equals(joueur1.getNom())) {
			gagnant = joueur1;
			perdant = joueur2;
		} else {
			gagnant = joueur2;
			perdant = joueur1;
		}

		if (!gagnant.getCurrentScore().equals("Win game") && !perdant.getCurrentScore().equals("Win game")
				){

			gagnant.addLastScore(gagnant.getCurrentScore());
			perdant.addLastScore(perdant.getCurrentScore());

			switch (gagnant.getCurrentScore()) {
			case "0":
				gagnant.setCurrentScore("15");
				break;
			case "15":
				gagnant.setCurrentScore("30");
				break;
			case "30":
				gagnant.setCurrentScore("40");
				break;
			case "40":
				if (perdant.getCurrentScore().equals("40")) {
					gagnant.setCurrentScore("ADV");
				} else if (perdant.getCurrentScore().equals("ADV")) {
					gagnant.setCurrentScore("DEUCE");
					perdant.setCurrentScore("DEUCE");
				} else {
					gagnant.setCurrentScore("Win game");
					joueur1.getScores().add("0");
					joueur2.getScores().add("0");
				}
				break;
			case "DEUCE":
				gagnant.setCurrentScore("ADV");
				perdant.setCurrentScore("40");
				break;
			case "ADV":
				gagnant.setCurrentScore("Win game");
				joueur1.getScores().add("0");
				joueur2.getScores().add("0");
				break;
			default:
				break;
			}
			if (gagnant.getCurrentScore().equals("Win game")) {

				gagnant.setFinalScore(gagnant.getFinalScore() + 1);
				if ((gagnant.getFinalScore() == 6 && perdant.getFinalScore() <= 4)
						|| (gagnant.getFinalScore() > 6 && (gagnant.getFinalScore() - perdant.getFinalScore() >= 2))) 

				{
					gagnantJeu = gagnant;
				}
				
			}

		} else {
			// initialize set score
			joueur1.addSetScore(joueur1.getFinalScore());
			joueur2.addSetScore(joueur2.getFinalScore());
			joueur1.setCurrentScore("0");
			joueur2.setCurrentScore("0");
			play(joueur);
		}
	}

	public Joueur getGagnantJeu() {
		return gagnantJeu;
	}

	public void setGagnantJeu(Joueur gagnantJeu) {
		this.gagnantJeu = gagnantJeu;
	}


}