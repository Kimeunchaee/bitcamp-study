package com.eomcs.pms0901pm2.pms.handler;

import java.util.List;
import com.eomcs.pms0901pm.pms.domain.Project;
import com.eomcs.pms0901pm.util.Prompt;

public class ProjectDeleteHandler extends AbstractProjectHandler {

  public ProjectDeleteHandler(List<Project> projectList) {
    super(projectList);
  }

  public void delete() {
    System.out.println("[프로젝트 삭제]");
    int no = Prompt.inputInt("번호? ");

    Project project = findByNo(no);

    if (project == null) {
      System.out.println("해당 번호의 프로젝트가 없습니다.");
      return;
    }

    if (project.getOwner().getNo() != AuthLoginHandler.getLoginUser().getNo()) {
      System.out.println("삭제 권한이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("프로젝트 삭제를 취소하였습니다.");
      return;
    }

    projectList.remove(project);

    System.out.println("프로젝트를 삭제하였습니다.");
  }
}




