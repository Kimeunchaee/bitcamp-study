package com.eomcs.oop.ex09.a1.after;

// 클래스를 정의할때 Worker 인터페이스를 구현하겠다고 선언하지는 않았지만
// Worker 인터페이스에 존재하는 메서드(여기서는 execute())를 모두 구현했을때
// 이 클래스는 Worker 규칙을 따른다고 할 수 있는가?
// 답 : 아니오!

// Worker 규칙을 따른다,구현한다고 인터페이스명을 선언해줘야 한다
// public class HulWorker implements Worker

// Exam01의 24번째줄

public class HulWorker {
  public void execute() {
    System.out.println("헐....^^");
  }
}
