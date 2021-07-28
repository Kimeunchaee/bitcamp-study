// 생성자 활용 예 - 자바에서 제공하는 클래스 사용을 통해 생성자 활용을 익혀보자!
package com.eomcs.oop.ex04;

import java.nio.charset.Charset;
import com.eomcs.oop.ex03.Exam0230.Calculator;

public class Exam0112 {

  public static void main(String[] args) throws Exception {
    System.out.println(Charset.defaultCharset());

    // 한글 문자 코드의 바이트 배열을 가지고 String 인스턴스 초기화시키기.
    // *바이트 배열은 utf-8 문자코드와 다르다
    // *jvm이 외부로 입출력하고 문자를 다룰때 기본으로 사용하는 문자표는 utf-8 문자표이다
    // *jvm이 내부에서 입출력하고 문자를 다룰때 기본으로 사용하는 문자표는 utf-16 문자표이다

    byte[] bytes = {
        (byte)0xb0, (byte)0xa1, // 가
        (byte)0xb0, (byte)0xa2, // 각
        (byte)0xb6, (byte)0xca, // 똘
        (byte)0xb6, (byte)0xcb  // 똥
    };
    String s1 = new String(bytes); // *바이트 타입인 스트링 생성자를 만듦
    System.out.println(s1);
    // 결과: 
    // => 한글 출력이 깨진다.
    //
    // 이유?
    // => String 클래스는 파라미터로 넘겨 받은 바이트 배열을 가지고
    //    유니코드(UCS2) 문자열로 변환할 때
    //    바이트 배열이 OS의 기본 문자 코드로 되어 있다고 간주한다.
    // => OS 마다 기본으로 사용하는 문자 코드표(Character Set)가 다르다.
    //    Windows : MS949
    //    Unix/Linux/macOS : UTF-8
    // => 그런데 위 예제의 바이트 배열은 EUC-KR 코드이다.
    //    그래서 String 클래스는 바이트 배열을 제대로 해석하지 못한 것이다.
    //
    // 해결책?
    // => String 클래스의 생성자를 호출할 때
    //    바이트 배열과 인코딩 정보를 함께 받는 생성자를 사용하라!
    // => 즉 bytes 배열에 EUC-KR의 코드 값이 들어 있다고 알려준다.
    //    그러면 JVM은 바이트 배열에 들어 있는 값을 제대로 유니코드 바꿀 것이다.
    // 
    String s2 = new String(bytes, "EUC-KR"); // *바이트 타입이고 EUC-KR코드를 사용한다고 알려주고 스트링 생성자를 만듦
    System.out.println(s2);


    //------------------------------------------------------------------------------------

    // *인스턴스를 만들지 않고 바로 클래스이름으로 메서드를 호출하는 경우도 있지만
    int a = Integer.parseInt("123"); //상수

    // *인스턴스를 만들어야지만 메서드를 사용할수있는 경우도 잇고 (생성자를 필수적으로 만들어야한다)
    // *date의 생성자는 6가지경우가 있다
    // *참고 : deprecated 디프리케이티드 비난받는 유지보수가 중단되어 사용이 권장되지 않음
    // *1.아무것도 없는 경우 , 2.deprecated 년월일 세팅, 3.deprecated 년월일시분 세팅,
    // *4.년월일시분초 세팅, 5.롱값 세팅 (1970년 1월 1일 0시부터 경과된시간~ 표준시간을 알려줌)
    // *6.deprecated 스트링값으로 세팅
    // date의 경우 1번,5번을 사용해야한다
    java.util.Date d = new java.util.Date(); // 데이트 클래스는 생성자 필수
    java.sql.Date d2 = new java.sql.Dae();


    Calculator c1 = new Calculator();
    // 위에 코드처럼 new로 인스턴스를 만든 다음에 생성자를 호출하고 그 인스턴스에 들어있는 데이터를 가지고
    // 값을 계산하는 경우가 더 많다
  }
















