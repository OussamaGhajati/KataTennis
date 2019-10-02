package com.nexo.oussamaghajati.katatennis;

import java.util.Arrays;
import java.util.List;

public class Joueur {

    public static final List<String> pointsString = Arrays.asList("love", "fifteen", "thirty", "forty");

    private int score;
 
    public int getScore() {
        return score;
    }
    String nom;
    public String getNom() {
        return nom;
    }

    public void winBall() {
        this.score = this.score + 1;
    }

    public Joueur(String nom) {
        this.nom = nom;
    }

    public String getScoreString(){
        return pointsString.get(score);
    }

}