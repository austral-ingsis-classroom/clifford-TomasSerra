package edu.austral.ingsis.fileSystem;

public class File implements FileSystemComponent {
  private final String name;

  public File(String name) {
    this.name = name;
  }

  @Override
  public String name() {
    return name;
  }
}
