package com.eomcs.pms;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import com.eomcs.pms.table.BoardTable;
import com.eomcs.pms.table.MemberTable;
import com.eomcs.pms.table.ProjectTable;
import com.eomcs.server.DataProcessor;
import com.eomcs.server.RequestProcessor;

public class ServerApp {

  public static void main(String[] args) throws Exception {
    System.out.println("[PMS 서버]");

    System.out.println("서버 실행중");
    ServerSocket serverSocket = new ServerSocket(8888);

    // RequestProcessor 가 사용할 DataProcessor 맵 준비
    HashMap<String,DataProcessor> dataProcessorMap = new HashMap<String,DataProcessor>();

    // => 데이터 처리 담당자를 등록한다.
    dataProcessorMap.put("board.", new BoardTable());
    dataProcessorMap.put("member.", new MemberTable());
    dataProcessorMap.put("project.", new ProjectTable());

    while (true) {
      Socket socket = serverSocket.accept();
      System.out.println("클라이언트 접속");

      // 1 ) 새 실행 흐름 생성
      RequestProcessor requestProcessor = new RequestProcessor(socket, dataProcessorMap);

      // 2) 새로 생성한 실행 흐름을 시작시킨다.
      // start 시키면 내부적으로 run()을 호출한다
      // requestProcessor 변수를 한번만 사용하니까 바로 객체에 넣을수 있다
      // RequestProcessor requestProcessor = new RequestProcessor(requestProcessor.start());
      // 시작시킨 후 즉시 리턴한다. 즉 새로 생성한 실행 흐름이 종료될때까지 기다리지 않는다
      requestProcessor.start();

    }

    //    System.out.println("서버 종료");
    //    serverSocket.close();
  }
}