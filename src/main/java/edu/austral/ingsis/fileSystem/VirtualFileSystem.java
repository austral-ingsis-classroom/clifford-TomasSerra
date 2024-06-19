package edu.austral.ingsis.fileSystem;

import java.util.*;

public class VirtualFileSystem {
  private Directory root;

  public VirtualFileSystem() {
    this.root = new Directory("/");
  }

  public Directory getRoot() {
    return root;
  }

  public String createFile(String name) {
    File file = new File(name);
    return root.add(file);
  }

  public String createDirectory(String name, Directory parent) {
    Directory directory = new Directory(name, parent);
    return root.add(directory);
  }

  public String delete(String name, String type) {
    return root.remove(name, type);
  }

  public String moveTo(String path) {
    if (path.equals("..")) {
      if (Objects.equals(root.name(), "/")) {
        return "moved to directory '/'";
      }
      if (root != null && root.getParent() != null) {
        root = root.getParent();
        return "moved to directory " + "'" + root.name() + "'";
      }
      return "cannot move to parent directory";
    }
    String[] directories = path.split("/");
    for (String directory : directories) {
      if (root == null) {
        return "directory not found";
      }
      if (root.getChild(directory) == null) {
        return "'" + directories[directories.length - 1] + "'" + " directory does not exist";
      }
      root = root.getChild(directory);
    }
    return "moved to directory " + "'" + directories[directories.length - 1] + "'";
  }

  public List<String> listChilds() {
    return root.getChilds();
  }

  public String getActualPath() {
    List<String> directories = new ArrayList<>();
    Directory actualRoot = root;
    directories.add(actualRoot.name());
    while (actualRoot.getParent() != null) {
      actualRoot = actualRoot.getParent();
      if (!Objects.equals(actualRoot.name(), "/")) {
        directories.add(actualRoot.name());
      }
    }
    List<String> reversedDirectories = new ArrayList<>();
    for (int i = directories.size() - 1; i >= 0; i--) {
      reversedDirectories.add(directories.get(i));
    }
    return "/" + String.join("/", reversedDirectories);
  }
}
