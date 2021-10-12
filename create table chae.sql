mysql -u root -p

create user 'chae'@'localhost' identified by '1111';

create database chaedb character set utf8 collate utf8_general_ci;

grant all on chaedb.* to 'chae'@'localhost';

exit

mysql -u chae -p

show databases;

use chaedb

- 회원 테이블 member 
create table member (
   member_id int,
   member_name varchar(50),
   birthday date,
   tel int
)

- 고객 테이블 customer
create table customer (
   customer_id int,
   customer_name varchar(45),
   birthday date,
   membertype_id tinyint   /*고객 회원 타입*/
);

insert into customer(customer_id, customer_name, birthday, membertype_id)
values(1, 김바람, 1984-06-24, 2);

insert into customer(customer_id, customer_name, birthday, membertype_id)
values(2, 이구름, 1990-07-16, 1);

insert into customer(customer_id, customer_name, birthday, membertype_id)
values(3, 박하늘, 1976-03-09, 2);

insert into customer(customer_id, customer_name, birthday, membertype_id)
values(4, 강산, 1991-05-04, 1);

insert into customer(customer_id, customer_name, birthday, membertype_id)
values(5, 유바다, 1993-04-21, 2);

- 고객 회원 타입 테이블 membertype
create table membertype (
   membertype_id int,      /* 회원타입 ID */
   membertype varchar(5)   /* 회원타입명 */
)

- 상품 테이블 product
create table product (
   product_id int,
   product_name varchar(20),
   stock int,
   price decimal(10.0)
)

- 주문 테이블 productToOrder
create table productToOrder (
   order_id int,
   customer_id int,
   product_id int,
   quantity int,     /*주문 수*/
   price decimal(10.0),
   order_time datetime
)


### 컬럼 타입

#### int
- 4바이트 크기의 정수 값 저장
- 기타 tinyint(1바이트), smallint(2바이트), mediumint(3바이트), bigint(8바이트)

#### float
- 부동소수점 저장

#### numeric = decimal
- 전체 자릿수와 소수점 이하의 자릿수를 정밀하게 지정할 수 있다.
- numeric(n,e) : 전체 n 자릿수 중에서 소수점은 e 자릿수다.
  - 예) numeric(10,2) : 12345678.12
- numeric : numeric(10, 0) 과 같다.

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