package com.eomcs.algorithm.quiz.stu_quiz;

// 출처: codefights.com
//
// 배열의 전체 길이를 L이라고 하자.
// 배열을 절반(L/2)으로 나눌 때, 앞쪽 부분과 뒤쪽 부분의 위치를 바꿔라.
// 예)
// [2, 4, 5, 6, 4, 3, 7, 8] => [4, 3, 7, 8, 2, 4, 5, 6]
//
// 한 줄에 버그가 있다. 고쳐라!
public class Test3_0 {

  static void changeValuePosition(int[] values) {
    int tmp;
    for (int i = 0; i < values.length / 2; i++) {   // values.length >>1 ;  비트연산자로도 표현 가능 같은 의미 
      tmp = values[i];  

      //values[i] 는 앞에 4개 숫자
      //values[i + values.length / 2]는 절반, values[i]와 대응되는것 뒤에 4개 숫자

      values[i] = values[i + values.length / 2];
      values[i + values.length / 2] = tmp;
    }
  }

  public static void main(String[] args) {
    int[] values = {2, 4, 5, 6, 4, 3, 7, 8};
    changeValuePosition(values);

    for (int v : values) {
      System.out.print(v + ",");
    }
  }

}
