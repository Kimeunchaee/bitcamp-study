package com.eomcs.pms0802.menu;

import com.eomcs.pms0802.util.Prompt;


public class MenuGroup3 extends Menu {

  Menu[] childs = new Menu[100];  
  int size;

  boolean disablePrevMenu; // 이전메뉴를 활성화(기본값)할지  : 이전메뉴가 출력되는게 기본값임


  public MenuGroup3 (String title) {
    super(title);
  }

  //생성자 추가
  public MenuGroup3 (String title, boolean disablePrevMenu) {
    super(title);
    this.disablePrevMenu = disablePrevMenu;   //이 생성자를 사용하면 비활성화시킨다
  }


  public void add (Menu child) {
    if (this.size == this.childs.length) {
      return;
    }
    this.childs[this.size++] = child;
  }

  public Menu remove (Menu child) {
    int index = indexOf(child);   
    if(index == -1) {               
      return null;                       

    }
    for (int i = index + 1; i < this.size; i++) {
      this.childs[i - 1] = this.childs[i];
    }
    childs[--this.size] = null;
    return child; 
  }

  public int indexOf (Menu child) {
    for(int i = 0; i < this.size; i++){
      if(this.childs[i] == child) {
        return i;
      }
    } 
    return -1;
  }

  public Menu getMenu(String title) {
    for(int i = 0; i < this.size; i++) {
      if (this.childs[i].title.equals(title)){
        return childs[i];
      }
    }
    return null;
  }


  @Override
  public void execute() {
    while (true) {
      System.out.printf("\n[%s]\n", this.title);
      for (int i = 0; i < this.size; i++) {
        System.out.printf("%d. %s\n", i + 1, this.childs[i].title);
      }

      if (!disablePrevMenu) {
        System.out.println("0. 이전메뉴");
      }

      int menuNo = Prompt.inputInt("선택> ");
      if (menuNo == 0 && !disablePrevMenu) {
        return;
      }

      if (menuNo < 0 || menuNo > this.size) {
        System.out.println("무효한 메뉴 번호입니다.");
        continue;
      }

      this.childs[menuNo - 1].execute();
    }
  }

}
