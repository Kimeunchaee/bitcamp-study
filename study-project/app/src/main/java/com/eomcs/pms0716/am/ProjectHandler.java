package com.eomcs.pms0716.am;

public class ProjectHandler {

  //프로젝트 정보
  /*
   static final int LENGTH = 1000;
  static int[] no = new int[LENGTH];
  static String[] title = new String[LENGTH];
  static String[] content = new String[LENGTH];
  static Date[] startDate = new Date[LENGTH];
  static Date[] endDate = new Date[LENGTH];
  static String[] owner = new String[LENGTH];
  static String[] members = new String[LENGTH];
  // static int size = 0; 지워줌
   */

  // 위의 코드를 Project 클래스로 옮겨줌 (public)


  static final int LENGTH = 100;
  static Project[] projects = new Project[100];
  static int size = 0;
  static final int MAX_LENGTH = 7;


  public static void add() {   //변수명에 project 빼줌

    Project project = new Project();

    System.out.println("[프로젝트 등록]");
    project.no = Prompt.inputInt("번호? ");
    project.title = Prompt.inputString("프로젝트명? ");
    project.content = Prompt.inputString("내용? ");
    project.startDate = Prompt.inputDate("시작일? ");
    project.endDate = Prompt.inputDate("종료일? ");
    project.owner = Prompt.inputString("만든이? ");
    project.members = Prompt.inputString("팀원? ");
    //pSize++; 을 아래 코드로 바꿔줌
    projects [size++] = project;
  }

  public static void list() {  //변수명에 project 빼줌
    System.out.println("[프로젝트 목록]");
    for (int i = 0; i < size; i++) {
      System.out.printf("%d, %s, %s, %s, %s\n",
          projects[i].no,  //projects[i] 로 수정
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
