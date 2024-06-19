package edu.austral.ingsis;

import edu.austral.ingsis.commands.Command;
import edu.austral.ingsis.commands.CommandParser;
import edu.austral.ingsis.fileSystem.VirtualFileSystem;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CLI {
  private final VirtualFileSystem fileSystem;
  private final CommandParser parser;

  public CLI() {
    this.fileSystem = new VirtualFileSystem();
    this.parser = new CommandParser();
  }

  public String executeCommand(String stringCommand) {
    String[] args = stringCommand.split(" ");
    Command command = parser.parse(args[0]);
    String[] params = Arrays.copyOfRange(args, 1, args.length);
    return command.execute(Arrays.stream(params).collect(Collectors.toList()), fileSystem);
  }
}
