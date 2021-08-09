package com.eomcs.pms0806.handler;


// 인터페이스 적용

//현재 리스트클래스는 추상클래스이다
// 인터페이스로 바꾸면(라벨=역할,문법)
// ArryList, LinjedList는 concrete로 바꾼다

// 인터페이스 : 객체(=클래스를 의미함)를 사용하기위한 메서드 호출규칙


//List 클래스
// - 상속해줄 필드는 없다
// - 상속해줄 메서드도 없다
// - 다만 서브 클래스에게 반드시 구현하라고 강요하는 추상메서드는 있다
// 이런경우 차라리 "객체 사용 규칙"을 전문적으로 정의하는 인터페이스를 사용하는 것이 낫다


// 인터페이스
//- 모든 필드는 public, static, final 필드이다.
//- 모든 메서드는 public, abstract 메서드이다.
//- default 키워드를 이용하여 구현 메서드를 만들수는 있다.
//- 객체 사용 규칙을 정의할 때 사용하는 문법이다.
//- 당연히 인스턴스를 생성할 수 없다.



// 1. class를 
// 2. interface로 변경 (기본적으로 public abstract 이기때문에 붙혀도 되고 생략해도 된다)
// 3. ArrayList3와 LinkedList3에서 구현(implements)한다
public abstract interface List3 {

  //public abstract void add (Object item);
  void add (Object item);       // 타입 생략가능
  public abstract Object[] toArray(); 
  public abstract boolean remove(Object item);


}
