package com.eomcs.pms0722;

public class Test {

  // 배열에서 해당 항목의 값을 삭제한다.
  // 배열 뒤의 항목은 -1로 설정한다.
  // 배열을 출력할 때는 -1인 항목은 출력하지 않는다.

  static void deleteValue(int[] arr, int value) {

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
//  삭제할 데이터의 인덱스 이후의 값들을 앞으로 한칸씩 밀어주고
// 배열의 크기를 하나 감소시키면 된다.