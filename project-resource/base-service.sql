SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS tb_feedback;
DROP TABLE IF EXISTS tb_pet;
DROP TABLE IF EXISTS tb_pet_kind;
DROP TABLE IF EXISTS tb_pet_mate;
DROP TABLE IF EXISTS tb_pet_type;
DROP TABLE IF EXISTS tb_product;
DROP TABLE IF EXISTS tb_product_img;
DROP TABLE IF EXISTS tb_region;
DROP TABLE IF EXISTS tb_sms;
DROP TABLE IF EXISTS tb_sys_config;




/* Create Tables */

-- 反馈表
CREATE TABLE tb_feedback
(
	-- 编号
	id varchar(32) NOT NULL COMMENT '编号 : 编号',
	-- 用户编号
	user_id varchar(32) COMMENT '用户编号 : 用户编号',
	-- 创建时间
	create_time datetime COMMENT '创建时间 : 创建时间',
	-- 联系方式
	contact varchar(50) COMMENT '联系方式 : 联系方式',
	-- 邮箱
	email varchar(100) COMMENT '邮箱 : 邮箱',
	-- 问题路径,菜单层级-页面流程
	question_url varchar(200) COMMENT '问题路径 : 问题路径,菜单层级-页面流程',
	-- 问题描述
	comment varchar(500) COMMENT '问题描述 : 问题描述',
	-- 来源：前端、后台
	src varchar(20) COMMENT '来源 : 来源：前端、后台',
	-- 状态
	status varchar(20) COMMENT '状态 : 状态',
	-- 删除标识
	is_del int DEFAULT 0 COMMENT '删除标识 : 删除标识',
	PRIMARY KEY (id)
) COMMENT = '反馈表';


-- 宠物表
CREATE TABLE tb_pet
(
	-- 编号
	id varchar(32) NOT NULL COMMENT '编号 : 编号',
	-- 用户编号
	user_id varchar(32) COMMENT '用户编号 : 用户编号',
	-- 宠物类目编号
	pet_type_id varchar(32) COMMENT '宠物类目编号 : 宠物类目编号',
	-- 宠物种类编号
	pet_kind_id varchar(32) COMMENT '宠物种类编号 : 宠物种类编号',
	-- 宠物名称
	pet_name varchar(16) COMMENT '宠物名称 : 宠物名称',
	-- birthday
	birthday date COMMENT 'birthday : birthday',
	-- 头像地址
	pet_face_url varchar(256) COMMENT '头像地址 : 头像地址',
	-- 性别
	sex varchar(8) COMMENT '性别 : 性别',
	-- 颜色
	pet_color varchar(8) COMMENT '颜色 : 颜色',
	-- 体重
	weight varchar(8) COMMENT '体重 : 体重',
	-- 技能，json
	skill varchar(256) COMMENT '技能 : 技能，json',
	-- 描述
	remark varchar(256) COMMENT '描述 : 描述',
	-- 删除标识
	is_del int DEFAULT 0 COMMENT '删除标识 : 删除标识',
	PRIMARY KEY (id)
) COMMENT = '宠物表';


-- 宠物种类表
CREATE TABLE tb_pet_kind
(
	-- 编号
	id varchar(32) NOT NULL COMMENT '编号 : 编号',
	-- 类目编号
	pet_type_id varchar(32) COMMENT '类目编号 : 类目编号',
	-- 种类名称
	kind_name varchar(32) COMMENT '种类名称 : 种类名称',
	-- 类型图
	kind_url varchar(256) COMMENT '类型图 : 类型图',
	-- 描述
	descs varchar(256) COMMENT '描述 : 描述',
	-- 删除标识
	is_del int DEFAULT 0 COMMENT '删除标识 : 删除标识',
	PRIMARY KEY (id)
) COMMENT = '宠物种类表';


-- 宠物配偶表
CREATE TABLE tb_pet_mate
(
	-- 编号
	id varchar(32) NOT NULL COMMENT '编号 : 编号',
	-- 宠物编号
	pet_id varchar(32) COMMENT '宠物编号 : 宠物编号',
	-- 配偶宠物编号
	mete_pet_id varchar(32) COMMENT '配偶宠物编号 : 配偶宠物编号',
	-- 开始时间
	start_time datetime COMMENT '开始时间 : 开始时间',
	-- 结束时间
	end_time datetime COMMENT '结束时间 : 结束时间',
	-- 状态（配对中、结束、受孕、已生育）
	status varchar(20) COMMENT '状态 : 状态（配对中、结束、受孕、已生育）',
	-- 预留字段1
	res1 varchar(50) COMMENT '预留字段1 : 预留字段1',
	-- 预留字段2
	res2 varchar(50) COMMENT '预留字段2 : 预留字段2',
	-- 预留字段3
	res3 varchar(50) COMMENT '预留字段3 : 预留字段3',
	-- 删除标识
	is_del int DEFAULT 0 COMMENT '删除标识 : 删除标识',
	PRIMARY KEY (id)
) COMMENT = '宠物配偶表';


-- 宠物类型表
CREATE TABLE tb_pet_type
(
	-- 编号
	id varchar(32) NOT NULL COMMENT '编号 : 编号',
	-- 类目名称
	type_name varchar(32) COMMENT '类目名称 : 类目名称',
	-- 小图url
	logo_url varchar(256) COMMENT '小图url : 小图url',
	-- 描述
	descs varchar(512) COMMENT '描述 : 描述',
	-- 删除标识
	is_del int DEFAULT 0 COMMENT '删除标识 : 删除标识',
	PRIMARY KEY (id)
) COMMENT = '宠物类型表';


-- 基础商品表
CREATE TABLE tb_product
(
	-- 编号
	id varchar(32) NOT NULL COMMENT '编号 : 编号',
	-- 创建人
	create_id varchar(32) COMMENT '创建人 : 创建人',
	-- 创建时间
	create_time datetime COMMENT '创建时间 : 创建时间',
	-- 更新人
	update_id varchar(32) COMMENT '更新人 : 更新人',
	-- 更新时间
	update_time datetime COMMENT '更新时间 : 更新时间',
	-- 商品名称
	product_name varchar(128) COMMENT '商品名称 : 商品名称',
	-- 原价(单位分）
	original_price bigint COMMENT '原价 : 原价(单位分）',
	-- 销售价(单位分）
	sell_price bigint COMMENT '销售价 : 销售价(单位分）',
	-- 品牌名称
	brand_name varchar(64) COMMENT '品牌名称 : 品牌名称',
	-- 商品规格
	product_spec varchar(64) COMMENT '商品规格 : 商品规格',
	-- 供应商名称
	vender_name varchar(64) COMMENT '供应商名称 : 供应商名称',
	-- 商品文字描述
	product_desc text COMMENT '商品文字描述 : 商品文字描述',
	-- 商品类型（实质商品、增值服务）
	product_type varchar(32) COMMENT '商品类型 : 商品类型（实质商品、增值服务）',
	-- 删除标识
	is_del int DEFAULT 0 COMMENT '删除标识 : 删除标识',
	PRIMARY KEY (id)
) COMMENT = '基础商品表';


-- 基础商品图片表
CREATE TABLE tb_product_img
(
	-- 编号
	id varchar(32) NOT NULL COMMENT '编号 : 编号',
	-- 基础商品ID
	product_id varchar(32) COMMENT '基础商品ID : 基础商品ID',
	-- 图片地址
	img_url varchar(256) COMMENT '图片地址 : 图片地址',
	-- 图片类型:主图（多张）， 详情图（多张）
	img_type varchar(16) COMMENT '图片类型 : 图片类型:主图（多张）， 详情图（多张）',
	-- 排序值
	sort_num int DEFAULT 0 COMMENT '排序值 : 排序值',
	-- 删除标识
	is_del int DEFAULT 0 COMMENT '删除标识 : 删除标识',
	PRIMARY KEY (id)
) COMMENT = '基础商品图片表';


-- 地区表
CREATE TABLE tb_region
(
	-- 行政编号
	region_id varchar(32) NOT NULL COMMENT '行政编号 : 行政编号',
	-- 父地区编号
	region_parent_id varchar(32) COMMENT '父地区编号 : 父地区编号',
	-- 地区名
	region_name varchar(50) COMMENT '地区名 : 地区名',
	-- 地区行政等级
	region_type int COMMENT '地区行政等级 : 地区行政等级',
	-- 创建人编号
	create_id varchar(32) COMMENT '创建人编号 : 创建人编号',
	-- 创建时间
	create_time datetime COMMENT '创建时间 : 创建时间',
	-- 更新人
	update_id varchar(32) COMMENT '更新人 : 更新人',
	-- 更新时间
	update_time datetime COMMENT '更新时间 : 更新时间',
	-- 删除标识
	is_del int DEFAULT 0 COMMENT '删除标识 : 删除标识',
	PRIMARY KEY (region_id)
) COMMENT = '地区表';


-- 短信表
CREATE TABLE tb_sms
(
	-- 编号
	id varchar(32) NOT NULL COMMENT '编号 : 编号',
	-- 短信编号
	num varchar(32) COMMENT '短信编号 : 短信编号',
	-- 模板内容
	template_val varchar(128) COMMENT '模板内容 : 模板内容',
	-- 运营商响应码
	ser_resp_code varchar(50) COMMENT '运营商响应码 : 运营商响应码',
	-- 运营商响应内容
	ser_resp_msg varchar(128) COMMENT '运营商响应内容 : 运营商响应内容',
	-- 创建时间
	create_time datetime COMMENT '创建时间 : 创建时间',
	-- 发送结果
	result varchar(16) COMMENT '发送结果 : 发送结果',
	-- 删除标识
	is_del int DEFAULT 0 COMMENT '删除标识 : 删除标识',
	PRIMARY KEY (id)
) COMMENT = '短信表';


-- 系统配置表
CREATE TABLE tb_sys_config
(
	-- 编号
	id varchar(32) NOT NULL COMMENT '编号 : 编号',
	-- 配置项
	config_key varchar(32) COMMENT '配置项 : 配置项',
	-- 配置值
	config_value varchar(256) COMMENT '配置值 : 配置值',
	-- 描述
	config_remark varchar(256) COMMENT '描述 : 描述',
	PRIMARY KEY (id)
) COMMENT = '系统配置表';



/* Create Foreign Keys */

ALTER TABLE tb_pet
	ADD FOREIGN KEY (pet_kind_id)
	REFERENCES tb_pet_kind (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE tb_pet
	ADD FOREIGN KEY (pet_type_id)
	REFERENCES tb_pet_type (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE tb_pet_kind
	ADD FOREIGN KEY (pet_type_id)
	REFERENCES tb_pet_type (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



