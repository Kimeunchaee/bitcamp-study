# bitcamp-study

- # mariadb 설치 및 설정
    - ## mariadb 설치
        - [windows OS]

        - https://mariadb.org/download/
            - 윈도우 다운로드 > 마리아DB
            - 환경변수 path에 추가
            - 윈도우 > 서비스 > 설치됐는지 확인 

        - scoop 패키지 관리자를 이용하여 mariadb 설치
            - scoop install mariadb

        - 서비스에 등록 
            - mysqld --install "서비스명"
            - mysqld --install "mariadb"

        - 서비스 시작 
            - net start 서비스명
            - net start mariadb

        - 서비스 종료
            - net stop 서비스명
            - net stop mariadb

    - ## mysql 서버에 접속하기
        - 로컬 MySQL 서버에 접속
            - mysql -u root -p
            - Enter password: 암호입력

    - ## root 사용자 접근 거부 오류 발생시(linux)
        - 일단 권한 검사를 하지 않는 모드로 MariaDB를 실행
            - $ sudo mysqld_safe --skip-grant-tables

        - root 사용자가 로컬호스트에서 접근할 수 있도록 설정을 변경
            - $ sudo mysql -u root -p   <--- MariaDB 서버에 접속
            - grant all privileges on *.* to 'root'@'localhost' identified BY '<password>';
            - flush privileges;

        - 만약, 위의 명령이 실행되지 않으면, 다음 명령을 실행
            - update mysql.user set plugin = 'mysql_native_password' WHERE user = 'root' and plugin = 'unix_socket';
            - flush privileges;
            - exit

        - 다시 명령 프롬프트로 나와 MariaDB 를 실행 종료
            - 현재 실행 중인 MariaDB 프로세스를 알아낸다.
                - $ ps -el | grep mysql
            - 모든 MariaDB 프로세스를 종료한다.
                - $ sudo kill 프로세스번호

        - 그리고 다시 정식으로 MariaDB 서버를 실행
            - $ service mariadb start

        - 원격 MySQL 서버에 접속
            - mysql -h 서버주소 -u root -p
            - Enter password: 암호입력  

    - ## mysql root 암호 변경
        - alter user 'root'@'localhost' identified by '1111';

- # MySQL 사용자
    - ## MySQL 사용자 추가
        - create user '사용자아이디'@'원격호스트주소' identified by '암호';

        - 로컬에서만 접속할 수 있는 사용자를 만들기:
            - create user 'study'@'localhost' identified by '1111';
            - 이 경우 study 사용자는 오직 로컬(서버를 실행하는 컴퓨터)에서만 접속 가능한다.
            - 다른 컴퓨터에서 실행하는 MySQL 서버에 접속할 수 없다는 것을 의미한다.

        - 원격에서만 접속할 수 있는 사용자를 만들기:
            - create user 'study'@'%' identified by '1111';
            - 이 경우 study 사용자는 원격에서만 접속 가능하다.

    - ## MySQL 사용자 목록 조회
        - select user, host from 데이터베이스명.테이블명;
        - select user, host from mysql.user;

    - ## MySQL 사용자 삭제
        - drop user '아이디'@'원격호스트주소';
        - drop user 'study'@'localhost';

- # MySQL 데이터베이스
    - ## MySQL 데이터베이스 생성
        - mariadb에서는 default 키워드를 사용하지 않는다.
            - create database 데이터베이스명 character set utf8 COLLATE utf8_general_ci;
            - create database studydb character set utf8 COLLATE utf8_general_ci;

    - ## MySQL 데이터베이스 삭제
        - drop database 데이터베이명;
        - drop database studydb;

    - ## MySQL 사용자에게 데이터베이스 사용 권한 부여
        - grant all on 데이터베이스명.* TO '사용자아이디'@'서버주소';
        - grant all on studydb.* TO 'study'@'localhost';

    - ## 데이터베이스 목록 조회
        - show databases;

    - ## 사용자 교체
        - quit or exit  (프로그램 종료 후)
        - mysql -u study -p   (다시 실행)

    - ## 기본으로 사용할 데이터베이스 지정하기
        - use 데이터베이스명
        - use studydb;

    - ## 데이터베이스의 전체 테이블 목록 조회
        - show tables;

- # DDL(Data Definition Language)
    - DB 객체(테이블, 뷰, 함수, 트리거 등)를 생성, 변경, 삭제하는 SQL 명령
        - 데이터베이스(database) = 스키마(schema)
        - 테이블(table)
        - 뷰(view)
        - 트리거(trigger)
            - 특정 조건에서 자동으로 호출되는 함수
            - 특정 조건? SQL 실행 전/후 등
            - OOP 디자인 패턴에서 옵저버에 해당한다.
        - 함수(function)
        - 프로시저(procedure)
        - 인덱스(index)

    ## 데이터 베이스
    - 데이터베이스 생성
        - create database 데이터베이스명 옵션들...;

    - 데이터베이스 삭제
        - drop database 데이터베이스명;

    - 데이터베이스 변경
        - alter database 데이터베이스명 옵션들...;

    ## 테이블
    - 테이블 생성
        - create table 테이블명 (
        컬럼명 타입 NULL여부 옵션,
        컬럼명 타입 NULL여부 옵션,
        ...
        컬럼명 타입 NULL여부 옵션
        );

        - create table test01 (
            name varchar(50) not null,
            kor int not null,
            eng int not null,
            math int not null,
            sum int not null,
            aver float not null
        );

    - 테이블 정보 보기
        - describe 테이블명;
        - desc 테이블명;
        - 예) describe test01;
        - 예) desc test01;

    - 테이블 삭제하기
        - drop table 테이블명;
        - 예) drop table test01;

    ## 테이블 컬럼 옵션
    - 1) null 허용
        - 데이터를 입력하지 않아도 된다.
        - > create table test1 (
                no int,
                name varchar(20)
            );

        - 데이터 입력 테스트:
        - > insert into test1(no, name) values(1, 'aaa');
        - > insert into test1(no, name) values(null, 'bbb');
        - > insert into test1(no, name) values(3, null);
        - > insert into test1(no, name) values(null, null);
        - > select * from test1;

    - 2) not null
        - 데이터를 입력하지 않으면 입력/변경 거절!
        - > create table test1(
            no int not null,
            name varchar(20)
        );

    데이터 입력 테스트:
    > insert into test1(no, name) values(1, 'aaa');
    > insert into test1(no, name) values(null, 'bbb'); /* 실행 오류 */
    > insert into test1(no, name) values(3, null);

- 3) 기본값 지정
입력할 때 컬럼을 생략하면 지정된 기본값이 대신 입력된다.
> create table test1(
    no int not null,
    name varchar(20) default 'noname',
    age int default 20
  );

> insert into test1(no, name, age) values(1, 'aaa', 30);

- 값을 입력하지 않는 컬럼은 이름과 값 지정을 생략
> insert into test1(name, age) values('aaa', 30); /* 오류! no는 not null*/
> insert into test1(no, age) values(3, 30);
> insert into test1(no, name) values(4, 'ddd');
> insert into test1(no) values(5);

- 컬럼에 default 옵션이 있는 경우,
- 컬럼 값을 생략하면 default 옵션으로 지정한 값이 사용된다.
- 컬럼 값을 null로 지정하면 기본 값이 사용되지 않는다.
> insert into test1(no, age, name) values(6, null, null);

### 컬럼 타입

#### int
- 4바이트 크기의 정수 값 저장
- 기타 tinyint(1), smallint(2), mediumint(3), bigint(8)

#### float
- 부동소수점 저장

#### numeric = decimal
- 전체 자릿수와 소수점 이하의 자릿수를 정밀하게 지정할 수 있다.
- numeric(n,e) : 전체 n 자릿수 중에서 소수점은 e 자릿수다.
- numeric : numeric(10, 0) 과 같다.

입력 테스트:
> create table test1(
  c1 int,
  c2 float,
  c3 numeric(6,2), /* 소수점 자릿수를 지정하면 부동소수점으로 사용 */
  c4 numeric -- decimal 과 같다
  );

> insert into test1(c1) values(100);
> insert into test1(c1) values(3.14); /* 소수점 이하 반올림하고 짜름 */
> insert into test1(c1) values(100.98); /* 소수점 이하 반올림하고 짜름 */

> insert into test1(c2) values(100);
> insert into test1(c2) values(3.14);
> insert into test1(c2) values(3.14159);

> insert into test1(c3) values(100);
> insert into test1(c3) values(123456789); /* 입력 오류. 5자리 초과 */
> insert into test1(c3) values(12345); /* 입력 오류. 1자리 초과 */
> insert into test1(c3) values(1234);
> insert into test1(c3) values(3.14);
> insert into test1(c3) values(3.14159); /* 2자리를 초과한 값은 반올림. */
> insert into test1(c3) values(3.14551); /* 2자리를 초과한 값은 반올림. */

> insert into test1(c4) values(1234567890);
> insert into test1(c4) values(12.34567890); /* 소수점은 반올림 처리됨 */
> insert into test1(c4) values(12345678.90); /* 소수점은 반올림 처리됨 */

#### char(n)
- 최대 n개의 문자를 저장.
- 0 <= n <= 255
- 고정 크기를 갖는다.
- 한 문자를 저장하더라도 n자를 저장할 크기를 사용한다.
- 메모리 크기가 고정되어서 검색할 때 빠르다.

#### varchar(n)
- 최대 n개의 문자를 저장.
- 0 ~ 65535 바이트 크기를 갖는다.
- n 값은 문자집합에 따라 최대 값이 다르다.
- 한 문자에 1바이트를 사용하는 ISO-8859-n 문자집한인 경우 최대 65535 이다.
- 그러나 UTF-8로 지정된 경우는, n은 최대 21844까지 지정할 수 있다.
- 가변 크기를 갖는다.
- 한 문자를 저장하면 한 문자 만큼 크기의 메모리를 차지한다.
- 메모리 크기가 가변적이라서 데이터 위치를 찾을 때 시간이 오래 걸린다.
  그래서 검색할 때 위치를 계산해야 하기 때문에 검색 시 느리다.

> create table test1(
  c1 char(5),
  c2 varchar(5),
  c3 varchar(21000)
  );

입력 테스트:
> insert into test1(c1) values('');
> insert into test1(c1) values('abcde');
> insert into test1(c1) values('가나다라마'); /* 한글 영어 상관없이 5자 */
> insert into test1(c1) values('abcdefghi'); /* 입력 크기 초과 오류! */
> insert into test1(c1) values('가나다라마바'); /* 입력 크기 초과 오류! */

> insert into test1(c2) values('');
> insert into test1(c2) values('abcde');
> insert into test1(c2) values('abcdefghi'); /* 입력 크기 초과 오류! */

고정 크기와 가변 크기 비교:
> insert into test1(c1) values('abc');
> insert into test1(c2) values('abc');

> select * from test1 where c1='abc';
DBMS 중에는 고정 크기인 컬럼의 값을 비교할 때 빈자리까지 검사하는 경우도 있다.
즉 c1='abc'에서는 데이터를 찾지 못하고, c1='abc  '여야만 데이터를 찾는 경우가 있다.
그러나 mysql은 고정크기 컬럼이더라도 빈자리를 무시하고 데이터를 찾는다.

#### text(65535), mediumtext(약 1.6MB), longtext(약 2GB)
- 긴 텍스트를 저장할 때 사용하는 컬럼 타입이다.
- 오라클의 경우 long 타입과 CLOB(character large object) 타입이 있다.

#### date
- 날짜 정보를 저장할 때 사용한다.
- 년,월,일 정보를 저장한다.
- 오라클의 경우 날짜 뿐만 아니라 시간 정보도 저장한다.

#### time
- 시간 정보를 저장할 때 사용한다.
- 시, 분, 초 정보를 저장한다.

#### datetime
- 날짜와 시간 정보를 함께 저장할 때 사용한다.

> create table test1(
  c1 date,
  c2 time,
  c3 datetime
  );

입력 테스터:
> insert into test1(c1) values('2017-11-21');
> insert into test1(c2) values('16:12:35');
> insert into test1(c3) values('2017-9-7 16:5:3');
> insert into test1(c1) values('2017-11-21 16:13:33'); /* 날짜 정보만 저장*/
> insert into test1(c2) values('2017-11-21 16:13:33'); /* 시간 정보만 저장*/

#### boolean
- 보통 true, false를 의미하는 값을 저장할 때는 정수 1 또는 0으로 표현한다.
- 또는 문자로 Y 또는 N으로 표현하기도 한다.
- 실제 컬럼을 생성할 때 tinyint(1) 로 설정한다.

> create table test1(
  c1 char(1),
  c2 int,
  c3 boolean
  );


> insert into test1(c1) values('Y'); /* yes */
> insert into test1(c1) values('N'); /* no */
> insert into test1(c1) values('T'); /* true */
> insert into test1(c1) values('F'); /* false */
> insert into test1(c1) values('1'); /* true */
> insert into test1(c1) values('0'); /* false */

> insert into test1(c2) values(1); /* true */
> insert into test1(c2) values(0); /* false */

> insert into test1(c3) values('Y'); /* error */
> insert into test1(c3) values('N'); /* error */
> insert into test1(c3) values('T'); /* error */
> insert into test1(c3) values('F'); /* error */

> insert into test1(c3) values(true); /* 저장할 때 1 */
> insert into test1(c3) values(false); /* 저장할 때 0 */
> insert into test1(c3) values('1'); /* true -> 1 */
> insert into test1(c3) values('0'); /* false -> 0 */
> insert into test1(c3) values(1); /* true -> 1 */
> insert into test1(c3) values(0); /* false -> 0 */

- 숫자 컬럼인 경우 값을 설정할 때 문자로 표현할 수 있다.
- 즉 문자열을 숫자로 바꿀 수 있으면 된다.