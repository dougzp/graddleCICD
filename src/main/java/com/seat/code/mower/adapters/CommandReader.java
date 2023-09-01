package com.seat.code.mower.adapters;

import com.seat.code.mower.ports.ValidateInputCommands;
import com.seat.code.mower.ports.tos.MowerCommands;
import com.seat.code.mower.ports.tos.MowerCommandType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CommandReader implements com.seat.code.mower.ports.CommandReader {
    private final ValidateInputCommands validateInputCommands;

    public CommandReader(ValidateInputCommands validateInputCommands) {
        this.validateInputCommands = validateInputCommands;
    }

    @Override
    public List<MowerCommands> readMowerCommandsToProcess(List<String> commands) {
        return commands.stream()
                .flatMap(command -> {
                    List<MowerCommands> resultCommands = new ArrayList<>();
                    if (this.validateInputCommands.validatePlateauInitCommand(command)) {
                        resultCommands.add(new MowerCommands(command, MowerCommandType.PLATEAU_INIT));
                    }
                    if (this.validateInputCommands.validateMowerInitCommand(command)) {
                        resultCommands.add(new MowerCommands(command, MowerCommandType.MOWER_INIT));
                    }
                    if (this.validateInputCommands.validateMowerMoveCommand(command)) {
                        resultCommands.add(new MowerCommands(command, MowerCommandType.MOVER_MOVE));
                    }
                    return resultCommands.stream();
                })
                .collect(Collectors.toList());
    }
}
