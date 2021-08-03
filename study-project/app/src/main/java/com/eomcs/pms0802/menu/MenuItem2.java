package com.eomcs.pms0802.menu;


//MenuItem과 리스너

//ActionListener 규칙에 따라 리스너 객체를 실행하는 코드를 추가한다.
//- 리스너를 보관할 배열 준비
//- 리스너를 등록하는 메서드 추가
public class MenuItem2 extends Menu {

  //--------------------------------------------

  //3단계 : ActionListener 이름의 인터페이스를 별도의 파일로 만들기
  //리스너를 보관하는 배열을 준비한다.
  ActionListener[] listeners = new ActionListener[10];
  int size;

  //--------------------------------------------

  // 1단계 : 부모클래스의 생성자 호출
  public MenuItem2(String title) {
    super(title);
  }

  //--------------------------------------------

  //4단계 : 리스너를 등록하는 메서드 추가
  public void addActionListener(ActionListener listener) {
    if (this.size == this.listeners.length) {   //추가된 폴더와 전체배열의 크기가 같으면(꽉차면)
      return; //리턴해라?
    }
    this.listeners[this.size++] = listener;
  }



  //--------------------------------------------
  //2단계 : 부모클래스의 메서드 오버라이딩
  @Override
  public void execute() {

    //5단계 : execute()에 실행항 내용 작성해주기

    // 메뉴를 실행하면 이 메뉴에 등록된 모든 리스너에게 알린다.
    for (int i = 0; i < this.size; i++) {
      // 배열에 보관된 각각의 리스너 객체에 대해 
      // ActionListener 규칙에 따라 메서드를 호출한다.
      // => 이것이 리스너에게 알린다는 의미다.
      this.listeners[i].doAction();

    }
  }
}
