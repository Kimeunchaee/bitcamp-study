// 목록 조회: java.util.Collection의 forEach() 사용법
package com.eomcs.basic.ex03;

import java.util.ArrayList;
import java.util.function.Consumer;



public class Exam0240 {




  // 바깥으로 빼주고 static 붙힘
  // opp참고
  // 1. 현재 로컬클래스(Member)에서 선언이랑 생성자는 알아서 만들어주니까 지우고 오버라이드만 남김
  // 2. 익명클래스로 바꿔줌
  // 3. 메서드가 2개기때문에 람다까지는 못봐꿔줌
  static class Member {
    String name;
    int age;

    public Member(String name, int age) {
      this.name = name;
      this.age = age;
    }

    @Override
    public String toString() {
      return "Member [name=" + name + ", age=" + age + "]";
    }

    //      @Override
    //      mublic int hashCode() {
    //        final int mrime = 31;
    //        int result = 1;
    //        result = mrime * result + age;
    //        result = mrime * result + ((name == null) ? 0 : name.hashCode());
    //        return result;
    //      }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Member other = (Member) obj;
      if (age != other.age)
        return false;
      if (name == null) {
        if (other.name != null)
          return false;
      } else if (!name.equals(other.name))
        return false;
      return true;
    }
  }






  public static void main(String[] args) {
    Member m1 = new Member("홍길동", 20);
    Member m2 = new Member("임꺽정", 30);
    Member m3 = new Member("유관순", 17);



    ArrayList<Member> list = new ArrayList<>();
    list.add(m1);       // collection의 구현체인 list (add는 컬렉션의 메서드이지만 list가 구현했으므로 사용가능)
    list.add(m2);
    list.add(m3);


    //1.-----------------------------------------------------
    // 기존 배열                
    //  Object[] obj = list.toArray();
    //  for(int i = 0; i < list.size(); i++) {
    //    Member m = list.get(i);           //get() 객체를 꺼낸다
    //    System.out.printf("%s(%d)\n", m.name, m.age);
    //  }



    //2.-----------------------------------------------------
    // 향상된 for문 , 형변환                       
    //  Object[] arr = list.toArray();
    //  for(Object item : arr) {
    //    Member m = (Member)item;
    //    System.out.printf("%s(%d)\n", m.name, m.age);
    //  }



    //3.-----------------------------------------------------
    //형변환이 싫으면 멤버로 바로 객체를 만들어라 (또는 제네릭사용)   
    //  Member[] arr2 = new Member[list.size()];
    //  list.toArray();
    //
    //  for(Member m : arr2) {
    //    System.out.printf("%s(%d)\n", m.name, m.age);
    //  }



    //4.-----------------------------------------------------
    //배열객체를 바로 리턴하도록하고 형변환 필요없음
    //  Member[] arr3 = list.toArray(new Member[list.size()]);
    //
    //  for(Member m : arr3) {
    //    System.out.printf("%s(%d)\n", m.name, m.age);
    //  }

    //5.-----------------------------------------------------
    // list.size 사용하기 싫어서
    //  Member[] arr4 = list.toArray(new Member[0]);
    // 빈배열이 만들어지고 가비지가 생김, 하지만 메모리가 좀 낭비되어도 어때~~ 걍 사용함
    //  for(Member m : arr4) {
    //    System.out.printf("%s(%d)\n", m.name, m.age);
    //  }


    //-----------------------------------------------------
    // <Iterable>
    // Araay 는 컬렉션의 서브타입, 리스트 서브타입, 이터러블 객체, 컬렉션객체, 리스트 객체,..... 등등 이다. 

    // <향상된 for문 - 문법>
    // for(변수선언(데이터타입 레퍼런스) : 배열 or Iterable) {  } ;



    //6.-----------------------------------------------------
    // 배열대신 Iterable 이 올수도 있음   
    // 목록에서값을꺼내주는자 = iterator

    //    Iterator<Member> iterator = list.iterator();
    //    while (iterator.hasNext()) {
    //      Member m = iterator.next();
    //      System.out.printf("%s(%d)\n", m.name, m.age);
    //    }

    // 옛날에는 iterator 를 꺼내서 직접 코드를 작성해서 사용했는데 번거롭다
    // 향상된 for문을 사용하는게 간단하다

    //7.-----------------------------------------------------
    // forEach() = 각각에 대하여 작업을 수행하라
    //    list.forEach(new Consumer<Member>() {
    //      @Override
    //      public void accept(Member m) {
    //        System.out.printf("%s(%d)\n", m.name, m.age);
    //      }
    //    });


    //8.-----------------------------------------------------
    // forEach() 람다 문법 사용
    //    list.forEach(m -> System.out.printf("%s(%d)\n", m.name, m.age));

    //9.-----------------------------------------------------
    list.forEach(Exam0240::printUserInfo);// Import 삭제!




    //-----------------------------------------------------
    // forEach() 메서드에게 넘길 객체
    // => Consumer 규칙에 따라 만들어야 한다.
    // => List 보관된 객체를 반복문을 통해 꺼낼 때 마다 
    //    Consumer 규칙에 따라 accept()를 호출할 것이다.
    // 
    class MyConsumer implements Consumer<Member> {
      @Override
      public void accept(Member m) {
        // forEach() 에서 반복문을 돌릴 때
        // Consumer 규칙에 따라 
        // 각 항목에 대해 이 메서드를 호출한다.
        System.out.printf("이름: %s, 나이: %d\n", m.name, m.age);
      }
    }




    // 의미:
    // => 야 List! 
    //    너가 갖고 있는 목록에서 값을 한 개 꺼낼 때 마다 
    //    지금 내가 파라미터로 넘겨주는 객체 있지?
    //    MyConsumer 객체 말이야.
    //    이 객체의 accept()를 호출해주렴.

    //list.forEach(new MyConsumer());



  }


  //메인밖에 선언
  // Member 클래스를 바깥으로 빼고 메서드 만들기
  static void printUserInfo(Member m) {
    System.out.printf("%s(%d)\n", m.name, m.age);
  }

}






