package com.eomcs.pms0802.Menu;

public class MenuGroup_copy extends Menu_copy {

  Menu_copy[] childs = new Menu_copy[100];
  int size;

  public MenuGroup_copy (String title) {
    super(title);
  }


  public void add (Menu_copy childMenu) {
    if (this.size == this.childs.length) {
      return;
    }
    this.childs[this.size++] = childMenu;
  }

  public void remove(Menu_copy child) {
    int index = indexOf(child);
    for (int i = index + 1; i < this.size; i++) {
      this.childs[i - 1] = this.childs[i];
    }

    childs[--this.size] = null;
  }

  public int indexOf (Menu_copy child) {
    for(int i = 0; i < this.size; i++){
      if(this.childs[i] == child) {
        return i;
      }
    } 
    return -1;
  }

  public Menu_copy getMenu(String title) {

    for(int i = 0; i < this.size; i++) {
      if (childs[i] == title){
        return childs[i];
      }
    }
    return null;

  }
  @Override
  public void execute() {

  }

}
