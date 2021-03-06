package com.eomcs.oop.ex07.b;

public class BubbleSort {
  public void run(int[] values) {

    //전채배열이 15개면
    // 14번 반복시켜서 실행하면
    // 원하는 결과값을 얻을수 있음

    int size = values.length;

    for (int i = 0; i < size - 1; i++) {
      for (int j = 0; j < size - i - 1; j++) {
        if (values[j] > values[j + 1]) {
          //System.out.printf("%d <==> %d\n", values[j], values[j + 1]);
          int temp = values[j];
          values[j] = values[j + 1];
          values[j + 1] = temp;
        }
      }
    }
  }
}
