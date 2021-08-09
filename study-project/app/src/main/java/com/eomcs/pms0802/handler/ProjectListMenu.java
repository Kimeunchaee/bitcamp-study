package com.eomcs.pms0802.handler;

import com.eomcs.pms0802.menu.Menu;

public class ProjectListMenu extends Menu{

  ProjectHandler projectHandler;
  public ProjectListMenu(ProjectHandler projectHandler) {
    super("등록");
    this.projectHandler = projectHandler;
  }


  @Override
  public void execute() {
    projectHandler.add();
  }

}





