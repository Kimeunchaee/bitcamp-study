package com.eomcs.lang.ex07;

// # 메서드 : main() 메서드 - 프로그램 아규먼트 응용 II
//
public class Exam0540 {

  public static void main(String[] args) {
    // 학생의 이름과 국영수 점수를 입력 받아 총점과 평균을 출력하라
    // $ java -cp ./bin/main com.eomcs.lang.ex07.Exam0540 홍길동 100 100 90
    // 이름: 홍길동
    // 총점: 290
    // 평균: 96.9
    //

    if (args.length < 4) {
      System.out.println(
          "실행 형식: java -cp ./bin/main com.eomcs.lang.ex07.Exam0540 이름 국어점수 영어점수 수학점수");
      return; //void일때 return은 메소드 종료를 의미함
    }

    int sum = 0;
    for (int i = 1; i < args.length; i++)  // 0번은 이름이니까 1번 점수부터 지정하기 위해 1 < 4 로 선언
      sum += Integer.parseInt(args[i]);

    System.out.printf("이름: %s\n", args[0]);
    System.out.printf("총점: %d\n", sum);
    System.out.printf("평균: %.1f\n", sum / 3f); //부동소수점

    // java -cp ./bin/main com.eomcs.lang.ex07.Exam0540 홍길동 100 100 90 를 cmd창에 입력하면 결과값 확인가능
  }
}

