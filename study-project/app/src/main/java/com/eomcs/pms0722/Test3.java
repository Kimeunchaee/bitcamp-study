package com.eomcs.pms0722;

public class Test3 {

  // 배열에서 해당 항목의 값을 삭제한다.
  // 배열 뒤의 항목은 -1로 설정한다.
  // 배열을 출력할 때는 -1인 항목은 출력하지 않는다.

  static void deleteValue(int[] arr, int value) {

    // i를 위에 선언 = for문 밖에서도 어디서든지 변수를 사용할 수 있음
    //int deleteIndex = -1;

    int i;

    for (i = 0; i < arr.length; i++) {
      if (arr[i] == value) {
        break;
      }
    }
    if (i == arr.length) { //i값이 배열의 길이와 같다 = 반복문을 실행했을때 끝까지 일치하는 값을 찾지 못했다
      return;
    }
    for(i++; i < arr.length; i++ ) {
      // i++ 는 찾은값(i)보다 하나 큰거
      arr[i-1] = arr[i];
    }
    arr[arr.length-1]= -1;

  }

  public static void main(String[] args) {
    int[] arr = {100, 200, 300};
    deleteValue(arr, 200);

    for (int value : arr) {
      if (value == -1)
        break;
      System.out.println(value);
    }
  }
}