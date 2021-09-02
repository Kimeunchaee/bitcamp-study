package com.eomcs.pms0901.pms.handler;

import com.eomcs.pms0901.pms.domain.Project;
import com.eomcs.pms0901.pms.domain.Task;
import com.eomcs.pms0901.util.Prompt;

// 추상클래스로 변경
public abstract class AbstractTaskHandler {

  // 데이터타입을 부모클래스로 선언한다
  // 접근 범위 제한
  protected AbstractProjectHandler projectHandler;

  public AbstractTaskHandler(AbstractProjectHandler projectHandler) {
    this.projectHandler = projectHandler;
  }


  //접근 범위 수정
  protected void printTasks(Project project) {
    System.out.printf("%s:\n\n", project.getTitle());
    for (Task task : project.getTasks()) {
      System.out.printf("%d, %s, %s, %s, %s\n",
          task.getNo(), 
          task.getContent(), 
          task.getDeadline(), 
          getStatusLabel(task.getStatus()), 
          task.getOwner().getName());
    }
  }

  //접근 범위 수정
  protected static String getStatusLabel(int status) {
    switch (status) {
      case 1: return "진행중";
      case 2: return "완료";
      default: return "신규";
    }
  }

  // 접근 범위 수정
  protected static int promptStatus() {
    return promptStatus(-1);
  }

  // 접근 범위 수정
  protected static int promptStatus(int status) {
    if (status == -1) {
      System.out.println("상태?");
    } else {
      System.out.printf("상태(%s)?\n", getStatusLabel(status));
    }
    System.out.println("0: 신규");
    System.out.println("1: 진행중");
    System.out.println("2: 완료");
    return Prompt.inputInt("> ");
  }

  // 접근 범위 수정
  protected static Task findByNo(Project project, int taskNo) {
    for (Task task : project.getTasks()) {
      if (task.getNo() == taskNo) {
        return task;
      }
    }
    return null;
  }

}
