// 아규먼트에 람다(lambda) 활용 II - 파라미터와 리턴 값이 있는 람다 만들기
package com.eomcs.oop.ex12;

public class Exam0320 {

  static interface Calculator {
    int compute(int a, int b);
  }

  static void test(Calculator c) {
    System.out.println(c.compute(100, 200));
  }


  public static void main(String[] args) {
    //람다
    //파라미터와 리턴 값이 있는 메서드 구현하기
    //test((a, b) -> a + b);
  }
}





//연습
// 1번 로컬클래스
//  public static void main(String[] args) {
//    class MyCalculator implements Calculator{
//      @Override
//      public int compute(int a, int b) {
//        return a + b;
//      }
//    }
//
//    MyCalculator obj = new MyCalculator();
//
//    test(obj);
//  }



// 2번 인스턴스 객체 바로 넘겨주기 (obj생략)
//  public static void main(String[] args) {
//    class MyCalculator implements Calculator{
//      @Override
//      public int compute(int a, int b) {
//        return a + b;
//      }
//    }
//    test(new MyCalculator());
//  }




// 3번 익명클래스 (레퍼런스 obj다시만들기 )
//  public static void main(String[] args) {
//    Calculator obj = new Calculator() {
//      @Override
//      public int compute(int a, int b) {
//        return a + b;
//      }
//    };
//    test(obj);
//  }


// 4번 test()메서드안에서 인스턴스 바로 생성
//  public static void main(String[] args) {
//    test(new Calculator() {
//      @Override
//      public int compute(int a, int b) {
//        return a + b;
//      }
//    });
//  }


// 5번 람다문법 적용
//  public static void main(String[] args) {
//    test ((int a, int b) -> {return a + b;});
//  }



// 6번 람다문법 간략하게
// 데이터 타입 생략가능, 리턴도 생략해줘야함
//  public static void main(String[] args) {
//    //test ((int a, int b) -> return a + b);
//    test((a, b) -> a + b);
//  }
