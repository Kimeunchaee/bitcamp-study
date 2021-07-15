package com.eomcs.algorithm.quiz.stu_quiz;

// 출처: codefights.com
//
// 숫자 배열에서 각 이웃하는 숫자간의 차가 가장 큰 것을 알아내기
// 예)
// [2, 4, 1, 0] => 3
// 
// 한 줄에 버그가 있다. 고쳐라!

public class Test2_0 {

  static int maxDiff(int[] values) {
    int answer = 1;
    for (int i = 1; i < values.length; i++) {  //int i = 1; 1부터 시작해야 두번째 숫자인 4부터 시작
      // .length 는 4 .length-1 해줘야 3
      // 0부터 시작하려면
      // for (int i = 0; i < values.length-1; i++)


      if (Math.abs(values[i] - values[i - 1]) > answer) {   // answer = 1 1보다 뺸간격차이가 크면 참
        //Math.abs : 절댓값으로 바꿔줌 (음수>양수)
        answer = Math.abs(values[i] - values[i-1]);
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    System.out.println(maxDiff(new int[]{2, 4, 1, 0}));   // 배열이 들어간게아니라 arr배열의 주소가 넣어진것임!
    // int[] arr = new int[]{2,4,1,0};
    // int result = mavDiff(arr)
    // System.out.prontln(result);
    // 이걸 한줄로 표현

  }

}
