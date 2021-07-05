package com.eomcs.lang.ex99;

//# 콘솔로 출력하기 III - 형식을 갖춰서 날짜 값 출력하기 
// 
public class Exam0130 {
  public static void main(String[] args) {

    //자바 데이터를 가져와 정보 생성
    java.util.Date today = new java.util.Date();

    // 년도 : 4자리 tY , 2자리 ty
    System.out.printf("%1$tY, %1$ty\n", today);

    // 월 : 긴이름 tB , 짧은이름 tb , 숫자 tm (한글은 상관x)
    System.out.printf("%1$tB, %1$tb %1$tm\n",today);

    // 일 : 2자리 td , 1자리 te
    System.out.printf("%1$td %1$te\n",today);

    // 요일 : 긴이름 tA , 짧은이름 ta 
    System.out.printf("%1$tA %1$ta\n",today);

    // 시간 : 24시간 tH , 12시간 tI
    System.out.printf("%1$tH %1$tI\n",today);

    // 분 : tM
    System.out.printf("%1$tM\n",today);

    // 초 : 초 tS , 밀리초 tL , 나노초 tN
    System.out.printf("%1$tS %1$tL %1$tN\n",today);

    // 오전,오후 : am pm = tp , AP PM = Tp , 한글은 의미X
    System.out.printf("%1$tp %1$Tp\n",today);

    // 년-월-일-요일 시:분:초:오전오후 출력
    System.out.printf("%1$tY-%1$tB-%1$td"+"일"+"-%1$tA\n %1$tH : %1$tM : %1$tS : %1$tp",today);

  }
}
















