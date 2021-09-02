package com.eomcs.pms0901pm2.pms.handler;

import com.eomcs.pms0901pm.pms.domain.Project;
import com.eomcs.pms0901pm.pms.domain.Task;
import com.eomcs.pms0901pm.util.Prompt;

public class TaskAddHandler extends AbstractTaskHandler {

  // 생성자에서 MemberPromprHandler 를 받을필요없다
  // 왜???? 아래
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

    if (project.getOwner().getNo() != AuthLoginHandler.getLoginUser().getNo()) {
      System.out.println("이 프로젝트의 관리자가 아닙니다.");
      return;
    }

    Task task = new Task();

    task.setProject(project);
    task.setNo(Prompt.inputInt("작업번호? "));
    task.setContent(Prompt.inputString("내용? "));
    task.setDeadline(Prompt.inputDate("마감일? "));
    task.setStatus(promptStatus());

    // 스태틱이기때문에 클래스명으로 바로 호출
    //task.setOwner(AbstractMemberHandler.promptMember("담당자?(취소: 빈 문자열) ", project.getMembers()));
    task.setOwner(MemberPromptHandler.promptMember("담당자?(취소: 빈 문자열) ", project.getMembers()));

    if (task.getOwner() == null) {
      System.out.println("작업 등록을 취소합니다.");
      return; 
    }

    project.getTasks().add(task);

    System.out.println("작업을 등록했습니다.");
  }
}





