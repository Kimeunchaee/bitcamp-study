package com.eomcs.lang.ex05;

//# 논리 연산자 : &&, ||, !(not), ^(XOR; exclusive-OR)
//
public class Exam0311 {
  public static void main(String[] args) {
    // Boolean 타입이 아닌 데이터타입에서는 사용할 수 없다.
    // 정수에 대해서는 다 컴파일 오류
    // exclusive-OR(XOR)연산자는 숫자 가능


    //System.out.println(0 && 1);

    //System.out.println(0 || 1);

    //System.out.println(!0);

    System.out.println(1 ^ 0);
    // 00000000_00000000_00000000_00000010 (2)
    // 00000000_00000000_00000000_00000011 (3)
    //-----------------------------------------
    // 00000000_00000000_00000000_00000001
    // exclusive-OR 에 정수를 입력하면
    // 비트단위로 연산을 수행하고 
    // 두 개의 값이 다를 때 true = 1, 같은면 false = 0 으로 결과값이 나온다    
  }
}
