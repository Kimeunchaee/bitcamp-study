package com.eomcs.pms0902.pms.handler;

import java.util.List;
import com.eomcs.pms0902.pms.domain.Project;
public class ProjectListHandler extends AbstractProjectHandler implements Command {

  public ProjectListHandler(List<Project> projectList) {
    super(projectList);
  }

  //  public void list() {
  @Override
  public void execute () {
    System.out.println("[프로젝트 목록]");

    for (Project project : projectList) {
      System.out.printf("%d, %s, %s ~ %s, %s, [%s]\n",
          project.getNo(), 
          project.getTitle(), 
          project.getStartDate(), 
          project.getEndDate(), 
          project.getOwner().getName(),
          project.getMemberNames());
    }
  }
}





