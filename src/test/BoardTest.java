package test;

import org.junit.*;

import game.Board;
import game.Color;
import game.Direction;
import game.Line;
import game.Pawn;

import static org.junit.Assert.*;

/**
 * The test of the Board class
 * @author Herard Thibault
 */
public class BoardTest {

    Board b;

    /**
     * Initialisation
     */
    @Before
    public void setUp(){

        b = new Board();

    }

    /**
     * Tear down
     */
    @After
    public void tearDown(){

        b = null;

    }

    /**
     * Test of the constructor
     */
    @Test
    public void testBoard(){

        assertNotNull(b);

    }

    /**
     * Test of the method isFree
     */
    @Test
    public void testIsFree(){

        boolean free = b.isFree(1, 1);
        assertTrue(free);

        boolean busy = b.isFree(0, 0);
        assertFalse(busy);

    }

    /**
     * Test of the method add
     */
    @Test
    public void testAdd(){
        Pawn p = new Pawn(1, 1, Color.WHITE);
        b.add(p);

        boolean verif = b.isFree(1, 1);

        assertFalse(verif);

    }

    /**
     * Test of the method remove
     */
    @Test
    public void testRemove(){

        Pawn p = new Pawn(1, 1, Color.WHITE);
        b.add(p);
        b.remove(1,1);

        boolean verif = b.isFree(1, 1);
        assertTrue(verif);

    }

    /**
     * Test of the method isValid
     */
    @Test
    public void testIsValid(){

        boolean valid = b.isValid(b.getBoard()[0][5], Direction.E, b.numberOfPawn(Line.HORI, b.getBoard()[0][5]), Line.HORI);
        assertTrue(valid);

        boolean nonValid = b.isValid(b.getBoard()[0][5], Direction.SE, b.numberOfPawn(Line.DIAGGD, b.getBoard()[0][5]), Line.DIAGGD);
        assertFalse(nonValid);

    }   

    /**
     * Test of the method isAligned
     */
    @Test
    public void testIsAligned(){

        boolean nonAligned = b.isAligned(Color.BLACK);
        assertFalse(nonAligned);

        b = null;

        b = new Board();

        boolean aligned = b.isAligned(Color.WHITE);
        assertFalse(aligned);

    
    }

    /**
     * Test of the method selectPawn
     */
    @Test
    public void testSelectPawn(){

        assertEquals(b.getBoard()[0][0], b.selectPawn(0, 0));

    }

    /**
     * Test of the method numberOfPawn
     */
    @Test
    public void testNumberOfPawn(){

        
        int num = b.numberOfPawn(Line.HORI, b.getBoard()[0][0]);

        assertEquals(3, num);


    }
}

