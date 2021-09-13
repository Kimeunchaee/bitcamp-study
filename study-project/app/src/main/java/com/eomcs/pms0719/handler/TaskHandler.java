package com.eomcs.pms0719.handler;

import java.sql.Date;
import com.eomcs.pms0722.domain.Task;
import com.eomcs.pms0722.util.Prompt;

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
      System.out.printf("상태: %d\n", stateLabel);
    }
  }



  public void update() {
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

    String label = String.format("내용(%s)? ", task.content);
    String content = Prompt.inputString(label);

    Date deadline = Prompt.inputDate(String.format("마감일(%s)? ", task.deadline));
    String owner = Prompt.inputString(String.format("담당자(%s)? ", task.owner));


    task.content = content;
    task.deadline = deadline;
    task.owner = owner;
  }
}