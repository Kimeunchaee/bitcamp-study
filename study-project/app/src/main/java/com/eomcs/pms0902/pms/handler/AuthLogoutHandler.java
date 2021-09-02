package com.eomcs.pms0902.pms.handler;


public class AuthLogoutHandler implements Command {
  //  public void logout() {
  @Override
  public void execute() {
    System.out.println("[로그아웃]");

    AuthLoginHandler.loginUser = null;
    System.out.println("로그아웃 하였습니다.");
  }
}







