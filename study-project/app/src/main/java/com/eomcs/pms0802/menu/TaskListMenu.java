package com.eomcs.pms0802.menu;

import com.eomcs.pms0802.handler.TaskHandler;

public class TaskListMenu extends Menu {


  TaskHandler taskHandler;

  public TaskListMenu(TaskHandler taskHandler) {
    super("목록");
    this.taskHandler = taskHandler;
  }

  @Override
  public void execute() {
    taskHandler.list();
  }
}
