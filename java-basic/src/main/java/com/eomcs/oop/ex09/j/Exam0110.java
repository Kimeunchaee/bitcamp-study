// 인터페이스 : caller를 만드는 입장
package com.eomcs.oop.ex09.j;

import java.util.ArrayList;
import java.util.Iterator;

public class Exam0110 {
  public static void main(String[] args) {
    // 컬렉션 관련 클래스의 객체들을 선언할 때에는 제네릭을 사용하여 선언하는 것을 권장한다.
    // 왜냐하면 한 클래스의 한 가지 종류의 객체만 저장하기 때문이다.
    // 제네릭 : <>

    ArrayList<String> list = new ArrayList<>();
    list.add("홍길동");
    list.add("임꺽정");
    list.add("유관순");
    list.add("김구");

    // Iterator 는 인터페이스다.
    // Collection에서 제공하는 Iterator인터페이스는 Collection을 한방향으로 탐색하면서 객체에 대한 정보를 얻어낸다
    // ArrayList의 iterator() 메서드는 이 인터페이스를 구현한 클래스의 객체를 만들어 리턴한다.
    Iterator<String> iterator = list.iterator();

    // 인터페이스를 기준으로 한 개발자 입장:
    // => 인터페이스 호출 규칙에 따라 객체를 사용한다.
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}
