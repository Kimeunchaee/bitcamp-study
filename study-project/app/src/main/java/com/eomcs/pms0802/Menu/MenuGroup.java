package com.eomcs.pms0802.Menu;

public class MenuGroup extends Menu {

  //---------------------------------------------------------
  Menu[] childs = new Menu[100];
  int size; 

  //---------------------------------------------------------
  // 생성자를 정의하지 않으면 컴파일러가 기본 생성자를 자동으로 추가해준다
  // 문제는 컴파일러가 추가한 기본 생성자는 수퍼클래스의 기본생성자를 호출하기 때문에
  // 컴파일 오류가 발생한다 (Menu클래스에서 기본생성자를 만들어주지 않았기 때문에)
  // 따라서 개발자가 직접 생성자를 정의해야한다.
  public MenuGroup(String title) {
    super(title);
  }

  //---------------------------------------------------------
  // MenuGroup이 포함하는 객체인 하위 Menu를 다룰수 있도록 메서드를 정의한다

  public void add(Menu childMenu) {
    if (size >= this.childs.length){
      return; // 하위메뉴를 저장할 배열이 꽉 찼다면 더이상 저장해서는 안된다
    }
    //그렇지 않다면
    this.childs[this.size++] = childMenu;
  }


  //몇번째 인덱스인지 찾기
  //배열에 들어있는 Menu객체의 인덱스를 알아낸다
  public int indexOf(Menu child) {
    for(int i = 0; i < this.size; i++) {
      if(childs[i] == child) {
        return i;
      }
    }
    return -1;
  }

  // 배열에 들어있는 Menu객체를 찾아 제거한다
  public void remove(Menu child) {
    int index = indexOf(child); // 먼저 인덱스를 찾고
    for (int i = index+1; i<this.size; i++ ) {
      this.childs[i-1] = this.childs[i]; //앞으로 한칸 옮긴다
    }
    childs[--this.size] = null;
  }


  //배열에 들어있는 Menu객체를 찾는다
  public Menu getMenu(String title) {
    return null;
    //문자열을 비교할때는 ==연산자를 사용하면 안되고
    // equals로 비교해야한다!
  }








  //---------------------------------------------------------
  @Override
  public void execute() {

  }
}
