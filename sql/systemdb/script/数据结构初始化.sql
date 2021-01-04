SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for res_api_tbl
-- ----------------------------
DROP TABLE IF EXISTS `res_api_tbl`;
CREATE TABLE `res_api_tbl`  (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '请求接口表id',
`service_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '调用服务名称',
`controller` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '控制器',
`method` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '方法',
`remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '接口描述',
`create_time` datetime(0) NOT NULL COMMENT '创建时间',
`create_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建用户',
`modify_time` datetime(0) NOT NULL COMMENT '更新时间',
`modify_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '修改用户',
`del_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
`del_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除用户',
`isdel` tinyint(5) UNSIGNED ZEROFILL NOT NULL COMMENT '是否删除(0 否,1 是)',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '请求接口表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for res_application_api_tbl
-- ----------------------------
DROP TABLE IF EXISTS `res_application_api_tbl`;
CREATE TABLE `res_application_api_tbl`  (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '请求应用接口表id',
`app_id` int(11) NOT NULL COMMENT '请求应用表id',
`api_id` int(11) NOT NULL COMMENT '请求接口表id',
`create_time` datetime(0) NOT NULL COMMENT '创建时间',
`create_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建用户',
`del_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
`del_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除用户',
`isdel` tinyint(5) UNSIGNED ZEROFILL NOT NULL COMMENT '是否删除(0 否,1 是)',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '请求应用接口表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for res_application_tbl
-- ----------------------------
DROP TABLE IF EXISTS `res_application_tbl`;
CREATE TABLE `res_application_tbl`  (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '请求应用表id',
`name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '应用名称',
`secret` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密钥',
`remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '应用描述',
`create_time` datetime(0) NOT NULL COMMENT '创建时间',
`create_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建用户',
`modify_time` datetime(0) NOT NULL COMMENT '更新时间',
`modify_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '修改用户',
`del_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
`del_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除用户',
`isdel` tinyint(5) UNSIGNED ZEROFILL NOT NULL COMMENT '是否删除(0 否,1 是)',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '请求应用表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_component_tbl
-- ----------------------------
DROP TABLE IF EXISTS `sys_component_tbl`;
CREATE TABLE `sys_component_tbl`  (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '系统组件表id',
`parent_id` int(11) NOT NULL COMMENT '父组件id',
`name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '组件名称',
`perms` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限标识',
`remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组件描述',
`type` int(11) NOT NULL COMMENT '组件类型(0 路由,1 按钮)',
`no` int(11) NOT NULL COMMENT '排序',
`create_time` datetime(0) NOT NULL COMMENT '创建时间',
`create_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建用户',
`modify_time` datetime(0) NOT NULL COMMENT '更新时间',
`modify_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '修改用户',
`del_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
`del_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除用户',
`isdel` tinyint(5) UNSIGNED ZEROFILL NOT NULL COMMENT '是否删除(0 否,1 是)',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统组件表' ROW_FORMAT = Dynamic;

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
`type` int(11) NULL DEFAULT NULL COMMENT '类型',
`status` tinyint(5) NOT NULL COMMENT '状态(0 正在上传 1 已上传)',
`create_time` datetime(0) NOT NULL COMMENT '创建时间',
`create_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建用户',
`modify_time` datetime(0) NOT NULL COMMENT '更新时间',
`modify_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '修改用户',
`del_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
`del_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除用户',
`isdel` tinyint(5) UNSIGNED ZEROFILL NOT NULL COMMENT '是否删除(0 否,1 是)',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统文件表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_organization_tbl
-- ----------------------------
DROP TABLE IF EXISTS `sys_organization_tbl`;
CREATE TABLE `sys_organization_tbl`  (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '系统组织表id',
`parent_id` int(11) NOT NULL COMMENT '父组织id',
`name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '组织名称',
`remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组织描述',
`create_time` datetime(0) NOT NULL COMMENT '创建时间',
`create_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建用户',
`modify_time` datetime(0) NOT NULL COMMENT '更新时间',
`modify_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '修改用户',
`del_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
`del_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除用户',
`isdel` tinyint(5) UNSIGNED ZEROFILL NOT NULL COMMENT '是否删除(0 否,1 是)',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统组织表' ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统定时任务表' ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统角色组件表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role_tbl
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_tbl`;
CREATE TABLE `sys_role_tbl`  (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '系统角色表id',
`name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
`remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
`create_time` datetime(0) NOT NULL COMMENT '创建时间',
`create_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建用户',
`modify_time` datetime(0) NOT NULL COMMENT '更新时间',
`modify_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '修改用户',
`del_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
`del_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除用户',
`isdel` tinyint(5) UNSIGNED ZEROFILL NOT NULL COMMENT '是否删除(0 否,1 是)',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_router_tbl
-- ----------------------------
DROP TABLE IF EXISTS `sys_router_tbl`;
CREATE TABLE `sys_router_tbl`  (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '系统路由表id',
`component_id` int(11) NOT NULL COMMENT '系统组件表id',
`component` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '前端绑定组件',
`path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对应路由地址',
`icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
`redirect` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '重定向地址, 访问这个路由时,自定进行重定向',
`hidden` tinyint(5) NULL DEFAULT 0 COMMENT '控制路由和子路由是否显示在 sidebar(0 否 1 是)',
`hide_childrenIn_menu` tinyint(5) NULL DEFAULT 0 COMMENT '强制菜单显示为Item而不是SubItem(配合 meta.hidden)(0 否 1 是)',
`keep_alive` tinyint(5) NULL DEFAULT 1 COMMENT '缓存该路由 (开启 multi-tab 是默认值为 true)(0 否 1 是)',
`hidden_header_content` tinyint(5) NULL DEFAULT 0 COMMENT '特殊 隐藏 PageHeader 组件中的页面带的 面包屑和页面标题栏(0 否 1 是)',
`target` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单链接跳转目标（参考 html a 标记）',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统路由表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user_component_tbl
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_component_tbl`;
CREATE TABLE `sys_user_component_tbl`  (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '系统用户组件表id',
`user_id` int(11) NOT NULL COMMENT '用户id',
`com_id` int(11) NOT NULL COMMENT '组件id',
`create_time` datetime(0) NOT NULL COMMENT '创建时间',
`create_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建用户',
`del_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
`del_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除用户',
`isdel` tinyint(5) UNSIGNED ZEROFILL NOT NULL COMMENT '是否删除(0 否,1 是)',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 58 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统用户组件表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user_organization_tbl
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_organization_tbl`;
CREATE TABLE `sys_user_organization_tbl`  (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '系统用户组织表id',
`user_id` int(11) NOT NULL COMMENT '用户id',
`organization_id` int(11) NOT NULL COMMENT '组织id',
`create_time` datetime(0) NOT NULL COMMENT '创建时间',
`create_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建用户',
`del_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
`del_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除用户',
`isdel` tinyint(5) UNSIGNED ZEROFILL NOT NULL COMMENT '是否删除(0 否,1 是)',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统用户组织表' ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统用户角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user_tbl
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_tbl`;
CREATE TABLE `sys_user_tbl`  (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '系统用户信息表id',
`username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
`password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
`realname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
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
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for undo_log
-- ----------------------------
DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE `undo_log`  (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`branch_id` bigint(20) NOT NULL,
`xid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
`context` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
`rollback_info` longblob NOT NULL,
`log_status` int(11) NOT NULL,
`log_created` datetime(0) NOT NULL,
`log_modified` datetime(0) NOT NULL,
PRIMARY KEY (`id`) USING BTREE,
UNIQUE INDEX `ux_undo_log`(`xid`, `branch_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
