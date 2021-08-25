// 아규먼트에 람다(lambda) 활용
package com.eomcs.oop.ex12;

public class Exam0310 {

  static interface Player {
    void play();
  }

  static void testPlayer(Player p) {
    p.play();
  }

  // 1번 기존 로컬클래스
  //  public static void main(String[] args) {
  //    // 로컬 클래스 (클래스를 따로 만들고 인스턴스를 호출해야한다)
  //    class MyPlayer implements Player {
  //      @Override
  //      public void play() {
  //        System.out.println("실행!");
  //      }
  //    }
  //
  //    testPlayer(new MyPlayer());
  //
  //  }
  //}


  // 로컬 > 익명으로 수정
  // 익명클래스는 정의할때 인스턴스를 바로 만들수있다 (인스턴스를 한개만 사용하는경우) 



  // 2번 익명 클래스
  //  public static void main(String[] args) {
  //    Player p = new Player() {
  //      @Override
  //      public void play() {
  //        System.out.println("실행!");
  //      }
  //    };
  //
  //    testPlayer(p);
  //
  //  }
  //  


  // 3번 인스턴스를 바로 생성
  //  public static void main(String[] args) {
  //    testPlayer(new Player() {
  //      @Override
  //      public void play() {
  //        System.out.println("실행!");
  //      }
  //    });
  //
  //  }


  // 4번 아규먼트 자리에 lambda 문법을 사용
  public static void main(String[] args) {
    testPlayer(() -> System.out.println("실행!"));
  }
}
