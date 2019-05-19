SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS tb_contents_comment;
DROP TABLE IF EXISTS tb_contents_push;
DROP TABLE IF EXISTS tb_forum;
DROP TABLE IF EXISTS tb_forum_reply;
DROP TABLE IF EXISTS tb_help_strap;
DROP TABLE IF EXISTS tb_party;
DROP TABLE IF EXISTS tb_party_user;
DROP TABLE IF EXISTS tb_pet_diary;
DROP TABLE IF EXISTS tb_sell;
DROP TABLE IF EXISTS tb_store;
DROP TABLE IF EXISTS tb_store_comment;
DROP TABLE IF EXISTS tb_store_img;
DROP TABLE IF EXISTS tb_store_manage_type;
DROP TABLE IF EXISTS tb_store_product;
DROP TABLE IF EXISTS tb_store_product_img;
DROP TABLE IF EXISTS tb_store_product_selllog;
DROP TABLE IF EXISTS tb_store_subscribe;
DROP TABLE IF EXISTS tb_store_vip_user;




/* Create Tables */

CREATE TABLE tb_contents_comment
(
	-- 编号
	id varchar(32) NOT NULL COMMENT '编号',
	-- 用户编号
	user_id varchar(32) COMMENT '用户编号',
	-- 文章编号
	contents_push_id varchar(32) COMMENT '文章编号',
	-- 评论内容
	comment varchar(512) COMMENT '评论内容',
	-- 创建时间
	create_time datetime COMMENT '创建时间',
	-- 是否引用评论
	is_ref int DEFAULT 0 COMMENT '是否引用评论',
	-- 引用评论编号
	ref_comment_id varchar(32) COMMENT '引用评论编号',
	-- 预留字段1
	res1 varchar(50) COMMENT '预留字段1',
	-- 预留字段2
	res2 varchar(50) COMMENT '预留字段2',
	-- 预留字段3v
	res3 varchar(50) COMMENT '预留字段3v',
	-- 删除标识
	is_del int DEFAULT 0 COMMENT '删除标识',
	PRIMARY KEY (id)
);


CREATE TABLE tb_contents_push
(
	-- 编号
	id varchar(32) NOT NULL COMMENT '编号',
	-- 用户编号
	user_id varchar(32) COMMENT '用户编号',
	-- 用户类型（门店发布、用户发布、平台发布）根据user_id角色类型决定
	user_type varchar(32) COMMENT '用户类型（门店发布、用户发布、平台发布）根据user_id角色类型决定',
	-- 排序编号
	sort_num bigint DEFAULT 999999 COMMENT '排序编号',
	-- 标题
	title varchar(128) COMMENT '标题',
	-- 副标题
	subtitle varchar(128) COMMENT '副标题',
	-- 首图地址
	header_image_url varchar(256) COMMENT '首图地址',
	-- 发布内容
	contents longtext COMMENT '发布内容',
	-- 创建时间
	create_time datetime COMMENT '创建时间',
	-- 点赞数
	like_count bigint DEFAULT 0 COMMENT '点赞数',
	-- 是否原创(1:原创，0非原创）
	is_original int DEFAULT 1 COMMENT '是否原创(1:原创，0非原创）',
	-- 引用地址（如果非原创）
	ref_url varchar(256) COMMENT '引用地址（如果非原创）',
	-- 删除标识
	is_del int DEFAULT 0 COMMENT '删除标识',
	PRIMARY KEY (id)
);


CREATE TABLE tb_forum
(
	-- 编号
	id varchar(32) NOT NULL COMMENT '编号',
	-- 创建人
	create_id varchar(32) COMMENT '创建人',
	-- 创建时间
	create_time datetime COMMENT '创建时间',
	-- 标题
	title varchar(200) COMMENT '标题',
	-- 主文
	contents longtext COMMENT '主文',
	-- 图片地址
	img_url varchar(256) COMMENT '图片地址',
	-- 论坛类型（求助、分享、讨论）
	forum_type varchar(20) COMMENT '论坛类型（求助、分享、讨论）',
	-- 删除标识
	is_del int DEFAULT 0 COMMENT '删除标识',
	PRIMARY KEY (id)
);


CREATE TABLE tb_forum_reply
(
	-- 编号
	id varchar(32) NOT NULL COMMENT '编号',
	-- 主论坛编号
	forum varchar(32) COMMENT '主论坛编号',
	-- 回复内容
	reply_comment varchar(500) COMMENT '回复内容',
	-- 回复图片
	reply_img varchar(256) COMMENT '回复图片',
	-- 是否引用回复
	is_ref int DEFAULT 0 COMMENT '是否引用回复',
	-- 引用评论编号
	ref_reply_id varchar(32) COMMENT '引用评论编号',
	-- 创建时间
	create_time datetime COMMENT '创建时间',
	-- 楼层号
	floor_num bigint DEFAULT 1 COMMENT '楼层号',
	-- 删除标识
	is_del int DEFAULT 0 COMMENT '删除标识',
	PRIMARY KEY (id)
);


CREATE TABLE tb_help_strap
(
	-- 编号
	id varchar(32) NOT NULL COMMENT '编号',
	-- 用户编号
	user_id varchar(32) COMMENT '用户编号',
	-- 宠物编号
	pet_id varchar(32) COMMENT '宠物编号',
	-- 创建时间
	create_time datetime COMMENT '创建时间',
	-- 更新时间
	update_time datetime COMMENT '更新时间',
	-- 开始时间
	start_time datetime COMMENT '开始时间',
	-- 结束时间
	end_time datetime COMMENT '结束时间',
	-- 描述
	comments text COMMENT '描述',
	-- 是否加急
	is_urgent int DEFAULT 0 COMMENT '是否加急',
	-- 是否使用宠物详细信息展示
	is_use_pet_info int DEFAULT 0 COMMENT '是否使用宠物详细信息展示',
	-- 宠物照片json str数组, 同是否使用宠物详细信息作为展示数据互斥
	pet_img_list varchar(1000) COMMENT '宠物照片json str数组, 同是否使用宠物详细信息作为展示数据互斥',
	-- 删除标识
	is_del int DEFAULT 0 COMMENT '删除标识',
	PRIMARY KEY (id)
);


CREATE TABLE tb_party
(
	-- 编号
	id varchar(32) NOT NULL COMMENT '编号',
	-- 创建人
	user_id varchar(32) COMMENT '创建人',
	-- 负责人编号
	responsible_id varchar(32) COMMENT '负责人编号',
	-- 创建时间
	create_time datetime COMMENT '创建时间',
	-- 更新时间
	update_time datetime COMMENT '更新时间',
	-- 开始时间
	start_time datetime COMMENT '开始时间',
	-- 结束时间
	end_time datetime COMMENT '结束时间',
	-- party类型(生日、日常、交友、聚会、交流）
	party_type varchar(32) COMMENT 'party类型(生日、日常、交友、聚会、交流）',
	-- 详细地址
	info_address varchar(256) COMMENT '详细地址',
	-- 描述内容
	comment varchar(1000) COMMENT '描述内容',
	-- 手机号码
	mobile varchar(16) COMMENT '手机号码',
	-- 微信号
	weixin varchar(50) COMMENT '微信号',
	-- 消费类型（AA制、 举办人全包、无须费用）
	consume_type varchar(16) COMMENT '消费类型（AA制、 举办人全包、无须费用）',
	-- 注意事项
	warning varchar(32) COMMENT '注意事项',
	-- 删除标识
	is_del int DEFAULT 0 COMMENT '删除标识',
	PRIMARY KEY (id)
);


CREATE TABLE tb_party_user
(
	-- 编号
	id varchar(32) NOT NULL COMMENT '编号',
	-- 聚会编号
	party_id varchar(32) COMMENT '聚会编号',
	-- 用户编号
	user_id varchar(32) COMMENT '用户编号',
	-- 创建时间
	create_time datetime COMMENT '创建时间',
	-- 删除标识
	is_del int DEFAULT 0 COMMENT '删除标识',
	PRIMARY KEY (id)
);


CREATE TABLE tb_pet_diary
(
	-- 编号
	id varchar(32) NOT NULL COMMENT '编号',
	-- 宠物编号(为空表示非特定宠物记录）
	pet_id varchar(32) COMMENT '宠物编号(为空表示非特定宠物记录）',
	-- 用户编号
	user_id varchar(32) COMMENT '用户编号',
	-- 日记内容
	contents longtext COMMENT '日记内容',
	-- 是否私有(默认1，私有。0 公开）
	is_private int DEFAULT 1 COMMENT '是否私有(默认1，私有。0 公开）',
	-- 创建时间
	create_time datetime COMMENT '创建时间',
	-- 更新时间
	update_time datetime COMMENT '更新时间',
	-- 删除标识
	is_del int DEFAULT 0 COMMENT '删除标识',
	PRIMARY KEY (id)
);


CREATE TABLE tb_sell
(
	-- 编号
	id varchar(32) NOT NULL COMMENT '编号',
	-- 用户编号
	user_id varchar(32) COMMENT '用户编号',
	-- 物品名称
	product_name varchar(128) COMMENT '物品名称',
	-- 原价
	origin_price varchar(50) COMMENT '原价',
	-- 销售价
	sell_price varchar(50) COMMENT '销售价',
	-- 币种（CNY/...)
	money_type varchar(10) COMMENT '币种（CNY/...)',
	-- 购买来源(JD/Taobao/实体店/自制/其他）
	buy_src varchar(50) COMMENT '购买来源(JD/Taobao/实体店/自制/其他）',
	-- 是否有发票
	is_invoce int DEFAULT 0 COMMENT '是否有发票',
	-- 描述
	comments longtext COMMENT '描述',
	-- 创建时间
	create_time datetime COMMENT '创建时间',
	-- 状态（售卖中，下架、售罄）
	status varchar(16) COMMENT '状态（售卖中，下架、售罄）',
	-- 删除标识
	is_del int DEFAULT 0 COMMENT '删除标识',
	PRIMARY KEY (id)
);


CREATE TABLE tb_store
(
	-- 编号
	id varchar(32) NOT NULL COMMENT '编号',
	-- 门店管理员
	admin_id varchar(32) COMMENT '门店管理员',
	-- 省份编号
	province_id varchar(32) COMMENT '省份编号',
	-- 市区ID
	city_id varchar(32) COMMENT '市区ID',
	-- 县城ID
	county_id varchar(32) COMMENT '县城ID',
	-- 乡镇ID
	town_id varchar(32) COMMENT '乡镇ID',
	-- 门店名称
	store_name varchar(64) COMMENT '门店名称',
	-- 创建时间
	create_time datetime COMMENT '创建时间',
	-- 创建人
	create_id varchar(32) COMMENT '创建人',
	-- 更新时间
	update_time datetime COMMENT '更新时间',
	-- 更新人
	update_id varchar(32) COMMENT '更新人',
	-- 经度
	map_x varchar(32) COMMENT '经度',
	-- 纬度
	map_y varchar(32) COMMENT '纬度',
	-- 门店图文详情
	store_desc text COMMENT '门店图文详情',
	-- 门店头像
	log_url varchar(256) COMMENT '门店头像',
	-- 营业时间
	online_time varchar(128) COMMENT '营业时间',
	-- 门店移动号码
	store_mobile varchar(32) COMMENT '门店移动号码',
	-- 门店座机号码
	store_telphone varchar(32) COMMENT '门店座机号码',
	-- 门店微信
	store_wx varchar(64) COMMENT '门店微信',
	-- 门店qq
	store_qq varchar(32) COMMENT '门店qq',
	-- 门店排名
	store_rank bigint DEFAULT 999999 COMMENT '门店排名',
	-- 禁用标识
	is_disable int DEFAULT 0 COMMENT '禁用标识',
	-- 注销标识
	is_destory int DEFAULT 0 COMMENT '注销标识',
	-- 删除标识
	is_del int DEFAULT 0 COMMENT '删除标识',
	PRIMARY KEY (id)
);


CREATE TABLE tb_store_comment
(
	-- 编号
	id varchar(32) NOT NULL COMMENT '编号',
	-- 门店编号
	store_id varchar(32) COMMENT '门店编号',
	-- 评论用户
	user_id varchar(32) COMMENT '评论用户',
	-- 评论内容
	comment varchar(512) COMMENT '评论内容',
	-- 创建时间
	create_time datetime COMMENT '创建时间',
	-- 删除标识
	is_del int DEFAULT 0 COMMENT '删除标识',
	PRIMARY KEY (id)
);


CREATE TABLE tb_store_img
(
	-- 编号
	id varchar(32) NOT NULL COMMENT '编号',
	-- 门店编号
	store_id varchar(32) COMMENT '门店编号',
	-- 图片地址
	img_url varchar(256) COMMENT '图片地址',
	-- 图片类型:主图（多张）， 详情图（多张）
	img_type varchar(16) COMMENT '图片类型:主图（多张）， 详情图（多张）',
	-- 排序值
	sort_num int DEFAULT 0 COMMENT '排序值',
	-- 删除标识
	is_del int DEFAULT 0 COMMENT '删除标识',
	PRIMARY KEY (id)
);


CREATE TABLE tb_store_manage_type
(
	-- 编号
	id varchar(32) NOT NULL COMMENT '编号',
	-- 基础商品ID
	product_id varchar(32) COMMENT '基础商品ID',
	-- 宠物类目编号
	pet_type_id varchar(32) COMMENT '宠物类目编号',
	-- 删除标识
	is_del int DEFAULT 0 COMMENT '删除标识',
	PRIMARY KEY (id)
);


CREATE TABLE tb_store_product
(
	-- 编号
	id varchar(32) NOT NULL COMMENT '编号',
	-- 基础商品ID（非从基础商品继承，则运行为null。表示为门店自建）
	base_product_id varchar(32) COMMENT '基础商品ID（非从基础商品继承，则运行为null。表示为门店自建）',
	-- 门店编号
	store_id varchar(32) COMMENT '门店编号',
	-- 创建人
	create_id varchar(32) COMMENT '创建人',
	-- 创建时间
	create_time datetime COMMENT '创建时间',
	-- 更新人
	update_id varchar(32) COMMENT '更新人',
	-- 更新时间
	update_time datetime COMMENT '更新时间',
	-- 商品名称
	product_name varchar(128) COMMENT '商品名称',
	-- 原价(单位分）
	original_price bigint COMMENT '原价(单位分）',
	-- 销售价(单位分）
	sell_price bigint COMMENT '销售价(单位分）',
	-- 销售类型：来店自取、网络销售
	sell_type varchar(16) COMMENT '销售类型：来店自取、网络销售',
	-- 品牌名称
	brand_name varchar(64) COMMENT '品牌名称',
	-- 商品规格
	product_spec varchar(64) COMMENT '商品规格',
	-- 供应商名称
	vender_name varchar(64) COMMENT '供应商名称',
	-- 商品文字描述
	product_desc text COMMENT '商品文字描述',
	-- 商品类型（实质商品、增值服务）
	product_type varchar(32) COMMENT '商品类型（实质商品、增值服务）',
	-- 删除标识
	is_del int DEFAULT 0 COMMENT '删除标识',
	PRIMARY KEY (id)
);


CREATE TABLE tb_store_product_img
(
	-- 编号
	id varchar(32) NOT NULL COMMENT '编号',
	-- 基础商品ID
	product_id varchar(32) COMMENT '基础商品ID',
	-- 图片地址
	img_url varchar(256) COMMENT '图片地址',
	-- 图片类型:主图（多张）， 详情图（多张）
	img_type varchar(16) COMMENT '图片类型:主图（多张）， 详情图（多张）',
	-- 排序值
	sort_num int DEFAULT 0 COMMENT '排序值',
	-- 删除标识
	is_del int DEFAULT 0 COMMENT '删除标识',
	PRIMARY KEY (id)
);


CREATE TABLE tb_store_product_selllog
(
	-- 编号
	id varchar(32) NOT NULL COMMENT '编号',
	-- 门店商品编号
	store_product_id varchar(32) COMMENT '门店商品编号',
	-- 订单编号
	order_id varchar(32) COMMENT '订单编号',
	-- 订单号
	order_num varchar(32) COMMENT '订单号',
	-- 删除标识
	is_del int DEFAULT 0 COMMENT '删除标识',
	PRIMARY KEY (id)
);


CREATE TABLE tb_store_subscribe
(
	-- 编号
	id varchar(32) NOT NULL COMMENT '编号',
	-- 门店编号
	store_id varchar(32) COMMENT '门店编号',
	-- 用户编号
	user_id varchar(32) COMMENT '用户编号',
	-- 门店商品（服务）编号
	store_product_id varchar(32) COMMENT '门店商品（服务）编号',
	-- 联系电话
	mobile varchar(32) COMMENT '联系电话',
	-- 预约开始时间
	start_time datetime COMMENT '预约开始时间',
	-- 预约结束时间
	end_time datetime COMMENT '预约结束时间',
	-- 描述
	comment varchar(500) COMMENT '描述',
	-- 删除标识
	is_del int DEFAULT 0 COMMENT '删除标识',
	PRIMARY KEY (id)
);


CREATE TABLE tb_store_vip_user
(
	-- 编号
	id varchar(32) NOT NULL COMMENT '编号',
	-- 门店编号
	store_id varchar(32) COMMENT '门店编号',
	-- 用户编号
	user_id varchar(32) COMMENT '用户编号',
	-- 会员类型:预充值、其他
	vip_type varchar(16) COMMENT '会员类型:预充值、其他',
	-- 创建时间
	create_time datetime COMMENT '创建时间',
	-- 创建人
	create_id varchar(32) COMMENT '创建人',
	-- 更新时间
	update_time datetime COMMENT '更新时间',
	-- 更新人
	update_id varchar(32) COMMENT '更新人',
	-- 备注信息
	remark varchar(500) COMMENT '备注信息',
	-- 删除标识
	is_del int DEFAULT 0 COMMENT '删除标识',
	PRIMARY KEY (id)
);



