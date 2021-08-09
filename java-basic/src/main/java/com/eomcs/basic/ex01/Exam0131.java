// Object 클래스 - equals() 오버라이딩 
package com.eomcs.basic.ex01;



public class Exam0131 {

  public static void main(String[] args) {
    My obj1 = new My();
    obj1.name = "홍길동";
    obj1.age = 20;
    obj1.tel = "1111-1111";
    obj1.email = "hong@test.com";
    obj1.gender = 1;
    obj1.working = false;

    My obj2 = new My();
    obj2.name = "홍길동";
    obj2.age = 20;
    obj2.tel = "1111-1111";
    obj2.email = "hong@test.com";
    obj2.gender = 1;
    obj2.working = false;

    System.out.println(obj1 == obj2);
    System.out.println(obj1.equals(obj2));

    // 결론!
    // => Object에서 상속 받은 것을 그대로 사용하면 equals()는 인스턴스가 같은지 비교한다.
    // => 인스턴스의 내용물이 같은지 비교하도록 만들고 싶다면 equals()을 오버라이딩 하라!
    // => String와 wrapper 클래스는 equals() 오버라이딩 하였다.
    // => StringBuffer 클래스는 equals()를 오버라이딩 하지 않았다.
  }

  static class My {
    String name;
    int age;
    String tel;
    String email;
    int gender;
    boolean working;


    @Override       // 상속하지 않아도 기본으로 Object가 수퍼클래스임
    //기본 메서드인 equals를 재정의함
    public boolean equals(Object obj) {
      if (this == obj)
        return true;    // 배열의 주소는 다르더라도 각각의 값은 같은 배열이기때문에
      // 같은지를 비교해서 true를 리턴함
      if (obj == null) //obj는 파라미터로 넘어온 값
        return false;
      if (getClass() != obj.getClass()) //
        return false;
      My other = (My) obj;
      if (age != other.age)
        return false;
      if (email == null) {
        if (other.email != null)
          return false;
      } else if (!email.equals(other.email))
        return false;
      if (gender != other.gender)
        return false;
      if (name == null) {
        if (other.name != null)
          return false;
      } else if (!name.equals(other.name))
        return false;
      if (tel == null) {
        if (other.tel != null)
          return false;
      } else if (!tel.equals(other.tel))
        return false;
      if (working != other.working)
        return false;
      return true; //위에 if문을 다 통과했을때 true를 리턴
    }


  }

}







