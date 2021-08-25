// 메서드 레퍼런스 - 생성자 레퍼런스
package com.eomcs.oop.ex12;

public class Exam0730 {

  static class Message {
    String name;

    public Message() {
      this.name = "이름없음";
    }

    public Message(String name) {
      this.name = name;
    }

    public void print() {
      System.out.printf("%s님 반갑습니다!\n", name);
    }
  }

  static interface Factory1 {
    Message get();
  }

  static interface Factory2 {
    Message get(String name);
  }

  public static void main(String[] args) {
    // 생성자 레퍼런스를 지정할 때,
    // 인터페이스 메서드의 파라미터에 따라 호출할 생성자가 결정된다.

    Factory1 f1 = Message::new; // Message() 생성자를 가리킨다.
    //Factory1 f1 = () -> new Message();

    Factory2 f2 = Message::new; // Message(String) 생성자를 가리킨다.
    //Factory2 f2 = (name) -> new Message();

    // 인터페이스 인지 확인
    // 메서드 한개인지 확인
    // 어? 그럼 람다문법으로 해야겠다~
    // Factory2 f2 선언 
    // 뒤에 = 데이터타입(=클래스명) 메서드(파라미터) 적어주는데
    // 어? 데이터타이랑 메서드 이름 필요없으니까 빼줘야겠다~~~
    // 파라미터만 남기고 (이름 마음대로 바꿔도됨)
    // (name) -> {}; 이렇게 틀 만들어 놓기
    // {} 안에 리턴값써주기
    // return new 클래스명
    // 괄호, 중괄호랑 리턴 생략가능하니까 뺴줘야겠다
    // Factory2 f2 = name -> new Message();
    // Factory2 f2 = Message::new; 이렇게 수정



    Message msg = f1.get(); // ==> new Message()
    msg.print();

    msg = f2.get("홍길동"); // ==> new Message("홍길동")
    msg.print();

  }
}


