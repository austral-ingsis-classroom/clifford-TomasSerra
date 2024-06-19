package edu.austral.ingsis;

import java.util.ArrayList;
import java.util.List;

public class FileSystemRunnerImpl implements FileSystemRunner {
  private final CLI cli;

  public FileSystemRunnerImpl(CLI cli) {
    this.cli = cli;
  }

  @Override
  public List<String> executeCommands(List<String> commands) {
    List<String> result = new ArrayList<>();
    for (String command : commands) {
      result.add(cli.executeCommand(command));
    }

    return result;
  }
}
