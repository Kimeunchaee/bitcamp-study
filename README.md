# bitcamp-study

## 1일차
2021.06.28 월

- 교육의 목표 : 웹 개발자 역량 습득

- 소프트웨어 개요
    - System S/W , Application S?W
    - Standalone, Client/Server
- Web Application
    - Back-end (Server언어)
        - Java Application을 작성할때 사용되는 기술
        - Web Server 실행
    - Front-end (Client언어)
        - HTML/CSS/JavaScript 기술 개요
        - Web Browser 실행

- 프로그래밍 준비
    - git : 온라인저장소, 원격 저장소
    - github.com 계정 생성
    - github.com 개인 저장소(repo.) 생성
    - git client : git-scm.com 다운로드 CLI 사용
    - git token : 서버 업로드를 위한 개인사용자만의 암호 발급

## 2일차
2021.06.29 화

- <git 명령어> git 저장소 다루기
    - 새폴더 만들기
        `mkdir 파일명`
    - 서버저장소를 로컬저장소로 복제
        `git clone URL`
    - 서버저장소에서 변경사항이 생긴 후 파일 가져오기
        `$ git pull`
    - 로컬저장소에서 서버저장소로 백업
        `$ git config --global user.email "email.@"` / `$ git config --global user.name "name"` :사용자 계정과 로컬저장소를 연결
        `$ git add .` : 수정,삭제 등 변경된 내용을 찾아서 백업할 명단이 작성됨
        `$ git commit -m "백업설명"` : 백업내용과 함께 파일 백업
        `$ git push` / `username : 이름입력` / `token : 암호입력` : 백업 내용을 서버에 업로드

- 프로그래밍 원리
    - 프로그래밍 : 다양한 언어를 사용해 명령어를 작성하는것.
    - Compile
        c,c++언어를 사용해 명령어를 작성 후 기계어로 번역시키는 과정
        기계어를 CPU가 인식한 후 OS환경에 맞게 로딩후 명령어가 처리된다.
        소스파일(c언어사용)작성 > 확장자 : 파일명.c > `$ gcc 파일명`
    - Interpreter
        JavaScript, PHP, Python 등의 언어를 사용해 명령어를 작성 후 인터프리터 프로그램으로 로딩되어 OS에 실행
        소스파일(JavaScript언어사용)작성 > 확장자 : 파일명.js > `$ node 파일명.js`

- 도구 준비
     - VS Code 편집기 설치
     - c,c++ 컴파일러 설치 : c,c++언어로 작성된 코드를 컴파일해준다. MinGW 사용
     - Node.js 설치 : JavaScript 언어로 작성된 코드를 인터프리터한다.

## 3일차
2021.06.30 수

- 프로그래밍 원리
    - 프로그래밍 (2일차참고)
    - Compile (2일차참고)
    - Interpreter (2일차참고)
    - Hybird
        JAVA언어로 작성된 소스파일이 가상기계어(p-code)로 번역되고 class파일이 생성되는 컴파일 과정 후,
        JVM을 통해 로딩되어 OS에 실행되는 인터프리터방식이 함께 진행되는것을 하이브리드 방식이라고 한다.
        소스파일(JAVA언어사용)작성 > 확장자 : 파일명.java > `$javac -encodig utf-8 -d 클래스저장경로 소스파일경로/파일명.java` > 컴파일 후 .class 파일 생성됨
        클래스 파일을 JVM(실행)시켜주기 > `$ java -classpath (= -cp) class파일위치 소스파일위치.파일명(확장자X)`

- Java 11 JDK 설치
    - JAVA_HOME 환경 변수 설정
    - PATH 변수 설정

- Project 
    - Application과 프로젝트 관계
        - Project : Application에 있어서 최소의 관리단위
    - git 저장소에서 프로젝트 관리
        - 저장소 구조
            - 1단계 : 소스파일과 .class파일을 구분하지 않는다 (git repo. = project)
            - 2단계 : src 폴더와 bin 폴더를 사용하여 소스파일과 .class파일을 구분한다.
            - 3단계 : 프로젝트 규모가 커짐에 따라 소스파일 이외의 다른파일의 저장소가 필요 (Maven 프로젝트 표준 디렉토리 구조)
            - 4단계 : 큰 프로젝트 하나에 여러 프로젝트가 구성되어 있는 구조

- git 저장소에 백업
    - 폴더가 생성되어 있어도 폴더 안에 비어있으면 백업되지 않기때문에 빈폴더에 파일경로을 적은 `README.md` 파일을 만들어서 저장해준다.
    - class파일은 공유하지 않기 때문에 `.gitignore` 파일을 생성해서 백업 제외 대상을 작성해준다. ( 폴더명/ , *파일명)

- Naver D2 coding font 
    주석에 한글 사용시 글자마다 크기가 약간씩 다르므로 정렬이 잘 맞지 않을때가 있다.
    또한 알파벳 대소문자 O,o 숫자 0 등 구분한기 어려운 문자의 가독성을 높히기 위해 코딩 전용 폰트를 설치해준다.
    D2Coding 다운로드 및 설치 후 > VS code 에서 FontFamily 에 D2Coding 을 입력해서 추가

## 4일차
2021.07.01 목

- 프로젝트 관리
    - Project : 가장 큰 프로젝트이자 저장소명이 될 수도 있다
    - 하위 Root Project
    - 하위 Sub Project
    - 하위 Task : 가장 작은 단위의 작업

- 빌드 도구
	- 다양한 빌드 도구: Ant, Maven, Gradle
	- Gradle 빌드 도구를 이용하여 프로젝트 폴더 준비
    - 다움로드 및 설치 후 > PATH 변수 설정 > `$ gradle -v` 현재 설치된 버전을 확인 > `gradle init` 프로젝트 폴더 구성 명령어 입력
    - 명령어 입력 의미 및 순서
        프로젝트 유형 : 2. Appp
        프로그래밍 언어 : 3. Java
        루트프로젝트 아래 생성할 서브프로젝트 개수 작성
        빌드 스크립트 : 1. Groovy
        단위테스트 : 1. Junit4
        프로젝트명 작성 (디폴트값이 폴더이름=프로젝트이름 이므로 엔터쳐도 가능)
        패키지명 작성 (디폴트값 사용하려면 엔터) 

- Gradle 빌드 도구 사용법
	- 빌드 스크립트 파일의 용도
		- settings.gradle : 여러 프로젝트에 공통으로 적용할 설정 정보
		- sub/build.gradle : 서브 프로젝트에만 적용하는 빌드 설정 정보
	- Gradle 기본 작업
		- `init` : 현재 폴더를 프로젝트 폴더로 구성
		- `wrapper` : Gradle 설치 및 실행 파일 생성
		- gradle에 플러그인을 장착하면 더 많은 작업을 수행할 수 있다.

- 'java' gradle 플러그인  
	- `compileJava`
		- src/main/java 폴더에 있는 소스 파일이 모두 컴파일
		- build/classes/java/main 폴더에 .class 파일생성
	- `compileTestJava`
		- src/test/java 폴더에 있는 소스 파일이 모두 컴파일
		- build/classes/java/test 폴더에 .class 파일생성
	- `processResources`
		- src/main/resources 폴더에 있는 파일을 build/resources/main 폴더에 복사
	- `processTestResources`
		- src/test/resources 폴더에 있는 파일을 build/resources/test 폴더에 복사
	- `clean`
		- build 폴더를 삭제
	- `classes`
		- compileJava와 processResources를 한번에 수행
	- `testClasses`
		- classes + compileTestJava + processTestResources 한번에 수행
	- `check`
		- test + 단위 테스트 수행
	- `javadoc`
		- 소스 파일에서 javadoc 주석을 추출하여 HTML된 API 문서를 생성한다.
	- `build`
		- check + assemble(배포파일 생성) 수행

- 'application' gradle 플러그인  	
	- `run`
		- 'java' 플러그인의 classes 작업을 먼저 실행 후
		- application 설정에 지정한 클래스를 실행시킨다.
	- `build`
		- 이 플러그인을 장착한 상태에서 build 작업을 수행하면 고객에게 배포할 수 있는 파일을 build/distributions 폴더에 생성한다.
		- 자바 프로그램을 실행시킬 수 있는 스크립트 파일도 자동 생성된다.

## 5일차
2021.07.03 금

- Eclipse 설치
	- eclipse.org 에서 다운로드 및 설치
    - eclipse IDE : 확장이 용이한 개발툴
    - JDT : 자바 개발 도구
    - WTP : 자바 웹개발 도구

- Eclipse IDE 환경 설정
    - 이클립스 실행 할 때 workspace 폴더 경로 선택 
    - workspace 설정 (워크스페이스 폴더 마다 설정)
        - 메뉴 / Windows / Preferences 클릭
        - General/Workspace
            - Text file encoding을 UTF-8로 설정
            - New text file line delimiter를 Unix 방식으로 설정
        - Java/Code Style/Formatter
            - Eclipse java google style 포맷터 다운로드
            - https://github.com/google/styleguide/blob/gh-pages/eclipse-java-google-style.xml
            - Active profile 에서 구글 스타일 포맷터 임포트하기
        - Java/Installed JRE
            - JDK 홈 폴더가 등록되어 있지 않았다면 추가
        - Web
            - CSS Files : Encoding을 UTF-8로 설정
            - HTML Files : Encoding을 UTF-8로 설정
            - JSP Files : Encoding을 UTF-8로 설정

- Eclipse IDE 관련 작업
    - `eclipseProject` : .project 파일 생성
    - `eclipseClasspath` : .classpath 파일 생성
    - `eclipseJDT` : JDT 관련 파일 생성
    - `eclipse` : = eclipseProject + eclipseClasspath + eclipseJDT 파일 생성
    - `cleanEclipseProject` =  .project 파일 제거
    - `cleanEclipseClasspath` = .classpath 파일 제거
    - `cleanEclipseJDT` =  JDT 관련 파일 제거 (.setting 폴더는 없어지지 않지만 안에 내용은 다 제거됨)
    - `cleanEclipse` =  eclipseProject + eclipseClasspath + eclipseJDT 파일 한번에 제거
    - 이클립스 관련 파일은 각자 개발환경(툴)에 맞춰서 필요한걸 생성해야하기때문에 공유x = 백업x
    - .gitignore 에 관련 파일 백업하지 않도록 추가해주기 ( 폴더명/ , *파일명)

- Eclipse 프로젝트 이름을 설정하기
    - 이클립스는 .project 가 생성될때 build.gradle를 가진 폴더를 프로젝트 이름으로 인식해서 자동 생성시킨다
    - 프로젝트 이름과 파일이름을 다르게 만들어주기위해 eclipse 프로젝트 이름을 설정하는 명령어를 작성해준다
    - eclipse {
         project {
             name = 'study-project'
         }   
     }

- Eclipse로 프로젝트 폴더를 가져오기 
    - File > Import > General > Existing projects into Workspace > Select root directory에서 디렉토리 선택
    - 프로젝트 폴더에 eclipse 용 프로젝트 정보 파일(.project / .settings / .classpath)이 있어야만 임포트 할 수 있다.
        - .project 파일 : 프로젝트 정보를 담은 파일, 프로젝트 및 메뉴를 설정
        - .settings/ : Eclipse IDE의 플러그인 설정 파일이 들어 있는 폴더
        - .classpath 파일 : 자바 라이브러리 파일의 경로 정보
    - eclipse 정보 파일이 없을 떄
        - Gradle 도구를 이용
            - 1) build.gradle 파일의 plugins {} 안에 id 'eclipse' 플러그인 추가
            - 2) 터미널에서  `gradle eclipse` 실행한다.
            - 3) .settings/, .classpath, .project 등이 생성된다. 

- <git 명령어> git 저장소 연결 방법
    - 1. 서버저장소 생성 후 복제
        - gitgub에서 repo. 생성 후 `$ git clone URL` 하면 로컬저장소에 복제됨
    - 2. 로컬저장소 생성 루 서버저장소에 연결
        - 2-1) 새폴더 생성 후 `$ git init` 하면 repo. 성질을 가진 폴더로 변경됨 (= .git폴더 생성됨)
        - 2-2) github 에서 repo. 생성하면 서버저장소가 만들어짐
        - 2-3) 로컬저장소와 서버저장소 연결시키기
            - `git remote` : 서버저장소 위치 확인
            - `git remote -v` : 서버저장소 위치와 서버저장소 (URL) 확인
            - `git pull origin main` : git pull 저장소위치 브랜치이름
            -  `git branch --set-upstream-to=origin/main main`
    - 3. 각각 다른 히스토리를 갖고 있는 로컬과 서버를 연결 시킬때 
        - `git pull origin main --allow-unrelated-histories`

- <git 명령어> git 기록 확인
    - `git log` : 기록을 보여줌
    - `git log --oneline` : 최종기록을 한줄로 보여줌
    - `git log --oneline --all` : 최종기록을 한줄로 모두 보여줌
    - `git log --oneline --all --graph` : 기록을 한줄로 모두 그래프형식으로 보여줌

- Package , Class
    - java-basic/ex01 참고
        - 패키지 : 클래스가 소속된 폴더 (클래스의 이름 충돌을 방지)

        - 클래스 : 같은 이름의 클래스 사용 가능 (구분하기 위해 패키지 사용)

        - 소스 파일 : 소스파일 찾고 관리하기 쉽도록 패키지와 일치하는 폴더에 둔다.

        - 클래스 파일(.class) : 패키지 이름과 같은 폴더에 .class 파일이 생성

        - 경로 작성 방법
            - 패키지 하위에 소스파일
                - java -encoding utf-8 -cp bin/main/com/eomcs/lang Hello3
                - Hello3 가 패키지에 소속되어있기 때문에 패키지명, 클래스파일 이름을 따로 적어줘야함
            - 패키지 하위에 루트패키지, 소스파일
                - java -encoding utf-8 -cp bin/main com.eomcs.lang.Hello3 
                - 한칸띄고 Hello3가 소속된 패키지명을 작성해줌 (-cp 경로와 구분하기 위해 /가 아닌  . 사용)
            - 무소속 패키지
                - javac -encoding utf-8 -d bin/main src/main/java/com/eomcs/lang/Hello4.java
                - 무소속 패키지는 Hello4.java 파일이 com/eomcs/lang폴더에 있더라도 bin/main에 클래스가 생성됨


    - 자바 기초 문법 예제 (eomcs-java)
        - ex01
            - 패키지 다루기
            - 자바 소스 파일과 클래스 블록
            - 소스 파일의 인코딩
            - main() 메서드
        - ex02
            - 여러 줄 주석, 한 줄 주석
            - javadoc 주석
            - 애노테이션

## 6일차
2021.07.05
- 콘솔로 출력하기
    - `System.out.`
        - System = 시스템
        - out = JVM의 표준출력장치 콘솔

    - 작성문법
        - System.out.println(정수);
        - System.out.println('문자');
        - System.out.println("문자열");
        - System.out.println(변수명);
        - System.out.println("문자열"+변수명);
        - System.out.println(논리);
            - System.out.println(true);
            - System.out.println(false);
        

    - * 이클립스에서 'sysout' 이라고 입력 후 'ctrl+space'를 누르면 System.out.println()이 자동 입력된다.

    - print() = 출력만
        - `System.out.print(" ");`

    - println() = 출력 + 줄바꿈
        - `System.out.println(" ");` : 값을 주지 않으면 줄바꿈만 수행한다.
        - '\n' 이스케이프 문자도 줄바꿈을 수행한다.  /출력제어 문자 7일차 참고
        - `System.out.print('\n');`   =println 이랑 같은 역할

    - printf() = 출력 + 포맷(형식)
        - `System.out.printf("출력 서식" , 출력할 내용);`
        - 특정 형식을 갖춘 문자열안에 값을 삽입할때는 printf(); 를 사용
        - 형식을 지정하지 않으면 print();와 같은 역할
        
        - 형식을 갖는 값
            - 삽입할 값은 오른쪽에 설정한다.
            - `%s` : 지정한 자리에 오른쪽 문자열을 삽입한다.
            - `%d` : 정수 값을 10진수 문자열로 만들어 삽입한다.
            - `%x` : 정수 값을 16진수 문자열로 만들어 삽입한다.
            - `%c` : 정수 값을 문자로 만들어 삽입한다.
            - `%b` : true/false 값을 문자열로 만들어 삽입한다.
            
        - 삽일될 값의 순서 :
            - %[n$]s : n은 문자열에 삽입될 값의 순서이다. 순서는 1부터 증가한다. (대괄호 [n$]는 생략해도 된다는 뜻 = %n$s)
            - 첫번째 값과 두번째 값, 세번째 값 ... 이 모두 같을땐 첫번째 값만 작성한다.
            - 한 개의 값을 여러 곳에 삽입할 수 있다는 뜻이다.
            - ex) `("%2$d %2$x %2$c\n", 65, 66, 67);` 일때 65=1$, 66=2$, 67=3$ 을 의미함.
            - ex) `("%d %x %c\n", 65);` 일때 모든 문자열에 첫번째 값이 삽입됨.

        - 값을 삽입할 때 사용할 공간 지정 :
            - 문자열을 삽입할 때: `%[-][사용할공간너비]s` : -(마이너스)는 왼쪽 정렬이다. 안 붙이면 기본 오른쪽 정렬이다.
            - `System.out.printf("'%-10s' '%10s'\n", "홍길동", "임꺽정");`
            - `System.out.printf("'%-10d' '%10d'\n", 12345, 12345);`
            - `%-10s` : 왼쪽정렬 후 전체10자리를 확보하고 지정한 자리에 문자열을 삽입하라 그 후 줄바꿈 하라

        - 정수 자릿수 지정(0을 사용한다):
            - %[0][사용할공간너비]d : 앞의 빈자리는 0으로 채운다.
            - %[+][0][사용할공간너비]d : +는 숫자 앞에 부호를 붙인다.
            - `System.out.printf("'%010d' '%07d'\n", 12345, 12345);`
            - `System.out.printf("'%+010d' '%+07d'\n", 12345, -12345);` 
            - * %010d : 오른쪽정렬(기본)이고 전체 10자리를 확보하고 빈자리는 0으로 채우고 정수 값을 10진수 문자열로 만들어 삽입하라

        - 날짜 값 표기할때 :
            - java.util.Date today = new java.util.Date(); 패키지명으로 지정
            - 날짜 및 시간 옵션 (날짜 및 시각 데이터에서 ~추출) :
                - tY : 년도를 추출하여 4자리로 표현
                - ty : 년도를 추출하여 뒤의 2자리로 표현
                - System.out.printf("%1$tY, %1$ty\n", today);

                - tB : 월을 추출하여 전체 이름으로 표현 ex) January
                - tb : 월을 추출하여 단축 이름으로 표현 ex) Jan
                - System.out.printf("%1$tB, %1$tb\n", today);

                - tm : 월을 추출하여 2자리 숫자로 표현 ex) 12, 01
                - System.out.printf("%1$tm\n", today);

                - td : 일을 추출하여 2자리 숫자로 표현 ex) 01, 22
                - te : 일을 추출하여 1자리 숫자로 표현 ex) 1, 22
                - System.out.printf("%1$td %1$te\n", today);

                - tA : 요일을 추출하여 긴 이름으로 표현 ex) Sunday
                - ta : 요일을 추출하여 짧은 이름으로 표현 ex) Sun
                - System.out.printf("%1$tA %1$ta\n", today);

                - tH : 시각을 추출하여 24시로 표현
                - tI : 시각을 추출하여 12시로 표현
                - System.out.printf("%1$tH %1$tI\n", today);

                - tM : 시각을 추출하여 분을 표현
                - System.out.printf("%1$tM\n", today);

                - tS : 시각을 추출하여 초를 표현
                - tL : 시각을 추출하여 밀리초를 표현
                - tN : 시각을 추출하여 나노초를 표현
                - System.out.printf("%1$tS %1$tL %1$tN\n", today);

                - tp : 오전 오후 출력하기
                - 소문자 p를 사용하면 am 또는 pm으로 출력 
                - 대문자 P를 사용하면 AM 또는 PM으로 출력
                - 한글은 대소문자가 없기 때문에 의미없다.
                - System.out.printf("%1$tp\n", today);

                - 년-월-일 시:분:초를 출력하라! 예) 2019-01-04 12:04:30
                - System.out.printf("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", today);

- Literal
    - 리터럴 : 자바 언어로 표현한 값
    - 정수 : 2진수, 10진수, 8진수 16진수 ...
        - 1. 정수 > 2진수
            - 부호 절댓값 방식 : 2진수 맨 앞을 부호비트로 0은 양수, 1은 음수로 표현함
                                 (1로 시작하는 2진수를 구별할수 없게된다.)
            - 1의 보수 : 각각의 비트를 0은 1로, 1은 0으로 바꿔서 구하는것, 자리수의 수와 보수를 더하면 해당 진수의 자리 올림이 발생하고
                         해당자릿수는 0이 되도록 한다.
                         (-8 같은 자리올림이 발생하지 않는 2진수를 표현할 수 없다.)
            - 2의 보수 : 음수의 절댓값을 2진수로 구하기 > 2진수의 1의보수 구하기 > 계산한 1의 보수에 +1하기
                         양수 2진수에서 가장 오른쪽의 0에서 처음으로 나오는 1까지 그대로 두고 나머지를 1의 보수로 바꾸기

            - 2진수 덧셈
                - : 일반적인 덧셈방법으로 계산한다. 비트를 넘어가는 올림수는 무시
            - 2진수 뺼셈
                - : 연산을 수행하는 cpu(중앙처리장치)의 연산장치에는 가산기, 보수기, 시프터, 오버플로 검출기, 레지스터가 있다.
                - 덧셈에 필요한 가산기는 있지만 뺄셈에 필요한 감산기를 찾아볼 수가 없다.
                - 음의 정수를 덧셈으로 계산하기 위해 2의 보수를 이용해서 계산해준다.
    
    - System.out.println(정수);
        - 정수삽입 : 2진수,8진수,10진수,16진수 등으로 작성 가능, 결과값은 10진수로 표현된다.
        - 문자삽입 : 숫자 맨 앞 또는 맨 뒤에 삽입할수 없다. ex) (_1234)
        - 10진수 : 정수값 표현, 일반적으로 사용
            - System.out.println(78);
            - System.out.println(-78);
            - System.out.println(+78);
            - 결과값 78,-78,78

        - 8진수 : 0으로 시작, 코드 작성할땐 잘 사용하지 않음
            - System.out.println(0116);
            - 결과값 78

        - 16진수 : 0x 또는 0X 로 시작, 2진수를 간결하게 표현하기 위해 사용
            - System.out.println(0x4e);
            - System.out.println(0x64);
            - System.out.println(0x064); //0이 앞에 있어도 된다
            - 결과값 78

        - 2진수 : 0b 또는 0B 로 시작, 메모리 상태를 직설적으로 보여줄때 사용
            - System.out.println(0b01001110);
            - 결과값 78

    - 값과 메모리 크기
        - 2bit = 2² -1 = 0~3까지 표현가능
        - 4bit = 2⁴ -1 = 0~15까지 표현가능 

    - 2진수와 하드디스크,램 구동,작동원리 등
        - 하드디스크 구동원리 : 자성 물질로 덮인 플래터를 회전시키고, 그 위에 헤드(Head)를 접근시켜 플래터 표면의 자기 배열(sn/ns)을 변경하는 방식으로 데이터를 읽거나 쓴다.
        - 하드디스크, 램 등은 off(0)와 on(1)의 두 상태밖에 구별되지 않기 때문에 2진법을 사용해 데이터를 읽고 저장시킨다.



## 7일차
2021.07.06

- 이클립스 오류났을 때
        - gradle.build 에서 이클립스설정파일들을 자동생성하라고 세팅된 명령과 이클립스에서 새로 파일을 만들었을때 자동으로 생긴 이클립스설정 파일들이 부딪혀서 먹통이 되거나 오류가 생김
        - 이클립스,파일탐색기 등 종료 후 > 해당 폴더 gradle cleanEclipse (또는 직접 setting,project,classes 폴더를 삭제해준다) > 다시 gradle eclipse

- Literal
    - 실수 : 3.14 , 3.14e ...
        - 고정소수점 :  소수점의 위치를 기준으로 정수부와 실수부로 구분한다. 
        - 부동소수점 :  소수점의 위치가 지수부, 유효자릿수를 가수부로 구분한다.
            - 자료형 전체(=유효자릿수)가 가수부가 되고 소수점 위치로 지수부를 구분한다. (지수부 크기에 따라 소수점의 위치가 바뀐다.)
            - 실수 값을 부동소수점 방식으로 저장하려면 1과 0으로(2진수) 변환해야 한다. 이때 IEEE 754 명세에 따라 2진수로 변환한다.
            - 유효자릿수의 범위의 부동소수점을 2진수로 변환하면 최소의 오차로 값을 지정할수 있기때문에 2진수 변환을 사용한다.
            - 표현범위가 고정소수점에 비해 크다.
            - 결과값에 오차가 발생한다.

            - Exponential 기호 사용하기
                - e 기호를 사용하면 소수점의 위치를 조정할 수 있다.
                - 소수점의 위치를 움직인다고 해서 "부동소수점(floating point)"이라 부른다. 
                - System.out.println(0.0314e2); // 0.0314 * 10의2승 = 3.14
                - System.out.println(31.4e-1); // 31.4 * 10의-1승 = 3.14

            - 4바이트(32비트)
                - 단정도(single-precision)
                - 유효자릿수 : 7~8자리 (7까지 가능/유효자릿수가 8자리를 넘어가는 경우 값이 잘려서 저장될 수 있다.)
                - 7자리 숫자 맨앞에 0일때는 0을 제외시킨다.

                - 숫자 맨 뒤에 f 또는 F를 붙인다. (주로 소문자 f사용)
                - System.out.println(3.14f);

            - 8바이트(64비트)
                - 배정도(double-precision)
                - 유효자릿수 : 16자리 (15까지 가능/유효자릿수가 16자리를 넘어가는 경우 값이 잘려서 저장될 수 있다.)
                - 16자리 숫자 맨앞이 0일때는 0을 제외시킨다.
                - 숫자 맨 뒤에 d 또는 D를 붙인다. 생략도 가능
                - System.out.println(3.14d); 

        - 클래스 파일로 부동소수점 값 확인하기
            - 실행결과는 10진수로 보이지만 컴퓨터에 컴파일된 내용은 (classes 파일을 확인해보면)
              2진수에서 16진수로 바뀌여서 표현되어 있다. 2진수가 너무 길기 때문에)
            - Exam35.class 파일을 hexdump 플러그인으로 출력한다.
            - 12.375의 2진수 값인 0100_0001_0100_0110_0000_0000_0000_0000을 찾아본다.
            - 보통 에디터에서는 2진수를 16진수로 바꿔 보여주기 때문에 16진수 값 0x41460000을 찾아본다.

    - 문자 : 문자를 2진수로 바꾸는 규칙을 "문자집합(Character Set)"이라 한다.
        - 문자집합 종류
            - 1. ASCII : 영어 대소문자, 숫자, 특수문자 등
                - 'A' => 100_0001 = 0x41
                - 'B' => 100_0010 = 0x42
                - '1' => 011_0001 = 0x31
                - '2' => 011_0002 = 0x32
                - 한글(11172자)은 정의되어 있지 않다.

            - 2. ISO-8859-1(8비트) : ASCII 문자 + 유럽 문자

            - 3. EUC-KR(16비트) : 한글 2350자에 대한 규칙
                - '가' => 10110000_10100001 = 0xb0a1
                - '각' => 10110000_10100010 = 0xb0a2
                - 현대 통용되는 한글 음절 11172자를 모두 표현할 수 없다.

            - 4. Unicode(16비트) : 영어, 한글 모두 2바이트로 표현
                - 일반적으로 통용되는 대부분의 국가의 문자를 담고 있다
                - 'A' => 0x0041
                - '1' => 0x0031
                - '가' => 0xac00
                - 영어를 2바이트로 표현하기 때문에 비효율적이다.
                - 한글은 새로 정의했기 때문에 EUC-KR과 호환되지 않는다.

            - 5. UTF-8(8비트 ~ 32비트)
                - Unicode에 있는 문자를 규칙에 따라 1 ~ 4바이트로 변환한다.
                - 문자에 따라 바이트 크기가 다르다.
                - ISO-8859-1(영어,숫자,특수문자): 1바이트로 표현한다
                - 'A' => 0x41   
                - '1' => 0x31
                - 한글: 규칙에 따라 3바이트로 표현한다.
                - '가' => 0xac00(10101100_00000000, Unicode) => 1110xxxx 10xxxxxx 10xxxxxx (변환규칙) => 11101010 10110000 10000000 (규칙에 값 적용) => 0xEAB080(UTF-8)

        - java 사용 문자 : 유니코드
            - 전 세계의 모든 문자를 컴퓨터에서 일관되게 처리할 목적으로 정의된 산업 표준 규칙
            - 유니코드는 '문자를 2진수로 표현(인코딩; encoding)'할 때, 두 가지 방식(UTF와 UCS)을 사용
            - 자바는 메모리에 문자를 저장할 때는 'UCS(국제 문제 집합)'를 사용, 외부로 입출력 할 때는 'UTF'를 사용

            - UTF-8 : USC의 코드 값 중에서 00~7F(127개)ASCII에 해당하는 코드 그대로 1바이트로 표현
            그 외 문자코드는 규칙에 따라 2바이트~4바이트까지 변환하여 표현

            - UTF-16 :  USC의 코드 값 그대로 2바이트로 표현
            ASCII 코드와 USC-2 동일하게 2바이트로 표현
            USC-2 를 벗어나는 유니코드는 무조건 4바이트로 변환하여 표현

            - UTF-32 : UCS-4의 4바이트 코드 값을 그대로 표현
            즉 UTF-32는 UCS-4와 같으며 모든 문자를 4바이트 코드 값으로 표현하기 때문에 메모리 낭비가 심함

        - Char 문법
            - char 작성할 경우 : 
                - 유니코드 문자집합 65에 해당하는 A가 출력됨 : ((char)65);
                - 문자코드를 직접 입력할땐 16진수를 사용해줌 : ((char)0x41);
                - char와 정수 값을 연산하면 다음 문자코드인 B가 출력됨 : ((char)0x41 + 1); , ((char)('각' + 1));

            - char 작성하지 않을 경우 문자 출력 :
                - 사라임,시그마,파이 등 특수기호를 키보드로 입력할 수 없을 경우에 해당 유니코드 값을 직접 적는다.
                - \u + 16진수 사용 : ('\u0041') / A가 출력됨, 16진수는 대소문자 구분x
                - \u + 특수기호 코드 : ('\u4eba'); / 人 사람인 한자가 출력됨
                - \ + 8진수 사용 : ('\101') / A가 출력됨, 8진수는 0 ~ 377 범위만 가능
                - 작은 따옴표 : ('A'); / 작은 따옴표는 그대로 출력되기 때문에 char 필요없음

            - char 작성하지 않을 경우 정수 출력 : 
                - 숫자 65가 출력됨 : (65);
                - 정수 값만 연산하면 다음 유니코드인 정수가 출력됨 : (0x41 + 1);, ('각' + 1);
                - 문자의 정수값만 출력됨 : ((int)'A'); / int는 정수를 의미함

        - 폰트 파일의 유형
            - Raster 폰트 (bitmap font)
                - 크기를 늘리면 계단현상 발생
                - 폰트를 도트(점) 정보로 저장
                - 출력 속도가 빠름
                - 단순한 그림이나 복잡한 그림이 파일 크기가 같음
                - 왜? 천연색일 경우 각 점을 3바이트로 표현하기 때문

            - Vector 폰트 (truetype font)
                - 크기를 늘려도 깔끔하게 출력
                - 폰트를 명령어로 저장
                - 그릴 때 마다 명령어를 실행해야 하기 때문에 출력 속도가 느림
                - 그림이 복잡할수록 명령어가 복잡하기 때문에 파일 크기가 커짐

    - 논리값 : 참, 거짓을 표현
        - true : 참, 1
        - false : 거짓, 0
        - 반드시 소문자로 작성
        - 비교 연산( < , > ) / 논리 연산( && , || ) / 값 비교( == )의 결과값으로 사용
        - 논리값은 4바이트 int 메모리에 저장됨
        - c언어는 자바처럼 논리값을 표현하는 키워드가 없음.

    - 문자열 : 기본 타입이 아닌 하나의 객체 형태
        - 큰 따옴표 " " 안에 문자열을 작성
            - "ABC가나다" , "홍길동" ...
            - 문자열안에 유니코드를 포함할수 있음 ("\u0041BC\uac00나다");
        - 문자열과 +연산자
            - + 를 이용하여 문자열과 문자열을 연결 : "홍길동" + "입니다." => "홍길동입니다."
            - 다른 종류의 값을 연결할 수 있음 (다른종류의 값이 문자열로 바뀐 후 연결됨)
                - 문자열+숫자 : ("나이:" + 20);
                - 문자열+논리값 : (false + "재직자 여부");
                - 문자열+문자 : ("성별:" + '여')
                - 문자열+부동소수점 : ("키:" + 170.5f);  /접미사 f는 표현되지않고 결과값은 정수로만 보임

    - 출력 제어 문자 : 화면에 출력되지 않는 명령어
        -  \n : 줄바꿈 문자 / Line Feed(LF), 0x0a
        -  \r : 커서(cursor)를 처음으로 돌리는 문자 / Carrage Return(CR), 0x0d
            - ("Hello,\rabc"); 의 결과값은 abclo
        -  \t : 탭 공간을 추가시키는 문자 / Tab, 0x09
        -  \b : 커서를 뒤로 한 칸 이동시키는 문자 / Backspace, 0x08
            - ("Hello,\b\b\bworld!"); 의 결과값은 Helworld! (콤마도 포함 3번뒤로)
        -  \' : ' 문자를 출력시키는 문자 (' 앞에 \ 역슬래시를 써주기) / Single Quote, 0x27
        -  \" : " 문자를 출력시키는 문자 (" 앞에 \ 역슬래시를 써주기) / Double Quote, 0x22
        -  \\ : \ 문자를 출력시키는 문자 (\ 앞에 \ 역슬래시를 써주기)) / Backslash, 0x5c
