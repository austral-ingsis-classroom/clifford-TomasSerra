package edu.austral.ingsis.commands;

import edu.austral.ingsis.fileSystem.VirtualFileSystem;

import java.util.List;

public class CreateFileCommand implements Command {

    @Override
    public String execute(List<String> params, VirtualFileSystem virtualFileSystem) {
        return virtualFileSystem.createFile(params.get(0));
    }
}
