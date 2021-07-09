package com.eomcs.lang.ex05;

//# 증감 연산자 : 후위(post-fix) 감소 연산자
//
public class Exam0620 {
  public static void main(String[] args) {
    int i = 7;

    i--;
    // 현재 위치에 i 메모리에 들어 있는 값을 꺼내 놓는다. 
    // i 메모리의 값을 1 감소시킨다.
    // i--; 의 컴파일 과정
    // int temp = i;
    // i = i - 1;



    i--;
    // i--; 의 컴파일 과정
    // int temp = i;
    // i = i - 1;



    System.out.println(i); // 5

    System.out.println(i--);
    // 위 문장을 컴파일하면 다른과 같은 과정을 거치낟.
    // int temp = i;
    // i = i - 1;
    // System.out.println(temp); //5출력됨

    System.out.println(i);
    // 

  }
}
