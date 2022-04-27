package com.rbs.odc.interview;

public enum Direction {

    NORTH, SOUTH, EAST, WEST;

    public static Direction turnClockwise(Direction direction) {
        if (Direction.NORTH == direction) {
            return Direction.EAST;
        } else if (Direction.EAST == direction) {

            return Direction.SOUTH;
        } else if (Direction.SOUTH == direction) {

            return Direction.WEST;
        } else if (Direction.WEST == direction) {

            return Direction.NORTH;
        }
        throw new IllegalArgumentException("unknown direction");
    }

}
