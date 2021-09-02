package com.eomcs.pms0831.pms.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Project {
  private int no;
  private String title;
  private String content;
  private Date startDate;
  private Date endDate;

  // 기존
  //private String owner;
  //private String members;
  private Member owner;
  private List<Member> members;

  //추가
  // task를 등록할 때마다 한 개씩 한 개씩 add 시킨다는 의미
  // 그래서 빈 프로젝트라도 가지고 있어야 함 그래야 하나씩 add 할 수 있으니까
  // ArrayList와 LinkedList 둘 다 쓸 수 있고 어떤 걸 쓸지 모르기 때문
  private List<Task> tasks = new ArrayList<>();



  public List<Task> getTasks() {
    return tasks;
  }
  public void setTasks(List<Task> tasks) {
    this.tasks = tasks;
  }

  // 투스트링 추가
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

  // 수정
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
}
