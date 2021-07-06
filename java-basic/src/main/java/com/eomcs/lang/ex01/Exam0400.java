package com.eomcs.lang.ex01;

// main() 메소드의 내용은 뒤에 있는 {}이다
// {} 안의 내용을 컴파일(javac)후 실행(java)시킬때
// JVM이 main() 메소드의 내용을 실행시키기때문에
// main()메소드없어도 소스파일에서 클래스 생성은 되지만
// main()메소드가 없기때문에 클래스파일을 실행할때(java -cp)오류가 발생한다
// main()메소드는 필수로 작성!


public class Exam0400{
    public static void main(String[] args){

    }
}

//JVM 실행 : java -cp bin/main com.eomcs.lang.ex01.Exam0400
// 입력하면 결과가 보임 (공백)