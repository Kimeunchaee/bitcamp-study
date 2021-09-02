package com.eomcs.pms0901pm2.pms.handler;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.pms0901pm.pms.domain.Project;
import com.eomcs.pms0901pm.util.Prompt;

public class ProjectAddHandler extends AbstractProjectHandler {


  // 기존
  //AbstractMemberHandler memberHandler;

  // 수정
  //MemberPromptHandler 로 바꿔주기
  MemberPromptHandler memberPromprHandler;

  public ProjectAddHandler(List<Project> projectList,  MemberPromptHandler memberPromprHandler) {
    super(projectList);
    this.memberPromprHandler = memberPromprHandler;

    Project project = new Project();
    project.setNo(101);
    project.setTitle("프로젝트1");
    project.setContent("내용!!!");
    project.setStartDate(Date.valueOf("2021-1-1"));
    project.setEndDate(Date.valueOf("2021-2-2"));
    //기존
    //project.setOwner(memberHandler.memberList.get(0));

    //수정
    project.setOwner(memberPromprHandler.memberList.get(0));

    project.setMembers(new ArrayList<>());

    projectList.add(project);

    project = new Project();
    project.setNo(102);
    project.setTitle("프로젝트2");
    project.setContent("내용!!!");
    project.setStartDate(Date.valueOf("2021-3-1"));
    project.setEndDate(Date.valueOf("2021-4-2"));
    //project.setOwner(memberHandler.memberList.get(1));
    project.setOwner(memberPromprHandler.memberList.get(1));
    project.setMembers(new ArrayList<>());

    projectList.add(project);

    project = new Project();
    project.setNo(103);
    project.setTitle("프로젝트3");
    project.setContent("내용!!!");
    project.setStartDate(Date.valueOf("2021-5-1"));
    project.setEndDate(Date.valueOf("2021-6-2"));
    //project.setOwner(memberHandler.memberList.get(2));
    project.setOwner(memberPromprHandler.memberList.get(2));
    project.setMembers(new ArrayList<>());

    projectList.add(project);

  }

  public void add() {
    System.out.println("[프로젝트 등록]");

    Project project = new Project();

    project.setNo(Prompt.inputInt("번호? "));
    project.setTitle(Prompt.inputString("프로젝트명? "));
    project.setContent(Prompt.inputString("내용? "));
    project.setStartDate(Prompt.inputDate("시작일? "));
    project.setEndDate(Prompt.inputDate("종료일? "));
    project.setOwner(AuthLoginHandler.getLoginUser());
    //project.setMembers(memberHandler.promptMembers("팀원?(완료: 빈 문자열) "));
    project.setMembers(memberPromprHandler.promptMembers("팀원?(완료: 빈 문자열) "));

    projectList.add(project);

    System.out.println("프로젝트를 저장했습니다!");
  }
}





