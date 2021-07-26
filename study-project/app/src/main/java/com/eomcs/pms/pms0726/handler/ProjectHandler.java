package com.eomcs.pms.pms0726.handler;

import java.sql.Date;
import com.eomcs.pms.pms0726.domain.Project;
import com.eomcs.pms.pms0726.util.Prompt;

public class ProjectHandler {
  static final int MAX_LENGTH = 5;

  Project[] projects = new Project[MAX_LENGTH];
  int size = 0;

  //public MemberHandler memberHandler;
  // ProjectHandler가 지속적으로 사용할 의존 객체는 다음과 같이 인스턴스 필드로 받는다.
  // 이 인스턴스 변수에 의존 객체의 주소를 넣을 수 있도록 접근모드를 공개로 설정한다.
  //2. 생성자 만든후
  // 이제 의존객체는 생성자를 통해 주입받기때문에
  //외부에서 인스턴스 변수에 직접 접근할 이유가 ㅇ없다
  //따라서 전체공개모드에서 패키지멤버에게만 공개하는 모드로 전환단다 (public x)
  MemberHandler memberHandler;

  public ProjectHandler(MemberHandler memberHandler) {  //공개 - 리턴타입없음 - 메서드이름이 클래스이름과같아야함 - (인스턴스)
    // 프로젝트핸들러의 인스턴스를 만들때 멤버핸들러를 반드시 받아서 사용하도록 파라미터를 지정한다

    // 생성자에 파라미터가 있으면 인스턴스를 생성할때 반드시 그 값을 넘겨야한다
    // 일종의 인스턴스 변수의 값을 설정하는것을 강제하는 효과가 있다
    this.memberHandler = memberHandler; 
  }
  // 생성자 선언
  // - 인스턴스를 생성할때 반드시 호출되어야하는 메서드이다
  // - 생성자는 리컨타입이 없다
  // - 메서드 이름이 클래스이름과 같아야한다
  // - 인스턴스변수를 유효한값으로 초기화시킨다
  // = 필요하다면 인스턴스변수를 초기화시킬때 사용할 값을 파라미터로 받을수 있다

  public void add(/*MemberHandler memberHandler*/) {
    System.out.println("[프로젝트 등록]");

    Project project = new Project();

    project.no = Prompt.inputInt("번호? ");
    project.title = Prompt.inputString("프로젝트명? ");
    project.content = Prompt.inputString("내용? ");
    project.startDate = Prompt.inputDate("시작일? ");
    project.endDate = Prompt.inputDate("종료일? ");

    project.owner = promptOwner("만든이?(취소: 빈 문자열) "); //(memberHandler); 파라미터 줄 필요없음
    if (project.owner == null) {
      System.out.println("프로젝트 등록을 취소합니다.");
      return;
    }

    project.members = promptMembers("팀원?(완료: 빈 문자열) "); //(memberHandler); 파라미터 줄 필요없음

    this.projects[this.size++] = project;
  }

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

  //업데이트의 파라미터도 지워준다
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

    String owner = promptOwner(/*memberHandler, */String.format(
        "만든이(%s)?(취소: 빈 문자열) ", project.owner));
    if (owner == null) {
      System.out.println("프로젝트 변경을 취소합니다.");
      return;
    }

    String members = promptMembers(/*memberHandler, */String.format(
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

  private String promptOwner(/*MemberHandler memberHandler,*/ String label) {
    while (true) {
      String owner = Prompt.inputString(label);
      // 회원 이름이 등록된 회원의 이름인지 검사할 때 사용할 MemberHandler 인스턴스는
      // 인스턴스 변수에 미리 주입되어 있기 때문에 파라미터로 받을 필요가 없다.
      // 다음과 같이 인스턴스 변수를 직접 사용하면 된다. (this)
      if (this.memberHandler.exist(owner)) {
        return owner;
      } else if (owner.length() == 0) {
        return null;
      }
      System.out.println("등록된 회원이 아닙니다.");
    }
  }

  private String promptMembers(/*MemberHandler memberHandler,*/ String label) {
    String members = "";
    while (true) {
      String member = Prompt.inputString(label);
      // memberHandler  > this.memhandler 로 변경 (의존객체인 멤버핸들러가 자기자신에 있기때문에)
      if (this.memberHandler.exist(member)) {
        if (members.length() > 0) {
          members += ",";
        }
        members += member;
        continue;
      } else if (member.length() == 0) {
        break;
      } 
      System.out.println("등록된 회원이 아닙니다.");
    }
    return members;
  }

}
