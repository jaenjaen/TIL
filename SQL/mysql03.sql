-- 서브쿼리
-- 반드시 괄호로 쌓여야하며, 서브쿼리가 먼저 돌아간 결과값을 가지고 메인 쿼리가 실행된다.
-- from 뒤, where뒤, having 뒤 3가지의 서브쿼리로 나뉨
-- 서브쿼리의 값이 단일행인지 다중행인지 알아야함
-- 단일행 서브쿼리는 단일행 연산자와 사용 다중행 서브쿼리는 다중행 연산자와 사용됨 
-- 단일행 서브쿼리 : 스칼라서브쿼리

select ename, sal
from emp
where sal >= (select sal
			 from emp
			 where ename = 'CLARK');
             
-- 급여를 가장 많이 받는 사원 5명을 검색
select ename, sal
from emp 
order by sal desc limit 5;

-- ename이 'KING'인 사원과 같은 부서에서 근무하는 사원을 검색
select ename, deptno
from emp
where deptno = (select deptno
				from emp
                where ename = 'KING');
                
-- 10번 부서에서 근무하는 사원 중 사원 전체의 평균급여 보다 더 많은 급여를 받는 사원은?
select ename, sal, deptno
from emp
where deptno = 10 and
	  sal > (select avg(sal)
			 from emp);
             
-- job별 가장 적은 평균 급여를 검색
select job,avg(sal)
from emp
group by job
order by avg(sal) asc limit 1;

-- scott의 급여보다 더 많은 급여를 받는 사원을 검색
select ename, sal
from emp
where sal > (select sal
			 from emp
             where ename = 'SCOTT');
             
-- using by table alias
select a.ename, a.sal
from emp as a, (select sal
				from emp
                where ename='SCOTT') as b
where a.sal > b.sal;

select * from emp;
-- 직속상관이 King인 사원의 이름과 급여를 검색하시오
select ename, sal
from emp
where mgr = (select empno
			 from emp
             where ename = 'KING');


-- job이 사원 7389번 의 업무와 같고 급여가 사원 7876보다 많은 사원 을 검색
select ename, job, sal
from emp
where sal > (select sal
			 from emp
             where empno = 7876) and
	  job = (select job
			 from emp
             where empno = 7369);

-- 부서별 최소급여 중에서 20번 부서의 최소급여 보다 더 큰 최소급여를 검색
select deptno, min(sal)
from emp
group by deptno
having min(sal) > (select min(sal)
				  from emp
                  where deptno = 20);
                  
-- 부서별 최소급여와 같은 급여를 가지는 사원을 검색
select ename, deptno, sal
from emp
where sal in (select min(sal)
			  from emp
              group by deptno);
              
-- 급여를 3000이상 받는 소속된 부서와 거기에 근무하는 사원

select deptno, ename, job, sal
from emp
where deptno in ( select distinct deptno
				  from emp
                  where sal >= 3000);

-- 급여가 어떤 점원보다 작으면서 clerk이 아닌 사원 을 검색
select empno,ename, job,sal
from emp
where sal < ANY (select sal
			   from emp
               where job = 'CLERK')
and job <> 'CLERK';
-- 급여가 모든부서의 평균 보다 많은 사원을 검색
select empno, ename, sal
from emp
where sal > all(select avg(sal)
				from emp
				group by deptno);

-- 01 급여가 10번 부서에 속한 어떤 사원의 급여보다 더 많은 급여를 받는 사원을 검색 이때 10번 부서에 속한 사원은 제외 정렬은 사원번호순

select deptno, empno, ename, sal
from emp
where sal > any(select sal
				from emp
                where deptno = 10)
and deptno != 10
order by empno;

-- 02 30번 소속 사원들 중에서 가장 많이 받는 사원보다 더 많은 급여를 받는 사원의 이름과 급여를 검색
select deptno, ename, sal
from emp
where sal > (select  max(sal)
			  from emp
			  GROUP BY deptno
              HAVING deptno = 30);

-- 부하직원을 거느리는 사원을 검색
select empno, ename, mgr
from emp
where empno in (select mgr
				from emp);

-- 부하직원이 없는 사원 검색
select empno, ename, mgr
from emp
where empno not in (select ifnull(mgr,0)
					from emp);