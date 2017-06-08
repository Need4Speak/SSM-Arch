-- 数据库初始化脚本

-- 创建数据库
CREATE DATABASE seckill;
-- 使用数据库
use seckill;
-- 创建秒杀库存表
CREATE TABLE  seckill(
`seckill_id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品库存id',
`name` varchar(120) NOT NULL COMMENT '商品名称',
`number` int NOT NULL COMMENT '库存数量',
`start_time` timestamp NOT NULL COMMENT '秒杀开启时间',
`end_time` timestamp NOT NULL COMMENT '秒杀结束时间',
`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
PRIMARY KEY (seckill_id),
key idx_start_time(start_time),
key idx_end_time(end_time),
key idx_create_time(create_time)
)ENGINE=InnDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='秒杀库存';
-- 初始化数据
insert into
  seckill(name, number, start_time, end_time)
values
  ('1元秒杀手机', 100, '2015-06-06 00:00:00', '2015-06-07 00:00:00'),
  ('2元秒杀手机', 100, '2015-06-06 00:00:00', '2015-06-07 00:00:00'),
  ('3元秒杀手机', 100, '2015-06-06 00:00:00', '2015-06-07 00:00:00'),
  ('4元秒杀手机', 100, '2015-06-06 00:00:00', '2015-06-07 00:00:00'),
  ('5元秒杀手机', 100, '2015-06-06 00:00:00', '2015-06-07 00:00:00');

-- 秒杀成功明细表
-- 用户登录认证相关信息
CREATE TABLE  success_kill(
`seckill_id` bigint NOT NULL COMMENT '商品库存id',
`user_phone` bigint NOT NULL COMMENT '用户手机号',
`state` tinyint NOT NULL DEFAULT -1 COMMENT '-1：无效 0：成功 1：已发货',
`create_time` timestamp NOT NULL COMMENT '创建时间',
PRIMARY KEY (seckill_id, user_phone),
key idx_create_time(create_time)
)ENGINE=InnDB DEFAULT CHARSET=utf8 COMMENT='秒杀库存';

-- 连接数据库控制台
mysql -uroot -p11111111

