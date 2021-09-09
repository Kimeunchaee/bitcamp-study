// 활용 - 지정한 폴더에서 .class 파일만 찾아 출력하라.
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0740 {

  public static void main(String[] args) throws Exception {

    File dir = new File("bin/main");
    System.out.println(dir.getCanonicalPath());

    // 파라미터 1개
    // printClasses(dir);

    // 파라미터 2개 받는 메서드 호출
    printClasses(dir, "");
  }

  static void printClasses(File dir) {

    // 패키지에서 .class 파일만 출력
    // 1
    //    File[] files = dir.listFiles();
    //
    //    for (File f : files) {
    //      if(f.isFile() && f.getName().endsWith(".class")) {
    //        System.out.println(f.getName());}
    //    }

    // 2 
    //    File[] files = dir.listFiles(new FileFilter() {
    //      @Override
    //      public boolean accept(File fileff) {
    //        if(fileff.isFile() || fileff.getName().endsWith(".class")) {
    //          return true;
    //        }
    //        return false;
    //      }
    //    });
    //
    //    for (File f : files) {
    //      if(f.isFile() && f.getName().endsWith(".class")) {
    //        System.out.println(f.getName());}
    //    }

    // 3
    //    File[] files = dir.listFiles(fileff -> fileff.isFile() || (fileff.getName().endsWith(".class")));
    //
    //    for (File f : files) {
    //      if(f.isFile() && f.getName().endsWith(".class")) {
    //        System.out.println(f.getName());}
    //    }
  }


  static void printClasses(File dir, String packageName) {

    // main은 패키지가 비어있는 상태, 패키지 먼저 만들기
    //
    // 1
    File[] files = dir.listFiles(
        fileff -> fileff.isFile() || (fileff.getName().endsWith(".class")));

    for (File f : files) {
      if (f.isDirectory()) {
        printClasses(f, packageName +"."+f.getName());
      } else {
        System.out.println(packageName +"."+f.getName());
      }
    }

  }
}


