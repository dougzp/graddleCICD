package com.seat.code.mower.ports;

import com.seat.code.mower.ports.tos.MowerCommands;

import java.util.List;

public interface CommandReader {


    List<MowerCommands> readMowerCommandsToProcess(List<String> commands);

}
