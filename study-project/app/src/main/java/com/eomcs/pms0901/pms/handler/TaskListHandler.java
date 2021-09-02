package com.eomcs.pms0901.pms.handler;

import com.eomcs.pms0901.pms.domain.Project;

public class TaskListHandler extends AbstractTaskHandler {

  //기존
  //  ProjectHandler projectHandler;
  //
  //  public TaskListHandler(ProjectHandler projectHandler) {
  //    this.projectHandler = projectHandler;
  //  }

  // 수정
  // AbstractTaskHandler에는 기본생성자가 없고
  // ProjectHandler를 받는 생성자만 있다
  //테스크 리스트 <-> 프로젝트 리스트
  AbstractProjectHandler projectListHandler;    //생략가능

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
