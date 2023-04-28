
SELECT m.member_name, r.REVIEW_TEXT , date_format(r.REVIEW_DATE, '%Y-%m-%d') REVIEW_DATE
from member_profile m inner join rest_review r on m.member_id = r.member_id
where m.member_id = 
(select member_id from rest_review group by member_id order by count(review_id) desc limit 1)
order by REVIEW_DATE, REVIEW_TEXT