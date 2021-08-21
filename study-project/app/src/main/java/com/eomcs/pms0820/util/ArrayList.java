package com.eomcs.pms0820.util;

import java.util.Arrays;

// 일반 클래스에 제네릭을 ㅈ적용하면,
// 최종적인 타입이름은
// 그 클래스의 인스턴스를 생성할때 전달한다.


// ----기존
// public class ArrayList extends AbstractList {


public class ArrayList<E> extends AbstractList<E> {

  static final int MAX_LENGTH = 5;


  //인스턴스를 생성할때 (new) 타입이름을 결정한다.
  Object[] list = new Object[MAX_LENGTH];


  private E[] temp;


  @Override
  //public void add(Object obj) {
  public void add(E obj) {
    if (size == list.length) {
      Object[] arr = new Object[list.length + (list.length >> 1)];
      for (int i = 0; i < size; i++) {
        arr[i] = list[i];
      }
      list = arr;
    }
    this.list[this.size++] = obj;

  }

  @Override
  public Object[] toArray() {
    Object[] arr = new Object[this.size]; // 배열에 저장된 값을 담을 정도의 크기를 가진 새 배열을 만든다.
    for (int i = 0; i < this.size; i++) { // 배열에 저장된 값을 새 배열에 복사한다.
      arr[i] = list[i];
    }
    return arr; // 새 배열을 리턴한다.
  }

  @Override
  //public boolean remove(Object obj) {
  public boolean remove(E obj) {
    int index = indexOf(obj);
    if (index == -1) {
      return false;
    }

    for (int i = index + 1; i < this.size; i++) {
      this.list[i - 1] = this.list[i];
      this.list[i - 1] = this.list[i];
    }
    this.list[--this.size] = null;

    return true;
  }

  //private int indexOf(Object obj) {
  private int indexOf(E obj) {
    for (int i = 0; i < this.size; i++) {
      if (this.list[i] == obj) {
        return i;
      }
    }
    return -1;
  }


  @SuppressWarnings("unchecked")
  @Override
  //public Object get(int index) {
  public E get(int index) {
    if (index < 0 || index >= this.size) { // 유효하지 않은 인덱스인 경우
      return null;
    }
    //return this.list[index];
    return (E)this.list[index];
  }


  @SuppressWarnings("unchecked")
  @Override
  //public Object remove(int index) {
  public E remove(int index) {
    if (index < 0 || index >= this.size) { // 인덱스가 무효하다면
      return null;
    }

    //Object deleted = this.list[index]; // 삭제할 항목 저장
    E deleted = (E)this.list[index]; // 삭제할 항목 저장


    for (int i = index + 1; i < this.size; i++) {
      this.list[i - 1] = this.list[i];
    }
    this.list[--this.size] = null;

    return deleted; // 삭제한 항목 리턴
  }


  //추가
  @Override
  public E[] toArray(E[] arr) {

    // 1) 파라미터로 받은 배열이 현재 목록에 있는 값을 담을 만큼 충분히 크다면,
    if(arr.length >= this.size)   {           // arr.length : 파라미터로 받은 배열
      // 현재 목록에 있는 값을 파라미터로 받은 배열에 복사한다

      // 배열을 복사할 때 자바에서 제공하는 클래스를 사용하면
      // 반복문을 작성할 필요 없이 보다 쉽게 배열을 복사할 수 있다.

      // 복사하는 명령어 => System.arraycopy(원래배열, 복사시작인덱스, 값을 받은 배열, 복사시작인덱스, 복사할 개수)
      System.arraycopy(this.list, 0, arr, 0, this.size);
      // 리스트의 0번째부터 꺼내롸서 arr에 0번째 부터 넣는데
      return arr;  //파라미터로 받은 배열을 그대로 리턴한다




      // 2) 파라미터로 받은 배열이 현재 목록에 들어있는 값을 담을 만큼 크지 않다면,
    } else {

      // 방법1
      // 새 배열을 만들어 복사한다.
      //제네릭 타입은 인스턴스(new)를 생성할수 없다. 
      // E[] temp = new E[this.size];       //컴파일 오류!

      // 해결책?

      // 새배열을 만든다
      // => Array.newInstance(배열항목의 타입, 생성할 배열의 크기)
      // => arr.getClass() => 배열의 타입 / 예) Project[]
      // => arr.getClass().getComponaentType() => 배열의 각 항목의 타입 / 예) Project[]

      // 실행코드
      //      java.lang.reflect.Array.newInstance(arr.getClass().getComponentType(), this.size);
      //      System.arraycopy(this.list, 0, arr, 0, this.size);
      //      return temp;





      // 방법2
      // 제네릭이 적용된 배열을 만들어주는 메서드의 도움을 받아야한다
      // 복사하는 명령어 => Arrays.copyOf(원래배열, 복사할 개수, 새로만들배열의타입)
      // return : 배열 주소값을 리턴해줘야 toArray()를 호출해서 사용할수있음

      E[] temp =  (E[]) Arrays.copyOf(
          this.list,      // 원본 배열
          this.size,      // 복사할 배열, 현재 배열에 들어 있는 값들의 개수
          arr.getClass()    // 생성할 배열의 타입(원본 배열과 같은 타입의 배열을 생성할 것이다)
          );
      return temp;
    }
  }


}


// 기존배열을 복사 : System.arraycopy()
// 새배열을 복사 : Arrays.copyOf()






