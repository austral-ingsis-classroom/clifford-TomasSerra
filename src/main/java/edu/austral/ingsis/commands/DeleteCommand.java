package edu.austral.ingsis.commands;

import edu.austral.ingsis.fileSystem.VirtualFileSystem;

import java.util.List;

public class DeleteCommand implements Command {

    @Override
    public String execute(List<String> params, VirtualFileSystem virtualFileSystem) {
        if(params.size() == 0) return "No path provided";
        if(params.size() == 1) return virtualFileSystem.delete(params.get(0), "");
        if(params.size() == 2) return virtualFileSystem.delete(params.get(1), params.get(0));
        return "Too many arguments";
    }
}
