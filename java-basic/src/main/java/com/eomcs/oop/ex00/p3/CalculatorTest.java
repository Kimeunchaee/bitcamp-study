package com.eomcs.oop.ex00.p3;

public class CalculatorTest {
  public static void main(String[] args) {
    // 2 + 3 + 4 - 7 * 3 = 6
    // 3 * 2 - 1 = 5

    // Test3

    // Calculator3 클래스로 이동해서
    // result에 static을 빼주고

    // Test 에서 c1 = new 인스턴스 만들기

    // c1 인스턴스주소를 받을 파라미터 Calculator that 작성해주기

    // 다시 Test3 로 와서
    // Calculator.plus(c1, 2); / System.out.println(c1.result);
    // 형식으로 바꿔주기

    // Calculator4 클래스로 이동

    Calculator c1 = new Calculator();
    Calculator c2 = new Calculator();

    Calculator.plus(c1, 2);
    Calculator.plus(c1, 3);
    Calculator.plus(c1, 4);
    Calculator.minus(c1, 7);
    Calculator.multiple(c1, 3);
    System.out.println(c1.result);

    Calculator.plus(c2, 3);
    Calculator.multiple(c2, 2);
    Calculator.minus(c2, 1);
    System.out.println(c2.result);

  }


}
