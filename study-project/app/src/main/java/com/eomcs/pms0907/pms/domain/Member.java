package com.eomcs.pms0907.pms.domain;

import java.io.Serializable;
import java.sql.Date;

public class Member implements Serializable{
  // 인터페이스는 메서드를 구현해야하는데
  // Serializable 는 가지고있는 메서드가 없다
  // Serial 을 사용할 수 있다고 표시만 해주는 것
  private int no;
  private String name;
  private String email;
  private String password;
  private String photo;
  private String tel;
  private Date registeredDate;

  @Override
  public String toString() {
    return "Member [no=" + no + ", name=" + name + ", email=" + email + ", password=" + password
        + ", photo=" + photo + ", tel=" + tel + ", registeredDate=" + registeredDate + "]";
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getPhoto() {
    return photo;
  }
  public void setPhoto(String photo) {
    this.photo = photo;
  }
  public String getTel() {
    return tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }
  public Date getRegisteredDate() {
    return registeredDate;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }
}