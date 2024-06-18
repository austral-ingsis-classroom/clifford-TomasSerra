package edu.austral.ingsis.commands;

import edu.austral.ingsis.fileSystem.VirtualFileSystem;

import java.util.List;

public class ListCommand implements Command{

    @Override
    public String execute(List<String> params, VirtualFileSystem virtualFileSystem) {
        List<String> childs = virtualFileSystem.listChilds(params.size() > 0 ? params.get(0) : "");
        return String.join(" ", childs);
    }
}
