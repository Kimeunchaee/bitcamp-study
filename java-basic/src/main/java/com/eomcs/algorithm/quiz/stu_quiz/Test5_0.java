package com.eomcs.algorithm.quiz.stu_quiz;

// 출처: codefights.com
//
// 한번에 한 자리의 숫자만 바꿀 때 이전 값과 다르게 만들 수 있는 경우는 몇가지인가?
// 단 맨 앞의 숫자는 0이 될 수 없다.
// 예)
// 10 => 17
//


// 1의 자릿수가 0이면 : 0보다 큰수 1~9까지 9개 바꿀수있음
// 10의 자릿수가 1이면 : 1보다 큰수 2~9까지가 8개 바꿀수있음
// (9 - 각 자릿수) 가 각 자리의 숫자를 바꿀수있는 갯수를 구하는 공식

public class Test5_0 {

  static int countWaysToChangeDigit(int value) {
    int answer = 0;  
    while (value > 0) {       // value > 0 가장 큰 수 까지 실행시킴
      answer += 9 - value % 10;  //*이 아니라 +으로 수정 // 9-입력값의 자릿수
      value /= 10;
    }

    // value % 10 : 자기자신의 자릿수
    // value /= 10; //입력값을 10으로 나눠서 자릿수 올려줌
    return answer;
  }



  public static void main(String[] args) {
    System.out.println(countWaysToChangeDigit(81));

  }

}
