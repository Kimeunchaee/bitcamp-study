package com.eomcs.pms0802.menu;

import com.eomcs.pms0802.handler.ProjectHandler;

public class ProjectAddMenu extends Menu {

  // add 기능을 호출할뿐

  ProjectHandler projectHandler;

  public ProjectAddMenu(ProjectHandler projectHandler) {
    super("등록");
    this.projectHandler = projectHandler;
  }

  @Override
  public void execute() {
    projectHandler.add();
  }
}
