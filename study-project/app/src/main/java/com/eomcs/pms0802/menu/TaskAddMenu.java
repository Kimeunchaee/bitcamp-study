package com.eomcs.pms0802.menu;

import com.eomcs.pms0802.handler.TaskHandler;

public class TaskAddMenu extends Menu {

  // add 기능을 호출할뿐

  TaskHandler taskHandler;

  public TaskAddMenu(TaskHandler taskHandler) {
    super("등록");
    this.taskHandler = taskHandler;
  }

  @Override
  public void execute() {
    taskHandler.add();
  }
}
