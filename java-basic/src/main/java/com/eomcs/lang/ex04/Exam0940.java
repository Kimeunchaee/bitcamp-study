package com.eomcs.lang.ex04;

//# 형변환 - 명시적 형변환 : 큰 정수 변수의 값을 작은 정수 변수에 저장
//
public class Exam0940 {
  public static void main(String[] args) {

    byte b = 100;
    short s = 100;
    int i = 100;
    long l = 100;

    // 큰 메모리의 값을 작은 메모리에 저장하는 경우
    // => 작은 메모리에 들어갈 수 있는 값인 경우에 형변환을 해야 한다.

    // 1) 큰 메모리의 값이 작은 메모리에 충분히 들어가는 경우
    // short ==> byte
    byte b2 = (byte)s; // 명시적 형변환
    // byte b2 = s; 는 안됨 s변수가 100이니까 byte 값에 들어갈수있기때문에
    //  (byte) 써주면 강제로 형변환을 해줄수 있음
    System.out.println(b2);

    // int ==> byte
    b2 = (byte)i; // 명시적 형변환
    System.out.println(b2);

    // long ==> byte
    b2 = (byte)l; // 명시적 형변환
    System.out.println(b2);

    // 2) 큰 메모리의 값이 작은 메모리에 들어 갈 수 없는 경우
    // => 앞 쪽 바이트의 값이 짤려서 들어간다.
    int i2 = 0b0000_0000_0000_0000_0000_0001_0010_1100; // = 300(10진수)
    b2 = (byte) i2; // 앞쪽 0b0000_0000_0000_0000_0000_0001 가 짤리고 0010_1100가 남는다
    System.out.println(b2); // 0b0010_1100 = 44(10진수) 결과값이 달라짐

    l = 400_0000_0000L; // 0x00_00_00_09_50_2f_90_00
    i = (int)l; // 큰 메모리의 값이 작은 메모리에 들어가지 못하는 경우
    System.out.println(l); // 앞 쪽 바이트가 짤린다.
    System.out.println(i); // (l)과 (i) 결과값이 같아
    System.out.println(0x502f9000);
  }
}

// 정리!
// - 큰 값을 작은 메모리에 넣는 것은 아무런 의미가 없다.
// - 해서는 안된다.
// - 다만,
//   큰 메모리의 값을 바이트 단위로 쪼개고 싶을 때 유용하다. 
//