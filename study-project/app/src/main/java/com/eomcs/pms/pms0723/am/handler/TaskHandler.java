package com.eomcs.pms.pms0723.am.handler;

import java.sql.Date;
import com.eomcs.pms.pms0723.am.domain.Task;
import com.eomcs.pms.pms0723.am.util.Prompt;

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

    System.out.println("상태?");
    System.out.println("0: 신규");
    System.out.println("1: 진행중");
    System.out.println("2: 완료");
    task.status = Prompt.inputInt("> ");

    while (true) {
      String owner = Prompt.inputString("담당자?(취소: 빈 문자열) ");
      if (owner.length() == 0) {
        System.out.println("작업 등록을 취소합니다.");
        return; // 현재 메서드의 실행을 멈추고 리턴한다.
      } else if (memberHandler.exist(owner)) {
        task.owner = owner;
        break;
      }
      System.out.println("등록된 회원이 아닙니다.");
    }

    this.tasks[this.size++] = task;
  }

  //다른 패키지에 있는 App 클래스가 다음 메서드를 호출할 수 있도록 공개한다.
  public void list() {
    System.out.println("[작업 목록]");

    for (int i = 0; i < this.size; i++) {
      String stateLabel = null;
      switch (tasks[i].status) {
        case 1:
          stateLabel = "진행중";
          break;
        case 2:
          stateLabel = "완료";
          break;
        default:
          stateLabel = "신규";
      }

      System.out.printf("%d, %s, %s, %s, %s\n",
          this.tasks[i].no, 
          this.tasks[i].content, 
          this.tasks[i].deadline, 
          stateLabel, 
          this.tasks[i].owner);
    }
  }

  public void detail() {
    System.out.println("[작업 상세보기]");
    int no = Prompt.inputInt("번호? ");

    Task task = null;

    for (int i = 0; i < this.size; i++) { 
      if (this.tasks[i].no == no) {
        task = this.tasks[i];
        break; 
      }
    }

    if (task == null) {
      System.out.println("해당 번호의 작업이 없습니다.");
      return; 
    }

    System.out.printf("내용: %s\n", task.content);
    System.out.printf("마감일: %s\n", task.deadline);
    System.out.printf("담당자: %s\n", task.owner);

    // list 에서 가져옴
    // for문 사용 x
    // task.status 로 바꿔줌
    String stateLabel = null;
    switch (task.status) {
      case 1:
        stateLabel = "진행중";
        break;
      case 2:
        stateLabel = "완료";
        break;
      default:
        stateLabel = "신규";
    }
    System.out.printf("상태: %d\n", stateLabel);
  }



  public void update(MemberHandler memberHandler) {
    System.out.println("[작업 변경]");
    int no = Prompt.inputInt("번호? ");

    Task task = null;

    for (int i = 0; i < this.size; i++) { 
      if (this.tasks[i].no == no) {
        task = this.tasks[i];
        break; 
      }
    }

    if (task == null) {
      System.out.println("해당 번호의 작업이 없습니다.");
      return; 
    }



    String content = Prompt.inputString(String.format("내용(%s)? ", task.content));
    Date deadline = Prompt.inputDate(String.format("마감일(%s)? ", task.deadline));

    String stateLabel = null;
    switch (task.status) {
      case 1:
        stateLabel = "진행중";
        break;
      case 2:
        stateLabel = "완료";
        break;
      default:
        stateLabel = "신규";
    }

    System.out.printf("상태(%s)?\n", stateLabel); //기존상태를 출력
    System.out.println("0: 신규");
    System.out.println("1: 진행중");
    System.out.println("2: 완료");
    task.status = Prompt.inputInt("> ");

    String owner = null;
    while (true) {
      owner = Prompt.inputString(String.format("담당자(%s)? ", task.owner));
      if (owner.length() == 0) {
        System.out.println("작업 등록을 취소합니다.");
        return; // 현재 메서드의 실행을 멈추고 리턴한다.
      } else if (memberHandler.exist(owner)) {
        task.owner = owner;
        break;
      }
      System.out.println("등록된 회원이 아닙니다.");
    }

    this.tasks[this.size++] = task;
    task.content = content;
    task.deadline = deadline;
    task.owner = owner;
  }









  public void delete() {
    System.out.println("[작업 삭제]");
    int no = Prompt.inputInt("번호? ");

    int index = -1; 

    for (int i = 0; i < this.size; i++) { 
      if (this.tasks[i].no == no) {  
        index = i; 
        break;
      }
    }

    if(index == -1) { 
      System.out.println("해당 번호의 작업이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("작업 삭제를 취소하였습니다.");
      return;
    }

    for(int i = index + 1; i < this.size; i++ ) { 
      this.tasks[i - 1] = this.tasks[i];

    } this.tasks[--this.size] = null;

    System.out.println("작업을 삭제하였습니다.");
    return;
  }


}

