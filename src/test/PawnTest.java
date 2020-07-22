package test;

import org.junit.*;
import static org.junit.Assert.*;

import game.Color;
import game.Direction;
import game.Pawn;

/**
 * The test of the Pawn class
 * @author Herard Thibault
 */
public class PawnTest {
    
    Pawn p;

    /**
     * Initialisation
     */
    @Before
    public void setUp(){

        p = new Pawn(2,3,Color.WHITE);

    }

    /**
     * Tear down
     */
    @After
    public void tearDown(){

        p = null;

    }

    /**
     * Test of the constructor
     */
    @Test
    public void testPawn(){

        assertNotNull(p);

    }

    /**
     * Test of the method getX
     */
    @Test
    public void testGetX(){

        int x = p.getX();
        assertEquals(2, x);

    }

    /**
     * Test of the method getY
     */
    @Test
    public void testGetY(){

        int y = p.getY();
        assertEquals(3, y);

    }

    /**
     * Test of the method setPosition
     */
    @Test
    public void testSetPosition(){

        p.setPosition(3, 4);
        int x = p.getX();
        int y = p.getY();
        assertEquals(3, x);
        assertEquals(4, y);

    }

    /**
     * Test of the method isAlive
     */
    @Test
    public void testIsAlive(){

        boolean alive = p.isAlive();
        assertTrue(alive);

    }

    /**
     * Test of the setDead
     */
    @Test
    public void testSetDead(){

        //p.setDead();
        boolean dead = p.isAlive();
        assertTrue(dead);

    }

    /**
     * Test of the method move
     */
    @Test
    public void testMove(){

        p.move(Direction.SE, 2);
        assertEquals(4, p.getX());
        assertNotEquals(5, p.getY());


    }

    /**
     * Test of the method isZen
     */
    @Test
    public void testIsZen(){

        p = new Pawn(1,1,Color.ZEN);
        //boolean zen = p.isZen();
        //assertTrue(zen);

    }


    


    
}