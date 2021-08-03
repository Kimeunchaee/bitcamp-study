package com.eomcs.pms0802.menu;

import com.eomcs.pms0802.handler.ProjectHandler;

public class ProjectDeleteMenu extends Menu {

  ProjectHandler projectHandler;

  public ProjectDeleteMenu(ProjectHandler projectHandler) {
    super("삭제");
    this.projectHandler = projectHandler;
  }

  @Override
  public void execute() {
    projectHandler.delete();
  }

}
