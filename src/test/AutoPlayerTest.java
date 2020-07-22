package test;
import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import game.AutoPlayer;
import game.Color;
import game.Difficulty;
import game.Pawn;

/**
 * The test of the AutoPlayer class
 * @author Herard Thibault
 */
public class AutoPlayerTest {

    AutoPlayer a;

    /**
     * Initialisation
     */
    @Before
    public void setUp(){

        ArrayList<Pawn> pawns = new ArrayList<Pawn>();

        pawns.add(new Pawn(0, 6, Color.WHITE));
        pawns.add(new Pawn(0, 10, Color.WHITE));

        pawns.add(new Pawn(2, 3, Color.WHITE));
        pawns.add(new Pawn(2, 7, Color.WHITE));

        pawns.add(new Pawn(4, 1, Color.WHITE));
        pawns.add(new Pawn(4, 9, Color.WHITE));

        pawns.add(new Pawn(6, 1, Color.WHITE));
        pawns.add(new Pawn(6, 9, Color.WHITE));

        pawns.add(new Pawn(8, 3, Color.WHITE));
        pawns.add(new Pawn(8, 7, Color.WHITE));

        pawns.add(new Pawn(10, 0, Color.WHITE));
        pawns.add(new Pawn(10, 6, Color.WHITE));

        a = new AutoPlayer("Thibault", "WHITE", Difficulty.EASY);

    }

    /**
     * Tear down
     */
    @After
    public void tearDown(){

        a = null;

    }

    /**
     * Test of the constructor
     */
    @Test
    public void testAutoPlayer(){

        assertNotNull(a);

    }

    /**
     * Test of the method setDifficulty
     */
    @Test
    public void testSetDifficulty(){

        a.setDifficulty(Difficulty.EASY);
        assertEquals(Difficulty.EASY, a.getDifficulty());

    }  

    /**
     * Test of the method getDifficulty
     */
    @Test
    public void testGetDifficulty(){

        a.setDifficulty(Difficulty.EASY);
        Difficulty dif = a.getDifficulty();

        assertEquals(Difficulty.EASY, dif);

    }

}