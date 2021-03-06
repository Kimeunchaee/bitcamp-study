package com.eomcs.algorithm.quiz.stu_quiz;

public class Test1_0 {

  //출처: codefights.com
  //
  //주어진 숫자에 짝수가 몇 개인지 세어라.
  //예) 
  //1010 => 2
  //123 => 1
  //
  //한 줄에 버그가 있다. 고쳐라!

  static int countEvenNumber(int value) {
    int result = 0; //몇개인지 카운트 하는 변수
    int n = value;

    while(n != 0) {  // n이 0아닐때 (= n>0 도 가능)
      if ((n % 2) == 0) { //n을 2로 나눈 나머지가 0일때 (짝수일때)    (= (n&1)==0 도 가능)
        result++;   // 참이면 계속 실행
      }
      n /= 10; // @정답 %= 를 /= 로 수정 
      // 1238694636숫자를 10단위씩 나누면 뒷자리 숫자가 날라감 > 순서대로 짝수의 갯수를 알아냄
    }
    return result; //n값이 짝수면 int result = 0;이 하나씩 증가됨

  }

  public static void main(String[] args) {
    System.out.println(countEvenNumber(1238694636));

  }
}
