/*  INSERT 문
      INSERT INTO 테이블명 (컬럼명, 컬럼명, ....);
      VALUES(값, 값, ....)
    


 */


/*주소정보 입력*/
insert into ADDRS(postno, bas_addr) values('100-100', '서울 강남구');
insert into ADDRS(postno, bas_addr) values('100-101', '서울 서초구');
insert into ADDRS(postno, bas_addr) values('100-102', '서울 마포구');
insert into ADDRS(postno, bas_addr) values('100-103', '서울 영등포구');
insert into ADDRS(postno, bas_addr) values('100-104', '서울 송파구');
insert into ADDRS(postno, bas_addr) values('100-105', '서울 관악구');
insert into ADDRS(postno, bas_addr) values('100-106', '서울 동작구');
insert into ADDRS(postno, bas_addr) values('100-107', '서울 강동구');
insert into ADDRS(postno, bas_addr) values('100-108', '서울 중구');
insert into ADDRS(postno, bas_addr) values('100-109', '서울 은평구');

/* 데이터조회 
 * SELECT 컬럼명, 컬럼명 ... FROM 테이블명
 * SELECT * FROM 테이블명
 */
SELECT * FROM ADDRS;

/* 조회정보 입력*/
insert into MEMBERS(UID, PWD, EMAIL, UNAME, TEL)
values('u01', '1111', 'u01@test.com', '홍길동', '111-1111');

insert into MEMBERS(UID, PWD, EMAIL, UNAME, TEL)
values('u02', '1111', 'u02@test.com', '임꺽정', '111-1111');

insert into MEMBERS(UID, PWD, EMAIL, UNAME, TEL)
values('u03', '1111', 'u03@test.com', '유관순', '111-1111');

insert into MEMBERS(UID, PWD, EMAIL, UNAME, TEL)
values('u04', '1111', 'u04@test.com', '안중근', '111-1111');

insert into MEMBERS(UID, PWD, EMAIL, UNAME, TEL)
values('u05', '1111', 'u05@test.com', '윤봉길', '111-1111');

insert into MEMBERS(UID, PWD, EMAIL, UNAME, TEL)
values('u06', '1111', 'u06@test.com', '이순신', '111-1111');

insert into MEMBERS(UID, PWD, EMAIL, UNAME, TEL)
values('u07', '1111', 'u07@test.com', '김구', '111-1111');

insert into MEMBERS(UID, PWD, EMAIL, UNAME, TEL)
values('u08', '1111', 'u08@test.com', '김좌진', '111-1111');

insert into MEMBERS(UID, PWD, EMAIL, UNAME, TEL)
values('u09', '1111', 'u09@test.com', '안창원', '111-1111');

insert into MEMBERS(UID, PWD, EMAIL, UNAME, TEL)
values('u10', '1111', 'u10@test.com', '이봉창', '111-1111');

/* 문제1 : 회원의 아이디와 이름 , 이메일을 출력하라*/
select UID, UNAME, EMAIL from MEMBERS;

/* 문제2 : 위의 결과를 출력할 때 아이디와 이름의 라벨명(alias)을 id, name으로 바꿔라
 * 컬럼명 as 벌명
 * 컬럼명 별명 <== as 생략 가능
 * 컬럼명 (as) 벌명
 */
select UID as ID, UNAME NAME, EMAIL 
from MEMBERS;


/* 문제3: 회원 정보를 출력할 때 다음과 같이 출력하시오.
 * 회원명(이메일)
*/

select concat(UNAME, '(', EMAIL, ')') as USERNAME
from MEMBERS;

/* 제조사 */
insert into MAKERS(MKNAME, HOME ,TEL)
values('애플', 'www.apple.com', '100-1001');

insert into MAKERS(MKNAME, HOME ,TEL)
values('삼성', 'www.samsung.com', '100-1002');

insert into MAKERS(MKNAME, HOME ,TEL)
values('LG', 'www.lg.com', '100-1003');

insert into MAKERS(MKNAME, HOME ,TEL)
values('IBM', 'www.ibm.com', '100-1004');

insert into MAKERS(MKNAME, HOME ,TEL)
values('인텔', 'www.intel.com', '100-1005');

insert into MAKERS(MKNAME, HOME ,TEL)
values('구글', 'www.google.com', '100-1006');

/* 제품 입력*/
insert into PRODUCTS(PNAME, QTY, MKNO)
values('아이폰6', 100, 1);

insert into PRODUCTS(PNAME, QTY, MKNO)
values('아이폰5', 100, 1);

insert into PRODUCTS(PNAME, QTY, MKNO)
values('아이폰패드', 50, 1);

insert into PRODUCTS(PNAME, QTY, MKNO)
values('갤럭시S5', 2000, 2);

insert into PRODUCTS(PNAME, QTY, MKNO)
values('갤럭시S4', 1000, 2);

insert into PRODUCTS(PNAME, QTY, MKNO)
values('갤럭시노트', 500, 2);

insert into PRODUCTS(PNAME, QTY, MKNO)
values('구글글라스', 10000, 6);

insert into PRODUCTS(PNAME, QTY, MKNO)
values('넥서스7', 100, 6);

/* 사진 정보 입력*/

insert into PROD_PHOTS( PNO, URL)
values(1, 'a01.gif');

insert into PROD_PHOTS( PNO, URL)
values(2, 'a02.gif');

insert into PROD_PHOTS( PNO, URL)
values(4, 'a04.gif');

insert into PROD_PHOTS( PNO, URL)
values(5, 'a05.gif');

insert into PROD_PHOTS( PNO, URL)
values(7, 'a07.gif');

insert into PROD_PHOTS( URL)
values('x01.gif');

insert into PROD_PHOTS( URL)
values('x02.gif');

insert into PROD_PHOTS( URL)
values('x03.gif');



/* 주문 정보 입력*/
insert into ORDERS(PNO, UID, QTY, ODATE)
values (1, 'u01', 1, '2014-05-07');

insert into ORDERS(PNO, UID, QTY, ODATE)
values (1, 'u02', 3, '2014-06-07');

insert into ORDERS(PNO, UID, QTY, ODATE)
values (2, 'u01', 3, '2014-07-07');

insert into ORDERS(PNO, UID, QTY, ODATE)
values (2, 'u05', 1, '2014-08-07');

insert into ORDERS(PNO, UID, QTY, ODATE)
values (3, 'u07', 6, '2014-09-07');

insert into ORDERS(PNO, UID, QTY, ODATE)
values (7, 'u10', 1, '2014-10-07');

insert into ORDERS(PNO, UID, QTY, ODATE)
values (1, 'u01', 3, '0000-00-00');


/* 
 *  UPDATE명령
 * 문법
 * update 테이블명 set 컬럼명 = 값, 컬럼명=값,....
 * 
 * ㅇㄷ
 * 
 * */


insert into ORDERS(PNO, UID, QTY, ODATE)
values (7, 'u03', 5, '2014-11-10');

update ORDERS set 
QTY=3,
ODATE='2014-11-09'
where ONO =7

/*  DELETE 명령
 *  문법:
 *  delete from 테이블명 where 조건1...
 * 
 */


delete from ORDERS where ONO=7;



/* DISTINCT
 * 중복 데이터 제거
 * distinct 를 붙이지 않으면 기본으로 ALL이다.
 * 1.모든 제품 번호를 출력하라
 * */
select /*ALL*/ PNO from PRODUCTS;

/* 2. 모든 주문 제품의 번호를 추력하라
 * */
select  /*ALL*/ PNO form ODERS;


/* 3.주문한 제품이 무엇무엇이 있는지 목록을 출력하라*/
select DISTINCT PNO from ORDERS;

/* ORDER BY절
 * 출력결과정렬
 * ORDER BY /*ASC*/ 컬럼명, /*ASC*/ 컬럼명, ...
 * =>나열된 컬럼 순서대로 정렬한다. 기본은 상향정렬(ㄱ ~ ㅎ)이다
 * ORDER BY DESC 컬럼명, ASC 컬럼명, ... 
 
 *  정렬조건
 * ASC(ENDING)  => 오름차순
 * DESC(ENDING) = > 내림차순
 * ORDER BY 절 수행 후 SELECT 실행
*/

/*1)기본출력*/
select *from MEMBERS;

/*2)이름을 오름차순으로 정렬하라*/
select UID, UNAME, EMAIL from MEMBERS ORDER BY UNAME /*ASC*/;

/*3)이름을 내림차순으로 정렬하라*/
select UID, UNAME, EMAIL from MEMBERS ORDER BY  UNAME DESC;

/*4)주문 정보를 제품 번호의 오름 차순으로 정렬하라*/
select *from ORDERS ORDER BY PNO;

/*5)주문 정보를 제품 번호의 오름 차순으로 정렬하고 
 *  사용자 아이디로 오름차순으로 정렬하라 */
select *from ORDERS ORDER BY PNO, UID;

/*6)주문 정보를 제품 번호의 오름 차순으로 정렬하고 
  사용자 아이디로 내림차순으로 정렬하라*/
select *from ORDERS ORDER BY PNO, UID DESC;



/*7)주문 정보를 제품 번호의 오름 차순으로 정렬하고 
  사용자 아이디로 내림차순으로 정렬하라
  => 정렬을 먼저 한 다음 SELECT를 실행한다.*/
select *from ORDERS ORDER BY PNO, UID DESC;

/*별명 붙이기 
 * 문법:
 * SELECT 컬럼명 [AS] 벌명, ...*/
select ONO AS NO, ODATE AS 'Order Date' , PNO 'Product No',
UID id from ORDERS;


/* WHERE 절
 * 문법
 * WHERE 조건1 (AND | OR) 조건2 ...
 */


/*연산자 사용*/
/*1) 더하기 연산자*/
select ono, qty, qty * 500000 as TOTAL from ORDERS;

/*2)비교 연산자*/
select ONO, QTY FROM ORDERS
WHERE QTY > 2;

select ONO, QTY FROM ORDERS
WHERE QTY = 1;

select ONO, QTY FROM ORDERS
WHERE QTY > 1 AND QTY <= 5;

/* 문자열 비교 */
 select UID, UNAME, EMAIL from MEMBERS 
 WHERE UNAME ='홍길동';
 
 /*   '%'는 0개 이상의 글자*/ 
 select UID, UNAME, EMAIL from MEMBERS 
 WHERE UNAME LIKE  '김%';

 /*   '-'는 1개의 글자*/
  select UID, UNAME, EMAIL from MEMBERS 
 WHERE UNAME LIKE  '김_진';

 
 /*제품명에 '럭시' 라는 글자를 포함한 모든 제품 선택하기
   => 주의! 검색 속도가 매우 느리다. */
 select PNO, PNAME
 FROM PRODUCTS
 WHERE PNAME LIKE '%럭시%';
 
 /* IN
  * 표현식 IN(값, 값, 값, ....)
  * => 표현식이 IN에 들어있는 값과 일치하면 TRUE*/
 
 /*삼성과 애플 제품을 출력하시오*/
 SELECT PNO, PNAME, MKNO
 FROM PRODUCTS
 WHERE MKNO = 1 OR MKNO = 2;
 
  SELECT PNO, PNAME, MKNO
 FROM PRODUCTS
 WHERE MKNO IN(1 , 2);
 
 /* NULL 여부 검사*/
 select *from PROD_PHOTS
 WHERE PNO IS NULL;
 
  select *from PROD_PHOTS
 WHERE PNO IS NOT NULL;

 /* BETWEEN A AND B*/
 select *from ORDERS
 WHERE QTY >= 1 AND QTY <= 3;
 
 select *from ORDERS
 WHERE QTY BETWEEN 1 AND 3;
 
 /*UNION => 결과의 결합
  두 개의 결과를 합쳐서 하나로 다루고 싶을 때
  예) 제품 이름과 제조사이름을 알고 싶다.*/
 select  PNAME FROM PRODUCTS
 UNION
 select MKNAME FROM MAKERS;
 
 /*예) 2014년 7월 이후의 주문 정보와 애플 제품의 주문 정보를 출력하시오. */
 
 /*UNION=> 두 결과 데이터를 합칠 때 중복 데이터 제거 */
 select * from ORDERS
 WHERE ODATE >= '2014-07-01'
 UNION
 select *from ORDERS WHERE PNO IN(1, 2, 3);
 
 /*UNION ALL=> 두 결과 데이터를 중복에 상관없이 합친다..*/ 
  select * from ORDERS
 WHERE ODATE >= '2014-07-01'
 UNION ALL
 select *from ORDERS WHERE PNO IN(1, 2, 3);
 
 
 /* 7월 이후 주문 정보 중에서 애플 제품을 제외한 주문 정보
  * MySQL은 MINUS가 없다, 다른 문법으로 대체해야한다.*/
 select * from ORDERS
 WHERE ODATE >= '2014-07-01'
 AND PNO NOT IN (1, 2, 3);
 
 /*서브 쿼리
  * 1) 주문 제품의 주문 번호와 제품명을 출력하라*/
 select 
 ONO, 
 PNO,
 (SELECT PNAME FROM PRODUCTS WHERE PNO =T1.PNO) AS NAME,  
 QTY FROM ORDERS T1;
 
 
 /*2) 검새5ㄱ어와 일치하는 회사 제품의 주문 정보를 출력하시오*/
 SELECT*
 FROM ORDERS
 WHERE PNO IN(SELECT PNO FROM PRODUCTS WHERE MKNO = 1);
 
 /*3) '2014-07-01' 이후에 주문한 정보 중에서  u01, u05가 주문한것*/
 select *
 from (select *from ORDERS WHERE ODATE >= '2014-07-01') as T1
 WHERE UID IN ('u01', 'u05');
 
 /*1) CROSS 조인
  * 두 개의 테이블 데이터를 M:N 조인*/
SELECT ONO, PNO, QTY FROM ORDERS;
SELECT PNO, PNAME FROM PRODUCTS;

select ONO, T1.PNO, T1.QTY, PNAME 
FROM ORDERS T1, PRODUCTS T2;

/*2) NATURAL 조인
 * => 두 개 테이블의 공통 컬럼을 기준으로 조인한다.
 * => 외부키를 기준으로 조인을 수행한다.
 * */

select ONO, T1.PNO, T1.QTY, PNAME 
FROM ORDERS T1, PRODUCTS T2
WHERE T1.PNO = T2.PNO;

/*2) NATURAL 조인 => T1 JOIN T2 USING(컬럼명, 컬럼명, ....)
 * 단, 조인할 때 기준이 되는 컬럼명이 일치해야한다. 
 * */
 select ONO, T1.PNO, T1.QTY, PNAME 
FROM ORDERS T1 JOIN PRODUCTS T2 USING(PNO);
 
/*2) NATURAL 조인 => T1 JOIN T2 ON 조인조건1....
  => 조인의 기준이 되는 컬럼명이 다를 때 사용
*/
 select ONO, T1.PNO, T1.QTY, PNAME 
FROM ORDERS T1 JOIN PRODUCTS T2 ON T1.PNO = T2.PNO;
 

/*3) OUTER JOIN
 * 제품 정보와 사진정보를 출력하되, 사진 정보도 함께 출력하라
 * --다음 질의문은 조잉ㄴ 가능한 결과만 출력한다.
 * */
SELECT T1.PNO, T1.PNAME, T2.URL
FROM PRODUCTS T1 JOIN PROD_PHOTS T2 ON T1.PNO = T2.PNO


/*조인이 불가능하더라도, 즉 조인할 데이터가 상대 테이블에 없더라도 
  반드시 기준이 되는 테이블의 데이터를 모두 출력하고 싶다면 OUTER 조인을 사용하라.
 문법:
  왼쪽 T1테이블을 기준으로 T2 테이블과 조인하라
  =>T1  LEFT(기준테이블) OUTER JOIN T2 ON 조인조건1....
  => 기준 테이블인 T1의 데이터는 모두 출력될 것이다.
  **/

SELECT T1.PNO, T1.PNAME, T2.URL
FROM PRODUCTS T1 LEFT OUTER JOIN PROD_PHOTS T2 ON T1.PNO = T2.PNO




/*******************************************************************************
 * 문제 : 다음 결과를 출력하시오! 4개 테이블 쪼인쪼인
 * 주문번호, 제품명, 제조사명, 주문수량, 잔여수량, 고객명, 고객이메일
 ******************************************************************************/

 SELECT T1.ONO, T2.PNAME, T3.MKNAME, T1.QTY, T2.QTY, T4.UNAME, T4.EMAIL 
 FROM 
 ORDERS T1 LEFT OUTER JOIN PRODUCTS T2 ON T1.PNO = T2.PNO
 LEFT OUTER  JOIN MEMBERS T4 ON T4.UID = T1.UID
 LEFT OUTER  JOIN MAKERS T3 ON T2.MKNO = T3.MKNO;
 



