package com.eomcs.pms0901pm.pms.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Project {
  private int no;
  private String title;
  private String content;
  private Date startDate;
  private Date endDate;
  private Member owner;
  private List<Member> members;
  private static List<Task> tasks = new ArrayList<>();

  @Override
  public String toString() {
    return "Project [no=" + no + ", title=" + title + ", content=" + content + ", startDate="
        + startDate + ", endDate=" + endDate + ", owner=" + owner + ", members=" + members
        + ", tasks=" + tasks + "]";
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public Date getStartDate() {
    return startDate;
  }
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }
  public Date getEndDate() {
    return endDate;
  }
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }
  public Member getOwner() {
    return owner;
  }
  public void setOwner(Member owner) {
    this.owner = owner;
  }
  public List<Member> getMembers() {
    return members;
  }
  public void setMembers(List<Member> members) {
    this.members = members;
  }
  public static List<Task> getTasks() {
    return tasks;
  }
  public void setTasks(List<Task> tasks) {
    this.tasks = tasks;
  }

  //추가
  // AbstractProjectHandler 에 있던 getMemberNames() 메서드를 Project 도메인으로 옮긴다
  //접근 범위 수정 (기존 protected > public)
  public String getMemberNames(List<Member> members) {
    if(this.members == null) {
      return "";
    }
    StringBuilder names = new StringBuilder();
    for (Member member : members) {
      if (names.length() > 0) {
        names.append(",");
      }
      names.append(member.getName());
    }
    return names.toString();
  }


  //추가
  // AbstractProjectHandler 에 있던 getMemberNames() 메서드를 Project 도메인으로 옮긴다
  // 접근 범위 수정 (기존 protected > public)
  // 메서드명 수정 (기존 findByNo > findByTaskNo)
  // 파라미터 수정, 이제 내부 메서드니까 (Project project 삭제)
  // Project project 삭제했으므로 task 변수선언과 게터메서드를 static으로 수정해줘야한다

  // TaskDetailHandler , TaskUpdateHandler , TaskDeleteHandler 3개의 클래스에서 사용하므로 가서 수정해주기

  public static Task findByTaskNo(int taskNo) {
    for (Task task : getTasks()) {
      if (task.getNo() == taskNo) {
        return task;
      }
    }
    return null;
  }
}
