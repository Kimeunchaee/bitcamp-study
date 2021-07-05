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

- 자바 기초 문법
    - java-basic/ex01 참고
        - 패키지
        - 클래스
        - 소스 파일
        - 클래스 파일
        - 경로 작성 방법

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
    - System.out.
        - System = 시스템
        - out = JVM의 표준출력장치 콘솔

    - print() = 출력만
        - System.out.print();

    - println() = 출력 + 줄바꿈
        - System.out.println(); : 값을 주지 않으면 줄바꿈만 수행한다.
        - '\n' 이스케이프 문자도 줄바꿈을 수행한다.
        - System.out.print('\n');   =println 이랑 같은 역할

    - printf() = 출력 + 포맷(형식)
        - System.out.printf();
        - 특정 형식을 갖춘 문자열안에 값을 삽입할때는 printf(); 를 사용
        - 형식을 지정하지 않으면 print();와 같은 역할
        
        - 형식을 갖는 값
            - 삽입할 값은 오른쪽에 설정한다.
            - %s : 지정한 자리에 오른쪽 문자열을 삽입한다.
            - %d : 정수 값을 10진수 문자열로 만들어 삽입한다.
            - %x : 정수 값을 16진수 문자열로 만들어 삽입한다.
            - %c : 정수 값을 문자로 만들어 삽입한다.
            - %b : true/false 값을 문자열로 만들어 삽입한다.
            
        - 삽일될 값의 순서 :
            - %[n$]s : n은 문자열에 삽입될 값의 순서이다. 순서는 1부터 증가한다. (대괄호 [n$]는 생략해도 된다는 뜻)
            - 첫번째 값과 두번째 값, 세번째 값 ... 이 모두 같을땐 첫번째 값만 작성한다.
            - 한 개의 값을 여러 곳에 삽입할 수 있다는 뜻이다.
            - ex) ("%2$d %2$x %2$c\n", 65, 66, 67); 일때 65=1$, 66=2$, 67=3$ 을 의미함.
            - ex) ("%d %x %c\n", 65); 일때 모든 문자열에 첫번째 값이 삽입됨.

        - 값을 삽입할 때 사용할 공간 지정 :
            - 문자열을 삽입할 때: %[-][사용할공간너비]s : -는 왼쪽 정렬이다. 안 붙이면 기본 오른쪽 정렬이다.
            - System.out.printf("'%-10s' '%10s'\n", "홍길동", "임꺽정");
            - System.out.printf("'%-10d' '%10d'\n", 12345, 12345);
            - * %-10s : 왼쪽정렬 후 전체10자리를 확보하고 지정한 자리에 문자열을 삽입하라 그 후 줄바꿈 하라

        - 정수를 삽입할 때:
            - %[0][사용할공간너비]d : 앞의 빈자리는 0으로 채운다.
            - %[+][0][사용할공간너비]d : +는 숫자 앞에 부호를 붙인다.
            - System.out.printf("'%010d' '%07d'\n", 12345, 12345);
            - System.out.printf("'%+010d' '%+07d'\n", 12345, -12345);
            - * %010d : 오른쪽정렬(기본)이고 전체 10자리를 확보하고 빈자리는 0으로 채우고 정수 값을 10진수 문자열로 만들어 삽입하라

        - 날짜 값 표기할때 :
            - java.util.Date today = new java.util.Date(); 패키지명으로 지정
            - 날짜 및 시간 옵션 (날짜 및 시각 데이터에서 ~추출)

                - Y : 년도를 추출하여 4자리로 표현
                - y : 년도를 추출하여 뒤의 2자리로 표현
                - System.out.printf("%1$tY, %1$ty\n", today);

                - B : 월을 추출하여 전체 이름으로 표현 ex) January
                - b : 월을 추출하여 단축 이름으로 표현 ex) Jan
                - System.out.printf("%1$tB, %1$tb\n", today);

                - m : 월을 추출하여 2자리 숫자로 표현 ex) 12, 01
                - System.out.printf("%1$tm\n", today);

                - d : 일을 추출하여 2자리 숫자로 표현 ex) 01, 22
                - e : 일을 추출하여 1자리 숫자로 표현 ex) 1, 22
                - System.out.printf("%1$td %1$te\n", today);

                - A : 요일을 추출하여 긴 이름으로 표현 ex) Sunday
                - a : 요일을 추출하여 짧은 이름으로 표현 ex) Sun
                - System.out.printf("%1$tA %1$ta\n", today);

                - H : 시각을 추출하여 24시로 표현
                - I : 시각을 추출하여 12시로 표현
                - System.out.printf("%1$tH %1$tI\n", today);

                - M : 시각을 추출하여 분을 표현
                - System.out.printf("%1$tM\n", today);

                - S : 시각을 추출하여 초를 표현
                - L : 시각을 추출하여 밀리초를 표현
                - N : 시각을 추출하여 나노초를 표현
                - System.out.printf("%1$tS %1$tL %1$tN\n", today);

                - p : 오전 오후 출력하기
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
            - 1의 보수 <1가지 방법>
                - 1) 자리수의 수와 보수를 더하면 해당 진수의 자리 올림이 발생하고 해당자릿수는 0이 되도록 한다. (각각의 비트를 0은 1로, 1은 0으로 바꿔서 구하는것) : 1의보수는 -8을 표현할수 없다. 자리올림이 발생하지 않기 때문에
            - 2의 보수 <3가지 방법>
                - 1) 2의 n승 -(주어진수의 절댓값) 
                - 2). 음수의 절댓값을 2진수로 구하기 > 2진수의 1의보수 구하기 > 계산한 1의 보수에 +1하기
                - 3) 양수 2진수에서 가장 오른쪽의 0에서 처음으로 나오는 1까지 그대로 두고 나머지를 1의 보수로 바꾸기
            - 2진수 덧셈
                - : 일반적인 덧셈방법으로 계산한다. 비트를 넘어가는 올림수는 무시
            - 2진수 뺼셈
                - : 연산을 수행하는 cpu(중앙처리장치)의 연산장치에는 가산기, 보수기, 시프터, 오버플로 검출기, 레지스터가 있다.
                - 덧셈에 필요한 가산기는 있지만 뺄셈에 필요한 감산기를 찾아볼 수가 없다.
                - 음의 정수를 덧셈으로 계산하기 위해 2의 보수를 이용해서 계산해준다.
            - 부호비트 : 최상위비트(가장왼쪽)을 부호로 설정, 0는 양수이고 1은 음수이다.

    - 실수 : 3.14 , 3.14e ...
        - 고정소수점
        - 부동소수점
        - IEEE 부동소수점 수 표준

    - 값과 메모리 크기
        - 2bit = 2² -1 = 0~3까지 표현가능
        - 4bit = 2⁴ -1 = 0~15까지 표현가능 

    - 2진수와 하드디스크,램 구동,작동원리 등
        - 하드디스크 구동원리 : 자성 물질로 덮인 플래터를 회전시키고, 그 위에 헤드(Head)를 접근시켜 플래터 표면의 자기 배열(sn/ns)을 변경하는 방식으로 데이터를 읽거나 쓴다.
        - 하드디스크, 램 등은 off(0)와 on(1)의 두 상태밖에 구별되지 않기 때문에 2진법을 사용해 데이터를 읽고 저장시킨다.


