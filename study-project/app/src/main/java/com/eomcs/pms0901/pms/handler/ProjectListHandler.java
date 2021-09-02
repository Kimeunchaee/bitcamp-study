package com.eomcs.pms0901.pms.handler;

import java.util.List;
import com.eomcs.pms0901.pms.domain.Project;

// 상속 추가
public class ProjectListHandler extends AbstractProjectHandler {

  //기존
  //  List<Project> projectList;
  //  MemberHandler memberHandler;
  //
  //  public ProjectListHandler(List<Project> projectList, MemberHandler memberHandler) {
  //    this.projectList = projectList;
  //    this.memberHandler = memberHandler;
  //  }

  // 수정
  // projectList는 수퍼클래스에 선언되어 있기때문에
  // 상속을 받았으므로 선언해주지 않아도
  // 파라미터 명으로 사용할 수 있음
  // List<Project> projectList; //삭제가능

  public ProjectListHandler(List<Project> projectList) {
    super(projectList);
  }


  public void list() {
    System.out.println("[프로젝트 목록]");

    for (Project project : projectList) {
      System.out.printf("%d, %s, %s, %s, %s, [%s]\n",
          project.getNo(), 
          project.getTitle(), 
          project.getStartDate(), 
          project.getEndDate(), 
          project.getOwner().getName(),
          getMemberNames(project.getMembers()));
    }
  }

  //수퍼클래스에 있으므로 필요없다
  //  @Override
  //  private String getMemberNames(List<Member> members) {
  //    StringBuilder names = new StringBuilder();
  //    for(Member member : members) {
  //      if(names.length() > 0) {
  //        names.append(",");
  //      }
  //      names.append(member.getName());
  //    }
  //    return names.toString();
  //  }
}





