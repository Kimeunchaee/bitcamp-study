package com.eomcs.pms0802.menu;

import com.eomcs.pms0802.handler.TaskHandler;

public class TaskDetailMenu extends Menu {


  TaskHandler taskHandler;

  public TaskDetailMenu(TaskHandler taskHandler) {
    super("상세보기");
    this.taskHandler = taskHandler;
  }

  @Override
  public void execute() {
    taskHandler.detail();
  }
}
