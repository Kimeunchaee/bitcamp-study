package com.eomcs.pms0806.handler;

import java.sql.Date;
import com.eomcs.pms0806.domain.Project;
import com.eomcs.pms0806.util.Prompt;

public class ProjectHandler2 {

  //프로젝트핸들러와 테스크핸들러의 공통분모를 추출하여
  //별도의 클래스 MemberHandler로 분리

  //메서드가 있어야할 적절한 클래스로 이동시킨다
  // promptOwner,promptMembers는 멤버에대해 다루는 메서드임으로
  // 멤버핸들러로 이동시킨다



  List projectList;
  public ProjectHandler2(List projectList) {
    this.projectList = projectList;
  }



  MemberHandler2 memberHandler;
  public ProjectHandler2(MemberHandler2 memberHandler) {
    this.memberHandler = memberHandler;
  }



  public void add() {
    System.out.println("[프로젝트 등록]");

    Project project = new Project();

    project.no = Prompt.inputInt("번호? ");
    project.title = Prompt.inputString("프로젝트명? ");
    project.content = Prompt.inputString("내용? ");
    project.startDate = Prompt.inputDate("시작일? ");
    project.endDate = Prompt.inputDate("종료일? ");

    // 기존 project.owner = promptOwner("만든이?(취소: 빈 문자열) ");
    project.owner = memberHandler.promptOwner("만든이?(취소: 빈 문자열) ");
    if (project.owner == null) {
      System.out.println("프로젝트 등록을 취소합니다.");
      return;
    }

    // 기존 project.members = promptMembers("팀원?(완료: 빈 문자열) ");
    project.members = memberHandler.promptMembers("팀원?(완료: 빈 문자열) ");

    projectList.add(project);
  }

  public void list() {
    System.out.println("[프로젝트 목록]");

    Object[] list = projectList.toArray();

    for (Object obj : list) {
      Project project = (Project) obj;
      System.out.printf("%d, %s, %s, %s, %s, [%s]\n",
          project.no, 
          project.title, 
          project.startDate, 
          project.endDate, 
          project.owner,
          project.members);
    }
  }

  public void detail() {
    System.out.println("[프로젝트 상세보기]");
    int no = Prompt.inputInt("번호? ");

    Project project = findByNo(no);

    if (project == null) {
      System.out.println("해당 번호의 프로젝트가 없습니다.");
      return;
    }

    System.out.printf("프로젝트명: %s\n", project.title);
    System.out.printf("내용: %s\n", project.content);
    System.out.printf("시작일: %s\n", project.startDate);
    System.out.printf("종료일: %s\n", project.endDate);
    System.out.printf("만든이: %s\n", project.owner);
    System.out.printf("팀원: %s\n", project.members);
  }

  public void update() {
    System.out.println("[프로젝트 변경]");
    int no = Prompt.inputInt("번호? ");

    Project project = findByNo(no);

    if (project == null) {
      System.out.println("해당 번호의 프로젝트가 없습니다.");
      return;
    }

    String title = Prompt.inputString(String.format("프로젝트명(%s)? ", project.title));
    String content = Prompt.inputString(String.format("내용(%s)? ", project.content));
    Date startDate = Prompt.inputDate(String.format("시작일(%s)? ", project.startDate));
    Date endDate = Prompt.inputDate(String.format("종료일(%s)? ", project.endDate));

    // 기존 String owner = promptOwner(String.format(
    //        "만든이(%s)?(취소: 빈 문자열) ", project.owner));
    String owner =  memberHandler.promptOwner(String.format(
        "만든이(%s)?(취소: 빈 문자열) ", project.owner));

    if (owner == null) {
      System.out.println("프로젝트 변경을 취소합니다.");
      return;
    }


    // 기존 String members = promptMembers(String.format(
    String members = memberHandler.promptMembers(String.format(
        "팀원(%s)?(완료: 빈 문자열) ", project.members));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("프로젝트 변경을 취소하였습니다.");
      return;
    }

    project.title = title;
    project.content = content;
    project.startDate = startDate;
    project.endDate = endDate;
    project.owner = owner;
    project.members = members;

    System.out.println("프로젝트를 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[프로젝트 삭제]");
    int no = Prompt.inputInt("번호? ");

    Project project = findByNo(no);

    if (project == null) {
      System.out.println("해당 번호의 프로젝트가 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("프로젝트 삭제를 취소하였습니다.");
      return;
    }

    projectList.remove(project);

    System.out.println("프로젝트를 삭제하였습니다.");
  }


  // 멤버핸들러로 이동
  //  private String promptOwner(String label) {
  //    while (true) {
  //      String owner = Prompt.inputString(label);
  //
  //      if (this.memberHandler.exist(owner)) {
  //        return owner;
  //      } else if (owner.length() == 0) {
  //        return null;
  //      }
  //      System.out.println("등록된 회원이 아닙니다.");
  //    }
  //  }


  // 멤버핸들러로 이동
  //  private String promptMembers(String label) {
  //    String members = "";
  //    while (true) {
  //      String member = Prompt.inputString(label);
  //
  //      if (this.memberHandler.exist(member)) {
  //        if (members.length() > 0) {
  //          members += ",";
  //        }
  //        members += member;
  //        continue;
  //      } else if (member.length() == 0) {
  //        break;
  //      } 
  //      System.out.println("등록된 회원이 아닙니다.");
  //    }
  //    return members;
  //  }

  private Project findByNo(int no) {
    Object[] arr = projectList.toArray();
    for (Object obj : arr) {
      Project project = (Project) obj;
      if (project.no == no) {
        return project;
      }
    }
    return null;
  }


}





