package com.eomcs.pms0712;
import java.sql.Date;
import java.util.Scanner;

// 06~08단계 작성해보기

// 6)  `/member/add`, `/member/list` 명령을 구분한다
// 7) `/member/add 명령 처리
// 8) `/member/list` 명령을 처리

public class App1_2 {
  public static void main(String[] args) {

    Scanner keyboardScan = new Scanner(System.in);

    // 최대 입력 개수
    final int LENGTH = 100;

    int[] no = new int[LENGTH];
    String[] name = new String[LENGTH];
    String[] email = new String[LENGTH];
    String[] password = new String[LENGTH];
    String[] photo = new String[LENGTH];
    String[] tel = new String[LENGTH];
    Date[] registeredDate = new Date[LENGTH];

    int size = 0;

    while(true) {
      System.out.print("명령 > ");
      String input = keyboardScan.nextLine();

      if(input.equals("exit") || input.equals("quit")) {
        break;
      } else if(input.equals("/member/add")) {
        System.out.println("[회원등록]");
        System.out.print("번호? ");
        no[size] = Integer.parseInt(keyboardScan.nextLine());

        System.out.print("이름? ");
        name[size] = keyboardScan.nextLine();

        System.out.print("이메일? ");
        email[size] = keyboardScan.nextLine();

        System.out.print("암호? ");
        password[size] = keyboardScan.nextLine();

        System.out.print("사진? ");
        photo[size] = keyboardScan.nextLine();

        System.out.print("전화? ");
        tel[size] = keyboardScan.nextLine();

        registeredDate[size] = new java.sql.Date(System.currentTimeMillis());

        size++;

      } else if (input.equals("/member/list")) {
        System.out.println("[회원목록]");
        for (int i = 0; i < size; i++) {
          // 번호, 이름, 이메일, 전화, 가입일
          System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
              no[i], name[i], email[i], tel[i], registeredDate[i]);
        }
      } else {
        System.out.println("실행할수없는 명령입니다.");
      }
      System.out.println();
      //System.out.println(input);     //코드 작성 순서에 따라 출력결과가 달라짐
    }
    keyboardScan.close();
  }
}
