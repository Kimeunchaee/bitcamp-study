// 인스턴스 메서드와 클래스 메서드의 활용 - Calendar 클래스
package com.eomcs.oop.ex04;

import java.util.Calendar;

public class Exam0250 {
  public static void main(String[] args) throws Exception {
    // Calendar 클래스의 생성자는 protected로 접근이 제한되어 있기 때문에
    // 다른 패키지에서 직접 생성자를 호출할 수 없다.
    //Calendar c = new Calendar(); // 컴파일 오류!

    // 오늘 날짜 및 시간 정보를 저장한 객체를 만들어 리턴한다.
    // 달력은 그레고리안 달력을 사용한다.
    Calendar c = Calendar.getInstance();
    //* getInstance 메서드를 호출하는 순간 년월일요일시분초 등 세팅된 값들이 자동으로 호출된다(== 초기값인 생성자가 호출된다)

    // 인스턴스 메서드 활용
    //* get 인스턴스 메서드
    System.out.println(c.get(1)); // 년도
    System.out.println(c.get(2) + 1); // 월(0 ~ 11) //*0부터 시작되기때문에 +1를 해줘야함
    System.out.println(c.get(5)); // 일
    System.out.println(c.get(7)); // 요일(1 ~ 7) = 1일,2월,3화,4수....
    System.out.println(c.get(4)); // 그 달의 몇 번째 주
    System.out.println(c.get(10)); // 시(0 ~ 11)
    System.out.println(c.get(11)); // 시(24시)
    System.out.println(c.get(12)); // 분
    System.out.println(c.get(13)); // 초

    System.out.println("-----------------------");


    // *get(1) 은 년도, get(7)을 요일 등등 숫자를 모두 기억하기 힘들기때문에
    // *숫자를 미리 변수에 저장해놓은(이미 스태틱변수로 정의되어있음) 변수이름으로 작성함
    // 상수의 활용
    System.out.println(c.get(Calendar.YEAR)); // 년도
    System.out.println(c.get(Calendar.MONTH) + 1); // 월(0 ~ 11)
    System.out.println(c.get(Calendar.DATE)); // 일
    System.out.println(c.get(Calendar.DAY_OF_WEEK)); // 요일(1 ~ 7)
    System.out.println(c.get(Calendar.WEEK_OF_MONTH)); // 그 달의 몇 번째 주
    System.out.println(c.get(Calendar.HOUR)); // 시(0 ~ 11)
    System.out.println(c.get(Calendar.HOUR_OF_DAY)); // 시(24시)
    System.out.println(c.get(Calendar.MINUTE)); // 분
    System.out.println(c.get(Calendar.SECOND)); // 초



    int year = c.get();

    System.out.println(c.get(Calendar.YEAR));
  }
}





