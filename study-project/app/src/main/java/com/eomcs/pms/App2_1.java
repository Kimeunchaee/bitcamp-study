package com.eomcs.pms;

import java.sql.Date; //데이트가 어느 패키지에 있는지 미리 알려줌
import java.util.Scanner; //스캐너가 어느 패키지에 있는지 미리 알려줌

public class App2_1 {
  public static void main(String[] args) {

    Scanner keyScan = new Scanner(System.in);
    // java.util.Scanner 를 import 해줬기때문에 패키지명 안써줘도됨
    System.out.println("[프로젝트]");

    // int 변수
    // 숫자만 입력 가능, 다른 형태 입력하면 오류!
    System.out.print("번호? ");
    int num = keyScan.nextInt();
    keyScan.nextLine(); // System.out.print(keyScan.nextLine());
    // int 엔터쳤을때 생긴 공백(남은 문자열) 한 줄을 실행시켜서 버린다.

    System.out.print("프로젝트명? ");
    String project = keyScan.nextLine();

    System.out.print("내용? ");
    String cont = keyScan.nextLine();

    System.out.print("시작일? ");
    // java.sql.Date 변수 : 2021-07-07 형태의 입력만 가능, 다른 형태입력하면 오류!
    // import 해줬기때문에 패키지명 작성x
    // Date 메소드 변수명 = 변수명.valueOf(실행문);
    // java.sql.Date.valueOf(날짜문자열)
    Date startDate = Date.valueOf(keyScan.nextLine());

    System.out.print("종료일? ");
    Date endDate = Date.valueOf(keyScan.nextLine());

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