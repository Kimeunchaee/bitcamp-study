package com.eomcs.pms0901.pms.handler;

import java.util.List;
import com.eomcs.pms0901.pms.domain.Project;
import com.eomcs.pms0901.util.Prompt;

public class ProjectDetailHandler extends AbstractProjectHandler {

  //기존
  //  List<Project> projectList;
  //  MemberHandler memberHandler;
  //
  //  public ProjectDetailHandler(List<Project> projectList, MemberHandler memberHandler) {
  //    this.projectList = projectList;
  //    this.memberHandler = memberHandler;
  //  }

  // 수정
  // projectList는 수퍼클래스에 선언되어 있기때문에
  // 상속을 받았으므로 선언해주지 않아도
  // 파라미터 명으로 사용할 수 있음
  // List<Project> projectList; //삭제가능

  public ProjectDetailHandler(List<Project> projectList) {
    super(projectList);
  }

  public void detail() {
    System.out.println("[프로젝트 상세보기]");
    int no = Prompt.inputInt("번호? ");

    Project project = findByNo(no);

    if (project == null) {
      System.out.println("해당 번호의 프로젝트가 없습니다.");
      return;
    }

    System.out.printf("프로젝트명: %s\n", project.getTitle());
    System.out.printf("내용: %s\n", project.getContent());
    System.out.printf("시작일: %s\n", project.getStartDate());
    System.out.printf("종료일: %s\n", project.getEndDate());
    System.out.printf("만든이: %s\n", project.getOwner().getName());
    System.out.printf("팀원: %s\n", getMemberNames(project.getMembers()));
  }

  // 수퍼클래스에 있으므로 필요없다
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
  //
  //  @Override
  //  public Project findByNo(int no) {
  //    Project[] arr = projectList.toArray(new Project[0]);
  //    for (Project project : arr) {
  //      if (project.getNo() == no) {
  //        return project;
  //      }
  //    }
  //    return null;
  //  }

}





