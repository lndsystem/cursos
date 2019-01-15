use sql_avancado;

sp_help resposta;

select * from aluno;

select 
    a.nome,c.nome from aluno a
join matricula m on a.id=m.aluno_id
join curso c on m.curso_id = c.id
order by a.nome

select count(*) from aluno;

select a.nome from aluno a
    where not exists(select m.id from matricula m where m.data > dateadd(day,-45,getdate()) and m.aluno_id=a.id);

select a.nome from aluno a
    left join matricula m on m.aluno_id=a.id and m.data > dateadd(day,-45,getdate());

select e.id,e.pergunta from exercicio e
    where not exists(select r.id from resposta r where r.exercicio_id=e.id);

select * from curso c
    where not exists(select m.id from matricula m where m.curso_id=c.id);

select a.nome, c.nome from aluno a
    join matricula m on m.aluno_id=a.id
    join curso c on m.curso_id=c.id
where not exists(select r.aluno_id from resposta r where r.aluno_id=a.id);

select a.nome from aluno a
    join resposta r on a.id=r.aluno_id
where exists(select m.aluno_id from matricula m where m.aluno_id=a.id);

create database sql2;

select c.nome, avg(n.nota) as media_nota from nota n
    join resposta r on n.resposta_id=r.id
    join exercicio e on r.exercicio_id=e.id
    join secao s on e.secao_id=s.id
    join curso c on s.curso_id=c.id
group by
    c.nome;

select c.nome, avg(n.nota) as media_nota from nota n
    join resposta r on n.resposta_id=r.id
    join exercicio e on r.exercicio_id=e.id
    join secao s on e.secao_id=s.id
    join curso c on s.curso_id=c.id 
    join aluno a on r.aluno_id=a.id
where
    a.nome like '%Santos%' or a.nome like '%Silva%'
group by
    c.nome;

select c.nome, count(*) as contagem from exercicio e
    join secao s on e.secao_id=s.id
    join curso c on s.curso_id=c.id
group BY
    c.nome;

select c.nome,count(*) as qtd from curso c
    join matricula m on m.curso_id=c.id
    join aluno a on a.id=m.aluno_id
group BY
    c.nome;   

select e.pergunta, count(*) as qtd_respostas from resposta r
    join exercicio e on r.exercicio_id=e.id
group by
    e.pergunta
order by
    count(*) desc;

select c.nome,a.nome,avg(n.nota) as media_nota from nota n
    join resposta r on n.resposta_id=r.id
    join exercicio e on r.exercicio_id=e.id
    join secao s on e.secao_id=s.id
    join curso c on s.curso_id=c.id
    join aluno a on r.aluno_id=a.id
group by
    c.nome,a.nome;

select a.nome,c.nome, avg(n.nota) from nota n
    join resposta r on r.id=n.resposta_id 
    join exercicio e on r.exercicio_id=e.id
    join secao s on s.id=e.secao_id
    join curso c on c.id=s.curso_id
    join aluno a on a.id=r.aluno_id
group by
    a.nome,c.nome
HAVING
    avg(n.nota) < 5;

select c.nome,count(a.id) from curso c
    join matricula m on m.curso_id=c.id
    join aluno a on a.id=m.aluno_id
group by
    c.nome
having
    count(a.id) > 1;

select c.nome, count(m.id) from curso c 
    join matricula m on c.id = m.curso_id 
group by 
    c.nome 
having count(m.id) > 1;

select c.nome, count(c.id) as qtd_secao from curso c
    join secao s on s.curso_id=c.id
group by
    c.nome
having
    count(c.id) > 3;

