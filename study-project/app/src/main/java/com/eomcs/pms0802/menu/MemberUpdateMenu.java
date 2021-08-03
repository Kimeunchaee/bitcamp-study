package com.eomcs.pms0802.menu;

import com.eomcs.pms0802.handler.MemberHandler;

public class MemberUpdateMenu extends Menu {

  MemberHandler memberhandler;

  public MemberUpdateMenu(MemberHandler memberHandler) {
    super("변경");
    this.memberhandler = memberHandler;
  }

  @Override
  public void execute() {
    memberhandler.update();
  }

}
