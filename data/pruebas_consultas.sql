
-- Todos los departamentos ordenados alfabeticamente
SELECT DISTINCT(job) FROM empleado ORDER BY job ASC;

-- Mayor sueldo
SELECT MAX(sal) FROM empleado;

-- Menor sueldo
SELECT MIN(sal) FROM empleado;

-- suma de todos los sueldos
SELECT SUM(sal) FROM empleado;

-- salario bruto anual de todos los empleados
SELECT SUM(sal)*12 as salario_bruto_anual FROM empleado;

-- media de sueldos
SELECT AVG(sal) FROM empleado;

-- contar departamentos
SELECT count( distinct deptno) from empleado;

-- resumen salariar por departamento
SELECT 
    deptno,
	max(sal) as maximo,
    min(sal) as minimo,
    avg(sal) as media,
    sum(sal) as total
from empleado
group by deptno;


-- resumen salarial por tipo de empleo, excluynedo al 'EMPRESARIO'
SELECT 
    job,
	max(sal) as maximo,
    min(sal) as minimo,
    avg(sal) as media,
    sum(sal) as total,
    count(empno) as empleados
from empleado
where job <> 'EMPRESARIO'
group by job
order by empleados desc;

-- resumen salarial por tipo de empleo, excluynedo al 'EMPRESARIO'
-- filtrado por la media > 1500
SELECT 
    job,
	max(sal) as maximo,
    min(sal) as minimo,
    avg(sal) as media,
    sum(sal) as total,
    count(empno) as empleados
from empleado
where job <> 'EMPRESARIO'
group by job
having media > 1500
order by empleados desc;



-- mostrar recetas que que contengan mas de 5 ingredientes


-- mostrar recetas que con gluten


-- mostrar recetas que con Sin gluten

-- contar recetas de cada usuario

































