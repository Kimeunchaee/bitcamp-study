package com.eomcs.pms0901pm2.pms.handler;

import java.util.List;
import com.eomcs.pms0901pm.pms.domain.Project;

public class ProjectListHandler extends AbstractProjectHandler {

  public ProjectListHandler(List<Project> projectList) {
    super(projectList);
  }

  public void list() {
    System.out.println("[프로젝트 목록]");

    for (Project project : projectList) {
      System.out.printf("%d, %s, %s ~ %s, %s, [%s]\n",
          project.getNo(), 
          project.getTitle(), 
          project.getStartDate(), 
          project.getEndDate(), 
          project.getOwner().getName(),
          // project 도메인에 getMemberNames() 메서드 사용
          project.getMemberNames(project.getMembers()));
    }
  }
}





