package com.eomcs.pms0802.menu;

import com.eomcs.pms0802.handler.BoardHandler;

public class BoardListMenu extends Menu {

  BoardHandler boardhandler;

  public BoardListMenu(BoardHandler boardHandler) {
    super("목록");
    this.boardhandler = boardHandler;
  }

  @Override
  public void execute() {
    boardhandler.list();

  }

}
