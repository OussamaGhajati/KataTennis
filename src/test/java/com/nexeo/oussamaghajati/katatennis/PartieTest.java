
package com.nexeo.oussamaghajati.katatennis;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.nexeo.oussamaghajati.katatennis.Joueur;
import com.nexeo.oussamaghajati.katatennis.Partie;

import static org.hamcrest.Matchers.*;


public class PartieTest {

    Joueur nadal;
    Joueur federer;
    Partie partie;
    List<Joueur> nadalRemporteSet;
    List<Joueur> federerRemporteSet;


    @Before
    public void beforePartieTest() {
        nadal = new Joueur("Nadal");
        federer = new Joueur("Federer");
        partie = new Partie(nadal, federer);
    	// nadal remporte le set
    	nadalRemporteSet = Arrays.asList(nadal, nadal, federer, nadal, federer, federer, nadal,nadal);

    	// federer remporte le set
    	 federerRemporteSet = Arrays.asList(nadal, nadal, federer, nadal, federer, federer,federer, federer);
        
    }

    @Test
    public void loveShouldBeDescriptionForScore0() {
        assertThat(nadal, hasProperty("currentScore", is("0")));
        assertThat(federer, hasProperty("currentScore", is("0")));
    }

    @Test
    public void loveFifteenShouldBeDescriptionForScore1() {

       partie.play(nadal);
       assertThat(nadal, hasProperty("currentScore", is("15")));
       assertThat(federer, hasProperty("currentScore", is("0")));

    }

    @Test
    public void thirtyLoveShouldBeDescriptionForScore2() {
    	
        partie.play(nadal);
        partie.play(nadal);
        assertThat(nadal, hasProperty("currentScore", is("30")));
        assertThat(federer, hasProperty("currentScore", is("0")));

    }

    @Test
    public void thirtyFifteenShouldBeDescriptionForScore3() {
    	
        partie.play(nadal);
        partie.play(nadal);
        partie.play(federer);
        assertThat(nadal, hasProperty("currentScore", is("30")));
        assertThat(federer, hasProperty("currentScore", is("15")));
    	
    }
    
    
    @Test
    public void fortyFifteenShouldBeDescriptionForScore4() {
    	
        partie.play(nadal);
        partie.play(nadal);
        partie.play(nadal);
        partie.play(federer);
        assertThat(nadal, hasProperty("currentScore", is("40")));
        assertThat(federer, hasProperty("currentScore", is("15")));
    	
    }
    
    @Test
    public void fortyThirtyShouldBeDescriptionForScore5() {
        partie.play(nadal);
        partie.play(nadal);
        partie.play(nadal);
        partie.play(federer);
        partie.play(federer);
        assertThat(nadal, hasProperty("currentScore", is("40")));
        assertThat(federer, hasProperty("currentScore", is("30")));
    }
    
    @Test
    public void fortyFortyShouldBeDescriptionForScore6() {
        partie.play(nadal);
        partie.play(nadal);
        partie.play(nadal);
        partie.play(federer);
        partie.play(federer);
        partie.play(federer);
        assertThat(nadal, hasProperty("currentScore", is("40")));
        assertThat(federer, hasProperty("currentScore", is("40")));
    }
    
    
    @Test
    public void advantageShouldBeDescriptionWhenLeastThreePointsHaveNeenScoredByEachSideAndJoueurHasOnePointMoreThanHisOpponent() {
        partie.play(nadal);
        partie.play(nadal);
        partie.play(nadal);
        partie.play(federer);
        partie.play(federer);
        partie.play(federer);
        partie.play(federer);
        assertThat(nadal, hasProperty("currentScore", is("40")));
        assertThat(federer, hasProperty("currentScore", is("ADV")));
    }

    @Test
    public void deuceShouldBeDescriptionWhenAtLeastThreePointsHaveBeenScoredByEachJoueurAndTheScoresAreEqual() {
        partie.play(nadal);
        partie.play(nadal);
        partie.play(nadal);
        partie.play(federer);
        partie.play(federer);
        partie.play(federer);
        partie.play(nadal);
        partie.play(federer);
        assertThat(nadal, hasProperty("currentScore", is("DEUCE")));
        assertThat(federer, hasProperty("currentScore", is("DEUCE")));
    }

    @Test
    public void partieShouldBeWonByTheFirstJoueurToHaveWonAtLeastFourPointsInTotalAndWithAtLeastTwoPointsMoreThanTheOpponent() {
        partie.play(nadal);
        partie.play(nadal);
        partie.play(nadal);
        partie.play(federer);
        partie.play(federer);
        partie.play(federer);
        partie.play(nadal);
        partie.play(federer);
        partie.play(federer);
        partie.play(federer);
        assertThat(federer, hasProperty("currentScore", is("Win game")));
    }
    
    @Test
    public void gameShouldBeWonByTheFirstJoueurToHaveWonSixSetsInTotalAndWithAtLeastTwoPointsMoreThanTheOpponent() {
    	

		playTennisSet(partie, nadalRemporteSet);
		playTennisSet(partie, nadalRemporteSet);
		playTennisSet(partie, nadalRemporteSet);
		playTennisSet(partie, federerRemporteSet);
		playTennisSet(partie, federerRemporteSet);
		playTennisSet(partie, federerRemporteSet);
		playTennisSet(partie, federerRemporteSet);
		playTennisSet(partie, nadalRemporteSet);
		playTennisSet(partie, nadalRemporteSet);
		playTennisSet(partie, nadalRemporteSet);

        assertThat(partie, hasProperty("gagnantJeu", is(nadal)));

    }

    @Test
    public void aNewSetIsNeeded() {
    	

		playTennisSet(partie, nadalRemporteSet);
		playTennisSet(partie, nadalRemporteSet);
		playTennisSet(partie, nadalRemporteSet);
		playTennisSet(partie, federerRemporteSet);
		playTennisSet(partie, federerRemporteSet);
		playTennisSet(partie, federerRemporteSet);
		playTennisSet(partie, federerRemporteSet);
		playTennisSet(partie, nadalRemporteSet);
		playTennisSet(partie, nadalRemporteSet);
		playTennisSet(partie, federerRemporteSet);
		playTennisSet(partie, nadalRemporteSet);

        assertThat(nadal, hasProperty("finalScore", is(6)));
        assertThat(federer, hasProperty("finalScore", is(5)));
    	
    }
    
    @Test
    public void gameShouldBeWonByTheFirstJoueurToHaveWonSevenSetsInTotal() {
    	
    	
		playTennisSet(partie, nadalRemporteSet);
		playTennisSet(partie, nadalRemporteSet);
		playTennisSet(partie, nadalRemporteSet);
		playTennisSet(partie, federerRemporteSet);
		playTennisSet(partie, federerRemporteSet);
		playTennisSet(partie, federerRemporteSet);
		playTennisSet(partie, federerRemporteSet);
		playTennisSet(partie, nadalRemporteSet);
		playTennisSet(partie, nadalRemporteSet);
		playTennisSet(partie, federerRemporteSet);
		playTennisSet(partie, nadalRemporteSet);
		playTennisSet(partie, federerRemporteSet);
		playTennisSet(partie, federerRemporteSet);


        assertThat(nadal, hasProperty("finalScore", is(6)));
        assertThat(federer, hasProperty("finalScore", is(7)));
    	
    

    }
    
    @Test
    public void SprintTwoUserStoryOne() {
    	
		playTennisSet(partie, federerRemporteSet);
		playTennisSet(partie, nadalRemporteSet);
		playTennisSet(partie, nadalRemporteSet);
		playTennisSet(partie, nadalRemporteSet);
		playTennisSet(partie, nadalRemporteSet);
		playTennisSet(partie, nadalRemporteSet);
		playTennisSet(partie, nadalRemporteSet);


    	 assertThat(partie, hasProperty("gagnantJeu", is(nadal)));

    }

	private void playTennisSet(Partie partie2, List<Joueur> pointsJoueur) {
		
		for (Joueur joueur : pointsJoueur) {

			partie2.play(joueur);

		}
		
	}
    



}