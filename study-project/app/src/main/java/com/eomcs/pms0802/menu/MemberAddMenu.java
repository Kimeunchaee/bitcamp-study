package com.eomcs.pms0802.menu;

import com.eomcs.pms0802.handler.MemberHandler;

public class MemberAddMenu extends Menu {

  // add 기능을 호출할뿐

  MemberHandler memberhandler;

  public MemberAddMenu(MemberHandler memberHandler) {
    super("등록");
    this.memberhandler = memberHandler;
  }

  @Override
  public void execute() {
    memberhandler.add();
  }
}
