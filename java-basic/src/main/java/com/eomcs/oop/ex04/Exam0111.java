2// 생성자 활용 예 - 자바에서 제공하는 클래스 사용을 통해 생성자 활용을 익혀보자!
package com.eomcs.oop.ex04;

public class Exam0111 {

  public static void main(String[] args) throws Exception {
    // 생성자를 호출하여 문자열 인스턴스를 초기화시킨다.
    // *인스턴스(변수)를 생성 후 사용할수 있도록 의미있는 값(유효한값)을 넣어 초기화시켜준다

    // => 문자열 리터럴을 사용하여 String 인스턴스를 초기화시키기.
    // *String(스트링리터럴) 생성자를 호출하여 인스턴스 초기화
    // * : 스트링은 기본타입이 아닌 스트링클래스이다
    // *스트링클래스는 자바에서 만들어놓은 값으로 초기화가 자동으로 이루어진다
    // *따라서 자동으로 생성자가 호출되긴 한다. 하지만 우리가 원하는 값을 넣어 초기화(세팅)시켜준다
    String s1 = new String("Hello");

    // *String(char[]) 생성자를 호출하여 인스턴스 초기화
    // => char[] 을 사용하여 String 인스턴스 초기화시키기.
    // *인스턴스에 메소드가 있는것이 아님 (메서드는 스택영역에)
    // *인스턴스 변수를 힙에 생성하는 것임
    char[] chars = new char[] {'H', 'e', 'l', 'l', 'o'};
    String s2 = new String(chars);

    // => 바이트 배열을 가지고 String 인스턴스 초기화시키기
    byte[] bytes = {
        (byte)0x48, // H 
        (byte)0x65, // e
        (byte)0x6c, // l
        (byte)0x6c, // l
        (byte)0x6f  // o 
    };
    String s3 = new String(bytes);

    System.out.printf("%s, %s, %s\n", s1, s2, s3);
  }
}

// 생성자의 활용
// => 인스턴스 변수를 초기화시키기 위해 여러 개의 생성자를 만들어 제공할 수 있다.
// => 자신에게 맞는 적절한 생성자를 호출하여 인스턴스를 초기화시킨 후 사용하면 된다. 















