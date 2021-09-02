package com.eomcs.pms0901.pms.handler;

import com.eomcs.pms0901.pms.domain.Project;
import com.eomcs.pms0901.pms.domain.Task;
import com.eomcs.pms0901.util.Prompt;

// 상속 추가
public class TaskDetailHandler extends AbstractTaskHandler {


  AbstractProjectHandler projectHandler;    //생략가능

  public TaskDetailHandler (AbstractProjectHandler projectHandler) {
    super(projectHandler);
  }

  public void detail() {
    System.out.println("[작업 상세보기]");

    Project project = projectHandler.promptProject();
    if (project == null) {
      System.out.println("작업 조회를 취소합니다.");
      return;
    }

    printTasks(project);

    System.out.println("-------------------------------------");

    int taskNo = Prompt.inputInt("작업 번호? ");

    Task task = findByNo(project, taskNo);
    if (task == null) {
      System.out.println("해당 번호의 작업이 없습니다.");
      return;
    }

    System.out.printf("내용: %s\n", task.getContent());
    System.out.printf("마감일: %s\n", task.getDeadline());
    System.out.printf("상태: %s\n", getStatusLabel(task.getStatus()));
    System.out.printf("담당자: %s\n", task.getOwner().getName());
  }
}
