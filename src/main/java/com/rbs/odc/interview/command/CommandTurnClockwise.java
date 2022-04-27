package com.rbs.odc.interview.command;

import com.rbs.odc.interview.Direction;
import com.rbs.odc.interview.Tractor;

//initialized in CommandFabric clazz
public class CommandTurnClockwise implements Command {

    private static final String COMMAND_KEY = "T";

    @Override
    public Command run(Tractor tractor) {
        tractor.setOrientation(Direction.turnClockwise(tractor.getOrientation()));
        return this;
    }

    @Override
    public String getName() {
        return COMMAND_KEY;
    }
}
