package com.eomcs.pms0802.menu;


public class MenuItemStu extends Menu {

  public interface ActionListener{void doAction();}


  ActionListener[] listeners = new ActionListener[10];
  int size;

  public void addActionListener(ActionListener listen) {
    if (this.size == this.listeners.length) {
      return;
    }
    this.listeners[this.size++] = listen;
  }

  public MenuItemStu(String title) {
    super(title);
  }

  @Override
  public void execute() {

    for(int i = 0; i < this.size; i++) {
      this.listeners[i].doAction();
    }



  }


}
