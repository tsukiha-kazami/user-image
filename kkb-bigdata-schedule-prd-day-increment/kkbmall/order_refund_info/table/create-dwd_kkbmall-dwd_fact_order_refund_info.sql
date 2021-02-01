CREATE DATABASE IF NOT EXISTS dwd_kkbmall;

DROP TABLE IF EXISTS dwd_kkbmall.dwd_fact_order_refund_info;


CREATE TABLE `dwd_kkbmall.dwd_fact_order_refund_info` (
 `id`                 string          COMMENT '编号',
 `user_id`            string          COMMENT '用户ID',
 `order_id`           string          COMMENT '订单ID',
 `sku_id`             string          COMMENT '商品ID',
 `refund_type`        string          COMMENT '退款类型', 
 `refund_num`         bigint          COMMENT '退款件数',  
 `refund_amount`      decimal(16,2)   COMMENT '退款金额', 
 `refund_reason_type` string          COMMENT '退款原因类型', 
 `create_time`        string          COMMENT '退款时间' 
)
COMMENT '退单表'
PARTITIONED BY (etl_date string comment '跑批时间，格式：yyyyMMdd')
stored AS orc 
TBLPROPERTIES ('transactional' = 'false');