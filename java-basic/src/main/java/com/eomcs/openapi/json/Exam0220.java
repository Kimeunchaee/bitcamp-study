// 배열 --> JSON 문자열 : 배열 값을 json 형식의 문자열로 만들기
// JSON 문자열 --> 객체 : 배열 다루기
package com.eomcs.openapi.json;

import com.google.gson.Gson;

public class Exam0220 {

  public static void main(String[] args) {

    String jsonStr = "[{\"no\":100,\"name\":\"홍길동\",\"email\":\"hong@test.com\",\"password\":\"1111\",\"photo\":\"hong.gif\",\"tel\":\"010-2222-1111\",\"registeredDate\":\"9월 16, 2021\"},{\"no\":101,\"name\":\"임꺽정\",\"email\":\"leem@test.com\",\"registeredDate\":\"9월 16, 2021\"},{\"no\":103,\"name\":\"안창호\",\"email\":\"ahn@test.com\",\"registeredDate\":\"9월 16, 2021\"}]";

    Member[] members = new Gson().fromJson(jsonStr, Member[].class);

    for (Member m : members) {
      System.out.println(m);
    }
  }
}

