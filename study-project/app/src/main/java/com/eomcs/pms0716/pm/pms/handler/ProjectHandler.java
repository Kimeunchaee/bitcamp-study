package com.eomcs.pms0716.pm.pms.handler;

import com.eomcs.pms0716.pm.pms.domain.Project;
import com.eomcs.pms0716.pm.util.Prompt;




public class ProjectHandler {

  static final int LENGTH = 100;
  static Project[] projects = new Project[100];
  static int size = 0;
  static final int MAX_LENGTH = 7;


  public static void add() {  
    Project project = new Project();

    System.out.println("[프로젝트 등록]");
    project.no = Prompt.inputInt("번호? ");
    project.title = Prompt.inputString("프로젝트명? ");
    project.content = Prompt.inputString("내용? ");
    project.startDate = Prompt.inputDate("시작일? ");
    project.endDate = Prompt.inputDate("종료일? ");
    project.owner = Prompt.inputString("만든이? ");
    project.members = Prompt.inputString("팀원? ");
    projects [size++] = project;
  }

  public static void list() { 
    System.out.println("[프로젝트 목록]");
    for (int i = 0; i < size; i++) {
      System.out.printf("%d, %s, %s, %s, %s\n",
          projects[i].no,
          projects[i].title,
          projects[i].content,
          projects[i].startDate,
          projects[i].endDate,
          projects[i].owner,
          projects[i].members
          );
    }
  }

}
