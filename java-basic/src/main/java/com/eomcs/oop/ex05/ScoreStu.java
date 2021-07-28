package com.eomcs.oop.ex05;

import com.eomcs.oop.ex05.d.Score;

public class ScoreStu {

  public String name;
  public int kor;
  public int eng;
  public int math;
  public int sum;
  public float aver;


  public void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3f;
  }
}


class ScoreStu2 extends Score {
  public int music;
  public int art;

  @Override
  public void compute() {
    this.sum = this.kor + this.eng + this.math + this.music + this.art;
    this.aver = this.sum / 5f;

    //this는 ScoreStu2 자기자신의 인스턴스주소 (상속된 부모this가 아님)
  }
}


//------------------------------------------------------

class Exam03 {
  void main(String[] args) {
    ScoreStu2 s = new  ScoreStu2();
    s.name = "홍길동";
    s.kor = 100;
    s.eng = 100;
    s.math = 100;
    s.music = 100;
    s.art = 100;
    s.compute();
    System.out.printf("%s: %d(%.1f)\n", s.name, s.sum, s.aver);
  }
}







