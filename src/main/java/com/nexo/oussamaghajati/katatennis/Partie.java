package com.nexo.oussamaghajati.katatennis;


public class Partie {

    private Joueur joueur1;
    private Joueur joueur2;

    public Partie(Joueur joueur1, Joueur joueur2) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
    }

    public String getScore() {

    	if (joueur1.getScore() ==4  || joueur2.getScore() == 4) {
    		Joueur leadJoueur = getLeadJoueur();
            return leadJoueur.getNom() + " won";
    		
    	}
            return joueur1.getScoreString() + ", " + joueur2.getScoreString();
        }


    public Joueur getLeadJoueur() {
        return (joueur1.getScore() > joueur2.getScore()) ? joueur1 : joueur2;
    }

}