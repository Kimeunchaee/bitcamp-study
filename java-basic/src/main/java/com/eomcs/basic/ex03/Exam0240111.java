// 목록 조회: java.util.Collection의 forEach() 사용법
package com.eomcs.basic.ex03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;


public class Exam0240111 {

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
    list.add(m1);
    list.add(m2);
    list.add(m3);

    Iterator<Member> iterator = list.iterator();
    while (iterator.hasNext()) {
      Member m = iterator.next();
      System.out.printf("%s(%d)\n", m.name, m.age);
    }

    // //1.로컬클래스
    //    class F implements Consumer<Member> {
    //      @Override
    //      public void accept(Member m) {
    //        System.out.printf("이름: %s, 나이: %d\n", m.name, m.age);
    //      }
    //    }
    //    list.forEach(null);


    // //2.익명 클래스
    //    Consumer<Member> m = new Consumer<Member>() {
    //      @Override
    //      public void accept(Member m) {
    //        System.out.printf("이름: %s, 나이: %d\n", m.name, m.age);
    //      }
    //    };
    //    list.forEach(m);


    // //3.익명 클래스 - 인스턴스 바로 생성
    //    list.forEach(new Consumer<Member>() {
    //      @Override
    //      public void accept(Member m) {
    //        System.out.printf("이름: %s, 나이: %d\n", m.name, m.age);
    //      }
    //    });


    // //4.익명 클래스 - 인스턴스 바로 생성
    //    list.forEach(new Consumer<Member>() {
    //      @Override
    //      public void accept(Member m) {
    //        System.out.printf("이름: %s, 나이: %d\n", m.name, m.age);
    //      }
    //    });


    // //5.람다(클래스)
    // //1단계
    //list.forEach((Member m) -> {
    // System.out.printf("이름: %s, 나이: %d\n", m.name, m.age);
    //});
    // //2단계
    //list.forEach(m -> System.out.printf("이름: %s, 나이: %d\n", m.name, m.age));
    // -> 메인 끝



    // //6. forEach의 출력문을 별도의 메서드로 선언 - main() 밖에서
    //  static void printInfo(Member m) {
    //    System.out.printf("%s(%d)\n", m.name, m.age);
    //  }

    // 다시 main()안에서 우리가 만든 메서드를 호출해서 사용
    // //7. 람다(메서드)
    list.forEach(Exam0240111::printInfo);


    class MyConsumer implements Consumer<Member> {
      @Override
      public void accept(Member m) {
        // forEach() 에서 반복문을 돌릴 때
        // Consumer 규칙에 따라 
        // 각 항목에 대해 이 메서드를 호출한다.
        System.out.printf("이름: %s, 나이: %d\n", m.name, m.age);
      }
    }


    //list.forEach(new MyConsumer());


  }
  static void printInfo(Member m) {
    System.out.printf("%s(%d)\n", m.name, m.age);
  }

}





