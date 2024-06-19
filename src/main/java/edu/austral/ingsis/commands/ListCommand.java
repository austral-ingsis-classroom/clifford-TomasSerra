package edu.austral.ingsis.commands;

import edu.austral.ingsis.fileSystem.VirtualFileSystem;
import java.util.Collections;
import java.util.List;

public class ListCommand implements Command {

  @Override
  public String execute(List<String> params, VirtualFileSystem virtualFileSystem) {
    List<String> childs = virtualFileSystem.listChilds();
    if (params.isEmpty()) {
      return String.join(" ", childs);
    }
    String order = params.get(0);
    if (order.equals("--ord=asc")) {
      Collections.sort(childs);
    } else if (order.equals("--ord=desc")) {
      childs.sort(Collections.reverseOrder());
    }
    return String.join(" ", childs);
  }
}
