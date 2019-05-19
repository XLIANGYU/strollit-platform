SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS tb_pet;
DROP TABLE IF EXISTS tb_pet_kind;
DROP TABLE IF EXISTS tb_pet_type;
DROP TABLE IF EXISTS tb_user;
DROP TABLE IF EXISTS tb_role;
DROP TABLE IF EXISTS tb_sys_config;




/* Create Tables */

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


-- 用户表
CREATE TABLE tb_user
(
	-- 编号
	id varchar(32) NOT NULL COMMENT '编号 : 编号',
	-- 角色编号
	role_id varchar(32) NOT NULL COMMENT '角色编号 : 角色编号',
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
	PRIMARY KEY (id)
) COMMENT = '用户表';



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


ALTER TABLE tb_user
	ADD FOREIGN KEY (role_id)
	REFERENCES tb_role (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE tb_pet
	ADD FOREIGN KEY (user_id)
	REFERENCES tb_user (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



