// Object 클래스 - getClass() 와 배열
package com.eomcs.basic.ex01;

public class Exam0161 {

  public static void main(String[] args) {

    String obj1 = new String();
    Class<?> classInfo = obj1.getClass();
    System.out.println(classInfo.getName()); // java.lang.String

    // 배열의 클래스 정보
    String[] obj2 = new String[10];
    classInfo = obj2.getClass();
    System.out.println(classInfo.getName()); //[Ljava.lang.String;

    int[] obj3 = new int[10];
    classInfo = obj3.getClass();
    System.out.println(classInfo.getName()); //[I

    float[] obj4 = new float[10];
    classInfo = obj4.getClass();
    System.out.println(classInfo.getName()); //[F

    double[] obj5 = new double[10];
    classInfo = obj5.getClass();
    System.out.println(classInfo.getName()); //[D

    System.out.println(new byte[10].getClass().getName()); //[B (byte의 배열 타입)
    System.out.println(new short[10].getClass().getName()); //[S ( short의 배열 타입)
    System.out.println(new long[10].getClass().getName()); //[J (long의 의 배열 타입)
    System.out.println(new char[10].getClass().getName()); //[C (char의 배열 타입)
    System.out.println(new boolean[10].getClass().getName()); //[Z (blooean의 배열타입
  }
}







