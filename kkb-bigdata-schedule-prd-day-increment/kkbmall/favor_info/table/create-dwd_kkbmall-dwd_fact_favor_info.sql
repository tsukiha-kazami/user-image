CREATE DATABASE IF NOT EXISTS dwd_kkbmall;

DROP TABLE IF EXISTS dwd_kkbmall.dwd_fact_favor_info;


CREATE TABLE `dwd_kkbmall.dwd_fact_favor_info` (
  `id`           string COMMENT '编号',
  `user_id`      string COMMENT '用户id', 
  `sku_id`       string COMMENT 'skuid', 
  `spu_id`       string COMMENT 'spuid', 
  `is_cancel`    string COMMENT '是否取消', 
  `create_time`  string COMMENT '收藏时间', 
  `cancel_time`  string COMMENT '取消时间'
)
COMMENT '商品收藏事实表'
PARTITIONED BY (etl_date string comment '跑批时间，格式：yyyyMMdd')
stored AS orc 
TBLPROPERTIES ('transactional' = 'false');