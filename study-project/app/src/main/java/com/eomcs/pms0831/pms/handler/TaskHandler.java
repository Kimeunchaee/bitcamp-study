package com.eomcs.pms0831.pms.handler;

import java.sql.Date;
import com.eomcs.pms0831.pms.domain.Member;
import com.eomcs.pms0831.pms.domain.Project;
import com.eomcs.pms0831.pms.domain.Task;
import com.eomcs.pms0831.util.Prompt;

public class TaskHandler {

  ProjectHandler projectHandler;

  public TaskHandler(ProjectHandler projectHandler) {
    this.projectHandler = projectHandler;
  }

  public void add() {
    System.out.println("[작업 등록]");

    // 작업을 등록하기전에 프로젝트가 하나라도 있는지 유무 확인
    Project project = projectHandler.promptProject();
    if(project == null) {
      System.out.println("작업 등록을 취소합니다");
      return;
    }

    // 권한 유무 확인하는 기능 추가
    // 프로젝트를 생성한 관리자만 작업을 추가할 수 있다
    if (project.getOwner().getNo() != AuthHandler.getLoginUser().getNo()) {
      System.out.println("이 프로젝트의 관리자가 아닙니다.");
      return;
    }

    Task task = new Task();

    task.setNo(Prompt.inputInt("번호? "));
    task.setContent(Prompt.inputString("내용? "));
    task.setDeadline(Prompt.inputDate("마감일? "));
    task.setStatus(promptStatus());
    // 회원중에서 프로젝트를 등록한 담당자인지를 확인하는 기능이 필요하다
    // MemberHandler에서 findByName()에 파라미터 2개받는거를 하나 더 만든다
    task.setOwner(MemberHandler.promptMember("담당자?(취소: 빈 문자열) " , project.getMembers()));
    if (task.getOwner() == null) {
      System.out.println("작업 등록을 취소합니다.");
      return; 
    }

    project.getTasks().add(task);

    System.out.println("작업을 등록했습니다");
  }


  public void list() {
    System.out.println("[작업 목록]");

    // 작업을 등록하기전에 프로젝트가 하나라도 있는지 유무 확인
    Project project = projectHandler.promptProject();
    if(project == null) {
      System.out.println("프로젝트를 먼저 등록해주세요");
      return;
    }

    printTasks(project);
  }

  private void printTasks(Project project) {
    System.out.printf("%s:\n\n", project.getTitle());
    for (Task task : project.getTasks()) {
      System.out.printf("%d, %s, %s, %s, %s\n",
          task.getNo(), 
          task.getContent(), 
          task.getDeadline(), 
          getStatusLabel(task.getStatus()), 
          task.getOwner());
    }
  }

  public void detail() {
    System.out.println("[작업 상세보기]");

    // 작업을 등록하기전에 프로젝트가 하나라도 있는지 유무 확인
    Project project = projectHandler.promptProject();
    if (project == null) {
      System.out.println("작업 조회를 취소합니다.");
      return;
    }

    // 프로젝트가 하나라도 있으면 출력
    printTasks(project);

    System.out.println("-------------------------------------");

    int no = Prompt.inputInt("작업 번호? ");

    Task task = findByNo(project, no);
    if (task == null) {
      System.out.println("해당 번호의 작업이 없습니다.");
      return;
    }

    System.out.printf("내용: %s\n", task.getContent());
    System.out.printf("마감일: %s\n", task.getDeadline());
    System.out.printf("상태: %s\n", getStatusLabel(task.getStatus()));
    System.out.printf("담당자: %s\n", task.getOwner());
  }

  public void update() {
    System.out.println("[작업 변경]");

    // 작업을 등록하기전에 프로젝트가 하나라도 있는지 유무 확인
    Project project = projectHandler.promptProject();
    if (project == null) {
      System.out.println("작업 변경을 취소합니다.");
      return;
    }

    // 권한 유무 확인하는 기능 추가
    // 프로젝트를 생성한 관리자만 작업을 변경할 수 있다
    if (project.getOwner().getNo() != AuthHandler.getLoginUser().getNo()) {
      System.out.println("이 프로젝트의 관리자가 아닙니다.");
      return;
    }

    // 프로젝트가 하나라도 있으면 출력
    printTasks(project);

    System.out.println("-------------------------------------");

    int no = Prompt.inputInt("작업 번호? ");

    Task task = findByNo(project, no);

    if (task == null) {
      System.out.println("해당 번호의 작업이 없습니다.");
      return;
    }

    String content = Prompt.inputString(String.format("내용(%s)? ", task.getContent()));
    Date deadline = Prompt.inputDate(String.format("마감일(%s)? ", task.getDeadline()));
    int status = promptStatus(task.getStatus());
    Member owner = MemberHandler.promptMember(String.format(
        "담당자(%s)?(취소: 빈 문자열) ", task.getOwner().getName()) ,  project.getMembers());
    if (owner == null) {
      System.out.println("등록된 담당자가 없으므로 작업 변경을 취소합니다.");
      return;
    }

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("작업 변경을 취소하였습니다.");
      return;
    }

    task.setContent(content);
    task.setDeadline(deadline);
    task.setStatus(status);
    task.setOwner(owner);

    System.out.println("작업를 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[작업 삭제]");

    // 작업을 등록하기전에 프로젝트가 하나라도 있는지 유무 확인
    Project project = projectHandler.promptProject();
    if (project == null) {
      System.out.println("작업 변경을 취소합니다.");
      return;
    }

    // 권한 유무 확인하는 기능 추가
    // 프로젝트를 생성한 관리자만 작업을 변경할 수 있다
    if (project.getOwner().getNo() != AuthHandler.getLoginUser().getNo()) {
      System.out.println("이 프로젝트의 관리자가 아닙니다.");
      return;
    }

    // 프로젝트가 하나라도 있으면 출력
    printTasks(project);

    System.out.println("-------------------------------------");

    int no = Prompt.inputInt("번호? ");

    Task task = findByNo(project, no);

    if (task == null) {
      System.out.println("해당 번호의 작업이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("작업 삭제를 취소하였습니다.");
      return;
    }

    project.getTasks().remove(task);

    System.out.println("작업를 삭제하였습니다.");
  }

  private String getStatusLabel(int status) {
    switch (status) {
      case 1: return "진행중";
      case 2: return "완료";
      default: return "신규";
    }
  }

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

  // 파라미터 2개 받는 메서드로 수정
  private static Task findByNo(Project project, int taskNo) {
    for (Task task : project.getTasks()) {
      if (task.getNo() == taskNo) {
        return task;
      }
    }
    return null;
  }
}





