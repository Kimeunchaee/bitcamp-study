// 오버라이딩(overriding) - 준비
package com.eomcs.oop.ex06.c;



public class Exam0430 {

  static class A {
    String name = "A";
    String tel = "A: 010-1111-1111";
    boolean working = true;

    void print() {
      System.out.println("A.print():");
      System.out.printf("  => this.name(%s)\n",
          this.name);
      System.out.printf("  => this.tel(%s)\n",
          this.tel);
      System.out.printf("  => this.working(%s)\n",
          this.working);
    }
  }


  static class A2 extends A {
    int age = 20;

    @Override
    void print() {
      System.out.println("A2.print():");
      System.out.printf("  => this.name(%s), super.name(%s)\n",  // A의 name을 가리킴
          this.name, super.name);
      System.out.printf("  => this.tel(%s), super.tel(%s)\n",   //A의 name을 가리킴
          this.tel, super.tel);
      System.out.printf("  => this.working(%s), super.working(%s)\n",       //A의 name을 가리킴
          this.working, super.working);
      System.out.printf("  => this.age(%s), super.age(컴파일 오류!) \n",     //this에서는 A2를 가리키고 super에서는 A를 가리키는데 A에는 값이 없으므로 오류가뜸
          this.age /*, super.age*/);
    }
  }


  static class A3 extends A {
    int age = 30;
    String tel = "A3: 010-1111-2222";

    @Override
    void print() {
      System.out.println("A3.print():");
      System.out.printf("  => this.name(%s), super.name(%s)\n", this.name, super.name); //this는 A3, super는 A를 가리키킴 > A3에 name이 없으므로 A를 가리킴 > this,super 둘다 A를 가리킴
      System.out.printf("  => this.tel(%s), super.tel(%s)\n", this.tel, super.tel);     //this는A3, super는 A를 가리킴
      System.out.printf("  => this.working(%s), super.working(%s)\n", this.working, super.working);     //this는 A3,super는 A2를 가리키는 데 둘다 name이 없으므로 A로 올라가서 표시됨
      System.out.printf("  => this.age(%s), super.age(컴파일 오류!) \n", this.age /*, super.age*/);
      // this는 A3, super는 A를 가리키는데 A에는 age가 없으므로 super를 넣으면 오류가 뜸
    }
  }


  static class A4 extends A3 {
    String age = "40";
    boolean working = false;

    @Override
    void print() {
      System.out.println("A4.print():");
      System.out.printf("  => this.name(%s), super.name(%s)\n", this.name, super.name);
      System.out.printf("  => this.age(%s), super.age(%s)\n", this.age, super.age);
      System.out.printf("  => this.tel(%s), super.tel(%s)\n", this.tel, super.tel);
      System.out.printf("  => this.working(%s), super.working(%s)\n", this.working, super.working);
      // this는 A4 , super는 A를 가리킴 (A3에 working가 없고, A3가 상속받는 A의 working을 가리킴)
    }
  }

  public static void main(String[] args) {
    A obj1 = new A();
    obj1.print();
    System.out.println("--------------------------------");

    A2 obj2 = new A2();
    obj2.print();
    System.out.println("--------------------------------");

    A3 obj3 = new A3();
    obj3.print();
    System.out.println("--------------------------------");

    A4 obj4 = new A4();
    obj4.print();
    System.out.println("--------------------------------");
  }
}
