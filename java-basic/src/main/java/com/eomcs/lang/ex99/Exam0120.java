package com.eomcs.lang.ex99;

//# 콘솔로 출력하기 II - 특정 형식을 갖춘 문자열 안에 값을 삽입하여 출력하기
//
public class Exam0120 {
  public static void main(String[] args) {

    System.out.print(01);
    System.out.println();
    System.out.println(01);
    System.out.print("01\n");

    // printf("출력 서식" , 출력할 내용)
    // \n 줄바꿈
    // %s : 문자열 삽입 (삽입할 문자열은 오른쪽에 작성)
    System.out.printf("이름 : %s\n", "홍길동");
    System.out.printf("나이 : %s\n", "만 21세");

    System.out.printf("%d\n", 65);  // %d : 정수를 10진수 문자열로 삽입
    System.out.printf("%x\n", 65);  // %x : 정수를 16진수 문자열로 삽입
    System.out.printf("%c\n", 65);  // %c : 정수를 문자로 삽입
    System.out.printf("%b\n", true);  // %b : true/false 값을 문자열로 삽입
    System.out.println();
    // 한번에 작성할수 있다 (출력할 내용은 순서대로 적용됨)
    System.out.printf("%d %x %c %b\n", 65,90,65,true);

    // 값의 순서 지정 %[n$]s
    System.out.printf("%2$d %1$x %1$c %3$b\n", 164, 65, false);

    // 사용할 공간 지정 0으로 시작 
    System.out.printf("'%05d' '%09d'\n", 88, 564);  // 0이 없고 공백으로 처리됨
    System.out.printf("'%+05d' '%09d'\n", 88, 88);

    // 자리수 지정은 기본으로 오른쪽정렬 (0이 없으면 공백으로 처리됨)
    System.out.printf("%4d\n",1);
    System.out.printf("%4d\n",10);
    System.out.printf("%4d\n",100);
    System.out.printf("%4d\n",1000);

    // 자리수 지정 후 -를 붙히면 왼쪽정렬
    System.out.printf("%-4d\n",1);
    System.out.printf("%-4d\n",10);
    System.out.printf("%-4d\n",100);
    System.out.printf("%-4d\n",1000);




  }
}
















