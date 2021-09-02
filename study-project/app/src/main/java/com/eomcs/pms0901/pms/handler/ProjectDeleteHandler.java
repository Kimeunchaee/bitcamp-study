package com.eomcs.pms0901.pms.handler;

import java.util.List;
import com.eomcs.pms0901.pms.domain.Project;
import com.eomcs.pms0901.util.Prompt;

// 상속추가
public class ProjectDeleteHandler extends AbstractProjectHandler {

  //기존
  //  List<Project> projectList;
  //  MemberHandler memberHandler;
  //
  //  public ProjectDeleteHandler(List<Project> projectList, MemberHandler memberHandler) {
  //    this.projectList = projectList;
  //    this.memberHandler = memberHandler;
  //  }

  // 수정
  // projectList는 수퍼클래스에 선언되어 있기때문에
  // 상속을 받았으므로 선언해주지 않아도
  // 파라미터 명으로 사용할 수 있음
  // List<Project> projectList; //삭제가능

  public ProjectDeleteHandler(List<Project> projectList) {
    super(projectList);
  }


  public void delete() {
    System.out.println("[프로젝트 삭제]");
    int no = Prompt.inputInt("번호? ");

    Project project = findByNo(no);

    if (project == null) {
      System.out.println("해당 번호의 프로젝트가 없습니다.");
      return;
    }

    if(project.getOwner().getNo() != AuthHandler.getLoginUser().getNo()) {
      System.out.println("삭제 권한이 없습니다.");
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





