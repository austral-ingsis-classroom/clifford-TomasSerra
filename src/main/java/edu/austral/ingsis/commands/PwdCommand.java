package edu.austral.ingsis.commands;

import edu.austral.ingsis.fileSystem.VirtualFileSystem;

import java.util.List;

public class PwdCommand implements Command{

    @Override
    public String execute(List<String> params, VirtualFileSystem virtualFileSystem) {
        return virtualFileSystem.getActualPath();
    }
}
