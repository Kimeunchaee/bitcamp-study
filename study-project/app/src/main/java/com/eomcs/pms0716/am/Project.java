package com.eomcs.pms0716.am;

import java.sql.Date;

public class Project {
  public int no;
  public String title;
  public String content;
  public Date startDate;
  public Date endDate;
  public String owner;
  public String members;

  // 회원등록에 no와 이름이 같아도 상관없기 때문에 pNo > No > no 로 바꿔줌 

}
