package com.rbs.odc.interview;


import com.rbs.odc.interview.command.CommandFabric;
import lombok.Data;

@Data
public class Tractor {

    private CommandFabric commandFabric = CommandFabric.getInstance();

    private int[] position = new int[]{0, 0};
    private int[] field;
    private Direction orientation = Direction.NORTH;

    public Tractor(int maxX, int maxY) {
        field = new int[]{maxX, maxY};
    }

    public void move(String command) {

        commandFabric.getCommand(command)
                .orElseThrow(() -> new IllegalArgumentException("unknown command"))
                .run(this)
                .validate(this);
    }


    public int getPositionX() {
        return position[0];
    }

    public int getPositionY() {
        return position[1];
    }

    public Direction getOrientation() {
        return orientation;
    }
}
