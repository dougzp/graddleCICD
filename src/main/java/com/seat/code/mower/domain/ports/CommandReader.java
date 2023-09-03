package com.seat.code.mower.domain.ports;

import com.seat.code.mower.adapters.tos.MowerCommands;

import java.util.List;

public interface CommandReader {


    List<MowerCommands> readMowerCommandsToProcess(List<String> commands);

}
