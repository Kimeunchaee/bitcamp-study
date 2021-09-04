package com.eomcs.pms0903.pms.handler;

// 인터페이스
// 호출 명령을 execute로 통일한다 (핸들러의 메서드마다 바꿔주기)
public interface Command {
  void execute();
}
