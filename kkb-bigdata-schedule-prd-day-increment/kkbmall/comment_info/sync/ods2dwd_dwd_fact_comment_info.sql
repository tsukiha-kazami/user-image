insert overwrite table dwd_kkbmall.dwd_fact_comment_info partition(etl_date='20201002') 
select
   id,
   user_id,
   sku_id,
   spu_id,
   order_id,
   appraise,
   create_time
from ods_kkbmall.o_comment_info
where etl_date='20201002';

