package com.eomcs.pms.pms0717;

public class ProjectHandler {


  static Project[] projects = new Project[100];
  static int size = 0;

  static void add() {
    Project project = new Project();

    while(true) {
      System.out.println("[프로젝트 등록]");
      project.no = Prompt.inputInt("번호? ");
      project.title = Prompt.inputString("프로젝트명? ");
      project.content = Prompt.inputString("내용? ");
      project.startDate = Prompt.inputDate("시작일? ");
      project.endDate = Prompt.inputDate("종료일? ");
      project.owner = Prompt.inputString("만든이? ");
      project.member =  Prompt.inputString("팀원? ");
      projects[size++] = project;
      System.out.print("계속 입력하시겠습니까?(y/N) ");
      String str = Prompt.keyboardScan.nextLine();
      if (!str.equalsIgnoreCase("y")) {
        break;
      }
      System.out.println();
    }
  }

  static void list() {
    System.out.println("-------------출력------------");
    for(int i = 0; i < size; i++) {
      System.out.printf("%d %s %s %s %s %s %s\n", 
          projects[i].no, projects[i].title, projects[i].content, 
          projects[i].startDate, projects[i].startDate, 
          projects[i].owner, projects[i].member);
    }
  }








}
