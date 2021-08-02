package com.eomcs.pms0802.Menu;


public abstract class Menu_copy {

  String title;

  public Menu_copy(String title) {
    this.title = title;
  }

  public abstract void execute();
}
