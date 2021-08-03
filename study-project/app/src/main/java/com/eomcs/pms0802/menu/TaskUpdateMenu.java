package com.eomcs.pms0802.menu;

import com.eomcs.pms0802.handler.TaskHandler;

public class TaskUpdateMenu extends Menu {


  TaskHandler taskHandler;

  public TaskUpdateMenu(TaskHandler taskHandler) {
    super("변경");
    this.taskHandler = taskHandler;
  }

  @Override
  public void execute() {
    taskHandler.update();
  }
}
