package com.eomcs.pms0805pm.handler;

import com.eomcs.pms0805pm.domain.Project;

//- 상속
//서브클래스의 공통필드들을 수퍼클래스로 정의한다


//extends ArrayList 상속 추가
public class ProjectList3 extends ArrayList{

  // 수퍼클래스에서 사용하는 메서드들 지워주기
  public Project findByNo(int no) {

    // 수정
    Object[] arr = toArray();
    for(Object obj : arr) {
      Project project = (Project) obj; //형변환 미리선언
      if(project.no == no) { 
        return project;
      }
    }
    return null;
  }
}








