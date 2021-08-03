package com.eomcs.pms0802.menu;

import com.eomcs.pms0802.handler.MemberHandler;

public class MemberDetailMenu extends Menu {

  MemberHandler memberhandler;

  public MemberDetailMenu(MemberHandler memberHandler) {
    super("상세보기");
    this.memberhandler = memberHandler;
  }

  @Override
  public void execute() {
    memberhandler.detail();
  }

}
