SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS tb_hot_spot;
DROP TABLE IF EXISTS tb_login_log;
DROP TABLE IF EXISTS tb_op_log;
DROP TABLE IF EXISTS tb_rec_address;
DROP TABLE IF EXISTS tb_role;
DROP TABLE IF EXISTS tb_system_notice;
DROP TABLE IF EXISTS tb_user;




/* Create Tables */

-- 我的关注表
CREATE TABLE tb_hot_spot
(
	-- 编号
	id varchar(32) NOT NULL COMMENT '编号 : 编号',
	-- 用户编号
	user_id varchar(32) COMMENT '用户编号 : 用户编号',
	-- 关注人编号
	hot_spot_user_id varchar(32) COMMENT '关注人编号 : 关注人编号',
	-- 创建时间
	create_time datetime COMMENT '创建时间 : 创建时间',
	-- 删除标识
	is_del int DEFAULT 0 COMMENT '删除标识 : 删除标识',
	PRIMARY KEY (id)
) COMMENT = '我的关注表';


-- 登录记录表
CREATE TABLE tb_login_log
(
	-- 编号
	id varchar(32) NOT NULL COMMENT '编号 : 编号',
	-- 用户编号
	user_id varchar(32) COMMENT '用户编号 : 用户编号',
	-- 登录时间
	login_time datetime COMMENT '登录时间 : 登录时间',
	-- 登录结果
	login_result varchar(8) COMMENT '登录结果 : 登录结果',
	-- 登录异常信息
	login_error_msg varchar(512) COMMENT '登录异常信息 : 登录异常信息',
	-- 登录IP
	login_ip varchar(32) COMMENT '登录IP : 登录IP',
	-- 登录方式
	login_type varchar(32) COMMENT '登录方式 : 登录方式',
	-- 平台名称:小程序、运营平台、门店平台
	portal_name varchar(64) COMMENT '平台名称 : 平台名称:小程序、运营平台、门店平台',
	-- 预留字段1
	res1 varchar(64) COMMENT '预留字段1 : 预留字段1',
	-- 预留字段2
	res2 varchar(64) COMMENT '预留字段2 : 预留字段2',
	PRIMARY KEY (id)
) COMMENT = '登录记录表';


-- 操作日志表
CREATE TABLE tb_op_log
(
	-- 编号
	id varchar(32) NOT NULL COMMENT '编号 : 编号',
	-- 用户编号
	user_id varchar(32) COMMENT '用户编号 : 用户编号',
	-- 菜单名称
	menu_name varchar(128) COMMENT '菜单名称 : 菜单名称',
	-- 平台名称:小程序、运营平台、门店平台
	portal_name varchar(64) COMMENT '平台名称 : 平台名称:小程序、运营平台、门店平台',
	-- 操作类型: 新增、删除、编辑、查询
	op_type varchar(8) COMMENT '操作类型 : 操作类型: 新增、删除、编辑、查询',
	-- 操作时间
	op_time datetime COMMENT '操作时间 : 操作时间',
	-- 描述
	remark varchar(128) COMMENT '描述 : 描述',
	PRIMARY KEY (id)
) COMMENT = '操作日志表';


-- 收货地址表
CREATE TABLE tb_rec_address
(
	-- 编号
	id varchar(32) NOT NULL COMMENT '编号 : 编号',
	-- 用户编号(前端)
	user_id varchar(32) COMMENT '用户编号 : 用户编号(前端)',
	-- 创建时间
	create_time datetime COMMENT '创建时间 : 创建时间',
	-- 更新时间
	update_time datetime COMMENT '更新时间 : 更新时间',
	-- 归属：家/公司 等字符串枚举
	belong varchar(20) COMMENT '归属 : 归属：家/公司 等字符串枚举',
	-- 收货人
	consignee varchar(20) COMMENT '收货人 : 收货人',
	-- 省份编号
	province_id varchar(32) COMMENT '省份编号 : 省份编号',
	-- 省份名称（不做存储，查询展示）
	province_name varchar(80) COMMENT '省份名称 : 省份名称（不做存储，查询展示）',
	-- 城市编号
	city_id varchar(32) COMMENT '城市编号 : 城市编号',
	-- 城市名称
	city_name varchar(80) COMMENT '城市名称 : 城市名称',
	-- 县城编号
	county_id varchar(32) COMMENT '县城编号 : 县城编号',
	-- 县城名称
	county_name varchar(80) COMMENT '县城名称 : 县城名称',
	-- 乡镇编号
	town_id varchar(32) COMMENT '乡镇编号 : 乡镇编号',
	-- 乡镇名称
	town_name varchar(80) COMMENT '乡镇名称 : 乡镇名称',
	-- 地址
	address varchar(250) COMMENT '地址 : 地址',
	-- 邮箱地址
	email varchar(100) COMMENT '邮箱地址 : 邮箱地址',
	-- 手机号码
	mobile varchar(20) COMMENT '手机号码 : 手机号码',
	-- 固定电话
	tel varchar(20) COMMENT '固定电话 : 固定电话',
	-- 是否默认,1.默认
	is_default int DEFAULT 0 COMMENT '是否默认 : 是否默认,1.默认',
	-- 删除标识
	is_del int DEFAULT 0 COMMENT '删除标识 : 删除标识',
	PRIMARY KEY (id)
) COMMENT = '收货地址表';


-- 角色表
CREATE TABLE tb_role
(
	-- 角色编号
	id varchar(32) NOT NULL COMMENT '角色编号 : 角色编号',
	-- 更新人
	update_id varchar(32) COMMENT '更新人 : 更新人',
	-- 创建人
	create_id varchar(32) COMMENT '创建人 : 创建人',
	-- 角色名称
	role_name varchar(16) COMMENT '角色名称 : 角色名称',
	-- 创建时间
	create_time datetime COMMENT '创建时间 : 创建时间',
	-- 更新时间
	update_time datetime COMMENT '更新时间 : 更新时间',
	-- 描述
	remark varchar(64) COMMENT '描述 : 描述',
	-- 删除标识
	is_del int DEFAULT 0 COMMENT '删除标识 : 删除标识',
	PRIMARY KEY (id)
) COMMENT = '角色表';


-- 系统通知表
CREATE TABLE tb_system_notice
(
	-- 编号
	id varchar(32) NOT NULL COMMENT '编号 : 编号',
	-- 创建来源(系统生成、平台手动创建）
	create_src varchar(10) COMMENT '创建来源 : 创建来源(系统生成、平台手动创建）',
	-- 创建人(仅在手动创建时有值）
	create_id varchar(32) COMMENT '创建人 : 创建人(仅在手动创建时有值）',
	-- 标题
	title varchar(100) COMMENT '标题 : 标题',
	-- 正文
	contents varchar(1000) COMMENT '正文 : 正文',
	-- 创建时间
	create_time datetime COMMENT '创建时间 : 创建时间',
	-- 接受用户编号
	rec_user_id varchar(32) COMMENT '接受用户编号 : 接受用户编号',
	-- 是否已读
	is_read int DEFAULT 0 COMMENT '是否已读 : 是否已读',
	-- 删除标识
	is_del int DEFAULT 0 COMMENT '删除标识 : 删除标识',
	PRIMARY KEY (id)
) COMMENT = '系统通知表';


-- 用户表
CREATE TABLE tb_user
(
	-- 编号
	id varchar(32) NOT NULL COMMENT '编号 : 编号',
	-- 角色编号
	role_id varchar(32) COMMENT '角色编号 : 角色编号',
	-- 省份编号
	provinde_id varchar(32) COMMENT '省份编号 : 省份编号',
	-- 城市ID
	city_id varchar(32) COMMENT '城市ID : 城市ID',
	-- 县城ID
	county_id varchar(32) COMMENT '县城ID : 县城ID',
	-- 乡镇ID
	town_id varchar(32) COMMENT '乡镇ID : 乡镇ID',
	-- 账号
	account varchar(16) COMMENT '账号 : 账号',
	-- 昵称
	nick_name varchar(64) COMMENT '昵称 : 昵称',
	-- 密码
	passwd varchar(64) COMMENT '密码 : 密码',
	-- 盐
	salt varchar(64) COMMENT '盐 : 盐',
	-- 头像地址
	face_url varchar(256) COMMENT '头像地址 : 头像地址',
	-- 微信token
	wx_token varchar(256) COMMENT '微信token : 微信token',
	-- 详细地址
	info_address varchar(256) COMMENT '详细地址 : 详细地址',
	-- 性别
	sex varchar(8) COMMENT '性别 : 性别',
	-- 是否注销
	is_destory int DEFAULT 0 COMMENT '是否注销 : 是否注销',
	-- 是否禁用
	is_disable int DEFAULT 0 COMMENT '是否禁用 : 是否禁用',
	-- 删除标识
	is_del int DEFAULT 0 COMMENT '删除标识 : 删除标识',
	PRIMARY KEY (id)
) COMMENT = '用户表';



