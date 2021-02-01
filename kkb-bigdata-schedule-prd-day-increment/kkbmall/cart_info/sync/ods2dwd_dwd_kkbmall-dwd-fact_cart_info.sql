insert overwrite table dwd_kkbmall.dwd_fact_cart_info partition(etl_date='20201002') select
   id,
   user_id,
   sku_id,
   cart_price,
   sku_num,
   sku_name,
   create_time,
   operate_time,
   is_ordered,
   order_time,
   source_type,
   source_id
from ods_kkbmall.o_cart_info;