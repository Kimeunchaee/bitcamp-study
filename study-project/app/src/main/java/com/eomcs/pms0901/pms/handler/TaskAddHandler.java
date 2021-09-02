package com.eomcs.pms0901.pms.handler;
import com.eomcs.pms0901.pms.domain.Project;
import com.eomcs.pms0901.pms.domain.Task;
import com.eomcs.pms0901.util.Prompt;

// 상속추가
public class TaskAddHandler extends AbstractTaskHandler {

  //기존
  //  ProjectHandler projectHandler;
  //
  //  public TaskAddHandler(ProjectHandler projectHandler) {
  //    this.projectHandler = projectHandler;
  //  }

  // 수정
  // AbstractTaskHandler에는 기본생성자가 없고
  // ProjectHandler를 받는 생성자만 있다
  AbstractProjectHandler projectHandler; //생략가능

  public TaskAddHandler(AbstractProjectHandler projectHandler) {
    super(projectHandler);
  }


  public void add() {
    System.out.println("[작업 등록]");

    Project project = projectHandler.promptProject();
    if (project == null) {
      System.out.println("작업 등록을 취소합니다.");
      return;
    }

    if (project.getOwner().getNo() != AuthHandler.getLoginUser().getNo()) {
      System.out.println("이 프로젝트의 관리자가 아닙니다.");
      return;
    }

    Task task = new Task();

    task.setProjet(project);
    task.setNo(Prompt.inputInt("작업번호? "));
    task.setContent(Prompt.inputString("내용? "));
    task.setDeadline(Prompt.inputDate("마감일? "));
    task.setStatus(promptStatus());
    task.setOwner(MemberHandler.promptMember("담당자?(취소: 빈 문자열) ", project.getMembers()));
    if (task.getOwner() == null) {
      System.out.println("작업 등록을 취소합니다.");
      return; 
    }

    project.getTasks().add(task);

    System.out.println("작업을 등록했습니다.");
  }

}
