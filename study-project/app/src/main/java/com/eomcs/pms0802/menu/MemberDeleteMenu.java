package com.eomcs.pms0802.menu;

import com.eomcs.pms0802.handler.MemberHandler;

public class MemberDeleteMenu extends Menu {

  MemberHandler memberhandler;

  public MemberDeleteMenu(MemberHandler memberHandler) {
    super("삭제");
    this.memberhandler = memberHandler;
  }

  @Override
  public void execute() {
    memberhandler.delete();
  }

}
