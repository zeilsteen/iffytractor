package com.rbs.odc.interview.command;

import com.rbs.odc.interview.Direction;
import com.rbs.odc.interview.Tractor;

//initialized in CommandFabric clazz
public class CommandBackward implements Command {

    private static final String COMMAND_KEY = "B";

    @Override
    public Command run(Tractor tractor) {
        Direction orientation = tractor.getOrientation();
        int[] position = tractor.getPosition();
        if (orientation == Direction.NORTH) {
            tractor.setPosition(new int[]{position[0], position[1] - 1});
        } else if (orientation == Direction.EAST) {
            tractor.setPosition(new int[]{position[0] - 1, position[1]});
        } else if (orientation == Direction.SOUTH) {
            tractor.setPosition(new int[]{position[0], position[1] + 1});
        } else if (orientation == Direction.WEST) {
            tractor.setPosition(new int[]{position[0] + 1, position[1]});
        }

        return this;
    }

    @Override
    public String getName() {
        return COMMAND_KEY;
    }

}
