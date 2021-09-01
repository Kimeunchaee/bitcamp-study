package com.eomcs.pms0901.pms.domain;

import java.sql.Date;

public class Task {
  private int no;
  private String content;
  private Date deadline;  
  private int status;

  // 기존
  // private String owner;
  private Member owner;

  //추가
  private Project projet;


  //투스트링 추가
  @Override
  public String toString() {
    return "Task [no=" + no + ", content=" + content + ", deadline=" + deadline + ", owner=" + owner
        + ", status=" + status + ", projet=" + projet + "]";
  }

  //수정
  public Member getOwner() {
    return owner;
  }
  public void setOwner(Member owner) {
    this.owner = owner;
  }
  public Project getProjet() {
    return projet;
  }
  public void setProjet(Project projet) {
    this.projet = projet;
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public Date getDeadline() {
    return deadline;
  }
  public void setDeadline(Date deadline) {
    this.deadline = deadline;
  }
  public int getStatus() {
    return status;
  }
  public void setStatus(int status) {
    this.status = status;
  }
}
