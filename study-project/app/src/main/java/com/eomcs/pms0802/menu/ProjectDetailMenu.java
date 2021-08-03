package com.eomcs.pms0802.menu;

import com.eomcs.pms0802.handler.ProjectHandler;

public class ProjectDetailMenu extends Menu {

  ProjectHandler projectHandler;

  public ProjectDetailMenu(ProjectHandler projecthandler) {
    super("상세보기");
    this.projectHandler = projectHandler;
  }

  @Override
  public void execute() {
    projectHandler.detail();
  }

}
