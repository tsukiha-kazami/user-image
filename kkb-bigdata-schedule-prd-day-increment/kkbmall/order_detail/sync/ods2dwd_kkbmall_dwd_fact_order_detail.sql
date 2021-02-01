insert overwrite table dwd_kkbmall.dwd_fact_order_detail partition(etl_date='20201002') 
select
id,
order_id,
user_id,
sku_id,
sku_name,
order_price,
sku_num,
create_time,
province_id,
source_type,
source_id,
original_amount_d,
if(rn=1,final_total_amount -(sum_div_final_amount - final_amount_d),final_amount_d), 
if(rn=1,feight_fee - (sum_div_feight_fee - feight_fee_d),feight_fee_d), 
if(rn=1,benefit_reduce_amount - (sum_div_benefit_reduce_amount -benefit_reduce_amount_d), benefit_reduce_amount_d) 
from
(
select
od.id,
od.order_id,
oi.user_id,
od.sku_id,
od.sku_name,
od.order_price,
od.sku_num,
od.create_time,
oi.province_id,
od.source_type,
od.source_id,
round(od.order_price*od.sku_num,2) original_amount_d,
round(od.order_price*od.sku_num/oi.original_total_amount*oi.final_total_amount,2) final_amount_d,
round(od.order_price*od.sku_num/oi.original_total_amount*oi.feight_fee,2) feight_fee_d,
round(od.order_price*od.sku_num/oi.original_total_amount*oi.benefit_reduce_amount,2) benefit_reduce_amount_d,
row_number() over(partition by od.order_id order by od.id desc) rn, oi.final_total_amount,
oi.feight_fee,
oi.benefit_reduce_amount,
sum(round(od.order_price*od.sku_num/oi.original_total_amount*oi.final_total_amount,2)) over(partition by od.order_id) sum_div_final_amount,
sum(round(od.order_price*od.sku_num/oi.original_total_amount*oi.feight_fee,2)) over(partition by od.order_id) sum_div_feight_fee,
sum(round(od.order_price*od.sku_num/oi.original_total_amount*oi.benefit_reduce_amount, 2)) over(partition by od.order_id) sum_div_benefit_reduce_amount
from
(
select * from ods_kkbmall.o_order_detail where etl_date='20201002'
) od join
(
select * from ods_kkbmall.o_order_info where etl_date='20201002'
) oi
   on od.order_id=oi.id
)t1;