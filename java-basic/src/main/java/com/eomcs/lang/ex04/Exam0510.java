package com.eomcs.lang.ex04;

//# 배열 - 배열을 선언하는 방법 
// 배열? : 같은 종류의 메모리를 쉽게 만드는 방법
//
// - 문법
//        메모리종류[] 메모리이름 = new 메모리종류[개수]
//        데이터타입[] 변수명 = new 데이터타입[개수];
//        ex) int 자료형의 배열은 int[] 로 표현
//            String 타입의 배열은 String[]로 표현
//        
//        - 즉 배열이란 자료형의 종류가 아닌 자료형의 집합을 의미한다!
//        ex) int[] arr = new int[5];
//
// - C언어 스타일 
//        데이터타입 변수명[] = new 데이터타입[개수];
//        ex) int arr[] = new int[5];
//
// 배열의 개수는 int 타입의 최대 값과 같다.
// 즉 2147483647 개 이다. 
//
public class Exam0510 {
  public static void main(String[] args) {
    // 배열 사용 전
    int i1, i2, i3, i4, i5;

    // 배열 선언
    // 배열의 길이를 설정하여 변수를 먼저 새앙하고 값을 나중에 대입하는 방식
    // 반드시 길이값이 필요하며, 길이값이 없으면 오류가 발생한다
    int[] arr1 = new int[5]; // OK!
    int arr2[] = new int[5]; // OK! C-style.

    // 배열의 크기는 int 타입의 최대 값에서 2를 뺀 값이다.
    // 배열의 최대 크기 = Integer.MAX_VALUE - 2

    //int[] arr3 = new int[2147483647]; // 실행 오류 => VM의 배열 크기 제한을 초과
    // Exception in thread "main" java.lang.OutOfMemoryError: Requested array size exceeds VM limit

    int[] arr3 = new int[2147483645]; // OK!
    //int[] arr3 = new int[Integer.MAX_VALUE - 2]; // OK!

    // 실행 오류 발생!
    // => Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    // => JVM이 OS로부터 사용 허가를 받은 메모리 크기를 벗어났기 때문에 발생한 것이다.

    // 해결책?
    // => JVM을 실행할 때 최대 힙(heap) 메모리의 크기를 늘리면 된다.
    // => JVM 실행 옵션에 다음을 추가하라!
    //        -Xmx메모리크기
    //    예) $ java -Xmx20000m ...
  }
}


