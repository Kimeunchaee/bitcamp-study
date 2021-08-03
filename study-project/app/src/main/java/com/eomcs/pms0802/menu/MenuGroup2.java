package com.eomcs.pms0802.menu;


import com.eomcs.pms0802.util.Prompt;

// 폴더역할 (다른 폳더도 포함할수 있고 다른 메뉴도 포함할수있음)
public class MenuGroup2 extends Menu {

  Menu[] childs = new Menu[100];   // 자식메뉴를 담을 배열
  int size;

  public MenuGroup2 (String title) {
    super(title);
  }



  public void add (Menu child) {
    if (this.size == this.childs.length) {
      return;
    }
    this.childs[this.size++] = child;
  }

  public Menu remove (Menu child) {
    int index = indexOf(child);   // child 리무브할 대상을 indexOf메서드로 찾음
    if(index == -1) {               // -1유효하지 않을때, 삭제할 대상을 찾지 못할때 
      return null;                       // null을 Menu에 리턴하면 삭제하지 못했다는뜻, 샂게했다면 삭제한 그 주소를 리턴함
      // 메서드 타입을 void > Menu로 바꿔주고 return null 해주기
    }
    for (int i = index + 1; i < this.size; i++) {
      this.childs[i - 1] = this.childs[i];
    }
    childs[--this.size] = null;
    return child;  //child를 삭제하기로 했으므로 삭제할 대상을 리턴해줌
  }

  public int indexOf (Menu child) {
    for(int i = 0; i < this.size; i++){
      if(this.childs[i] == child) {
        return i;
      }
    } 
    return -1;
  }

  // this.childs[i].title.equals(title) 기존 타이틀과 입력한 타이틀 비교
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
    System.out.printf("[%s]\n", this.title);
    for(int i = 0; i < this.size; i++) {            // this.size 는 하위메뉴몇개만들었는지 카운트된 변수
      System.out.printf("%d. %s\n", i+1, this.childs[i].title);  // "%d. %s\n", i+1, 번호를 출력할때 i보다 하나 큰값(인덱스는 0부터 시작하기떄문에)

      System.out.println("0. 이전메뉴");
      int menuNo = Prompt.inputInt("선택> ");

      if(menuNo == 0) {
        return;
      }

      if (menuNo < 0 || menuNo > this.size) {
        System.out.println("무효한 메뉴 번호입니다.");
        continue;
      }
      this.childs[menuNo - 1].execute(); //인덱스는 실제 번호보다 하나 큰수이기때문에  출력할때 ?????????????/
    }
  }

}