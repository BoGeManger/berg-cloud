/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50710
 Source Host           : localhost:3306
 Source Schema         : basedb

 Target Server Type    : MySQL
 Target Server Version : 50710
 File Encoding         : 65001

 Date: 10/06/2020 17:20:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_component_tbl
-- ----------------------------
DROP TABLE IF EXISTS `sys_component_tbl`;
CREATE TABLE `sys_component_tbl`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '系统组件表id',
  `parent_id` int(11) NOT NULL COMMENT '父组件id',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '组件名称',
  `perms` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限标识',
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对应路由地址',
  `icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `remark` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '组件描述',
  `type` int(11) NOT NULL COMMENT '组件类型(0=菜单,1=按钮)',
  `no` int(11) NOT NULL COMMENT '排序',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `create_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建用户',
  `modify_time` datetime(0) NOT NULL COMMENT '更新时间',
  `modify_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '修改用户',
  `del_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
  `del_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除用户',
  `isdel` tinyint(5) UNSIGNED ZEROFILL NOT NULL COMMENT '是否删除(0 否,1 是)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统组件表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_file_tbl
-- ----------------------------
DROP TABLE IF EXISTS `sys_file_tbl`;
CREATE TABLE `sys_file_tbl`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '系统文件表id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务编码',
  `path` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件路径',
  `full_path` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件全路径',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `create_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建用户',
  `modify_time` datetime(0) NOT NULL COMMENT '更新时间',
  `modify_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '修改用户',
  `del_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
  `del_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除用户',
  `isdel` tinyint(5) UNSIGNED ZEROFILL NOT NULL COMMENT '是否删除(0 否,1 是)',
  `type` int(11) NOT NULL COMMENT '类型(0 模板文件 1 其他)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统文件表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_organization_tbl
-- ----------------------------
DROP TABLE IF EXISTS `sys_organization_tbl`;
CREATE TABLE `sys_organization_tbl`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '系统组织表id',
  `parent_id` int(11) NOT NULL COMMENT '父组织id',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '组织名称',
  `remark` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '组织描述',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `create_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建用户',
  `modify_time` datetime(0) NOT NULL COMMENT '更新时间',
  `modify_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '修改用户',
  `del_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
  `del_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除用户',
  `isdel` tinyint(5) UNSIGNED ZEROFILL NOT NULL COMMENT '是否删除(0 否,1 是)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统组织表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_quartz_job_tbl
-- ----------------------------
DROP TABLE IF EXISTS `sys_quartz_job_tbl`;
CREATE TABLE `sys_quartz_job_tbl`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '系统定时任务表id',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '任务名称',
  `remark` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '任务描述',
  `job_class_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '任务类名',
  `cron_expression` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'cron表达式',
  `parameter` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `create_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建用户',
  `modify_time` datetime(0) NOT NULL COMMENT '更新时间',
  `modify_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '修改用户',
  `del_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
  `del_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除用户',
  `isdel` tinyint(5) UNSIGNED ZEROFILL NOT NULL COMMENT '是否删除(0 否,1 是)',
  `status` int(11) NOT NULL COMMENT '状态(0 进行中,1 已暂停)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统定时任务表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role_component_tbl
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_component_tbl`;
CREATE TABLE `sys_role_component_tbl`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '系统角色组件表id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `com_id` int(11) NOT NULL COMMENT '组件id',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `create_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建用户',
  `del_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
  `del_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除用户',
  `isdel` tinyint(5) UNSIGNED ZEROFILL NOT NULL COMMENT '是否删除(0 否,1 是)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统角色组件表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role_tbl
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_tbl`;
CREATE TABLE `sys_role_tbl`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '系统角色表id',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `remark` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '角色描述',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `create_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建用户',
  `modify_time` datetime(0) NOT NULL COMMENT '更新时间',
  `modify_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '修改用户',
  `del_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
  `del_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除用户',
  `isdel` tinyint(5) UNSIGNED ZEROFILL NOT NULL COMMENT '是否删除(0 否,1 是)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user_role_tbl
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role_tbl`;
CREATE TABLE `sys_user_role_tbl`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '系统用户角色表id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `create_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建用户',
  `del_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
  `del_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除用户',
  `isdel` tinyint(5) UNSIGNED ZEROFILL NOT NULL COMMENT '是否删除(0 否,1 是)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统用户角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user_tbl
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_tbl`;
CREATE TABLE `sys_user_tbl`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '系统用户信息表id',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `realname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `organization_id` int(11) NOT NULL COMMENT '所属组织id',
  `organization_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属组织名称',
  `last_login_time` datetime(0) NOT NULL COMMENT '最后登录时间',
  `lock_time` datetime(0) NULL DEFAULT NULL COMMENT '锁定时间',
  `lock_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '锁定人',
  `islock` tinyint(5) NOT NULL COMMENT '是否锁定(0 否,1 是)',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `create_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建用户',
  `modify_time` datetime(0) NOT NULL COMMENT '更新时间',
  `modify_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '修改用户',
  `del_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
  `del_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除用户',
  `isdel` tinyint(5) UNSIGNED ZEROFILL NOT NULL COMMENT '是否删除(0 否,1 是)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统用户信息表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
