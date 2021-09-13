// 버퍼 사용 전 - 데이터 읽는데 걸린 시간 측정
package com.eomcs.io.ex06;

import java.io.FileInputStream;

public class Exam0110 {

  public static void main(String[] args) throws Exception {

    // 1바이트씩 파일을 읽는데 걸리는 시간
    FileInputStream in = new FileInputStream("temp/jls11.pdf");

    int b;

    long startTime = System.currentTimeMillis(); // 밀리초

    int callCount = 0;
    while ((b = in.read()) != -1) {
      callCount++; // 파일을 끝까지 읽는다.
    }

    long endTime = System.currentTimeMillis();

    System.out.println(endTime - startTime);        // 걸리는 시간
    System.out.println(callCount);                  // 몇번 읽었는지

    in.close();
  }

}
