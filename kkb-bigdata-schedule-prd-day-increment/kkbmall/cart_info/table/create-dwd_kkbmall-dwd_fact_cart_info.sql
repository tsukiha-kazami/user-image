CREATE DATABASE IF NOT EXISTS dwd_kkbmall;

DROP TABLE IF EXISTS dwd_kkbmall.dwd_fact_cart_info;


CREATE TABLE `dwd_kkbmall.dwd_fact_cart_info` (
  `id`              string COMMENT '编号',
  `user_id`         string COMMENT '用户id',
  `sku_id`          string COMMENT 'skuid',
  `cart_price`      string COMMENT '放入购物车时价格',
  `sku_num`         string COMMENT '数量',
  `sku_name`        string COMMENT 'sku 名称 (冗余)',
  `create_time`     string COMMENT '创建时间',
  `operate_time`    string COMMENT '修改时间',
  `is_ordered`      string COMMENT '是否已经下单。1 为已下单;0 为未下单', 
  `order_time`      string COMMENT '下单时间',
  `source_type`     string COMMENT '来源类型',
  `srouce_id`       string COMMENT '来源编号'
)
COMMENT '加购事实表'
PARTITIONED BY (etl_date string comment '跑批时间，格式：yyyyMMdd')
stored AS orc 
TBLPROPERTIES ('transactional' = 'false');