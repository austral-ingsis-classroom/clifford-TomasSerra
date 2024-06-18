package edu.austral.ingsis.commands;

import edu.austral.ingsis.fileSystem.VirtualFileSystem;

import java.util.List;

public interface Command {
    String execute(List<String> params, VirtualFileSystem virtualFileSystem);
}
