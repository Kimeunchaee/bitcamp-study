package com.eomcs.pms0901.pms.handler;

import java.util.List;
import com.eomcs.pms0901.pms.domain.Project;
import com.eomcs.pms0901.util.Prompt;

// 상속 추가
public class ProjectAddHandler extends AbstractProjectHandler {

  // 기존
  //  List<Project> projectList;
  //  MemberHandler memberHandler;
  //
  //  public ProjectAddHandler(List<Project> projectList, MemberHandler memberHandler) {
  //    this.projectList = projectList;
  //    this.memberHandler = memberHandler;
  //  }

  // 수정
  // projectList는 수퍼클래스에 선언되어 있기때문에
  // 상속을 받았으므로 선언해주지 않아도
  // 파라미터 명으로 사용할 수 있음
  // List<Project> projectList; //삭제가능

  // ProjectAddHandler 내부에서 memberHandler를 사용해야한다
  // 수퍼클래스인 AbstractMemberHandler도 memberHandler를 갖고 있기때문에
  // 데이터 타입을 AbstractMemberHandler 해주는것이 낫다
  AbstractMemberHandler memberHandler;

  public ProjectAddHandler(List<Project> projectList , AbstractMemberHandler memberHandler) {
    super(projectList);
    this.memberHandler = memberHandler;
  }

  public void add() {
    System.out.println("[프로젝트 등록]");

    Project project = new Project();

    project.setNo(Prompt.inputInt("번호? "));
    project.setTitle(Prompt.inputString("프로젝트명? "));
    project.setContent(Prompt.inputString("내용? "));
    project.setStartDate(Prompt.inputDate("시작일? "));
    project.setEndDate(Prompt.inputDate("종료일? "));
    project.setOwner(AuthHandler.getLoginUser());
    project.setMembers(memberHandler.promptMembers("팀원?(완료: 빈 문자열) "));

    projectList.add(project);

    System.out.println("프로젝트를 저장했습니다!");
  }

}





