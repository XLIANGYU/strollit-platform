SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS tb_order;




/* Create Tables */

-- 订单表
CREATE TABLE tb_order
(
	-- 编号
	id varchar(32) NOT NULL COMMENT '编号 : 编号',
	-- 购买人
	user_id varchar(32) COMMENT '购买人 : 购买人',
	-- 门店编号
	store_id varchar(32) COMMENT '门店编号 : 门店编号',
	-- 订单编号
	order_num varchar(32) COMMENT '订单编号 : 订单编号',
	-- 创建时间
	create_time datetime COMMENT '创建时间 : 创建时间',
	-- 订单状态: 预创建、 待支付、已支付、异常单
	order_status varchar(32) COMMENT '订单状态 : 订单状态: 预创建、 待支付、已支付、异常单',
	PRIMARY KEY (id)
) COMMENT = '订单表';



