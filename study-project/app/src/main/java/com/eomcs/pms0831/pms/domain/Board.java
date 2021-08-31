package com.eomcs.pms0831.pms.domain;
import java.sql.Date;

public class Board {
  private int no;
  private String title;
  private String content;
  //기존
  //private String writer;
  private Member writer;

  private Date registeredDate;
  private int viewCount;
  private int like;


  // 도메인 클래스는 보통
  // 해시코드, 투스트링,이퀄스를 오버라이딩한다
  // 게시글을 비교할 일이 없으면 해시코드와 이퀄스는 하지 않아도 된다!
  // 0831 추가

  @Override
  public String toString() {
    return "Board [no=" + no + ", title=" + title + ", content=" + content + ", writer=" + writer
        + ", registeredDate=" + registeredDate + ", viewCount=" + viewCount + ", like=" + like
        + "]";
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
  public Date getRegisteredDate() {
    return registeredDate;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }
  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }
  public int getLike() {
    return like;
  }
  public void setLike(int like) {
    this.like = like;
  }

  public Member getWriter() {
    return writer;
  }
  public void setWriter(Member writer) {
    this.writer = writer;
  }

}
