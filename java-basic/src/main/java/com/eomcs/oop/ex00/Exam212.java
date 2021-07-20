package com.eomcs.oop.ex00;


// result 재정의

public class Exam212 {

  static class Calculate {

    static int result = 0;         // 3. result는 main()메소드에서도 사용해주기 위해 static을 붙혀준다

    void plus(int value) {           //5. int a, int b  > int value 변수를 하나로 바꿔줌
      result += value;              //6. return a + b; > result += value; 로 변경(변수명에 맞게)
    }                               //7. 타입을 void로 변경해준다

    void minus(int value) {      
      result -= value;
    }

    void multiple(int value) {
      result *= value;
    }

    void divide(int value) {
      result /= value;
    }
  }




  public static void main(String[] args) {
    // 2 + 3 - 1 * 7 / 3 = ?

    // result = plus(2, 3);  >   Calculate.plus(2, 3);
    // result 는 Calculate에서 정의하므로 main에서 관리해줄 필요는 없다.
    // 4.따라서 result 변수명을 사용하지 않고 메소드를 호출하기 위해 Calculate를 붙혀준다

    Calculate.plus(2, 3);                
    Calculate.minus(result, 1);
    Calculate.multiple(result, 7);
    Calculate.divide(result, 3);

    System.out.printf("result = %d\n", Calculate.result);
  }




}

