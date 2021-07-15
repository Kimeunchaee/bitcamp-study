package com.eomcs.algorithm.quiz.stu_quiz;

public class Test1_1 {

  // 주어진 숫자에 짝수가 몇 개인지 세어라.
  static int countEvenNumber(int value) {
    int result = 0;
    int n = value;

    while (n != 0) {        //n>0
      if((n % 2) == 0) {    //(n&1)==0
        result ++;
      }
      n /= 10;
    }
    return result;

  }

  public static void main(String[] args) {
    System.out.println(countEvenNumber(1238694636));

  }

}
