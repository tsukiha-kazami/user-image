CREATE DATABASE IF NOT EXISTS dwd_kkbmall;

DROP TABLE IF EXISTS dwd_kkbmall.dwd_fact_comment_info;


CREATE TABLE `dwd_kkbmall.dwd_fact_comment_info` (
  `id`           string COMMENT '编号',
  `user_id`      string COMMENT '用户ID', 
  `sku_id`       string COMMENT '商品sku', 
  `spu_id`       string COMMENT '商品spu', 
  `order_id`     string COMMENT '订单ID', 
  `appraise`     string COMMENT '评价', 
  `create_time`  string COMMENT '评价时间'
)
COMMENT '商品评论事实表'
PARTITIONED BY (etl_date string comment '跑批时间，格式：yyyyMMdd')
stored AS orc 
TBLPROPERTIES ('transactional' = 'false');