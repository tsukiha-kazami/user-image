insert overwrite table dwd_kkbmall.dwd_fact_order_refund_info partition(etl_date='20201002') select
   id,
   user_id,
   order_id,
   sku_id,
   refund_type,
   refund_num,
   refund_amount,
   refund_reason_type,
   create_time
from ods_kkbmall.o_order_refund_info where etl_date='20201002';