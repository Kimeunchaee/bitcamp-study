# bitcamp-study

- ## 2021.06.28 ~ 2021.07.02
    - ## 1일차
        - 2021.06.28 월

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

    - ## 2일차
        - 2021.06.29 화

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

    - ## 3일차
        - 2021.06.30 수

        - 프로그래밍 원리
            - 프로그래밍 (2일차참고)
            - Compile (2일차참고)
            - Interpreter (2일차참고)
            - Hybird
                JAVA언어로 작성된 소스파일이 가상기계어(p-code)로 번역되고 class파일이 생성되는 컴파일 과정 후,
                JVM을 통해 로딩되어 OS에 실행되는 인터프리터방식이 함께 진행되는것을 하이브리드 방식이라고 한다.
                소스파일(JAVA언어사용)작성 > 확장자 : 파일명.java > `$javac -encodig utf-8 -d 클래스저장경로 소스파일경로/파일명.java` > 컴파일 후 .class 파일 생성됨
                클래스 파일을 JVM(실행)시켜주기 > `$ java -encodig utf-8 -classpath (= -cp) class파일위치 소스파일위치.파일명(확장자X)`

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

    - ## 4일차
        - 2021.07.01 목

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

    - ## 5일차
        - 2021.07.02 금

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

- ## 2021.07.05 ~ 2021.07.09
    - ## 6일차
        - 2021.07.05
        - 이클립스 Live Share
            - VSCode Live 확장 팩 플러그인 추가
            - 라이브 코딩 작업 테스트

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
                - 2bit = 2² -1 = 0~3 까지 표현가능
                - 4bit = 2⁴ -1 = 0~15 까지 표현가능
                - 16bit = 2의 16승 -1 = 0~65535 까지 표현가능 (-32768 ~ +32767) 
                - 32bit = 2의 32승 -1 = 0~4,294,967,295 까지 표현가능 (약 -21억 ~ +21억)
                - 64bit = 2의 64승 -1 = 0~약1900경 까지 표현가능 (약 -900경 ~ + 900경)

            - 2진수와 하드디스크,램 구동,작동원리 등
                - 하드디스크 구동원리 : 자성 물질로 덮인 플래터를 회전시키고, 그 위에 헤드(Head)를 접근시켜 플래터 표면의 자기 배열(sn/ns)을 변경하는 방식으로 데이터를 읽거나 쓴다.
                - 하드디스크, 램 등은 off(0)와 on(1)의 두 상태밖에 구별되지 않기 때문에 2진법을 사용해 데이터를 읽고 저장시킨다.

        - 자바 기초문법 예제
            - ex03
                - 리터럴 표기법 요약 정리
                - 값을 메모리에 저장하는 방법: RAM, HDD
                - 10진수, 8진수, 2진수, 16진수 표기법
                - 정수를 2진수로 저장하는 방법
                - 메모리 크기에 따른 값의 범위


    - ## 7일차
        - 2021.07.06

        - 이클립스 오류났을 때
                - gradle.build 에서 이클립스설정파일들을 자동생성하라고 세팅된 명령과 이클립스에서 새로 파일을 만들었을때 자동으로 생긴 이클립스설정 파일들이 부딪혀서 먹통이 되거나 오류가 생김
                - 이클립스,파일탐색기 등 종료 후 > 해당 폴더 gradle cleanEclipse (또는 직접 setting,project,classes 폴더를 삭제해준다) > 다시 gradle eclipse

        - Literal
            - 실수 : 3.14 , 3.14e ...
                - 고정소수점 :  소수점의 위치를 기준으로 정수부와 실수부로 구분한다. 
                - 부동소수점
                    - 개념
                        - 전체 자리수(유효숫자)가 가수부이며 소수점의 위치를 2의 n승으로 표현하고 n이 지수부이다.
                        - 표현범위가 고정소수점에 비해 크다.
                        - 유효숫자와 부동소수점을 각각 2진수로 변환하면 그나마 최소의 오차로 값을 지정할수 있기때문에 2진수 변환을 사용한다.
                        - 하지만 결과값에 오차가 발생하는 한계를 가지고 있다.

                    - 2진수 변환 방법
                        - 실수 값을 부동소수점 방식으로 저장하려면 1과 0으로(2진수) 변환해야 한다. 이때 IEEE 754 명세에 따라 2진수로 변환한다.
                        - 소수점 위치에 따라 각각 2진수로 변환후 (무조건 맨앞이 1이 된다.)
                        - 맨앞에 1 오른쪽으로 소수점을 옮겨준다. 이때 1.xxxxx 의 xx부분이 가수부가 되고,
                        소수점이 이동한 자릿수의 갯수가 지수부가 되어 2의 n승(n=지수부)을 곱해준다. / 정수개념에서 보면 10의 n승이지만 2진법이기때문에 2의 n승
                        이를 정규화 과정이라고 한다
                        - 32bit(4byte)는 1bit는 부호비트 , 8bit는 지수부 , 나머지 23bit는 가수부로 구분되며
                        - 64bit(8byte)는 1bit는 부호비트 , 8bit는 지수부 , 나머지 55bit는 가수부로 구분된다.

                    - 클래스 파일로 부동소수점 값 확인하기
                        - 실행결과는 10진수로 보이지만 컴퓨터에 컴파일된 내용은 (classes 파일을 확인해보면)
                        2진수에서 16진수로 바뀌여서 표현되어 있다. 2진수가 너무 길기 때문에)
                        - Exam35.class 파일을 hexdump 플러그인으로 출력한다.
                        - 12.375의 2진수 값인 0100_0001_0100_0110_0000_0000_0000_0000을 찾아본다.
                        - 보통 에디터에서는 2진수를 16진수로 바꿔 보여주기 때문에 16진수 값 0x41460000을 찾아본다.

                    - Exponential 기호 사용하기
                        - e 기호를 사용하면 소수점의 위치를 조정하여 표현할 수 있다.
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
                    - 더블쿼터 " " 안에서 '는 자동출력된다.
                -  \" : " 문자를 출력시키는 문자 (" 앞에 \ 역슬래시를 써주기) / Double Quote, 0x22
                    - 싱글쿼터 ' ' 안에서 "는 자동출력된다.
                -  \\ : \ 문자를 출력시키는 문자 (\ 앞에 \ 역슬래시를 써주기)) / Backslash, 0x5c

    - ## 8일차
        - 2021.07.07

        - github.com 에서 개인홈페이지 만들기
            - 아이디.github.io 이름의 저장소 생성
            - setting/pages/choose theme 선택
            
        - 변수선언
            - 개념
                - 변수(variables) : 값을 저장하는 메모리
                - 선언 : 메모리의 종류와 크기를 결정하고 그 메모리에 이름을 부여한다.
                - 변수선언 : 변수를 선언한 후 바로 그 이름을 사용하여 메모리에 접근하고 값을 넣고 꺼낸다.
                보통 "변수를 생성한다"라고 표현하기도 한다.
            
            - 변수 이름 규칙
                - 보통 소문자로 시작한다.
                - 대소문자를 구분한다.
                - 여러 단어로 구성된 경우 두 번째 단어의 시작 알파벳은 대문자로 한다.
                - 예) firstName, createdDate, userId (카멜표기법)
                - 상수인 경우 보통 모두 대문자로 이름을 짓는다. 단어와 단어 사이는 _를 사용한다.
                - 예) USER_TYPE, USER_MANAGER

            - 변수 선언 위치
                - 사용할 변수를 블록 시작부분에 미리 선언한다.
                - 변수가 필요할때 중간 부분에 언제든지 선언 가능하다.

            - 변수 선언 문법
                - 한문장에서 한개의 변수 선언
                    - * 메모리의종류 메모리이름;
                    - int i1; / int i2; / int i3;

                - 한문장에서 여러개의 변수 선언
                    - 콤마를 사용한다.
                    - * 데이터타입 변수1, 변수2, 변수3;
                    - int j1, j2, j3;

                - 변수에 값 할당하기
                    - 할당 연산자(assignment operator) = : 변수가 가리키는 메모리에 값을 저장하는 것
                    - l-value : = 왼쪽에 있는 변수를 가리킨다. l-value는 리터럴이 될 수 없다. 반드시 메모리여야한다.
                    - r-value : = 오른쪽에 있는 변수나 리터럴을 가리킨다. 오른쪽에 지정된 값을 왼쪽 변수가 가리키는 메모리에 저장
                    - * 변수명 = 값(변수 또는 리터럴);
                    - int age; / age = 20; / age 변수가 가리키는 메모리에 20을 저장

                - 변수 선언과 값 할당을 동시에 하기
                    - 변수 초기화 문장(initializer) : 변수 선언과 동시에 값 저장을 한 번에 할당하는 것
                    - * 데이터타입 변수명 = 값;
                    - int age = 20; 

                - 여러 개의 변수를 한 번에 선언하고 초기화도 함께 수행하기
                    - 1. 모든 변수 초기화 : 콤마를 사용한다.
                        - * 데이터타입 변수명 = 값; 변수명 = 값;
                        - int a1 = 100, a2 = 200; a3 = 300;
                    - 2. 일부분만 초기화 : 초기화할 변수에만 값을 넣어준다.
                        - a2, a4에만 값을 넣어주면 a2,a4만 초기화된다.
                        - int a1, a2 = 200, a3, a4 = 400, a5;

                - 변수의 값 변경
                    - 할당 연산자를 이용해 언제든 해당 메모리에 다른 값 저장 가능하다.
                    - 가장 마지막줄 연산자의 명령을 실행시킨다.
                    - int age;
                    - age = 20; 
                    - age = 30;

                - 변수를 다른 도구에 사용
                    - 다른 도구(메서드; 함수라고도 부른다)에 값을 전달
                    - 예) println() 메서드 에 변수를 사용할수 있다.
                    - int age = 20; / System.out.println(age);
                
                - 다른 변수에 값을 저장 (값이 같다는 뜻 아님!)
                    - age1에 저장된 값을 age2에 복사한다는 의미
                    - age1과 age2는 같은 메모리가 아니다.
                    - int age1 = 20; / int age2 = age1; 변수 선언 후
                    - age1 = 30; 값을 변경 하면
                    - age1 , age2 의 결과값이 다르게 출력된다.

            - 변수 선언 오류
                - 같은 이름의 변수를 중복해서 선언할 수 없다.
                - 변수 사용이 선언보다 먼저 올 수 없다.
                - 항상 변수가 선언된 다음에 사용해야안다.
                - 순서 : int count; / count = 50;
                - 값을 지정하지 않은 상태에서 사용할수 없다.

        - 변수의 종류
            - 1. primitive data type (원시 데이터 타입)
                - 정수
                    - byte   : 1byte 메모리 (-128 ~ 127)
                    - short  : 2byte 메모리 (-32768 ~ 32767)
                    - int    : 4byte 메모리 (약 -21억 ~ 21억)
                    - long   : 8byte 메모리 (약 -922경 ~ 922경)
                - 부동소수점
                    - float  : 4byte 메모리 (유효자릿수 7자리)
                    - double : 8byte 메모리 (유효자릿수 15자리)
                - 문자
                    - char   : 2byte 메모리 (0 ~ 65535). UCS-2 코드 값 저장.
                - 논리값
                    - boolean : JVM에서 4 바이트 int 메모리를 사용한다.
                                배열일 경우 1 바이트 byte 메모리를 사용한다.

            - 2. reference(레퍼런스) : 데이터가 저장된 메모리의 주소를 저장하는 메모리.
                - 문자열(주소)
                    - String : 문자열이 저장된 메모리의 주소를 저장한다.
                            프로그래밍 입문 단계에서는 그냥 문자열을 저장하는 메모리로 생각
                - 날짜(주소)
                    - Date : 날짜 값이 저장된 메모리의 주소를 저장한다.
                            프로그래밍 입문 단계에서는 그냥 날짜를 저장하는 메모리로 생각

        - 변수의 메모리 크기
            - 정수
                - byte : 1byte 메모리 (-128 ~ 127)
                    - 1바이트 메모리에 담을 수 있는 최소/최대 정수값
                    - byte i; / i = -128; / i = 127; 까지 표현가능
                    - i = -129; / i = 128; 은 컴파일 오류

                - short : 2byte 메모리 (-32768 ~ 32767)
                    - 2바이트 메모리에 담을 수 있는 최소/최대 정수값
                    - short i; / i = -32768; / i = 32767; 까지 표현가능
                    - i = -32769; / i = 32768; 은 컴파일 오류!

                - int : 4byte 메모리 (약 -21억 ~ 21억)
                    - 4바이트 메모리에 담을 수 있는 최소/최대 정수값
                    - int i; / i = -2147483648; / i = 2147483647; 까지 표현 가능

                - long : 8byte 메모리 (약 -922경 ~ 922경)
                    - 8바이트 메모리에 담을 수 있는 최소/최대 정수값
                    - long i; / i = -9223372036854775808L; / i = 9223372036854775807L;

                - * 4 byte 크기를 벗어나는 정수를 표기할 때는 반드시 숫자 뒤에 L 또는 l을 붙여서 표기한다.

        - 변수와 리터럴의 크기
            - Exam0412 ~ Exam0451 까지 내용너무 많아서 파일에 정리 (주말에 복습하기!)

        - JAVA 키보드 입력 받기
            - System.out : 출력장치 모니터,명령창
            - System.in  : 입력장치 키보드
                - 1. InputStream
                    - java.io.InputStream keyboard = System.in;
                    - 키보드로 입력한 데이터를 읽을 때 사용할 도구를 준비한다.
            - Scanner 
                - 2. java.util.Scanner keyScan = new java.util.Scanner(keyboard);
                    - java.util.Scanner
                        - 바이트 단위로 읽어서 int나 문자열로 바꾸려면 또 코딩해야 하는 불편함이 있다.
                        이런 불편함을 줄이기 위해 자바에서는 바이트를 개발자가 원하는 값으로 바꿔주는 기능을 제공한다.
                    - java.util.Scanner keyScan 
                        - keyScan = reference (리모콘 역할)
                        - 객체 지향 프로그램에서 객체는 직접 조종하는것 아닌 리모콘을 통해서 조정한다.
                        - 리모콘이 해당 객체를 가르키도록 지정한 후 리모콘에서 명령을 내려야한다.
                    - new java.util.Scanner(keyboard);
                        - keyboard = object (객체)
                        - keyboard 을 장착한 새로운 스캐너를 장치로 지정한다.

            - `Scanner - nextLine();`
                - 3. System.out.print("팀명? ");
                    - '팀명?' 창을 출력함

                - 4. String str = keyScan.nextLine();
                    - reference인 키스캔에게 nextLine()을 요청함
                    - `nextLine()` : 키보드에서 한 줄 입력될때까지 기다려라,
                                    한줄이 입력되면 문자열만 뽑아서 리턴한다.
                                    (리턴=해당자리에 값을 입력한다)
                    - 요청된 값을 문자열 데이터타입(String)인 str으로 입력한다.

                - 5. System.out.println(str);
                    - 사용자가 입력한 문자열을 출력한다.
                    - str을 넣어주는 방법도 가능하지만 두줄을 써줘야하므로 String str = keyScan.nextLine(); / System.out.println(str);
                    - 한번에 System.out.println(keyScan.nextLine()); 으로 작성해줌
                        - 실행순서
                            - : 괄호 안에 nextLine()가 먼저 실행되고
                            - : println 줄바꿈이 실행된다

                - 6. keyScan.close();
                    - 스캐너는 사용 후 키보드와의 연결을 끊고 닫는다.

            - `Scanner - nextInt();`
                - 2.  java.util.Scanner keyboard = new java.util.Scanner(System.in);
                    - new java.util.Scanner(System.in);
                        - System.in = object (객체)
                        - System.in 을 장착한 새로운 스캐너를 장치로 지정한다.

                - 3. System.out.print("int: ");
                    - int: 창을 출력함

                - 4. int i = keyboard.nextInt();
                    - reference인 키스캔에게 nextInt()을 요청함
                    - `nextInt();` : 사용자가 입력한 내용에서 한 개의 토큰(token)을 읽을 때가지 기다린다.
                                    (=공백을 아무리 입력해도 넘어가지 않고 엔터를 쳐야 토큰을 인식하기 때문에 그때 넘어감)
                                    한 개의 token을 읽으면 4바이트 정수 값으로 바꾼 다음에 리턴한다.
                                    (토큰이란 공백으로 구분되는 단어를 뜻한다 / 리턴=해당자리에 값을 입력한다))
                                    중간에 여러 개의 공백이 들어가더라도 한 개의 공백으로 간주한다.
                                    단어 앞의 공백은 결과값에서 자동으로 제거된다.
                                    (공백은 스페이스(space), 탭, 줄바꿈 코드를 말한다.)
                                    // 예) aaa    bbb cc ==> aaa, bbb, cc
                                    // 사용자가 입려할때 중간에 여러 개의 공백이 들어가더라도 한 개의 공백으로 간주한다.
                    - 요청된 값을 정수 데이터타입(int)인 i 으로 입력한다.
                    - keyboard.nextInt(); 뒤에 keyboard.nextLine();
                        - 사용자가 내용을 입력하고 엔터를 치면 내용+공백 한칸이 생기는데 nextInt();명령어는 토큰만 인식을 하고
                        다음 명령어를 바로 실행해서 줄바꿈이 일어나거나 내용이 넘어가버린다. 이를 방지하기 위해
                        공백 한칸(빈 문자열)을 실행시켜서 버리기 위해 nextInt(); 뒤에 변수명.nextLine(); 을 작성해준다.

            - 현재 일시 알아내기
                - java.sql.Date 클래스
                    - java.sql.Date now = new java.sql.Date(System.currentTimeMillis());
                        - 메소드 java.sql.Date , 변수명 now
                        - System.currentTimeMillis() : 1970년 1월 1일 0시 0분 0초부터 현재까지 경과된 시간을 밀리초로 리턴한다.
                        - new java.sql.Date(밀리초) : 넘겨 받은 밀리초를 가지고 년,월,일,시,분,초를 계산한다.
                        - 밀리초로 제공되는 현재 날짜일수
                    - 출력문 : Date 메소드 변수명 = 변수명.valueOf(실행문);
                        - Date startDate = Date.valueOf(keyScan.nextLine());
                        - 2021-07-07 형태의 입력만 가능

            - 실습
                - App1.java 를 App1_1.java로 복사하고 System.in 파일로 코드 작성하기 
                - App2.java 를 App2_1.java로 복사하고 System.in 파일로 코드 작성하기 
                - App3.java 를 App3_1.java로 복사하고 System.in 파일로 코드 작성하기 

    - ## 9일차
        - 2021.07.08

        - 배열 실습
            - app project : 배열을 사용하여 여러 개의 데이터를 다뤄보기
            - 배열 : 같은 종류의 변수를 여러 개 만들 때 사용하는 문법
            - 문법 : int[] 변수명 = new int[값]; / String[] 변수명 = new String[값]; / Date[] = new Date[값];
            - 변수 : 인덱스(index)라 부르는, 0으로 시작하는 숫자(값)
            - 조건문 :  조건에 따라 실행시킬때 `if/else` 나 `switch`를 사용
            - 반복문 :  같은 명령어를 여러 번 반복 실행할때 `while`, `do/while`, `for` 를 사용하면 된다.
                        (보통 배열을 다룰 때는 for 반복문을 주로 사용)

            - 내용
                - 출력할 내용에 필요한 배열과 변수 선언
                - 배열문을 사용해 출력할 내용 작성하기
                - 반복문이 필요한지 확인 후 반복문과 반복 횟수, 조건 작성하기
                - 반복문(`while`, `do/while`, `for`)은 조건인 참인동안 증감문을 반복한다.
                - for문은 for (변수선언 및 초기화; 조건; 증감문) 형태로 한번에 작성할 수 있다.

        - java 문법
            - 날짜 표현
                - 1. 날짜를 밀리초로 표현 : java.util.Date now = new java.util.Date(System.currentTimeMillis()); 
                - 2. 날짜를 yyyy-mm-dd 표현 : java.sql.Date now = new java.sql.Date(System.currentTimeMillis()); 
                - import java.util.Date; / import java.sql.Date; 후 Date now = new Date(System.currentTimeMillis()); 로 작성가능

            - 값을 숫자로 변환
                - int 뿐만 아니라 byte, short, long, float, double 등 숫자와 관련된 타입은 전부 가능하다
                - parseByte() / parseShort() / parseInt() / parseLong() / parseFloat() / parseDouble()
                - () 안에는 문자열 타입의 숫자 넣어주기
                - boolean은 없음 / char의 경우, charAt() 사용으로 숫자로 변환
                - int 의 경우 : Integer.parseInt(String s)
                
            - 값을 원시값으로 반환
                - ()괄호 안의 해당 객체를 원시값 객체로 변환시키는 역활
                - String.valueOf(); : ()안에 어떤 객체(double,boolean,int...)가 와도 문자열로 변환시킴
                    - String.prototype.toString().과 동일
                - Date.valueOf(); : ()안의 값은 Date로 변환
                - Integer.valueOf(); : ()안의 값을 Integer 상수로 변환

            - 연산자
                - || (논리 or 연산자)
                    - 조건1, 조건2 중에 한 쪽만 true이면 조건을 만족하여 if문을 실행
                    - if (ans.equalsIgnoreCase("N") || ans.equals("")) {
                        break; 
                        }
                - ! (논리 NOT 연산자)
                    - !result 는 result가 false가 되면 조건을 만족하여 if문을 실행
                    - if (!str.equalsIgnoreCase("y")) {
                        break;
                        }

        - app 예제
            - app 1 : 여러 명의 회원 정보 입력과 출력
            - app 2 : 여러 개의 프로젝트 정보 입력과 출력
            - app 3 : 여러 개의 작업 정보 입력과 출력

    - ## 10일차
        - 2021.07.09

        - Arry 배열
            - 개념
                - 같은 종류의 메모리(int, String 등...)를 쉽게 만드는 방법
                - 문법 : 메모리종류[] 메모리이름 = new 메모리종류[개수];
                        데이터타입[] 변수명 = new 데이터타입[개수];
                - C 언어 문법 : 데이터타입 변수명[] = new 데이터타입[개수];
                - 배열의 최대값 : int 타입의 최대 값인 2147483647개
                    - 데이터 타입(String,boolean...)에 상관없이 배열자체가 int 성질이기때문에 int최대값의 크기를 가지고 있다.

            - 배열 선언
                - 문법
                    - 1. 선언
                        - new int[5]; : 사용할 메모리를 확보하는 명령(새로운 각각의 int메모리 5개를 만들어라)
                            - new 메모리 준비명령
                            - int 데이터타입
                            - [5] 데이터타입의 개수 
                        - 값을 저장하기 위해 확보된 메모리(=5)를 "인스턴스"라 부른다.

                    - 2. 선언 + 초기화
                        - int 이름 = new int[5] : 배열의 이름과 값을 지정
                            - 이름 : 배열 메모리의 주소를 담는 곳을 레퍼런스라고 부른다. 이 레퍼런스에 이름(변수명)을 지정해준다.
                            - = new int[5] 와 함께 한줄로 입력하면 선언과 초기화가 함께 이루어진다.

                    - 3. 인덱스
                        - 번호는 0부터 센다(0~4까지 5개의 메모리)
                        - ex) int no = new int[3] / no[2]=100;
                            - int타입의 배열 이름을 no로 지정
                            - int타입의 배열 메모리를 no[3] 3개 생성
                            - no[2]=100; : 3번째 배열에 100이라는 값을 넣어라 / [2] = 배열 인덱스

                - 개념
                    - 용어
                        - 레퍼런스(reference)란?
                            - 값이 아닌 메모리의 주소를 담는 변수
                            - 객체 그 자체가 아니라 객체 정보가 있는 메모리 주소
                        - 인스턴스(instance)란?
                            - 값을 저장하는 메모리

                    - 오프셋 주소
                        - application이 할당받은 메모리의 시작점을 0으로하여 계산된 주소
                        - ex) 문자 A의 배열이 abcdef를 포함한다면 'c' 문자는 A 시작점에서 2의 오프셋을 지닌다고 할 수 있다.

                    - 메모리 크기
                        - 메모리종류가 int이기 때문에 한개의 메모리 크기는 4byte
                        - 배열의 크기는 int 타입의 최대 값에서 2를 뺀 값이다. (int[] arr3 = new int[Integer.MAX_VALUE - 2];)
                        - 타입(String,boolean...)에 상관없이 배열자체가 int 성질이기때문에 int최대값의 크기를 가지고 있다.
                        - 최대값-2를 실행해도 오류가 뜨는 이유 : JVM이 OS로부터 사용 허가를 받은 메모리 크기를 벗어났기 때문에
                        - VM 실행 옵션에 Xmx메모리크기를 지정 옵션을 추가하면 된다 (-Xmx20000m)
                        - os허가 메모리를 벗어나는 크기의 배열은 거의 만들지 않는다.

                - 내용
                    - Garbage 메모리 (Exam0580참고)
                        - int[] arr = new int[3];  >   arr = new int[5]; / arr[2] = 30;
                        - 배열 주소를 새로 지정했기 때문에 첫번째 arr1에 저장된 주소가 사라지게 된다
                        - 이를 쓰레기메모리라고 부른다. (주소를 잃어버려 사용할 수 없는 메모리)

                    - 배열 레퍼런스와 인스턴스
                        - int[] arr1; /  arr1 = new int[5]; > int[] arr2 = arr1;
                        - arr1 과 arr2는 같은 배열 인스턴스를 가리키고 있다.
                        - 언제든 배열 인스턴스의 주소를 다른 레퍼런스에 담을 수 있다.

                    - 레퍼런스 초기화 null
                        - null 은 주소를 0으로 초기화 시킨다는것.즉 레퍼런스가 아무것도 가리키지 않음을 의미.
                        - arr1 = null; / arr1은 더이상 주소를 갖고 있지 않음을 선언 (nullpointer 상태)

                    - 배열 메모리의 기본값
                        - 로컬 변수는 값을 저장하지 않고 사용할 수 없다. (int v; 실행오류)
                        - new 명령으로 확보된 메모리는 종류에 상관없이 기본 값으로 자동 초기화(0) 된다.
                        - 배열 메모리 또한 생성되는 순간 기본 값으로 자동 초기화 된다. (int[] arr1 = new int[값])
                        - 정수 배열(byte[], short[], int[], long[]) : 0
                        - 부동소수점 배열(float[], double[]) : 0.0
                        - 논리 배열(boolean[]) : false 
                        - 문자 배열(char[]) : '\u0000'
                        - 주소 변수(Object[]) : null

                    - 배열 메모리 초기화
                        - 1. 배열 선언 + 초기화 명령
                            - 배열개수 지정 x
                            - int[] arr2 = new int[]{100, 90, 80, 70, 60};

                        - 2. 배열 선언 + 초기화 명령 II
                            - new int[] 생략 가능
                            - int[] arr3 = {100, 90, 80, 70, 60};

                        - 3. 선언 따로 초기화 따로
                            - new 생략 불가능!!
                            - int[] arr5; / arr5 = new int[]{0, 0, 0, 0, 0}; 
        
        - java의 데이터타입변수와 주소변수
            - 자바 변수는 크게 두가지로 나눌수 있다
            - 1. primitive data type 변수
                byte, shirt, int, long,float, double, boolean, char 
            - 2. 주소변수
                데이터타입변수를 제외한 모든 변수
                String, int[] ...

        - 변수 선언
            - 상수 : 변수의 값을 고정하는 방법, 값을 오직 한 번만 저잘할수 있다
                - 'fimal + 데이터타입 + 변수명' 으로 작성
                - 변수명은 모두 대문자로 작성
                - 변수값 초기화까지 함께 작성
                - ex) final float PI; / final float PI = 3.14159f;
            - 변수 : 언제든지 값을 변경할 수 있다.
                - '데이터타입 + 변수명' 으로 작성
                - ex) int a; / a = 10; / a = 100;
            
            - 변수 선언의 종류
                - 로컬 : 메소드 실행(String[] args)할때 로컬변수 생성됨
                - 클래스 : 클래스 로딩할때 클래스변수 생성됨
                - 인스턴스 : new 명령을 사용할때 인스턴스변수 생성됨

        - 연산자
            - 산술 연산자
                - +, -, *, /, %
                - (+), (-) 보다 (*), (/), (%) 가 우선
                - 연산자 우선순위가 같을때
                - 먼저 나온 것을 먼저 계산
                - 실행 순서가 바뀌더라도 상관없음
                - 강제로 실행 순서를 바꿀때 : 우선 실행할 코드에 괄호()

            - 연산자 우선 순위
                - 1. 괄호: ()
                - 2. 후위 연산자: a++, a--
                - 3. 전위 연산자: ++a, --a, 단항 연산자(+, -)
                - 4. *, /, %
                - 5. +, -
                - 6. 비트이동 연산자: <<, >>, >>>
                - 7. 관계 연산자: <, >, <=, >=, instanceof
                - 8. 등위 연산자: ==, !=
                - 9. &
                - 10. ^
                - 11. |
                - 12. 논리 연산자 AND: &&
                - 13. 논리 연산자 OR: ||
                - 14. 삼항 연산자: (조건) ? 값 : 값
                - 15. 할당 연산자: =, +=, -=, *=, /=, %=, &=, ^=, |=, <<=, >>=, >>>=

            - 바이트 크기와 정수값 (변수의 메모리 크기 내용 참고)
                - 리터럴 + 변수 를 연산하면 변수값에 따라 결과가 다르기때문에 > 변수로 처리됨 > 4바이트 결과값을 작은 메모리에 넣지 못한다
                - 리터럴끼리 산술연산할때, 리터럴 4바이트의 정수값이 변수의 범위 내의 저장할 수 있는 범위 내의 값이면 바이트변수에 저장하는것이 허용됨 (8바이트(값l(8byte)는 안됨) 
                - btye + byte / short + short
                - 자바의 기본단위가 int이기때문에 연산할때
                임시 4바이트 메모리에 값을 담아서 연산을 수행하고 (=암시적 형변환)
                연산결과도 4바이트 값으로 나온다.
                - 따라서 결과값을 1바이트 메모리, 2바이트 메모리에 넣지못한다.
                - 결론!
                - 숫자의 크기에 상관없이 작은 숫자를 다루더라도 정수를 다룰 때는 그냥 int를 사용하라!
                - byte는 보통 파일의 데이터를 읽어 들일 때 사용한다.

            - 데이터 타입과 연산자
                - 데이터 타입에 따라 사용할 수 있는 연산자가 정해져있다.
                - boolean 타입(참거짓): 산술 연산자를 사용할 수 없다. (&& and연산자를 사용할 수 있다.)
                - String 타입(문자열) : '+' 연산자는 문자열 연결 용도로 사용된다. (- 나 * 연산자는 문자열에서 사용할 수 없다)

            - 산술 연산자 결과 타입
                - 연산 후 생성된 결과도 피연산자와 같은 타입이다.
                - int값 + int값 = float 변수명
                - int끼리의 연산결과는 항상 int이다
                - 결과값 int를 float에 넣으면 소수점이 표기된다.
                - 이때 괄호를 사용해서 형변환(변수와 리터럴을 다른 타입의 값으로 바꾸는 것)을 시켜준다 
                - (float)int값 + (float)int값 = 변수명
                - 결과값은 float 형태가 된다
                - 값을 계산할때 결과메모리를 초과할 경우 값이 짤리기 때문에
                - 처음부터 피연산자의 값을 큰 메모리에 담아서 연산문을 작성해라
                - int + int = int 일떄 결과값이 int의 범위를 넘어가면 의도한 결과가 나오지 않고 결과값이 짤릴수 있다
                - > 더 큰 메모리 long 를 사용해서 결과값을 담는다고 해도
                    기본형인 int 4바이트로 먼저 연산이 되고 long변수에 저장되기 때문에
                    결과값이 다르게 나온다
                - > int + int 일때 결과값 int가 크기를 넘어갈 것같으면
                    형변환 해서 계산해준다
                    (long)int값 + (long)int값 으로 하면 long값으로 결과값이 나온다
                - *형변환할때 데이터타입 자체가 아예 바뀌는 것이 아니라 연산하는 과정에서만 암시적으로 바뀌어서 연산됨
                - byte short char > int로 암시적 형변환이 이루어짐
                - int > long로 암시적 형변환이 이루어짐 > int + long 의 결과는 long
                - long > float으로 암시적 형변환이 이루어짐 > long + float의 결과는 float
                - float > double 로 암시적 형변환이 이루어짐 > float + double의 결과는 double
                - long > double로 암시적 형변환이 이루어짐 > byte + short + int + long + float + double 의 결과값은 double
                - 정리!
                - 연산은 항상 같은 타입끼리만 가능하다.
                - 다른 타입끼리 연산을 할 때는 둘 중 한개의 타입을 다른 타입을 
                바꿔야 한다.
                - 타입을 바꾸는 것을 내부적인 규칙에 따라 자동으로 처리한다고 해서 "암시적 형변환(implicit type conversion)"이라 부른다.
                - 암시적 형변환 규칙 다음과 같이 오른쪽 타입의 값으로 자동 변환시킨다.
                - byte,short,char => int => long => float => double
                - 정수와 부동소수점에 대해서만 암시적 형변환이 일어난다. 그 외 다른 타입은 불가능하다

            - 관계 연산자(relational operators: <, <=, >, >=),
                - boolean : 비교의 결과는 true 또는 false로 나온다 즉 boolean 값이다.
                - 부동소수점 : 비교 

            - 등위 연산자(equality operators: ==, !=)
                - double d1 = 987.6543;
                - double d2 = 1.111111;
                - System.out.println((d1 + d2) == 988.765411);
                - > false (극소수값은 더해지지 않고 생각했던 결과값이 나오지 않는다)

                - double x = 234.765411;
                - double y = 754.0;
                - System.out.println((x + y) == 988.765411);
                - > true (극소수값에 0이 있기 때문에 생각했던 결과값이 나온다)

                - 소수점 뒤에 붙은 극소수의 값은 JVM이 자동으로 처리하지 않기 때문에
                - 부동소수점 비교 연산은 ==을 사용하면 안되고 개발자가 직접 처리해야한다

                - double EPSILON = 0.00001;
                - System.out.println(Math.abs((d1 + d2) - (x + y)) < EPSILON);
                - EPSILON = 0.00001; 극한값을 설정하고 
                - (d1 + d2)에서 (x + y)뺀 값이 극한값보다 작으면(오차이하의 값이면) 같다고 본다 > true
                - > 0.00001; 결과값 뒤에 극한값0.0001이 붙어서 오류가 발생한다
                    해결하기 위해 오차를 제거한 후 비교해준다 이때 계산결과를 절대값으로 만들고 오차 이하의 값인지 비교한다
                    절대값 : Math.abs(변수명)

            - 논리 연산자 : &&, ||, !(not), ^(XOR; exclusive-OR)
                - : boolean값일때만 사용할수있는 연산자
                - : 정수값은 연산 x / exclusive-OR은 정수를 비트값으로 연산o

                - AND 연산자  &&
                    - 두 개의 논리 값이 모두 true일 때 결과가 true가 된다.
                - OR 연산자  ||
                    - 두 개의 논리 값 중 한 개라도 true이면 결과는 true가 된다.
                - NOT 연산자  !
                    - true는 false로 false는 true로 바꾼다.
                - exclusive-OR(XOR)연산자 
                    - 배타적 비교 연산자라 부른다.
                    - 두 개의 값이 다를 때 true이다.
                - exclusive-OR 에 정수를 입력하면
                    - 비트단위로 연산을 수행하고 
                    - 두 개의 값이 다를 때 true = 1, 같은면 false = 0 으로 결과값이 나온다    

            - 논리 연산자 : &, |
                - &&(or) 와 &(and) 비교
                    - &  AND 연산자 : 두 개의 논리 값이 모두 true일 때 결과가 true가 된다.
                    - && 연산에서 왼쪽 값이 이미 false이기 때문에 결과는 확정되었다.
                    JVM은 실행의 효율을 위해 && 연산의 오른쪽을 실행하지 않는다.
                    왼쪽 문장의 결과 그대로 값이 출력된다
                    - & 연산자의 경우 결과에 상관없이 & 오른쪽 문장을 무조건 실행한다.

                - || 와 | 비교
                    - || OR 연산자 : 두 개의 논리 값 중 한 개라도 true이면 결과는 true가 된다
                    - || 왼쪽 값으로 이미 결과를 알 수 있기 때문에 || 오른쪽 문장은 실행하지 않는다.
                    - | 왼쪽 값으로 결과를 확정할 수 있더라도 무조건 오른쪽 문장을 실행한다.
                    - 비트 연산자 | 활용 : 특정 비트의 값만 강화하고 싶을 때 사용할 수 있다.

                - 비트 연산자 & 를 이용하여 % 연산 구현하기
                    - % : ]나누기 연산 후 나머지값수행
                    - 비트 연산자 & 활용: 특정 값을 차단하고 특정 값만 통과시킬 때
                    - 특정 비트의 값만 추출하고 싶을 때 사용할 수 있다.
                    - 둘다 1이면 1 / 둘다 0이면 0 / 두개가 1,0이면 0

            - 조건 연산자
                - 3개가 필요함 (조건 ? 표현식1 : 표현식2)
                - 표현식1 : 참일때 실행
                - 표현식2 : 거짓일때 실행
                - 할당연산자(=)의 왼편에 변수를 선언해야한다.
                - 조건연산자의 결과 값이 왼편의 변수 타입과 일치해야 한다.
                - 문장(statement) > 표현식(expression) 
                - 문장이 더 큰 범위
                - 문장은 작업을 수행시키는 명령어이다
                - 표현식은 문장을 실행한 후에 결과를 리턴하는 문장이다

            - 증가/증감연산자
                - 전위연산자(prefix) - 증가
                    - int i = 100;
                    - ++i; => 컴파일 할 때 => i = i+1 (여기서 i는 i자체)
                    - 후위연산자와 과정은 같음
                    - ++, --가 먼저 시행됨 (헷갈릴일x)

                - 후위연산자(postfix) - 증가
                    - int i = 100;
                    - i++; => 컴파일 할 때 => temp = i; (임시변수 i가 생성됨) i = i +1; (여기서 i는 temp임시변수값)
                    - System.out.println(i++); 는 System.out.println(temp);의 결과값과 같다.
                    - 그 다음 System.out.println(i); 출력 명령어를 입력하면 +1증가된 값이 출력된다

                - 후위연산자(postfix) - 증감
                    - i--;  => 컴파일 할 때 => int temp = i; => i = i - 1;
                    - 현재 위치에 i 메모리에 들어 있는 값을 꺼내 놓는다. 
                    - i 메모리의 값을 1 감소시킨다.

            - 할당(배정,대입) 연산자  : +=  -=  *=  /=  %=  &=  |=  ^=  <<=  >>=  >>>=

            - 연산자 축약 (+=)
                - i = i + 20;
                - i += 20;
                - += 연산자를 사용하면 위의 코드를 축약할 수 있다.

            - final
                - final int a = 1;
                - int 앞에 final를 붙일 시 , a는 상수가 된다. 여기서의 리터럴은 1이다.
                - 1과 같이 변하지 않는 데이터(boolean, char, double, long, int, etc...)를 리터럴(literal)이라고 부른다.


- ## 2021.07.12 ~ 2021.07.16
    - ## 11일차
        - 2021.07.12

        - 비트이동 연산자
            - >>, >>>, <<
            - << 사용법
                - 왼쪽으로 비트를 이동시킨다.
                - 오른 쪽 빈자리는 0으로 채운다.
                - 왼쪽 경계를 넘어간 비트는 자른다.
                - 값을 배수로 증가시킬 때 곱하기 연산을 하는 것 보다
            왼쪽 비트 이동 연산을 하는 것이 빠르기 때문에
            실무에서는 이 비트 이동 연산을 자주 사용한다.
                - 왼쪽으로 n비트 이동한다는것은 기존값에서 2의n승만큼 곱한다는 뜻
                - 음수를 왼쪽으로 이동할 때는 부호비트에 상관없이 무조건 이동한다. 음수가 양수로 바뀔 수 있다.

            - >> 사용법
                - 오른쪽으로 비트를 이동시킨다.
                - 왼쪽 빈자리를 기본값과 같은 부호비트로 채운다
                - 오른쪽 경계를 넘어간 비트는 자른다
                - 양수라면 0, 음수라면 1을 채운다.
                - 오른쪽으로 n비트 이동한다는것은 기존값에서 2의n승만큼 나눈다는 뜻
                - 나누기 연산을 수행하는 것 보다 계산 속도가 빠르다.        
                - 실무에서는 나눗셈 연산이 비용(시간과 CPU 사용량)이 많이 들기 때문에 소수점 이하까지 정확하게 계산할 게 아니라면 오른쪽 비트 이동 연산자를 사용하여 주로 처리한다.
                - 소수점이 있는 경우 날라간다,그 수 보다 작은 바로 밑 정수 값이 된다. 2.5 > 2 (음수일경우 -2.5 > -3)

            - >>> 사용법
                - >>와 같지만(비트를 오른쪽으로 이동)
                - 왼쪽에 채워지는 비트값은 부호비트와 상관없이 무조건 0으로 채운다
                - 오른쪽 경계를 넘어간 비트는 자른다

            - 비트이동의 유효범위
                - 기본값 int는 32bit 이기때문에 비트이동을 할 때는 0 ~31 까지만 유효하다.
                - 만약 31을 넘는 경우 32로 나눈 나머지 값을 비트 이동으로 간주한다.
                - long 타입의 경우 비트 이동은 0 ~ 63까지 유효하다.
                - 만약 63을 넘는 경우 64로 나눈 나머지 값을 비트 이동으로 간주한다.

            - 비트 연산자 응용1
                - 값을 1바이트씩 잘라서 16진수로 출력할때
                - 변수 i 에 값 설정 (int i = 0x27a130ff;)
                - 출력할 각각의 변수명 설정 (int a, b, c, d;)
                - a = i >> 24; / b = i >> 16 & 0xff; / c = i >> 8 & 0xff; / d = i & 0xff;
                - 중간에 다른 비트값이 있을경우, 마지막 8비트 값만 추출하기 위해 & 연산자를 사용해줌
                - & and 연산자(값이 둘다 1일때만 1)를 사용 : 0xff = 00000000_00000000_00000000_11111111
                - 끝에 8자리(8비트)만 남겨진 값이 비트이동된 값이다.
                - 출력 : System.out.println(Integer.toHexString(a));
                - Integer인티저라는 클래스에.toHexString() 를 사용하면 값이 16진수로 추출됨

            - 비트 연산자 응용2
                - Yes/No 또는 true/false 값을 저장할 때 비트 연산자를 사용하면 메모리를 절약할 수 있다.
                - 비트 연산자 사용 전 : 각각의 상태를 별도의 변수에 저장해야 한다. 8개의 데이터를 저장하기 위해 32바이트가 소요된다.
                - 배열 사용 : boolean 배열은 내부적으로 byte단위를 사용하기 때문에 1바이트 사용한다. 따라서 8개의 데이터를 저장하기 위해 8바이트를 사용한다.
                - 비트 연산자 사용 후 : 4바이트 변수 한 개만 있으면 최대 32개의 데이터를 저장할 수 있다. (int lang2 = 0;
                // 00000000 00000000 00000000 00000000)
                - 32비트에서 뒤에 8비트를 사용하여 8개의 true/false 값을 저장해보자
                - 예를 들어 00001000 : 파이썬 사용가능이라는 뜻의 true 일때
                - lang2 = 0; 에 (|)OR연산(값이 1라도 1이면 1)을 사용 : 00001000에 해당하는 0x08을 연산해주면 true라는 결과값이 추출된다

        - if 조건문 (흐름제어문)
            - 문법
                - if (조건) 문장1;
                    : 조건이 참일 때 문장1을 수행한다.
                    :  한 문장일 때는 블록으로 묶지 않아도 된다.
                    :  else 문 없이 단독으로 사용할 수 있다.
                - if (조건) 문장1; else 문장2;
                    : 조건이 참일 때 문장1을 수행하고, 거짓이면 문장2를 수행한다.
                    : else 문만 단독으로 사용할 수 없다.
                    : if 문과 else 문 사이에 다른 문장이 올 수 없다.
                -  if (조건) {문장1; 문장2;}
                    : 조건이 참일 때 여러 개의 문장을 실행하고 싶다면
                    :  중괄호({})를 사용 (블록으로 묶지 않으면 첫 번째 문장만 if에 종속)
                    :  들여쓰기는 문법에 영향을 끼치지 않는다.

            - 조건
                - if 문의 조건은 반드시 boolean 데이터타입을 사용
                - 그 외의 모든 데이터 타입은 컴파일 오류
                - if (true) / if (false) / if (10 < 8 + 5)
                - if문은 = 을 사용하면 오류 ==연산자를 사용해야한다
                - int a = 100; , if (a == 100)

            - else 문 소속 (흐름제어문)
                - else는 가장 가까운 if에 소속된다.
                - if 문 안에 if~else가 한문장으로 취급되어 사용될 수 있다. (한문장이기 때문에 중괄호도 사용할 필요없다)
                - 만약 else 문을 첫 번째 if 문에 소속되게 하고 싶다면 두 번재 if 문을 첫번째 if문 블록으로 묶어라! (Exam0160 소스코드 확인해보기)
                - 하지만 실수를 방지하기 위해 한문장이라도 중괄호를 사용해 작성하라!

        - 이클립스
            - 디버거 사용
                - 각 행의 연산을 순서대로 확인 가능
                - 토글 브레이크포인트 > 원하는 소스코드 라인 왼쪽을 더블클릭해 브레이크포인트 설정 > 디버그 모드 실행 > 스텝오버 버튼으로 실행 순서를 하나씩 확인할 수 있음
                - * resume (F8) : 다음 브레이크 포인트를 만날때까지 진행
                - * step over(Shift+F5) : 다음 라인으로 이동
            - 단축키
                - Ctrl + / : 선택된 라인의 주석 처리,해제

        - switch 문 (흐름 제어문)
            - 사용
                - 조건식 하나로 더 많은 경우의 수를 처리할때 용이
                - 조건식 결과값과 일치하는 case를 실행하는 방식
            - 문법
                - switch (값) {}

                - int i = 2;
                    switch (i)) {   
                        case 1 :   // 정수 사용
                        case 2 :
                        case 3 : case 4 : case 5 : 
                        default:
                    }

                - char c = 'A'; 
                    switch (c) {
                        case 'A': // 0x41 = 65   // 문자 사용
                        case 66:
                        case 0x43:
                        default:
                    }

                - String str = "hello";
                    switch (값) {
                        case "hello" :   //문자열 사용
                        default:
                    }

                - final int GUEST = 0, MEMBER = 1,
                    switch (값) {
                        case GUEST :   //상수 사용
                        case MEMBER :
                        default:
                    }

            - 데이터 타입
                - 값에 가능한 타입(리터럴만 가능) : int 정수(byte,short,int,char), 문자열(String), 특별한 상수 Enum 타입
                - 사용할 수 없는 값 : 변수(값이 무엇인지 정확히 모르기 때문), 4바이트를 넘어가는 정수, 부동소수점, boolean 값
            - if vs switch
                - 복잡한 조건으로 흐름을 제어해야 하는 상황은 if 문을 사용
                - int나 문자열처럼 단순한 값으로 제어할 수 있다면 switch문을 사용
                - 하나의 값으로 조건을 비교할수 있을 때 switch문을 사용
            - break
                - if문과 다르게 break를 통해 조건 만족시 조건문을 종료시켜주어야 한다.
                - break를 사용하지 않은 경우, fall-through 현상이 발생한다.
                - * fall-through : 조건문이 종료되지 않을 경우, 조건 ㅊㅇ족 case의 하위case까지 실행된다.
                - 일부러 break를 쓰지 않을 경우도 있다.

        - 반복문 while / do ~ while / for (흐름 제어문)
            - while 반복문
                - 사용
                    - 조건이 참인 동안 문장을 계속 실행한다.
                    - 0번 이상 반복한다.
                    - 여러 개의 문장을 반복 실행하려면 {블록}으로 묶어라!

                - 문법
                    while (조건) {
                        문장;
                    }

            - do ~ while 반복문
                - 사용
                    - 최소 한 번은 반복한다.
                    - 0 번 이상 반복하면 while
                - 문법
                    do {
                        문장1;
                        문장2;
                        문장3;
                    } while (조건);

            - break와 continue 활용
                - break; : 즉시 반복문을 종료하고 나간다. 다음문장 실행x
                - continue; : 다음 문장을 실행하지 않고 즉시 조건 검사로 이동한다.
                - 중첩된 반복문 탈출 : 자신이 소속된 가장 가까운 반복문을 나간다.
                - 라벨명: 반복문1 { 반복문2 {break 라벨명;}}
                    라벨 문법:
                    라벨: 문장;
                    라벨: {문장1, 문장2, ...}

            - for 반복문
                - 문법
                    - for (변수선언 및 초기화; 조건; 증감문) 문장;
                    - for (변수선언 및 초기화; 조건; 증감문) {문장1; 문장2; ...}

                - 실행 순서
                    - for (int i = 1; i <= 5; i++)
                        System.out.println(i);
                    - 1) 변수초기화 : int i = 1
                    - 2) 조건 : i <= 5
                    - 3) 문장 : System.out.print(i + " ")
                    - 4) 변수증가문 : i++
                    - 조건이 참인 동안 2 ~ 4를 반복한다.

                - 증감문 제거
                    - for (int i = 1; i <= 5;){}

                - 변수 선언 및 초기화 문장 제거
                    - int i = 1;
                    - for (; i <= 5;){}     //앞에 문장이 없더라도 세미콜론 필수

                - 조건문 제거
                    - int i = 1;
                    - for (;;){}        //앞에 문장이 없더라도 세미콜론 필수

                - 변수
                    - for 문에서 선언한 변수는 그 for 문 안에서만 사용할 수 있다.
                    - for 문 안에 선언된 변수는 for 문을 나가는 순간 제거된다.
                    - 반복문을 종료한 뒤라도 해당 변수의 값을 사용하고 싶으면,
                    - 반복문 밖에 변수를 선언하라!
                    - for 문을 종료한 후에도 i 변수를 사용할 수 있다. //System.out.println(i);

                - 변수초기화
                    - 초기화 시키는 문장에 여러 개의 변수를 선언 할 수 있다.
                    - 변수 증가문에 여러 개의 문장을 작성할 수 있다.
                    - for (int i = 1, j = 3, k = 5; i <= 10; i++, j--, k += 2)

                - for 중첩과 break
                    - break가 소속된 현재 반복문을 멈춘다.
                    - for (int i = 1; i <= 10; i++) {
                            for (int j = 1; j <= i; j++) {
                                System.out.print(j + " ");
                                if (j == 5)
                                break;               
                            }
                            System.out.println();
                            }
                        }

                - for 중첩과 continue
                    - 다음 줄로 가지 않고 '변수증가문'으로 이동한다.
                    - for (int i = 1; i <= 10; i++) {
                            for (int j = 1; j <= i; j++) {
                                if (j % 2 == 0)
                                continue; 
                                System.out.print(j + " ");
                            }
                            System.out.println();
                            }
                        }
                        
                - break 라벨명
                    - 라벨명 지정 > 라벨로 지정한 문장을 break 한다
                    - loop1: {
                            for (int i = 1; i <= 10; i++) {
                                for (int j = 1; j <= i; j++) {
                                System.out.print(j + " ");
                                if (j == 5)
                                    break loop1;
                                }
                                System.out.println();
                            }
                            System.out.println("-------------------------");
                            }
                        }

                - for(;;) 와 배열
                    - 선언 : 배열 변수 선언과 동시에 배열 초기화를 실행할 때는  new String[] 을 생략할 수 있다. 
                    - String[] names = {"홍길동", "임꺽정", "유관순", "윤봉길", "안중근"};
                    - 인덱스 범위 조정 : for (int i = 2; i < 4; i++)
                    - 증가치 조정 : for (int i = 0; i < names.length; i += 2) 
                    - 배열의 처음부터 끝까지 값을 꺼낼떼 : for (배열에서 꺼낸 값을 저장할 변수 선언 : 배열주소) 문장;
                    - for (:)
                        - 배열 전체를 반복하거나 컬렉션(collection) 객체 전체를 반복할 때 유용한다.
                        - 배열의 일부만 반복할 수 없다.
                        - 배열의 값을 다룰 때 인덱스를 사용할 필요가 없어 편리하다.
                    - 문법:
                        - for (변수 선언 : 배열, Iterable 구현체) 문장1;
                        - for (변수 선언 : 배열, Iterable 구현체) { 문장1; 문장2; ...}
                        - 변수의 타입은 배열이나 Iterable 구현체의 항목 타입과 같아야 한다.
                        - 반복문을 돌 때 마다 항목을 값을 꺼내 변수에 담는다.

    - ## 12일차
        - 2021.07.13

        - if,for문 실습
            - app1, app2, app3 를 하나의 프로젝트로 코드작성하기

        - 리팩토링
            - 기존 코드를 유지보수하기 쉬운 구조로 재작성하는 것

        - 미리 사용해본 메서드
            - Integer.parseInt("문자열 입력(정수)")   : 문자열을 int형으로 리턴
            - Integer.valueOf("문자열 입력(정수)") : 문자열을 int형으로 리턴
            - Date.valueOf(yyyy-m-d) : 일시 값이 리턴됨

        - 메서드
            - 개념
                - 문장으로 이루어진 코드를 기능 단위로 묶을때 사용하는 문법
                - 관리와 재사용이 쉽다.
            - 구분 
                - `static` 으로 선언하는 클래스 메서드(또는 스태틱 메서드)
                - `static` 이 붙지 않는(non-static) 인스턴스 메서드(또는 논스태틱 메서드)

        - 클래스 변수와 로컬변수
            - 로컬변수 : 다른메소드에서 로컬변수를 사용할수없다
            - 클래스 변수 : 각각 다른 메소드에서 클래스 변수를 가지고와서 사용할수있다
            
        - 클래스 메서드 (스태틱 메서드)     
            - static 을 맨앞에 붙혀줘야한다
            - static void main 바깥에 위치해야한다.
            - main 메서드와 로컬메서드에서 둘다 사용할수있다
            - 메서드로 분리한 코드를 실행하기(메서드 호출) : addMember();
            - 메서드명 : 동사구형태 (addMember(); , updateMember(); ...)
            - 메소드 자동생성 : 소스코드 선택 후 우클릭 > refactor > extract method
                                > package 클릭 > 메소드가 자동생성되고 그 빈자리에 메소드호출까지 한번에 됨
            - 호출된 메소드에서  소스코드로 이동 : 메소드명에 ctrl + 마우스 올려놓기

        - prompt();
            - 사용자로부터 문자열을 입력 받는 기능을 수행한다.
            - static void prompt (String title)
            - 파라미터 : title - 프롬프트의 메시지
            - 리턴 값 : String - 사용자가 입력한 문자열
            - prompt()의 기능 세분화
                - promptString() : 사용자로부터 문자열을 입력 받아 리턴한다.
                - promptInt() : 사용자로부터 숫자를 입력 받아 리턴한다.
                - promptDate() : 사용자로부터 날짜를 입력 받아 리턴한다.
                - promtString(), promptInt(), promptDate() 메서드의 코드를 정리한다.
                - ex) static String promptString(String title) {
                        System.out.print(title);
                        return keyboardScan.nextLine();
                    }

    - ## 13일차
        - 2021.07.14

        - 메서드 = 함수(function)
            - 개념
                - 명령어를 기능 단위로 관리하기 쉽게 별도로 분리하여 묶어 놓는 문법

            - 용어
                - 메서드명, 파라미터 변수선언 : 메서드 시그너처(method signature)
                - 메서드 블록 : 메서드 몸체(method body)

            - 메서드 종류
                - 1) 클래스 메서드
                    - 클래스에 소속되어 있다.
                    - 모든 인스턴스가 공유한다.
                    - static이 붙는다.
                - 2) 인스턴스 메서드
                    - 특정 인스턴스에 대해 사용한다.
                    - static이 붙지 않는다.

        - 메서드 사용
            - 메서드 문법
                - 기본 예시
                    - 리턴타입 메서드명(타입 파라미터, int a, int b){
                        int sum = 실행내용  //메서드 몸체
                        return sum;
                    }

                - 메서드 문법 종류
                    - 1) 명령어 블록을 실행할 때 값을 넘겨주지 않고 결과도 넘겨 받지 않는다.
                        void 메서드명() {
                            문장1;
                            문장2;
                        }

                    - 2) 명령어 블록을 실행할 때 값을 넘겨준다. 그러나 결과는 받지 않는다.
                        void 메서드명(변수선언1, 변수선언2, ...) {
                            문장1;
                            문장2;
                        }

                    - 3) 명령어 블록을 실행할 때 값을 넘겨주지 않는다. 결과는 받는다.
                        리턴타입 메서드명() {
                            문장1;
                            문장2;
                        }

                    - 4) 명령어 블록을 실행할 때 값을 넘겨주고 결과를 받는다.
                        리턴타입 메서드명(변수선언1, 변수선언2, ...) {
                            문장1;
                            문장2;
                        }
            
            - 메서드 호출 문법
                - 기본 예시
                    - int result = 메서드명(값지정,100,200,아규먼트);

                - 메서드 호출 방법 (사용방법)
                    - [리턴값을 받을 변수] = 메서드명(아규먼트);
                    - 아규먼트(argument) : 
                    - 메서드 블록에 들어 있는 명령을 실행하기 위해 넘겨주는 값
                    - 즉 파라미터 변수에 넘겨주는 값
                    - 파라미터 변수의 타입과 개수와 순서에 맞게 값을 넘겨줘야 한다.
                    - 변수타입과와 값의 타입이 같아야한다 (타입뿐만아니라 개수,순서도 같아야함!)
                
                - 리턴값을 받을 변수
                    -  메서드 블록을 실행한 후 리턴되는 값을 받을 변수이다.
                    - 메서드가 값을 리턴한다 하더라도 값을 받기 싫으면
                    - 변수를 선언하지 않아도 된다.
                    - 그러면 리턴 되는 값은 버려진다.
                    - 값을 리턴하지 않는 메서드에 대해 변수를 선언하면 컴파일 오류!

                - 메소드 매게변수와 리턴 참고
                    - https://hyuntaekhong.github.io/blog/java-basic11/

            - 가변 파라미터
                - 개념
                    - 0 개 이상의 값을 받을 때 선언하는 방식.
                    - 메서드 내부에서는 배열처럼 사용한다.
                - 문법
                    - 리턴타입 메서드명(`타입... 변수`) {...}
                - 내용
                    - 가변 파라미터는 여러 개 선언할 수 없다.
                        - static void m1(String... names, String... emails) {} (X)
                    - 중간에 다른 타입이 온다 하더라도 안된다.
                        - static void m1(String... names, int a, String... emails) {} (X)
                    - 가변 파라미터는 반드시 맨 끝에 와야 한다.
                        - static void m2(int a, String... names) {} (o))
                    - 가변 파라미터 자리에 배열을 직접 넣어도 된다.
                        - String[] arr = {"김구", "안중근", "윤봉길", "유관순"};

            - 배열 파라미터
                - 개념
                    - 0 개 이상의 값을 받을 때 선언하는 방식.
                    - 메서드 내부에서는 배열처럼 사용한다.
                - 문법
                    - 리턴타입 메소드명(`타입[] 변수`) {...}
                - 내용
                    - 배열 파라미터는 여러 개 선언할 수 있다.
                        - static void x1(String[] names, String[] emails) {}
                    - 배열 파리미터는 순서에 상관 없다.
                        - static void x2(String[] names, int a) {}

        - 메모리 구조
            - 운영체제로부터 할당받은 메모리 > Method area > JVM stack > Heap

            - JVM 메모리 실행 순서
                - 1) java -classpath bin com.eomcs.basic.ex07.Exam0410
                    - JVM은 클래스 정보를 Method Area 영역에 로드한다.
                - 2) main() 호출
                    - JVM Stack 영역에 main() 메서드가 사용할 로컬 변수를 준비한다.
                - 3) swap() 호출
                    - JVM Stack 영역에 swap() 메서드가 사용할 로컬 변수를 준비한다.
                - 4) swap() 실행 완료
                    - JVM Stack 영역에 있던 swap()이 사용한 메모리를 제거한다.
                - 5) main() 실행 완료
                    - JVM Stack 영역에 있던 main()이 사용한 메모리를 제거한다.
                - 6) JVM 실행 종료
                    - JVM이 사용한 모든 메모리를 OS에 반납한다.

            - JVM 메모리
                - 1) Method Area
                    - .class의 모든 소스코드를 두는 곳
                    - 클래스 명령 코드를 둔다.
                    - static 변수를 둔다.
                - 2) JVM Stack
                    - 스레드 별로 JVM Stack 메모리를 따로 관리한다.
                    - 각 메서드마다 프레임 단위로 관리한다.
                    - 프레임안에는 그 메소드의 로컬변수를 둔다(로컬변수안엔 파라미터(매개변수) 포함)
                    - 메서드 호출이 끝나면 그 메서드가 사용한 프레임 메모리가 제거된다.
                    - 이렇게 메서드가 호출될 때 로컬 변수가 준비되고
                    - 맨마지막에 호출한 메서드가 먼저 삭제된다고 해서 "스택(stack)" 메모리라 부른다.
                    - 스택? 접시 쌓는 것을 생각하라!
                    - 스택 방식을 "Last In First Out(LIFO;후입선출)"라 부른다. 
                    - JVM이 종료하면 JVM이 사용했던 모든 메모리를 OS에 반납한다.
                - 3) Heap
                    - new 명령으로 만든 변수의 메모리(인스턴스=객체)를 둔다.
                    - Garbage Collector(GC)가 관리하는 영역이다.

        - 메소드 호출 방식
            - 종류
                - 참고) 변수의 종류 2가지
                    - 1. primitive data type (원시데이터 타입) : byte , short , int , long , float , double , char , boolean 
                    - 2. reference (레퍼런스타입) : 데이터가 저장된 메모리의 주소를 저장하는 메모리, 원시데이터타입을 제외한 모든 변수타입
                
                - call by value 
                    - 메소드에 값(primitive type)을 전달하는 것
                    - 메소드 호출 시에 사용되는 인자의 메모리에 저장되어 있는 값(value)을 복사하여 보낸다.

                - call by reference
                    - 메소드에 객체(reference type)를 전달
                    - 메서드 호출 시 사용되는 인자 값의 메모리에 저장되어있는 주소(Address)를 복사하여 보낸다.
                    - 배열로 만드는 방법
                    - 클래스로 만드는 방법
                
                - 메서드 중첩 호출
                    - package com.eomcs.lang.ex07 Exam0280 참고
            
            - 자세한 개념 참고
                - https://re-build.tistory.com/3
                - https://wikidocs.net/265
        
    - ## 14일차
        - 2021.07.15

        - 복습
            - call by value
            - call by reference
            - JVM 메모리
            - Heap 메모리 영역
                - 1. jvm stack영역에 메모리(로컬변수)가 제거되고 종료됨
                - 2. Method area 영역에 메모리(메소드)가 종료되고 프로그램 끝남
                - 3. 메모리가 부족할 경우 가비지가 heap영역의 인스턴스메모리를 청소함
                - 4. 메모리가 충분할 경우 가비지는 청소하지 않지만, OS가 JVM이 사용한 모든 메모리(Method Area, JVM Stack, Heap 등)을 회수함
            - 메모리 구조
                - 예제 보면서 그림으로 과정 그려보기!
                - package com.eomcs.lang.ex07 Exam0430
                - package com.eomcs.lang.ex07 Exam0440

        - 메서드 : JVM Stack 메모리의 사용
            - package com.eomcs.lang.ex07 Exam0440 예제 참고 
                - 0) 시작
                - 1) main()
                - 2) main() => m1()
                - 3) main() => m1() => m2()
                - 4) main() => m1()
                - 5) main() => m1() => m3()
                - 6) main() => m1()
                - 7) main()
                - 8) 종료!

        - 메서드 : JVM Stack 메모리의 사용
            - 재귀호출 (package com.eomcs.lang.ex07 Exam0450 예제 참고)
                - 0) 시작
                - 1) main()
                - 2) main() => sum(5) 
                -            => 5 + sum(4) 
                -                   => 4 + sum(3)
                -                          => 3 + sum(2)
                -                                 => 2 + sum(1)
                -                                        => 1
                - 3) main()
                - 4) 종료!

                - 재귀호출(recursive call)
                    - 다른 메소드가 호출되면 스택에 그 메소드가 사용할 변수가 생성된다
                    - 수학식을 코드를 표현하기가 편하고 코드가 간결하다.
                    - 그러나 반복문을 사용하는 경우보다 메모리를 많이 사용한다.
                    - 멈춰야 할 조건을 빠뜨리면 스택 메모리가 극한으로 증가하여 메모리가 부족한 사태에 빠진다.
                    - 이런 사태를 "stackoverflow"라 부른다.
                    - 그래서 큰 수(즉 많이 호출되는 경우)에 대해서 재귀호출을 할 때 스택오버플로우가 자주 발생한다.
                    - 메서드 호출이 너무 깊게 들어가지 않는 상황에서 재귀호출을 사용하라.

                - 스택 오버플로우
                    - JVM 스택 메모리가 꽉 차서 더이상 메서드 실행을 위해 로컬 변수를 만들 수 없는 상태이다.
                    - 큰 수를 계산할 때는 재귀호출의 수가 높아져서 쉽게 스택 메모리가 부족해지는 문제가 발생한다.
                    - ex) sum(int value) > sum메소드의 값의 크기를 임의로 키워줌 > sum(long value) 으로 수정
                    - 호출하는 메서드의 로컬 변수 값이 클 때는 스택 메모리가 빨리 찬다.
                    - 즉 스택 오버플로우는 메서드 호출 회수에 영향을 받는 것이 아니라,
                    - 메서드에서 생성하는 로컬 변수의 크기에 영향을 받는다.

        - 메서드 : main() 메서드
            - JVM이 클래스를 실행할 때 main() 메서드를 호출
            - public static void main(String[] 변수명)

        - 프로그램 아규먼트
            - package com.eomcs.lang.ex07; (Exam0520)
            - 프로그램 아규먼트는 스트링 배열에 담겨서 main()를 호출할 때 넘어온다. (public static void main(String[] args))
            - jvm을 실행할 때 프로그램에 전달하는 값
            - $ java 클래스명 값1 값2 값3
            - 예) java -cp bin Exam0520 aaa bbb cccc
            - aaa bbb cccc 가 프로그램 아규먼트이다.
            - 공백을 기준으로 문자열을 잘라서 String[]배열을 만든다. (aaa bb ccccc)
            - = 아규먼트는 공백으로 구분한다.
            - 아규먼트가 없으면 빈 배열이 넘어온다.
            - 그런후 main()을 호출할 때 그 배열의 주소를 넘겨준다.
                
            - 응용 I
                - $ java -cp ./bin/main com.eomcs.lang.ex07.Exam0530 200 43 56 일때
                    - 0번 변수에 200
                    - 1번 변수에 43
                    - 2번 변수에 56 이 저장되고
                    - 공백은 다 버려짐

        - JVM 아규먼트 / 프로그램 아큐먼트와 다름
            - package com.eomcs.lang.ex07; (Exam0610)
            - JVM에게 전달하는 값
            - $java -cp ./bin/main -D이름=값 -D이름=값 -D이름=값 com.eomcs.basic.ex07.Exam0610
            - JVM 아규먼트의 값 꺼내기
                - : System.getProperty("이름");
                - 값마다 이름을 부여할수 있음
            - JVM에 기본으로 설정되어 있는 프로퍼티를 모두 출력
                - JVM의 전체 프로퍼티 목록 가져오기

                - ex )  java.util.Properties props = System.getProperties();
                        java.util.Set keySet = props.keySet();

                        for (Object key : keySet) {
                            props.getProperty((String) key);
                            System.out.printf("%s = %s\n", key, value);
                        }
                - 해석
                    - System.getProperties(); : JVM을 실행하면 OS로부터 정보를 수집하여 보관해둔다 (사용자의 홈폴더 경로 등등)
                    - props.keySet(); : Properties 객체에 저장되어 있는 값의 이름(key)을 알아낸다. keySet()이 리턴하는것은 이름이 들어있는 집합이다.
                    - (Object key : keySet) : 이름이 들어있는 집합에서 한 개의 이름을 가져와서 그 이름으로 저장된 값을 꺼낸다.
                        - 이름집합에서 꺼낸 값이 실제는 STring이지만,
                        - 문법 상에서는 object로 되어 있어서 변수를 선언할때 object타입으로 변수를 선언해야 한다.
                    - props.getProperty((String) key) : getProperty 에 이름을 전달할때는 String으로 전달해야한다
                        - key에 들어 있는것은 String이 맞지만 문법 상으로는 key변수가 object로 되어 있다
                        - 따라서 getPropert()에 key변수가 들어있는 값을 전달할때
                        - String 타입이라고 컴파일에게 알려줘야 한다.

        - 알고리즘 테스트
            - algorithm.quiz.stu_quiz
            - Test1 /  Test2 / Test3 / Test4 / Test5
            - 5개 풀어보고 해석했음 (예제참고)

    - ## 15일차
        - 2021.07.16

        - 클래스 추출(Extract Class)
            - 추출방법 1 : 메서드 분류
                - 04-a 예제 참고
                - 역할에 따라 메서드를 분류
                - 서로 관련된 일을 하는 메서드들을 한 곳에 묶어 놓는것
                - 새로운 클래스를 만들어서 같은 소스코드끼리 작성해준다
                - 변수명을 알아볼수 있도록 지정해준다.
                - 04-a 예제 실습

            - 추출방법 2 : 데이터타입 분류
                - 04-b 예제 참고
                - 새 데이터 타입 정의 (user defined data type)
                - 복합 데이터를 저장하는 메모리를 설계
                - 여러개의 값(변수)을 묶어 한 단위로 다루고 싶을때 새로운 클래스를 생성한다
            
            - 추출방법 3 : 패키지 분류
                - 04-c 예제 참고
                - 여러 개의 클래스를 역할이나 용도에 따라 관리하기 좋게 분류하는 문법
                - 보통 정의되어 있는 패키지 이름
                    - 프로젝트 패키지
                        - domain 패키지
                        업무에서 다루는 데이터를 표현
                        사용자 정의데이터 타입을 두는 패키지
                        vo(value object),dto(data transfer object) 라고도 한다 
                        - handler 패키지
                        : 업무를 처리하는 클래스를 두는 패키지
                    - util 패키지 
                        - 여러 프로젝트에 재사용할 수 있는 기능을 수행하는 클래스를 두는 패키지

    - ## 16일차 (주말스터디)
        - 2021.07.17
        
        - LENGTH
            - length : 배열의 크기 값
            - length() : 문자열의 길이
            - size() : 컬렉션프레임워크 타입의 길이

        - 자바에서 length 필드
            - 배열의 저장 공간과 합계 배열의 크기 값을 가진 공간
            - for문의 반복에 length 필드를 이용하면 배열의 크기가 정해져있지 않아도
              반복이 끝난 후 합계 배열의 크기값을 알 수 있다 (변수명.length)

- ## 2021.07.19 ~ 2021.07.23
    - ## 16일차