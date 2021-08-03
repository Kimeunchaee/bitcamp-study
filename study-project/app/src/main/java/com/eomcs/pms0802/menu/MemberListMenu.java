package com.eomcs.pms0802.menu;

import com.eomcs.pms0802.handler.MemberHandler;

public class MemberListMenu extends Menu {

  MemberHandler memberhandler;

  public MemberListMenu(MemberHandler memberHandler) {
    super("목록");
    this.memberhandler = memberHandler;
  }

  @Override
  public void execute() {
    memberhandler.list();
  }

}
