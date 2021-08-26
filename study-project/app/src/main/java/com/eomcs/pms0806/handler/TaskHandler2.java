package com.eomcs.pms0806.handler;

import java.sql.Date;
import com.eomcs.pms0806.domain.Task;
import com.eomcs.pms0806.util.Prompt;

public class TaskHandler2 {

  //프로젝트핸들러와 테스크핸들러의 공통분모를 추출하여
  //별도의 클래스 MemberHandler로 분리

  // 메서드가 있어야할 적절한 클래스로 이동시킨다
  // promptOwner는 멤버에대해 다루는 메서드임으로
  // 멤버핸들러로 이동시킨다


  List taskList;
  public TaskHandler2(List taskList) {
    this.taskList = taskList;
  }


  MemberHandler2 memberHandler;
  public TaskHandler2(MemberHandler2 memberHandler) {
    this.memberHandler = memberHandler;
  }



  public void add() {
    System.out.println("[작업 등록]");

    Task task = new Task();

    task.no = Prompt.inputInt("번호? ");
    task.content = Prompt.inputString("내용? ");
    task.deadline = Prompt.inputDate("마감일? ");
    task.status = promptStatus();
    //task.owner = promptOwner("담당자?(취소: 빈 문자열) ");
    task.owner = memberHandler.promptOwner("담당자?(취소: 빈 문자열) ");
    if (task.owner == null) {
      System.out.println("작업 등록을 취소합니다.");
      return; 
    }

    taskList.add(task);
  }


  public void list() {
    System.out.println("[작업 목록]");

    Object[] list = taskList.toArray();

    for (Object obj : list) {
      Task task = (Task) obj;
      System.out.printf("%d, %s, %s, %s, %s\n",
          task.no, 
          task.content, 
          task.deadline, 
          getStatusLabel(task.status), 
          task.owner);
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
    System.out.printf("상태: %s\n", getStatusLabel(task.status));
    System.out.printf("담당자: %s\n", task.owner);
  }

  public void update() {
    System.out.println("[작업 변경]");
    int no = Prompt.inputInt("번호? ");


    Task task = findByNo(no);

    if (task == null) {
      System.out.println("해당 번호의 작업이 없습니다.");
      return;
    }

    String content = Prompt.inputString(String.format("내용(%s)? ", task.content));
    Date deadline = Prompt.inputDate(String.format("마감일(%s)? ", task.deadline));
    int status = promptStatus(task.status);
    // 기존 String owner = promptOwner(String.format(
    String owner = memberHandler.promptOwner(String.format(
        "담당자(%s)?(취소: 빈 문자열) ", task.owner));
    if (owner == null) {
      System.out.println("작업 변경을 취소합니다.");
      return;
    }

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("작업 변경을 취소하였습니다.");
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


    Task task = findByNo(no);

    if (task == null) {
      System.out.println("해당 번호의 작업이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("작업 삭제를 취소하였습니다.");
      return;
    }

    taskList.remove(task);

    System.out.println("작업를 삭제하였습니다.");
  }

  private String getStatusLabel(int status) {
    switch (status) {
      case 1: return "진행중";
      case 2: return "완료";
      default: return "신규";
    }
  }

  // 멤버핸들러로 이동
  // (이미 프로젝트핸들러에서 공통코드를 옮겼기때문에 지우기만 하면됨)
  //  private String promptOwner(String label) {
  //    while (true) {
  //      String owner = Prompt.inputString(label);
  //      if (this.memberHandler.exist(owner)) {
  //        return owner;
  //      } else if (owner.length() == 0) {
  //        return null;
  //      }
  //      System.out.println("등록된 회원이 아닙니다.");
  //    }
  //  }

  private int promptStatus() {
    return promptStatus(-1);
  }

  private int promptStatus(int status) {
    if (status == -1) {
      System.out.println("상태?");
    } else {
      System.out.printf("상태(%s)?\n", getStatusLabel(status));
    }
    System.out.println("0: 신규");
    System.out.println("1: 진행중");
    System.out.println("2: 완료");
    return Prompt.inputInt("> ");
  }



  private Task findByNo(int no) {
    Object[] arr = taskList.toArray();
    for (Object obj : arr) {
      Task task = (Task) obj;
      if (task.no == no) {
        return task;
      }
    }
    return null;
  }


}




