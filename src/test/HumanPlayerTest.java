package test;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import game.Color;
import game.HumanPlayer;
import game.Pawn;

/**
 * The test of the HumanPlayer class
 * @author Herard Thibault
 */
public class HumanPlayerTest {

    HumanPlayer h;

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

        h = new HumanPlayer("Thibault", "WHITE");

    }

    /**
     * Tear down
     */
    @After
    public void tearDown(){

        h = null;

    }

    /**
     * Test of the constructor
     */
    @Test
    public void testHumanPlayer(){

        assertNotNull(h);

    }
    

}