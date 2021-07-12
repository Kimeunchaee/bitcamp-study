package com.eomcs.lang.ex06;

//# 흐름 제어문 - break와 continue 활용
//
public class Exam0320 {
  public static void main(String[] args) {
    int count = 0;
    int sum = 0;

    // 1부터 100까지의 합은?
    while (count < 100) {
      //count++; // 카운트 1개 증가한 상태로 시작
      //sum += count; // 이 두줄을 아래 한줄로 작성
      sum += ++count; // 첫 시작이 0부터 이기 때문에 ++로 해야 1부터 시작하게됨
    }
    System.out.printf("count=%d, sum=%d\n", count, sum);
  }
}
