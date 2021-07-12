package com.eomcs.pms0709;
import java.sql.Date;

public class App3_1 {

  public static void main(String[] args) {

    java.util.Scanner scan = new java.util.Scanner(System.in); 

    System.out.println("[작업]");
    System.out.print("프로젝트? ");
    String pro = scan.nextLine();

    //System.out.print("번호? ");
    //int num = scan.nextInt();
    //scan.nextLine(); 
    // 아래 명령어 방법 사용해보기
    System.out.print("번호? ");
    int num = Integer.parseInt(scan.nextLine()); //문자열을 숫자로 바꿔줌

    System.out.print("내용? ");
    String cont = scan.nextLine();

    System.out.print("완료일? ");
    Date endDate = Date.valueOf(scan.nextLine());

    // System.out.print("상태? \n0: 신규\n1. 진행중\n2. 완료\n> ");
    // String status = scan.nextLine();
    // 아래방법 사용해보기
    System.out.println("상태?");
    System.out.println("0: 신규");
    System.out.println("1: 진행중");
    System.out.println("2: 완료");
    System.out.print("> ");
    int status = Integer.valueOf(scan.nextLine());

    System.out.print("담당자? ");
    String charge = scan.nextLine();

    scan.close();

    System.out.println("------------------------------");
    System.out.printf("프로젝트: %s\n", pro);
    System.out.printf("번호: %s\n",num);
    System.out.printf("내용: %s\n",cont);
    System.out.printf("완료일: %s\n",endDate);

    //System.out.printf("상태: %s\n",status);
    switch (status) {
      case 1:
        System.out.println("상태: 진행중");
        break;
      case 2:
        System.out.println("상태: 완료");
        break;
      default:
        System.out.println("상태: 신규");
    }


    System.out.printf("담당자: %s\n",charge);
  }
}
