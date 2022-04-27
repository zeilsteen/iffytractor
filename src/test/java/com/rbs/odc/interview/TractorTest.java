package com.rbs.odc.interview;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

/**
 * @author Ben
 */

@RunWith(JUnit4.class)
public class TractorTest {

    @Test
    public void testShouldMoveForward() {
        Tractor tractor = new Tractor(4, 4);
        tractor.move("F");
        assertEquals(0, tractor.getPositionX());
        assertEquals(1, tractor.getPositionY());
    }

    @Test
    public void testShouldMoveForwardAndBackward() {
        Tractor tractor = new Tractor(4, 4);
        tractor.move("F");
        tractor.move("F");
        tractor.move("B");
        assertEquals(0, tractor.getPositionX());
        assertEquals(1, tractor.getPositionY());
    }

    @Test
    public void testShouldTurn() {
        Tractor tractor = new Tractor(4, 4);
        tractor.move("T");
        assertEquals(Direction.EAST, tractor.getOrientation());
        tractor.move("T");
        assertEquals(Direction.SOUTH, tractor.getOrientation());
        tractor.move("T");
        assertEquals(Direction.WEST, tractor.getOrientation());
        tractor.move("T");
        assertEquals(Direction.NORTH, tractor.getOrientation());
    }

    @Test
    public void testShouldTurnAndMoveInTheRightDirection() {
        Tractor tractor = new Tractor(4, 4);
        tractor.move("F");
        assertEquals(0, tractor.getPositionX());
        assertEquals(1, tractor.getPositionY());
        tractor.move("F");
        assertEquals(0, tractor.getPositionX());
        assertEquals(2, tractor.getPositionY());
        tractor.move("T");
        tractor.move("F");
        assertEquals(1, tractor.getPositionX());
        assertEquals(2, tractor.getPositionY());
        tractor.move("T");
        tractor.move("F");
        assertEquals(1, tractor.getPositionX());
        assertEquals(1, tractor.getPositionY());
    }

    @Test(expected = TractorInDitchException.class)
    public void testShouldThrowExceptionIfFallsOffPlateauOne() {
        Tractor tractor = new Tractor(4, 4);
        tractor.move("F");
        tractor.move("F");
        tractor.move("F");
        tractor.move("F");
        tractor.move("F");
    }

    @Test(expected = TractorInDitchException.class)
    public void testShouldThrowExceptionIfFallsOffPlateauTwo() {
        Tractor tractor = new Tractor(4, 4);
        tractor.move("B");
    }
}
