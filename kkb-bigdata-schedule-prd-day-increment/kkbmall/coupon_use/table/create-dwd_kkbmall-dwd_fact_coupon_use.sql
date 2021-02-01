CREATE DATABASE IF NOT EXISTS dwd_kkbmall;

DROP TABLE IF EXISTS dwd_kkbmall.dwd_fact_coupon_use;


CREATE TABLE `dwd_kkbmall.dwd_fact_coupon_use` (
  `id`             string COMMENT '编号',
  `coupon_id`      string COMMENT '优惠券 ID', 
  `user_id`        string COMMENT 'userid', 
  `order_id`       string COMMENT '订单id', 
  `coupon_status`  string COMMENT '优惠券状态',   
  `get_time`       string COMMENT '领取时间', 
  `using_time`     string COMMENT '使用时间(下单)',   
  `used_time`      string COMMENT '使用时间(支付)'
)
COMMENT '优惠券领用事实表'
PARTITIONED BY (etl_date string comment '跑批时间，格式：yyyyMMdd')
stored AS orc 
TBLPROPERTIES ('transactional' = 'false');