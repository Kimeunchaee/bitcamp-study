package com.eomcs.pms0716.am;

//1. 사용자의 입력을 받는 프롬프트 메서드를 별도의 클래스로 분리한다. (Prompt 클래스 파일을 생성)
//2. 회원 데이터 처리와 관련된 메서드를 별도의 클래스로 분리한다. (MemberHandelr 클래스 파일을 생성)
//3. 프로젝트 데이터 처리와 관련된 메서드를 별도의 클래스로 분리한다 (ProjectHandelr 클래스 파일을 생성)
//4. 작업 데이터 처리와 관련된 메서드를 별도의 클래스로 분리한다 (TaskHandler 클래스 파일을 생성)
//5. 키보드 스캐너를 닫는 기능을 스캐너를 가진 클래스(Prompt)에서 수행시킨다. 
// --------------------------  GRASP 에서 Information Expert 설계 기법 적용


//6. 클래스문법을 사용해서 복합구조의 변수를 설계하기

/*
  int no
  String name
  String email
  String password
  String photo
  String tel
  Date registeredDate
  이렇게 낱개의 변수로 여러사람의 정보를 다루고 있다
  이 회원정보들을 관리하기 쉽도록 한묶음으로 묶어주는 방법!
 */
// 6-1. MemberHandler 파일에서 작업
// 6-2. Member 클래스 파일을 생성 > class Member{ 낱개의 변수들 } 로 정의

// 6-3. MemberHandler 클래스 파일에서 add{}안에 member인스턴스 만들어주기
//  > new Member(); : Member라는 클래스명을 찾아서 new! 그 클래스 설계도에 따라 heap 영역에 변수를 만들어라(변수 주소를 가지고옴)
//  > member 인스턴스 : Member member = new Member();
//    1 Member : 클래스명(변수의 데이터타입)
//    2 member : Member인스턴스의 주소를 저장하는 변수이름(Member의 레퍼런스)
//    3 new : 그 클래스 설계도에 따라 heap 영역에 변수를 만들라는 명령
//    4 Member() : 클래스명
//    member의 낱개 변수들 = 인스턴스
//
// 6-4. no[size] 변수 선언해줬던걸 member.no 으로 수정
//



public class App06 {

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

    // Prompt 클래스에서 .close 를 수행하도록 함
    // prompt가 가진 자원이기때문에 그 클래스에서 시행되게 한다.
    Prompt.close();
  }
}
