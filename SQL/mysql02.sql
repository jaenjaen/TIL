-- 이름
-- 1.문자 관련 함수

-- 변수가 붙어서 나옴 concat
select concat(ename," ",job) as Message
from emp;

-- 잘라내는 함수 substr()
select ename, substr(hiredate,1,4)
from emp;

select ename, substr(hiredate,6,2) 월
from emp;

select ename, substr(hiredate,9,2) 일
from emp;

-- 2. 숫자관련 함수: abs()
-- blake와 smith의 차
select distinct abs((select sal
				  from emp
                  where ename = "BLAKE")-(select sal
										  from emp
                                          where ename = "SMITH")) as "Blake sal - SMITH sal"
from emp;

-- mob()
select ename, mod(empno,2) from emp;

-- 업무가 saleman인 모든 사원에 대해서 comm에 대한 급여 비율에 대한 나머지 검색

select ename, sal, comm,mod(sal,comm)
from emp
where job = 'SALESMAN';

-- round celiling floor truncate
-- round (숫자,n번째자리까지 남길것)
select round(45.923,2);
select round(45.923);
select round(45.923,0);
select round(45.923,-1);

-- floor 자리수 지정 안됨
select floor(45.923);

-- truncate는 자리수 지정해야됨
select truncate(45.923);
select truncate(45.923,0);
select truncate(45.923,1);

-- 날짜관련함수
select now();
select sysdate();
select curdate();
select current_time();
select DATE();

-- 970619
select datediff(curdate(),"1997-06-19");
select datediff(curdate(),"2020-04-27");
select datediff(curdate(),"1988-05-26");

-- emp 테이블에서 모든 사원들이 지금까지 근무한 일수
select ename, datediff(curdate(),hiredate) 근무일수
from emp;

select ename, floor(datediff(curdate(),hiredate)/7) 근무주수
from emp;

Select DATE_ADD(curdate(), INTERVAL 100 day);

-- 날짜 - 날짜 = 일수 
-- 날짜 +- 숫자 = 날짜

-- 4. 그룹함수
-- *는 기본키에 해당하는 모든 rows라고 생각하면 쉬움
select count(*)
from emp;

-- null은 그룹함수에서 제외
select count(comm)
from emp;

select  min(hiredate) '가장 빠른 입사일', max(hiredate) '가장 최근 입사일'
from emp;

select sum(sal)
from emp;

select round(avg(sal)) "사원평균총급여" 
from emp;

-- 업무가 mgr인 사원의 평균급여 검색
select round(avg(sal))
from emp
where job = "MANAGER";

-- 모든 사원의 보너스의 평균을 검색
select round(avg(ifnull(comm,0)))
from emp;

-- 사원테이블에서 모든 부서의 갯수 출력
select count(distinct(deptno))
from emp;

-- 부서번호가 10 or 20인 사원의 인원수 출력
select count(deptno)
from emp
where deptno = 10
	  or deptno =20;

select *
from emp
where deptno in (10,20);
      
 -- 부서번호가 10 or 20이 아닌 사원 인원수 출력
select count(deptno)
from emp
where deptno != 10
	and deptno !=20;

select count(deptno)
from emp
where deptno not in (10,20);
    

-- 사원 번호가 7369 이거나 7521이거나 7876인 사람 검색
select *
from emp
where empno = 7369
	 or empno = 7521
     or empno = 7876;

select *
from emp
where empno in (7369,7521,7876);

-- 부서에 평균 급여 검색
-- 그룹함수에 적용되지 않은 컬럼이 select에 있으면 반드시 group by 절 뒤에 명시해줘야함
select deptno,round(avg(sal))
from emp
group by deptno
order by deptno;

select deptno,sum(sal)
from emp
group by deptno
order by deptno;

-- 입사년도 별 입사 직원 수
select year(hiredate) 입사년도, count(hiredate) 입사인원
from emp
group by year(hiredate)
order by year(hiredate);

-- 부서별 평균급여를 구하는데 20번 부서는 제외
select deptno, round(avg(sal))
from emp
where deptno != 20
group by deptno
order by deptno asc;

-- 부서별 평균급여가 2000달러가 넘는 부서의 부서번화와 평균급여
-- where절에서는 그룹함수 못씀
select deptno, round(avg(sal))
from emp
group by deptno
having round(avg(sal))>=2000
order by deptno asc;

-- 부서별 평균급여가 2000달러 이상인 부서의 부서번호와 평균급여를 구하고 10번부서는 제외
select deptno, round(avg(sal))
from emp
where deptno != 10
group by deptno
having round(avg(sal))>=2000
order by deptno asc;

insert into myTable (id,name,addr,birthdate)
Values (1,"이재은","서초동","1995-02-28");

insert into myTable (id,name,addr,birthdate)
Values (2,"차승아","홍제동","1995-02-17");

insert into myTable (id,name,addr,birthdate)
Values (3,"김보라","고색동","1994-12-05");

select *
from myTable;

update myTable set addr='이충동', name='배상은'
where id=2;

/*
테이블 생성
create table myTest(
	id tinyint not null,
    name varchar(10),
    addr varchar(50),
    birthDate date);
    
테이블에 값 입력
Insert into myTest (id, name, addr,birthDate)
values(1,'A','A','2020-04-28');

테이블에서 값 삭제
delete from myTest; 모든 행 삭제
delete from mytest
where 조건문;

테이블 컬럼값 수정
update myTest set 수정할 컬럼명 =  컬럼값, 수정할 컬럼명2 =  컬럼값2
where 조건문;
*/









create table test1(
	num int auto_increment primary key,
    name varchar(20),
    age tinyint,
    height decimal(5,1),
    birthDate datetime,
    hiredate date);

desc test1;

insert into test1 (name,age,height,birthDate,hiredate)
values ("이재은",27,168.0,'1995-02-28','2012-12-14');
insert into test1 (name,age,height,birthDate,hiredate)
values ("김보라",27,158.8,'1994-12-05','2011-11-29');
insert into test1 (name,age,height,birthDate,hiredate)
values ("배상은",27,160.2,'1995-02-24','2015-07-14');
insert into test1 (name,age,height,birthDate,hiredate)
values ("차승아",27,161.2,'1995-02-17','2014-03-01');

select *
from test1;

-- 컬럼명 변경
alter table test1
change birthDate birthdate datetime;

desc test1;

-- 컬럼 속성 변경
alter table test1
change birthdate birthdate date;

desc test1;

-- num이 3번인 데이터를 삭제
DELETE FROM test1
where num = 3;

-- NUM이 2번인 데이터의 키와 나이를 수정
-- 기본키의 update 대상이 아님.
update test1 set height = 155.0, age = 26
where num = 2;

select *
from test1;

delete from test1;
truncate table test1;
drop table test1;

/*
delete from test1; -> 테이블의 구조 남김 / 한줄씩 지움 / 기존 데이터에 이어서 increment가 진행됨
truncate table test1; -> 구조남김 / 데이터 전체를 들어내버림(훨 빠름) increment 1부터 다시시작
drop table test1;

SQL
DML(manupulation) - insert delete(trancate) update
DDL(definition) - create drop alter
*/
