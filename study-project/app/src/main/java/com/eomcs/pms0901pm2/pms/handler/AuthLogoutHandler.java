package com.eomcs.pms0901pm2.pms.handler;

public class AuthLogoutHandler {
  public void logout() {
    System.out.println("[로그아웃]");

    AuthLoginHandler.loginUser = null;
    System.out.println("로그아웃 하였습니다.");
  }
}







