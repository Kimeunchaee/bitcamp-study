package com.eomcs.pp0723.pm.handler;

import java.sql.Date;
import com.eomcs.pp0723.pm.domain.Project;
import com.eomcs.pp0723.pm.util.Prompt;

public class ProjectHandler {

  static final int MAX_LENGTH = 5;

  Project[] projects = new Project[MAX_LENGTH];
  int size = 0;

  public void add(MemberHandler memberHandler) {
    System.out.println("[프로젝트 등록]");

    Project project = new Project();

    project.no = Prompt.inputInt("번호? ");
    project.title = Prompt.inputString("프로젝트명? ");
    project.content = Prompt.inputString("내용? ");
    project.startDate = Prompt.inputDate("시작일? ");
    project.endDate = Prompt.inputDate("종료일? ");

    // 코드 새로 작성해서 추가
    project.owner = promptOwner(memberHandler, null);
    if (project.owner == null) {
      System.out.println("프로젝트 등록을 취소합니다.");
      return;
    }

    // 수정
    project.members = promptMembers(memberHandler, null);  // 기존멤버이름은 넘기지 않는다 = null


    this.projects[this.size++] = project;
  }

  //다른 패키지에 있는 App 클래스가 다음 메서드를 호출할 수 있도록 공개한다.
  public void list() {
    System.out.println("[프로젝트 목록]");
    for (int i = 0; i < this.size; i++) {
      System.out.printf("%d, %s, %s, %s, %s, [%s]\n",
          this.projects[i].no, 
          this.projects[i].title, 
          this.projects[i].startDate, 
          this.projects[i].endDate, 
          this.projects[i].owner,
          this.projects[i].members);
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



  public void update(MemberHandler memberHandler) {
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


    // 수정
    // String owner = null;
    String owner = promptOwner(memberHandler, project.owner);
    if (owner==null) {
      System.out.println("프로젝트 변경을 취소합니다.");
      return; 
    }

    // 수정
    String members = promptMembers(memberHandler, project.members); // 기존회원의 이름을 넘긴다 = project.members

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

    int index = indexOf(no);

    if (index == -1) {
      System.out.println("해당 번호의 프로젝트가 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("프로젝트 삭제를 취소하였습니다.");
      return;
    }

    for (int i = index + 1; i < this.size; i++) {
      this.projects[i - 1] = this.projects[i];
    }
    this.projects[--this.size] = null;

    System.out.println("프로젝트를 삭제하였습니다.");
  }


  private Project findByNo(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.projects[i].no == no) {
        return this.projects[i];
      }
    }
    return null;
  }


  private int indexOf(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.projects[i].no == no) {
        return i;
      }
    }
    return -1;
  }


  //add 에서 만든이를 입력받는 소스코드 가져와서 두개의 값을 받는 메소드를 만듦
  private String promptOwner(MemberHandler memberHandler, String ownerName) {

    /*
    String label;
    if(ownerName != null) {  //ownerName이 넘어온다면 입력한 이름을 label에 넣어서 출력
      label = String.format("만든이(%s)?(취소: 빈 문자열) ", ownerName);
    } else {  //ownerName이 null이면 넘어오지 않았으니까 그대로
      label = "만든이?(취소: 빈 문자열) ";
    }
     */


    /*
    // 위에 5줄과 같은 코드
    String label = String.format("만든이(%s)?(취소: 빈 문자열) ", 
        ownerName != null ?"("+owner+")" : "");
     */

    while (true) {
      // 여기서 라벨은 한번만 사용하기 때문에 생략가능
      // 위에 label을 인풋스트링에 넣어줌
      //String owner = Prompt.inputString(label);

      String owner = Prompt.inputString(String.format("만든이(%s)?(취소: 빈 문자열) ", 
          ownerName != null ?"(" + ownerName + ")" : ""));

      if (memberHandler.exist(owner)) {
        //project.owner = owner;
        //break;
        return owner;
      } else if (owner.length() == 0) {
        //     x   System.out.println("프로젝트 등록을 취소합니다.");
        //     x   return;
        return null;
      }
      System.out.println("등록된 회원이 아닙니다.");
    }
  }


  //add 에서 팀원을 입력받는 소스코드 가져와서 두개의 값을 받는 메소드를 만듦
  private String promptMembers(MemberHandler memberHandler, String oldmembers) {
    String newMembers = "";
    while (true) {
      String member = Prompt.inputString(String.format("팀원(%s)?(취소: 빈 문자열) ", 
          oldmembers != null ?"(" + oldmembers + ")" : ""));
      if (memberHandler.exist(member)) {
        if (newMembers.length() > 0) {
          newMembers += ",";
        }
        newMembers += member;
        continue;
      } else if (member.length() == 0) {
        break;
      } 
      System.out.println("등록된 회원이 아닙니다.");
    }
    return newMembers;
  }

}
