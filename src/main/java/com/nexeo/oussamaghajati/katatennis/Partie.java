package com.nexeo.oussamaghajati.katatennis;


public class Partie {

    private Joueur joueur1;
    private Joueur joueur2;

    public Partie(Joueur joueur1, Joueur joueur2) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
    }

    public String getScore() {
        if (joueur1.getScore() >= 3 && joueur2.getScore() >= 3) {
            if (Math.abs(joueur2.getScore() - joueur1.getScore()) >= 2) {
              Joueur leadJoueur = getLeadJoueur();
              return leadJoueur.getNom() + " won";
            } else if (joueur1.getScore() == joueur2.getScore()) {
                return "deuce";
            } else {
                return "advantage " + getLeadJoueur().getNom();
            }
        } else {
            return joueur1.getScoreString() + ", " + joueur2.getScoreString();
        }
    }


    public Joueur getLeadJoueur() {
        return (joueur1.getScore() > joueur2.getScore()) ? joueur1 : joueur2;
    }

}