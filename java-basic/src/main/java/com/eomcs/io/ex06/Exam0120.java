// 버퍼 사용 후 - 데이터 읽는데 걸린 시간 측정
package com.eomcs.io.ex06;

import java.io.FileInputStream;

public class Exam0120 {

  public static void main(String[] args) throws Exception {
    FileInputStream in = new FileInputStream("temp/jls11.pdf");

    // 8바이트씩 파일을 읽는데 걸리는 시간
    // 미리 메모리를 만들어 놓는다
    byte[] buf = new byte[8192]; // 보통 8KB 정도 메모리를 준비한다.
    // 더 메모리로 파일을 읽으면 시간은 단축될수 있지만
    // 자바는  여러개의 App이 동시에, 여러 이용자가 동시에 이용하는
    // 서비스를 제공하므로 (동시사용자가 이용하는 서비스)
    // 한명이 한번 실행할때 모든 메모리를 독차지하게 된다
    // 또한 연속되지않은 메모리는 찾는데도 시간이 더 걸릴 수 있다.

    int len = 0;

    long startTime = System.currentTimeMillis(); // 밀리초

    int callCount = 0;
    while ((len = in.read(buf)) != -1) {
      callCount++; // 파일을 끝까지 읽는다.
    }

    long endTime = System.currentTimeMillis();

    System.out.println(endTime - startTime);    // 시간
    System.out.println(callCount);              // 몇번 읽었는지
    in.close();
  }

}
