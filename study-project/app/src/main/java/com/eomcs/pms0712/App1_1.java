package com.eomcs.pms0712;
import java.util.Scanner;

// 01~05단계 작성해보기

// 1) 변경 준비(이미 입력된 내용 주석처리)
// 2) 사용자에게 "명령" 출력
// 3) 사용자의 명령을 입력 받아 출력 (스캐너 필요,임포트해주기,입력할수있는창 만들어주기)
// 4) 명령을 입력 받아 출력하는 것을 무한 반복
// 5) exit나 quit 명령을 입력하면 반복 실행 중지


public class App1_1 {
  public static void main(String[] args) {

    Scanner keyboardScan = new Scanner(System.in);

    while(true) {
      System.out.print("명령 > ");
      String input = keyboardScan.nextLine();
      if(input.equals("exit") || input.equals("quit")) {
        break;
      }
      System.out.println(input);     //코드 작성 순서에 따라 출력결과가 달라짐

    }
    keyboardScan.close();
  }
}
