Create table If Not Exists stadium (id int, visit_date DATE NULL, people int);
Truncate table stadium;
insert into stadium (id, visit_date, people) values ('1', '2017-01-01', '10');
insert into stadium (id, visit_date, people) values ('2', '2017-01-02', '109');
insert into stadium (id, visit_date, people) values ('3', '2017-01-03', '150');
insert into stadium (id, visit_date, people) values ('4', '2017-01-04', '99');
insert into stadium (id, visit_date, people) values ('5', '2017-01-05', '145');
insert into stadium (id, visit_date, people) values ('6', '2017-01-06', '1455');
insert into stadium (id, visit_date, people) values ('7', '2017-01-07', '199');
insert into stadium (id, visit_date, people) values ('8', '2017-01-08', '188');

# TODO 601. Human Traffic of Stadium
# Write your MySQL query statement below
select distinct stadium.id, stadium.visit_date, stadium.people
from stadium inner join (
    #group by min and max widnow of stadium dates where min
    #and max people gte 100 and window record count is 4
    select min(stadium.visit_date) min_date, max(stadium.visit_date) max_date
    from stadium inner join (
        #create min and max id window
        select stadium.id min_id,
               stadium.id+2 as max_id
        from stadium
    ) as window on stadium.id between window.min_id and window.max_id
    group by window.min_id, window.max_id
    having min(stadium.people)>=100 and max(stadium.people)>=100 and count(stadium.id)=3
) as window_date_range
                        on stadium.visit_date between window_date_range.min_date and window_date_range.max_date;