-- dwd 小文件合并

insert overwrite table dwt.dwd_dim_activity_info partition  
(etl_date='2020-06-14') 
select
   id,
   activity_name,
   activity_type,
   start_time,
   end_time,
   create_time
from dwd.o_activity_info
where etl_date='20201002';