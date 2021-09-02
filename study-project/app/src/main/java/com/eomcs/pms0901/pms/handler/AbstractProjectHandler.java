package com.eomcs.pms0901.pms.handler;

import java.util.List;
import com.eomcs.pms0901.pms.domain.Member;
import com.eomcs.pms0901.pms.domain.Project;
import com.eomcs.pms0901.util.Prompt;

//추상클래스로 만들기
public abstract class AbstractProjectHandler {

  // 접근 범위 수정
  protected List<Project> projectList;
  //protected MemberHandler memberHandler;

  public AbstractProjectHandler(List<Project> projectList /*, MemberHandler memberHandler*/) {
    this.projectList = projectList;
    //this.memberHandler = memberHandler;
  }

  // 접근범위 수정
  protected String getMemberNames(List<Member> members) {
    StringBuilder names = new StringBuilder();
    for (Member member : members) {
      if (names.length() > 0) {
        names.append(",");
      }
      names.append(member.getName());
    }
    return names.toString();
  }

  protected Project findByNo(int no) {
    for (Project project : projectList) {
      if (project.getNo() == no) {
        return project;
      }
    }
    return null;
  }

  public Project promptProject() {
    System.out.println("프로젝트:");
    for (Project project : projectList) {
      System.out.printf("  %d. %s\n", project.getNo(), project.getTitle());
    }
    while (true) {
      int projectNo = Prompt.inputInt("프로젝트 번호 선택? (취소: 0) ");
      if (projectNo == 0) {
        return null;
      }
      Project selectedProject = findByNo(projectNo);
      if (selectedProject != null) {
        return selectedProject;
      }
      System.out.println("프로젝트 번호가 옳지 않습니다.");
    }
  }

}

