package com.eomcs.lang.ex07;

//# 메서드 : call by reference II
//
public class Exam0330 { //Exam0330 클래스파일을 로딩해서 메소드 area에서 실행됨
  // > JVM Stack 영역에 main변수 호출
  // > main안에 swap변수가 사용된걸 보고 JVM Stack 영역 swap변수도 호출

  // main()에서 만든 int a와 int b의 값을 바꾸고 싶다면,
  // primitive data type 값을 직접 넘기지 말고 
  // 객체에 담아 넘겨라!
  static class MyObject { // MyObject 클래스파일을 로딩해서 메소드 area에서 실행됨
    // Exam0330 안에 포함되어 있을 뿐, 따로 컴파일되어 클래스파일이 생성됨
    int a; // main에서 new 명령어를 줬을때 heap에 만들어지는 변수 int a,b
    int b;
  }

  static void swap(MyObject ref) { //ref에 저장된 메모리는 모두 heap의 주소이다.
    System.out.printf("swap(): a=%d, b=%d\n", ref.a, ref.b);
    int temp = ref.a;
    ref.a = ref.b;
    ref.b = temp;
    System.out.printf("swap(): a=%d, b=%d\n", ref.a, ref.b);
  }

  public static void main(String[] args) { //Method Area 영역에 main 변수를 로드 > JVM Stack 영역에 args, ref 변수가 만들어짐

    // MyObject 설계도에 따라 int a와 int b 메모리를 만든다.
    // 그리고 그 메모리(인스턴스=객체)의 주소를 ref 변수에 저장한다.
    MyObject ref = new MyObject();
    ref.a = 100; //변수는 heap 공간에 만들어짐
    ref.b = 200;

    // a, b 변수가 들어 있는 인스턴스(객체=메모리)의 주소를 
    // swap()에 넘긴다. => 그래서 "call by reference"인 것이다.
    swap(ref);
    System.out.printf("main(): a=%d, b=%d\n", ref.a, ref.b);
  }
}
