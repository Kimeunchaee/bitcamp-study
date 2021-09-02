package com.eomcs.pms0902.pms.handler;

import java.util.List;
import com.eomcs.pms0902.pms.domain.Project;

public abstract class AbstractProjectHandler {

  protected List<Project> projectList;

  public AbstractProjectHandler(List<Project> projectList) {
    this.projectList = projectList;
  }

  // ProjectPrompt에도 복붙
  // 하위클래스에서 써야하기 때문에 여기에는 그냥 둠
  protected Project findByNo(int no) {
    for (Project project : projectList) {
      if (project.getNo() == no) {
        return project;
      }
    }
    return null;
  }

  // 따로 클래스로 분리(ProjectPrompt)
  //  public Project promptProject() {
  //    System.out.println("프로젝트:");
  //    for (Project project : projectList) {
  //      System.out.printf("  %d. %s\n", project.getNo(), project.getTitle());
  //    }
  //    while (true) {
  //      int projectNo = Prompt.inputInt("프로젝트 번호 선택? (취소: 0) ");
  //      if (projectNo == 0) {
  //        return null;
  //      }
  //      Project selectedProject = findByNo(projectNo);
  //      if (selectedProject != null) {
  //        return selectedProject;
  //      }
  //      System.out.println("프로젝트 번호가 옳지 않습니다.");
  //    }
  //  }

}





