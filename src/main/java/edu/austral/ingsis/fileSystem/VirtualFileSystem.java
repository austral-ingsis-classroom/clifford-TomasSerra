package edu.austral.ingsis.fileSystem;

import java.util.Comparator;
import java.util.List;

public class VirtualFileSystem {
    private Directory root;

    public VirtualFileSystem() {
        this.root = new Directory("C", new Directory("/"));
    }

    public Directory getRoot() {
        return root;
    }

    public String createFile(String name) {
        File file = new File(name);
        root.add(file);
        return "'" + name + "'" + " file created";
    }

    public String createDirectory(String name, Directory parent) {
        Directory directory = new Directory(name, parent);
        root.add(directory);
        return "'" + name +"'" + " directory created";
    }

    public String delete(String name, String type) {
        return root.remove(name, type);
    }

    public String moveTo(String path) {
        if(path.equals("..")){
            if(root != null && root.getParent() != null){
                root = root.getParent();
                return "moved to directory " + "'" + root.name() + "'";
            }
            return "cannot move to parent directory";
        }
        String[] directories = path.split("/");
        for (String directory : directories) {
            if(root == null){
                return "directory not found";
            }
            if(root.getChild(directory) == null){
                return "'"+directories[directories.length-1]+ "'" + " directory does not exist";
            }
            root = root.getChild(directory);
        }
        return "moved to directory " + "'" + directories[directories.length-1] + "'";
    }

    public List<String> listChilds(String order) {
        List<String> childs = root.getChilds();
        if(order.equals("--ord=asc")){
            childs.sort(String::compareTo);
        } else if(order.equals("--ord=desc")){
            childs.sort(Comparator.reverseOrder());
        }
        return childs;
    }

    public String getActualPath() {
        StringBuilder actualPath = new StringBuilder();
        while (root.getParent() != null) {
            actualPath.append("/").append(root.getParent().name());
        }
        return actualPath.toString();
    }
}
