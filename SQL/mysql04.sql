-- join 
select * from emp;
select * from dept;

-- 특정사원이 소속된 부서의 정보 검색
/*
* Cartesian Product = 단순 곱으로 테이블x테이블 (14*4)
* 1) 조인조건을 안줄 경우
* 2) 조인조건을 잘못 주거나
*
* Join조건 이용하는 방법
* 1) where절을 이용해서 각각 테이블의 공통 컬럼을 명시
* 2)
*/
select *
from emp, dept;


-- 1) 컬럼명 일일히 명시, 불필요한 컬럼이 출력되는 것 방지
select e.*,d.*
from emp e, dept d
where e.deptno = d.deptno;

-- 2) 
select e.empno, e.ename, e.sal, d.deptno, d.dname, d.loc
from emp e, dept d
where e.deptno = d.deptno;

-- 사원의 이름, 급여, 부서번호, 부서명을 검색 단, 급여가 2000 이상이고, 30번 부서에 한해서만 검색
-- where절에서 조인조건과 비조인 조건이 함께 쓰임 
select e.ename, e.sal, d.deptno,d.dname
from emp e, dept d
where e.deptno = d.deptno
and d.deptno = 30
and e.sal >= 2000;

select empno, ename, mgr
From emp
where ename = "BLAKE";

select empno, ename
From emp
where empno = 7839;

-- self join
select *
from (select empno, ename, mgr
	  from emp) e,
      (select empno, ename
      from emp) m;

select distinct e.empno as '사원번호', e.ename as'사원 이름' ,e.mgr as '상사번호' ,m.ename as '상사이름'
from emp e, emp m
where e.ename = "BLAKE"
and m.empno = e.mgr;

-- OUTER JOIN

select e.ename, e.deptno, d.dname 
from emp e, dept d
where e.deptno = d.deptno;

-- Right OUTER JOIN : join시 우측 테이블이 중심이 되어서 결과를 생산하게 해줌

select e.ename, e.deptno, d.dname 
from emp e RIGHT OUTER JOIN dept d
ON e.deptno = d.deptno;

-- LEFT OUTER JOIN 
select e.ename, e.deptno, d.dname 
from emp e LEFT OUTER JOIN dept d
ON e.deptno = d.deptno;

-- 특정사원의 상사의 이름 검색 (기존 13줄 출력) self join시 킹 없음
select concat(e.ename,'의 매니저는 ',m.ename,'입니다.') as INFO
from emp e, emp m
where m.empno = e.mgr;

-- KING까지 출력
select concat(e.ename,'의 매니저는 ',m.ename,'입니다.') as INFO
from emp e LEFT OUTER JOIN emp m
ON e.mgr = m.empno;

-- full outer join 용 테이블 만들고 예제 풀이
CREATE TABLE outer1(sid int);
CREATE TABLE outer2(sid int);

INSERT INTO outer1(sid) VALUES (10);
INSERT INTO outer1(sid) VALUES (20);
INSERT INTO outer1(sid) VALUES (40);

INSERT INTO outer2(sid) VALUES (10);
INSERT INTO outer2(sid) VALUES (20);
INSERT INTO outer2(sid) VALUES (30);

select * from outer1;
select * from outer2;

SELECT sid from outer1
union
select sid from outer2;
