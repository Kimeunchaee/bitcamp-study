package com.eomcs.pms0716;

//1. 사용자의 입력을 받는 프롬프트 메서드를 별도의 클래스로 분리한다. (Prompt 클래스 파일을 생성)
//2. 회원 데이터 처리와 관련된 메서드를 별도의 클래스로 분리한다. (MemberHandelr 클래스 파일을 생성)
//3. 프로젝트 데이터 처리와 관련된 메서드를 별도의 클래스로 분리한다 (ProjectHandelr 클래스 파일을 생성)
//4. 작업 데이터 처리와 관련된 메서드를 별도의 클래스로 분리한다 (TaskHandler 클래스 파일을 생성)
//5. 키보드 스캐너를 닫는 기능을 스캐너를 가진 클래스에서 수행시킨다. 
// --------------------------  GRASP 에서 Information Expert 설계 기법 적용
//6. 클래스문법을 사용해서 복합구조의 변수를 설계하기
// 6-1. Member 클래스 파일을 생성 (member의 낱개변수 선언)
// 6-2. MemberHandler 클래스 파일에서 add{}안에 member 인스턴스 작성해주기(Member member = new Member();)
// 6-3. no[size] 변수 선언해줬던걸 member.no 으로 수정

//7. 기존 static final int LENGTH = 100; 가 있는 상태에서
//    Member 인스턴스의 주소를 저장할 레퍼런스(final int MAX_LENGTH)를 5개 생성(=5)한다.
// 7-1. 레퍼런스 이름은 m1,m2... 이다. (static Member m1, m2, m3, m4, m5;)
// 7-2. 갯수 제한을 두지 않고 많이 만들고 싶을땐 배열으로 작성
//  레퍼런스를 100개 생성한다. (인스턴스를 100개 만드는게 아니라 인스턴스 저장될 주소인 레퍼런스가 100개 생기는것이다!!)
//  : static Member[] members = new Member[100];
//  : static int size = 0;
// 7-3. Integer.valueOf(promptInt) 를 Prompt.inputInt 으로 수정
// 7-4. promptString 을 Prompt.inputString 으로 바꿔줌 (클래스명의 변수로 이름변경)
// 7-5. no[size] 를 member.no 로 바꿔줌
// 7-6. size++ 를  members [size++] = member; 으로 바꿔줌
// 7-7. list()메소드에서  members[i].no, members[i].name, ... 선언으로 이름 바꿔줌



public class App08 {

  public static void main(String[] args) {

    while (true) {
      String input = Prompt.inputString("명령> ");

      if (input.equals("exit") || input.equals("quit")) {
        System.out.println("안녕!");
        break;
      } else if (input.equals("/member/add")) {
        MemberHandler.add();

      } else if (input.equals("/member/list")) {
        MemberHandler.list();

      }  else if (input.equals("/project/add")) {
        ProjectHandler.add();

      }  else if (input.equals("/project/list")) {
        ProjectHandler.list();

      }  else if (input.equals("/task/add")) {
        TaskHandler.add();

      }  else if (input.equals("/task/list")) {
        TaskHandler.list();

      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      System.out.println();
    }
    Prompt.close();
  }
}
