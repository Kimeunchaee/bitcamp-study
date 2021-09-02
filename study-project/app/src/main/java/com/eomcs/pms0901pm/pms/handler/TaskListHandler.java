package com.eomcs.pms0901pm.pms.handler;

import com.eomcs.pms0901pm.pms.domain.Project;

public class TaskListHandler extends AbstractTaskHandler {

  public TaskListHandler(AbstractProjectHandler projectHandler) {
    super(projectHandler);
  }

  public void list() {
    System.out.println("[작업 목록]");

    Project project = projectHandler.promptProject();
    if (project == null) {
      System.out.println("작업 등록을 취소합니다.");
      return;
    }

    printTasks(project);
  }
}





