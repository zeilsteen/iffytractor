package com.rbs.odc.interview.command;


import com.rbs.odc.interview.Tractor;
import com.rbs.odc.interview.TractorInDitchException;

public interface Command {

    Command run(Tractor tractor);

    String getName();

    default void validate(Tractor tractor) {

        int[] position = tractor.getPosition();
        int[] field = tractor.getField();
        if (position[0] > field[0] || position[1] > field[1] || position[0] < 0 || position[1] < 0) {
            throw new TractorInDitchException();
        }

    }
}
