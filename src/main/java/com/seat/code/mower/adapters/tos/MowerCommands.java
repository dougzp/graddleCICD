package com.seat.code.mower.adapters.tos;

public class MowerCommands {

    public MowerCommands(String command, MowerCommandType type) {
        this.command = command;
        this.type = type;
    }
    private final String command;
    private final MowerCommandType type;

    public String getCommand() {
        return command;
    }

    public MowerCommandType getType() {
        return type;
    }

}
