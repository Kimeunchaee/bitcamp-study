package com.eomcs.oop.ex00.p2;

public class CalculatorTest {
  public static void main(String[] args) {
    // 2 + 3 + 4 - 7 * 3 = 6
    // 3 * 2 - 1 = 5


    // r1 r2 선언을 지우고
    // r1 = Calculator.plus(r1, 2);를
    // Calculator.plus(2); 로변경
    // 출력문 System.out.println (Calculator.result) 각각 넣어주기

    // 두번째 계산식 실행 할때는 
    //  Calculator.result = 0; 초기화해주기

    // 3 으로 이동


    Calculator.plus(2);
    Calculator.plus(3);
    Calculator.plus(4);
    Calculator.minus(7);
    Calculator.multiple(3);
    System.out.println(Calculator.result);

    Calculator.result = 0;
    Calculator.plus(3);
    Calculator.multiple(2);
    Calculator.minus(1);
    System.out.println(Calculator.result);

  }


}
