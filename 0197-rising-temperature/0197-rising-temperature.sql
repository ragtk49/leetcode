/* Write your T-SQL query statement below */
select w2.id
from Weather w1, Weather w2
Where DATEDIFF(day,w1.recordDate, w2.recordDate) = 1
and w1.temperature < w2.temperature;