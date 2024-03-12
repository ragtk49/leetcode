/* Write your T-SQL query statement below */


select * from Cinema c
where c.id % 2 != 0
and c.description != 'boring'
order by c.rating desc;