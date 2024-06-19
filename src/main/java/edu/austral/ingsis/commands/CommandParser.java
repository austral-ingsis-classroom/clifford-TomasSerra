package edu.austral.ingsis.commands;

import java.util.HashMap;
import java.util.Map;

public class CommandParser {
  private final Map<String, Command> commands = new HashMap<>();

  public CommandParser() {
    commands.put("touch", new CreateFileCommand());
    commands.put("mkdir", new CreateDirectoryCommand());
    commands.put("ls", new ListCommand());
    commands.put("cd", new MoveToCommand());
    commands.put("pwd", new PwdCommand());
    commands.put("rm", new DeleteCommand());
  }

  public Command parse(String command) {
    return commands.get(command);
  }
}
