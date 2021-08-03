package com.eomcs.pms0802.menu;

import com.eomcs.pms0802.handler.TaskHandler;

public class TaskDeleteMenu extends Menu {


  TaskHandler taskHandler;

  public TaskDeleteMenu(TaskHandler taskHandler) {
    super("삭제");
    this.taskHandler = taskHandler;
  }

  @Override
  public void execute() {
    taskHandler.delete();
  }
}
