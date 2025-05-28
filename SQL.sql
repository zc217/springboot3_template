CREATE TABLE `sys_user`
(
    `id`        bigint      NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`  varchar(64) NOT NULL COMMENT '用户名',
    `password`  varchar(64) NOT NULL COMMENT '密码',
    `email`     varchar(64) DEFAULT NULL COMMENT '邮箱',
    `phone`     varchar(64) DEFAULT NULL COMMENT '手机',
    `sex`       varchar(64) DEFAULT NULL COMMENT '性别',
    `dept_id`   bigint      DEFAULT NULL COMMENT '部门ID',
    `post_id`   bigint      DEFAULT NULL COMMENT '岗位ID',
    `real_name` varchar(64) DEFAULT NULL COMMENT '真实姓名',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='用户表';