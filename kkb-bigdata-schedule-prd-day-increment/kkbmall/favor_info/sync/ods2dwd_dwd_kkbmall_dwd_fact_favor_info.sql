insert overwrite table dwd_kkbmall.dwd_fact_favor_info partition(etl_date='20201002') select
   id,
   user_id,
   sku_id,
   spu_id,
   is_cancel,
   create_time,
   cancel_time
from ods_kkbmall.o_favor_info
where etl_date='20201002';