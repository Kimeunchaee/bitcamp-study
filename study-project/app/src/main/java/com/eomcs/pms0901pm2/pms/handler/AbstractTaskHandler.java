package com.eomcs.pms0901pm2.pms.handler;

import com.eomcs.pms0901pm.pms.domain.Project;
import com.eomcs.pms0901pm.pms.domain.Task;
import com.eomcs.pms0901pm.util.Prompt;

public abstract class AbstractTaskHandler {

  protected AbstractProjectHandler projectHandler;

  public AbstractTaskHandler(AbstractProjectHandler projectHandler) {
    this.projectHandler = projectHandler;
  }


  //출력은 핸들러의 역할 (프로젝트의 값을 다루고 있어도 테스크에서 출력하는것이기때문에 옮길필요없음)
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

  protected static String getStatusLabel(int status) {
    switch (status) {
      case 1: return "진행중";
      case 2: return "완료";
      default: return "신규";
    }
  }

  protected static int promptStatus() {
    return promptStatus(-1);
  }

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


  //AbstractTaskHandler 에 있던 findByNo() 메서드를 Project 도메인으로 옮긴다
  //  protected static Task findByNo(Project project, int taskNo) {
  //    for (Task task : project.getTasks()) {
  //      if (task.getNo() == taskNo) {
  //        return task;
  //      }
  //    }
  //    return null;
  //  }

}




