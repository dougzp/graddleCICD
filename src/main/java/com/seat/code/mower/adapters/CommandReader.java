package com.seat.code.mower.adapters;

import com.seat.code.mower.adapters.exception.InvalidMowerCommandException;
import com.seat.code.mower.domain.ports.ValidateInputCommands;
import com.seat.code.mower.adapters.tos.MowerCommands;
import com.seat.code.mower.adapters.tos.MowerCommandType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CommandReader implements com.seat.code.mower.domain.ports.CommandReader {
    private final ValidateInputCommands validateInputCommands;

    public CommandReader(ValidateInputCommands validateInputCommands) {
        this.validateInputCommands = validateInputCommands;
    }

    @Override
    public List<MowerCommands> readMowerCommandsToProcess(List<String> commands) {
        return commands.stream()
                .flatMap(command -> {
                    List<MowerCommands> resultCommands = new ArrayList<>();
                    if (this.validateInputCommands.validatePlateauInitCommand().test(command)) {
                        resultCommands.add(new MowerCommands(command, MowerCommandType.PLATEAU_INIT));
                    } else if (this.validateInputCommands.validateMowerInitCommand().test(command)) {
                        resultCommands.add(new MowerCommands(command, MowerCommandType.MOWER_INIT));
                    } else if (this.validateInputCommands.validateMowerMoveCommand().test(command)) {
                        resultCommands.add(new MowerCommands(command, MowerCommandType.MOVER_MOVE));
                    }else{
                        throw new InvalidMowerCommandException("Invalid List of Commands");
                    }
                    return resultCommands.stream();
                })
                .collect(Collectors.toList());
    }
}
