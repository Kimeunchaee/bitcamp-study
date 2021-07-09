package com.eomcs.basic.ex10;

public class Exam0100 {
  public static void main(String[] args) {
    long mills = System.currentTimeMillis();
    //double 은 8바이트지만 지수부 가수부 나눠서 표현하기때문에 16자리만 표현되고
    // 숫자가 짤려서 표현됨 > 너무 큰 수 이기때문에 눈에 안보임 , 오류는 안뜨지만
    // doble은 잘못된 변수임

    System.out.println(mills);
    //java.util.Date d = new java.util.Date(mills); // Date 객체을 만드는 순간의 시각을 저장해둔다
    java.sql.Date d = new java.sql.Date(mills);
    System.out.println(d.toString());
    System.out.printf("%tY-%tm-%td", d, d, d);
    System.out.printf("%tY-%1$tm-%1$td\n gggggg", d);
  }

}
