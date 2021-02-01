insert overwrite table dwd_kkbmall.dwd_fact_payment_info partition(etl_date='20201002') select
   pi.id,
   pi.out_trade_no,
   pi.order_id,
   pi.user_id,
   pi.alipay_trade_no,
   pi.total_amount,
   pi.subject,
   pi.payment_type,
   pi.payment_time,
   oi.province_id
from
( select * from ods_kkbmall.o_payment_info where etl_date='20201002' ) pi
join
( select id,province_id from ods_kkbmall.o_order_info where etl_date='20201002' ) oi
on 
pi.order_id = oi.id;