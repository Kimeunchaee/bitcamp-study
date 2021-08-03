package com.eomcs.pms0802.menu;

import com.eomcs.pms0802.handler.ProjectHandler;

public class ProjectUpdateMenu extends Menu {

  ProjectHandler projectHandler;

  public ProjectUpdateMenu(ProjectHandler projectHandler) {
    super("변경");
    this.projectHandler = projectHandler;
  }

  @Override
  public void execute() {
    projectHandler.update();
  }

}
