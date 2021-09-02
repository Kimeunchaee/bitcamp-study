package com.eomcs.pms0901.pms.handler;

import java.sql.Date;
import java.util.List;
import com.eomcs.pms0901.pms.domain.Member;
import com.eomcs.pms0901.pms.domain.Project;
import com.eomcs.pms0901.util.Prompt;

// 상속추가
public class ProjectUpdateHandler extends AbstractProjectHandler {

  //기존
  //  List<Project> projectList;
  //  MemberHandler memberHandler;
  //
  //  public ProjectUpdateHandler(List<Project> projectList, MemberHandler memberHandler) {
  //    this.projectList = projectList;
  //    this.memberHandler = memberHandler;
  //  }

  // 수정
  // projectList는 수퍼클래스에 선언되어 있기때문에
  // 상속을 받았으므로 선언해주지 않아도
  // 파라미터 명으로 사용할 수 있음
  // List<Project> projectList; //삭제가능

  //ProjectAddHandler 내부에서 memberHandler를 사용해야한다
  // 수퍼클래스인 AbstractMemberHandler도 memberHandler를 갖고 있기때문에
  // 데이터 타입을 AbstractMemberHandler 해주는것이 낫다
  AbstractMemberHandler memberHandler;

  public ProjectUpdateHandler(List<Project> projectList,  AbstractMemberHandler memberHandler) {
    super(projectList);
    this.memberHandler = memberHandler;
  }

  public void update() {
    System.out.println("[프로젝트 변경]");
    int no = Prompt.inputInt("번호? ");

    Project project = findByNo(no);

    if (project == null) {
      System.out.println("해당 번호의 프로젝트가 없습니다.");
      return;
    }


    if(project.getOwner().getNo() != AuthHandler.getLoginUser().getNo()) {
      System.out.println("변경 권한이 없습니다.");
      return;
    }

    String title = Prompt.inputString(String.format("프로젝트명(%s)? ", project.getTitle()));
    String content = Prompt.inputString(String.format("내용(%s)? ", project.getContent()));
    Date startDate = Prompt.inputDate(String.format("시작일(%s)? ", project.getStartDate()));
    Date endDate = Prompt.inputDate(String.format("종료일(%s)? ", project.getEndDate()));

    List<Member> members = memberHandler.promptMembers(String.format(
        "팀원(%s)?(완료: 빈 문자열) ", project.getMembers()));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("프로젝트 변경을 취소하였습니다.");
      return;
    }

    project.setTitle(title);
    project.setContent(content);
    project.setStartDate(startDate);
    project.setEndDate(endDate);
    project.setMembers(members);

    System.out.println("프로젝트를 변경하였습니다.");
  }

  @Override
  public Project findByNo(int no) {
    Project[] arr = projectList.toArray(new Project[0]);
    for (Project project : arr) {
      if (project.getNo() == no) {
        return project;
      }
    }
    return null;
  }
}





