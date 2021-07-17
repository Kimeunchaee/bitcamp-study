package com.eomcs.algorithm.quiz.stu_quiz;

// 출처: codefights.com
//
// 숫자 배열이 있다.
// 나누어 0이 떨어지는 수가 몇 쌍이 있는지 구하라!


// 숫자 배열 : 정수로 이루어진  int[] values => divisorsPairs(values) => divisorsPairs(int[] sequence) {}
// int[i] sequence i배열과 int[j] sequence j배열 2개를 선언해줌
// 나누어 0이 되는 수 = 나머지가 0이 되려면 (x % y == 0)
// 
public class Test4_0 {
  public static int divisorsPairs(int[] sequence) {

    int result = 0; //나누어 0이 되는 수 결과값을 카운트해주는 변수

    for (int i = 0; i < sequence.length; i++) {
      for (int j = 1; j < sequence.length; j++) {   // @정답 j = i를 j = 1로 바꿔줌, i번째는 여러줄일때 사용 
        if (sequence[i] % sequence[j] == 0 || sequence[j] % sequence[i] == 0) {
          result++;
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    int[] values = {2, 4, 8};
    System.out.println(divisorsPairs(values));
  }
}
