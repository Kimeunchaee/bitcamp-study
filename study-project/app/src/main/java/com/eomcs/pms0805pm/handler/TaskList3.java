package com.eomcs.pms0805pm.handler;

import com.eomcs.pms0805pm.domain.Task;

//- 상속
//서브클래스의 공통필드들을 수퍼클래스로 정의한다


//extends ArrayList 상속 추가
public class TaskList3 extends ArrayList{



  public Task findByNo(int no) {

    // 수정
    Object[] arr = toArray();
    for(Object obj : arr) {
      Task task = (Task) obj; //형변환 미리선언
      if(task.no == no) { 
        return task;
      }
    }
    return null;
  }




}
