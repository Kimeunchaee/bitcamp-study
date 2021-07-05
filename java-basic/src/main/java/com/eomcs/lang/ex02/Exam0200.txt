// JAVA 프로그래밍 주석 = 컴파일할때 무시됨
// 1. 일반 주석     :   //
// 2. 여러줄쓸땐   : /* */ 
// 3. 한줄쓸땐      :  //



package com.eomcs.lang.ex02;

@author eomjinyoung 
 public class Exam0200 {
     //변수 선언 앞에 설명
        public static String message = "Hello, world!";
         
         //메소드 앞에 설명
         @param args
        public static void main(String[] args) {
        System.out.println(message);
  }

}

// javadoc 디렉토리를 직접 만들어야하는지 자동으로 생성되는지?
// 명령어 작성하면 doc디렉터리가 생성된다
// 바로 문서(html)로 추출하는 명령어이기때문에 클래스만들필요x(=컴파일x)

// javadoc -encoding utf-8 -charset utf-8 -d javadoc -sourcepath src/main/java com.eomcs.lang.ex02
//       -encoding utf-8 (문자집합)
//       -charset utf-8 (문자집합)
//       -d javadoc (생성된 파일을 놓아둘 디렉토리) / javadoc 이라는 폴더가 생성됨
//       -sourcepath src/main/java (자바 소스 경로만)
//       -com.eomcs.lang.ex02 (맨뒤에는 패키지명 적어주기)

