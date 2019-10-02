
package com.nexeo.oussamaghajati.katatennis;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.nexo.oussamaghajati.katatennis.Joueur;
import com.nexo.oussamaghajati.katatennis.Partie;

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

       assertThat(partie, hasProperty("score", is("forty, forty")));
    }
    
    
    @Test
    public void NadalShouldBeDescriptionForScore6() {
       for(int index = 1; index <= 4; index++) {
            nadal.winBall();
        }
       assertThat(partie, hasProperty("score", is("Nadal won")));
    }
    
    @Test
    public void SprintOneUserStoryOne() {
    	
    	List<Joueur> matchScenario = Arrays.asList(federer, federer, nadal, federer, nadal, nadal, nadal );
    	for (Joueur player : matchScenario) {
    		player.winBall();
    	}
    	assertThat(partie, hasProperty("score", is("Nadal won")));

    }

}