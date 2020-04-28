-- [Proejction | Selection]
select * from emp;
select empno,ename,job,deptno from emp;
select distinct(deptno) from emp;

-- 오름차순(asc)과 내림차순(desc) asc가 기본
select distinct deptno from emp order by deptno;

-- 사원중에 입사일이 가장 빠른 사원 순으로 출력
select empno, ename, job, hiredate from emp order by hiredate desc;
-- 사원중에 월급 가장 많이 받는 사원 순으로 출력
select ename, job, sal from emp order by sal desc;
-- limit
select empno, ename, job, hiredate from emp order by hiredate desc limit 0,2;
select empno, ename, job, hiredate from emp order by hiredate desc limit 3;
select empno, ename, job, hiredate from emp order by hiredate desc limit 3,2;
select empno, ename, job, hiredate from emp order by hiredate desc limit 1,2;


-- salesman의 이름 급여 연봉 검색
select ename, sal, (sal*12+comm) as 연봉 from emp where job = "SALESMAN";
select ename, sal, (sal*12+comm) '연봉' from emp where job = "SALESMAN";
select ename, sal, (sal*12+comm) "연봉" from emp where job = "SALESMAN" order by "연봉";
select ename, sal, (sal*12+comm) "연봉" from emp where job = "SALESMAN" order by "연봉";
select ename, sal, (sal*12+comm) as "annualSalary" 
from emp 
where job = "SALESMAN" 
order by annualSalary;

select ename, sal, (sal*12+comm) as "연봉"
from emp
order by 연봉;

-- comm이 null이면 0으로 치환 
select ename, sal, (sal*12+ ifnull(comm,0)) as "연봉"
from emp
order by 연봉;

-- comm이 null 이 아닌 사람들의 이름 업무 급여 comm 검색
select ename, job, sal, comm
from emp
where comm is not null;

-- 
select distinct mgr as "상사번호"
from emp
order by mgr desc;

select ename, hiredate, year(hiredate) as 입사년도
from emp;

select ename, hiredate, month(hiredate) as 입사월
from emp
where month(hiredate)=5;

-- A가 이름에 들어간 사원 검색
select ename, job, deptno
from emp
where ename LIKE '%A%';

select ename, job, deptno
from emp
where ename LIKE '%G';