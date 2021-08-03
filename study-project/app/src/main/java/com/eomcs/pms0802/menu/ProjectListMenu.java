package com.eomcs.pms0802.menu;

import com.eomcs.pms0802.handler.ProjectHandler;

public class ProjectListMenu extends Menu {

  ProjectHandler projectHandler;

  public ProjectListMenu(ProjectHandler projectHandler) {
    super("목록");
    this.projectHandler = projectHandler;
  }

  @Override
  public void execute() {
    projectHandler.list();

  }

}
