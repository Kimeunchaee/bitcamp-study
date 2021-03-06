// 버퍼 사용 전 - 파일 복사 및 시간 측정
package com.eomcs.io.ex06;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Exam0310 {

  public static void main(String[] args) throws Exception {

    // 1바이트씩 읽는데 시간이 오래걸림
    // 출력하면 복사된 파일이 생김 (jls11_2 가 생겼다)
    FileInputStream in = new FileInputStream("temp/jls11.pdf");
    FileOutputStream out = new FileOutputStream("temp/jls11_2.pdf");

    int b;

    long startTime = System.currentTimeMillis(); // 밀리초

    while ((b = in.read()) != -1) {
      out.write(b);
    }

    long endTime = System.currentTimeMillis();

    System.out.println(endTime - startTime);

    in.close();
    out.close();
  }

}
