package com.eomcs.pp0723.pm.handler;

import java.sql.Date;
import com.eomcs.pp0723.pm.domain.Task;
import com.eomcs.pp0723.pm.util.Prompt;

public class TaskHandler {

  static final int MAX_LENGTH = 5;

  Task[] tasks = new Task[MAX_LENGTH];
  int size = 0;

  //다른 패키지에 있는 App 클래스가 다음 메서드를 호출할 수 있도록 공개한다.
  public void add(MemberHandler memberHandler) {
    System.out.println("[작업 등록]");

    Task task = new Task();

    task.no = Prompt.inputInt("번호? ");
    task.content = Prompt.inputString("내용? ");
    task.deadline = Prompt.inputDate("마감일? ");
    task.status = promptStatus(-1); // -1 사용자가 입력전인 현재는 상태가 없음

    //    System.out.println("상태?");
    //    System.out.println("0: 신규");
    //    System.out.println("1: 진행중");
    //    System.out.println("2: 완료");
    //    task.status = Prompt.inputInt("> ");
    // 지우고 task.status = getStatus(-1); 넣어줌 // -1은 유효하지 않음을 표시해줌, 사용자가 입력전인 현재는 상태가 없기때문에
    // -1를 쓰지 않으면 컴파일오류! 파라미터를 가진 메소드이기때문에 파라미터와 아규먼트가 일치해야한다

    task.owner = promptOwner(memberHandler, null);
    if(task.owner == null) {
      System.out.println("작업 등록을 취소합니다");
      return;
    }

    this.tasks[this.size++] = task;
  }

  //다른 패키지에 있는 App 클래스가 다음 메서드를 호출할 수 있도록 공개한다.
  public void list() {
    System.out.println("[작업 목록]");

    for (int i = 0; i < this.size; i++) {
      // 상태의 스위치문을 지우고 getStatusLabel() 메소드 사용
      // 출력문을 반복문안으로 넣어서 정리함
      System.out.printf("%d, %s, %s, %s, %s\n",
          this.tasks[i].no, 
          this.tasks[i].content, 
          this.tasks[i].deadline, 
          getStatusLabel(this.tasks[i].status),
          this.tasks[i].owner);
    }

  }

  public void detail() {
    System.out.println("[작업 상세보기]");
    int no = Prompt.inputInt("번호? ");

    Task task = findByNo(no);

    if (task == null) {
      System.out.println("해당 번호의 작업이 없습니다.");
      return;
    }

    System.out.printf("내용: %s\n", task.content);
    System.out.printf("마감일: %s\n", task.deadline);

    //    String stateLabel = null;
    //    switch (task.status) {
    //      case 1:
    //        stateLabel = "진행중";
    //        break;
    //      case 2:
    //        stateLabel = "완료";
    //        break;
    //      default:
    //        stateLabel = "신규";
    //    }
    // 지우고 getStatusLabel() 메소드 사용

    // 수정
    System.out.printf("상태: %s\n", getStatusLabel(task.status));

    System.out.printf("담당자: %s\n", task.owner);
  }

  public void update(MemberHandler memberHandler) {
    System.out.println("[작업 변경]");
    int no = Prompt.inputInt("번호? ");

    Task task = findByNo(no);

    if (task == null) {
      System.out.println("해당 번호의 작업이 없습니다.");
      return;
    }

    String content = Prompt.inputString(String.format("내용(%s)? ", task.content));
    Date deadline = Prompt.inputDate(String.format("마감일(%s)? ", task.deadline));


    // 1번째 수정. 기존 스위치문을 지우고 getStatusLabel 메소드를 사용해줌
    //    getStatus();
    //    System.out.printf("상태(%s)?\n", getStatusLabel(task.status));
    //    System.out.println("0: 신규");
    //    System.out.println("1: 진행중");
    //    System.out.println("2: 완료");
    //    int status = Prompt.inputInt("> ");


    // 2번째 수정. println 지우고 promptStatus(); 사용
    // (promptStatus에 getStatusLabel를 사용해서 메서드를 작성함)
    // 파라미터와 리턴값이 둘다 있는 메서드이기때문에
    // 2-1. 리턴값을 받을 변수인 메서드명 promptStatus 준비
    // 2-2. 변수에 리턴값을 선언(타입이 같아야한다) int status = 
    // 2-3. 변수의 아큐먼트를 작성해준다 (task.status)
    int status = promptStatus(task.status);


    String owner = promptOwner(memberHandler, task.owner);
    if (owner == null) {
      System.out.println("작업 변경을 취소합니다.");
      return;
    }

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("작업 삭제를 취소하였습니다.");
      return;
    }

    task.content = content;
    task.deadline = deadline;
    task.status = status;
    task.owner = owner;

    System.out.println("작업를 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[작업 삭제]");
    int no = Prompt.inputInt("번호? ");

    int index = indexOf(no);

    if (index == -1) {
      System.out.println("해당 번호의 작업이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("작업 삭제를 취소하였습니다.");
      return;
    }

    for (int i = index + 1; i < this.size; i++) {
      this.tasks[i - 1] = this.tasks[i];
    }
    this.tasks[--this.size] = null;

    System.out.println("작업를 삭제하였습니다.");
  }


  private Task findByNo(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.tasks[i].no == no) {
        return this.tasks[i];
      }
    }
    return null; //반복문이 다 돌때까지 못찾았으면 
  }


  private int indexOf(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.tasks[i].no == no) {
        return i; // 일치하는 번호를 찾았을때 i번째 배열에 있는 거를 리턴하다
      }
    }
    return -1; //찾지못하면
  }
  // add 에서 담장자를 입력받는 소스코드 가져와서 메소드로 만듦
  private String promptOwner(MemberHandler memberHandler, String ownerName) {
    while (true) {
      String owner = Prompt.inputString(String.format("담당자?(%s)?(취소: 빈 문자열) ",
          ownerName != null ? "(" + ownerName + ")" : ""));
      if (owner.length() == 0) {
        System.out.println("작업 등록을 취소합니다.");
        return owner; 
      } else if (memberHandler.exist(owner)) { 
        // memberHandler.exist(owner) 의 값이 참이면 (= 기존에 저장된 이름과 새로입력한 이름이 같으면)널값을 리턴해라
        //     x   task.owner = owner;
        //     x   break;
        return null;
      }
      System.out.println("등록된 회원이 아닙니다.");
    }
  }



  private String getStatusLabel(int status) {
    switch (status) {
      case 1: return "진행중";
      case 2: return "완료";
      default: return "신규";
    }


  }


  private int promptStatus(int status) {
    System.out.printf("상태%s\n?", status != -1 ? getStatusLabel(status) : ""); // -1이 아니라면 = 상태가 없다면
    //
    System.out.println("0: 신규");
    System.out.println("1: 진행중");
    System.out.println("2: 완료");
    return Prompt.inputInt("> ");
  }
}
