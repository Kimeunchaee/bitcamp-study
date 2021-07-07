package com.eomcs.pms;

public class App2_1 {

  public static void main(String[] args) {

    java.util.Scanner keyScan = new java.util.Scanner(System.in);

    System.out.println("[프로젝트]");

    //번호는 int 변수
    System.out.print("번호? ");
    int num = keyScan.nextInt();
    keyScan.nextLine(); 
    // System.out.print(keyScan.nextLine());
    // int 엔터쳤을때 생긴 공백(남은 문자열) 한 줄을 실행시켜서 버린다.

    System.out.print("프로젝트명? ");
    String project = keyScan.nextLine();
    System.out.print(project);

    System.out.print("내용? ");
    String cont = keyScan.nextLine();

    // 시작일과 종료일은 java.sql.Date 변수
    System.out.print("시작일? ");
    String startDate = keyScan.nextLine();

    System.out.print("종료일? ");
    String endDate = keyScan.nextLine();

    System.out.print("만든이? ");
    String made = keyScan.nextLine();

    System.out.print("팀원? ");
    String team = keyScan.nextLine();

    keyScan.close();

    System.out.println("-------------------");
    System.out.printf("번호? %d\n",num);
    System.out.printf("프로젝트명? %s\n",project);
    System.out.printf("내용? %s\n",cont);
    System.out.printf("시작일? %s\n",startDate);
    System.out.printf("종료일? %s\n",endDate);
    System.out.printf("만든이? %s\n",made);
    System.out.printf("팀원? %s\n",team);

  }

}
