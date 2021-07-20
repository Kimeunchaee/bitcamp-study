package com.eomcs.oop.ex00;

public class Stu001 {
  static class Score {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
  }


  public static void main(String[] args) {


    Score[] s = new Score[3];
    s[0] = create("홍길동", 100, 100, 100);
    s[1] = create("임꺽정", 90, 90, 90);
    s[2] = create("유관순", 80, 80, 80);

  }

  static Score create (String name, int kor, int eng, int math) {
    Score ss = new Score();
    ss.name = name;
    ss.kor = kor;
    ss.eng = eng;
    ss.math = math;
    ss.sum = ss.kor + ss.eng + ss.math;
    ss.aver = ss.sum / 3f;
    return ss;
  }

  static void print(Score[] s) {
    for(int i = 0; i < s.length; i++) {

      System.out.printf("%s: %d, %d, %d, %d, %.1f\n",
          s[i].name, s[i].kor, s[i].eng, s[i].math, s[i].sum, s[i].aver);
    }
  }

}
