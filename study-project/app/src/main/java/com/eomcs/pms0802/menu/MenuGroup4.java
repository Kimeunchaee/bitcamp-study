package com.eomcs.pms0802.menu;

import com.eomcs.pms0802.util.Prompt;


public class MenuGroup4 extends Menu {

  Menu[] childs = new Menu[100];  
  int size;

  boolean disablePrevMenu; 

  String prevMenuTitle =  "이전메뉴";   // 기본값 하나 추가함





  public MenuGroup4 (String title) {
    super(title);
  }


  public MenuGroup4 (String title, boolean disablePrevMenu) {
    super(title);
    this.disablePrevMenu = disablePrevMenu; 
  }


  // prevMenuTitle 는 필수적인것이 아니라 선택적으로 사용하도록
  // 생성자로 만들지 않고 setter로 만든다
  public void setPrevMenuTitle(String prevMenuTitle) {
    this.prevMenuTitle = prevMenuTitle;
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
        //System.out.println("0. 이전메뉴");
        // prevMenuTitle 사용해줌
        System.out.printf("0. %s\n", this.prevMenuTitle);
      }

      int menuNo = Prompt.inputInt("선택> ");
      if (menuNo == 0 && !disablePrevMenu) {
        return; //메서드가 호출된 곳으로 돌아감 (App에 execute()부분)
      }

      if (menuNo < 0 || menuNo > this.size) {
        System.out.println("무효한 메뉴 번호입니다.");
        continue;
      }

      //.execute()를 실행으로 while문을 반복
      this.childs[menuNo - 1].execute();
    }
  }

}
