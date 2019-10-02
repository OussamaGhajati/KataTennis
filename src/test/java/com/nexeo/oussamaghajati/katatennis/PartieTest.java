
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

    @Before
    public void beforePartieTest() {
        nadal = new Joueur("Nadal");
        federer = new Joueur("Federer");
        partie = new Partie(nadal, federer);
    }

    @Test
    public void loveShouldBeDescriptionForScore0() {
        assertThat(partie, hasProperty("score", is("love, love")));
    }

    @Test
    public void loveFifteenShouldBeDescriptionForScore1() {
        federer.winBall();
        assertThat(partie, hasProperty("score", is("love, fifteen")));
    }

    @Test
    public void thirtyLoveShouldBeDescriptionForScore2() {
        nadal.winBall();
        nadal.winBall();
        assertThat(partie, hasProperty("score", is("thirty, love")));
    }

    @Test
    public void thirtyFifteenShouldBeDescriptionForScore3() {
        nadal.winBall();
        nadal.winBall();
       federer.winBall();
       assertThat(partie, hasProperty("score", is("thirty, fifteen")));
    }
    
    
    @Test
    public void fortyFifteenShouldBeDescriptionForScore4() {
        for(int index = 1; index <= 3; index++) {
            nadal.winBall();
        }
       federer.winBall();
       assertThat(partie, hasProperty("score", is("forty, fifteen")));
    }
    
    @Test
    public void fortyThirtyShouldBeDescriptionForScore5() {
        for(int index = 1; index <= 3; index++) {
            nadal.winBall();
        }
       federer.winBall();
       federer.winBall();
       assertThat(partie, hasProperty("score", is("forty, thirty")));
    }
    
    @Test
    public void fortyFortyShouldBeDescriptionForScore6() {
        for(int index = 1; index <= 3; index++) {
            nadal.winBall();
        }
        for(int index = 1; index <= 3; index++) {
            federer.winBall();
        }

       assertThat(partie, hasProperty("score", is("deuce")));
    }
    
    
    @Test
    public void advantageShouldBeDescriptionWhenLeastThreePointsHaveNeenScoredByEachSideAndJoueurHasOnePointMoreThanHisOpponent() {
        for(int index = 1; index <= 3; index++) {
            nadal.winBall();
        }
        for(int index = 1; index <= 4; index++) {
            federer.winBall();
        }
        assertThat(partie, hasProperty("score", is("advantage Federer")));
    }

    @Test
    public void deuceShouldBeDescriptionWhenAtLeastThreePointsHaveBeenScoredByEachJoueurAndTheScoresAreEqual() {
        for(int index = 1; index <= 3; index++) {
            nadal.winBall();
        }
        for(int index = 1; index <= 3; index++) {
            federer.winBall();
        }
        assertThat(partie, hasProperty("score", is("deuce")));
        nadal.winBall();
        assertThat(partie, hasProperty("score", is(not("deuce"))));
        federer.winBall();
        assertThat(partie, hasProperty("score", is("deuce")));
    }

    @Test
    public void partieShouldBeWonByTheFirstJoueurToHaveWonAtLeastFourPointsInTotalAndWithAtLeastTwoPointsMoreThanTheOpponent() {
        for(int index = 1; index <= 4; index++) {
            nadal.winBall();
        }
        for(int index = 1; index <= 3; index++) {
            federer.winBall();
        }
        assertThat(partie, hasProperty("score", is(not("Nadal won"))));
        assertThat(partie, hasProperty("score", is(not("Federer won"))));
        nadal.winBall();
        assertThat(partie, hasProperty("score", is("Nadal won")));
    }
    

    
    @Test
    public void SprintOneUserStoryTwo() {
    	
    	List<Joueur> matchScenario = Arrays.asList(federer, federer, nadal, federer, nadal, nadal, nadal,federer, federer, federer );
    	for (Joueur player : matchScenario) {
    		player.winBall();
    	}
    	assertThat(partie, hasProperty("score", is("Federer won")));

    }


}