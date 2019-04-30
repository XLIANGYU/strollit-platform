SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS tb_role;
DROP TABLE IF EXISTS tb_user;




/* Create Tables */

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
	is_del int COMMENT '删除标识 : 删除标识',
	PRIMARY KEY (id)
) COMMENT = '角色表';


-- 用户表
CREATE TABLE tb_user
(
	-- 编号
	id varchar(32) NOT NULL COMMENT '编号 : 编号',
	-- 角色编号
	role_id varchar(32) COMMENT '角色编号 : 角色编号',
	-- 账号
	account varchar(64) COMMENT '账号 : 账号',
	-- 昵称
	nick_name varchar(64) COMMENT '昵称 : 昵称',
	-- 密码
	passwd varchar(64) COMMENT '密码 : 密码',
	-- 盐
	salt varchar(64) COMMENT '盐 : 盐',
	-- 头像地址
	face_url varchar(256) COMMENT '头像地址 : 头像地址',
	PRIMARY KEY (id)
) COMMENT = '用户表';



