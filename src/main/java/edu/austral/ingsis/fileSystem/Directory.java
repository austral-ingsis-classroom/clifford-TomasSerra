package edu.austral.ingsis.fileSystem;

import java.util.*;

public class Directory implements FileSystemComponent {
  private final String name;
  private final List<FileSystemComponent> components = new ArrayList<>();
  private final Directory parent;

  public Directory(String name) {
    this.name = name;
    this.parent = null;
  }

  public Directory(String name, Directory parent) {
    this.name = name;
    this.parent = parent;
  }

  public String add(Directory component) {
    boolean contains = false;
    for (FileSystemComponent fileSystemComponent : components) {
      if (fileSystemComponent.name().equals(component.name())
          && fileSystemComponent instanceof Directory) {
        contains = true;
      }
    }
    if (contains) {
      return "'" + component.name() + "'" + " already exists";
    }
    components.add(component);
    return "'" + component.name() + "'" + " directory created";
  }

  public String add(File component) {
    boolean contains = false;

    for (FileSystemComponent fileSystemComponent : components) {
      if (fileSystemComponent.name().equals(component.name())
          && fileSystemComponent instanceof File) {
        contains = true;
      }
    }

    if (contains) {
      return "'" + component.name() + "'" + " already exists";
    }
    components.add(component);
    return "'" + component.name() + "'" + " file created";
  }

  @Override
  public String name() {
    return name;
  }

  public String remove(String name, String type) {
    if (Objects.equals(type, "")) {
      for (FileSystemComponent component : components) {
        if (component.name().equals(name) && component instanceof File) {
          components.remove(component);
          return "'" + name + "'" + " removed";
        }
      }
    } else if (Objects.equals(type, "--recursive")) {
      for (FileSystemComponent component : components) {
        if (component.name().equals(name) && component instanceof Directory) {
          components.remove(component);
          return "'" + name + "'" + " removed";
        }
      }
    }

    return "cannot remove " + "'" + name + "'" + ", is a directory";
  }

  public Directory getChild(String name) {
    for (FileSystemComponent component : components) {
      if (component.name().equals(name) && component instanceof Directory) {
        return (Directory) component;
      }
    }
    return null;
  }

  public List<String> getChilds() {
    List<String> childs = new ArrayList<>();
    for (FileSystemComponent component : components) {
      childs.add(component.name());
    }
    return childs;
  }

  public Directory getParent() {
    return parent;
  }
}
