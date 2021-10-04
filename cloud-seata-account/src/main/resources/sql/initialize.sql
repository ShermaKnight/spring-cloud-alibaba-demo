create database if not exists seata_account default character set utf8mb4;

use seata_account;
CREATE TABLE seata_account.undo_log
(
    id            BIGINT(20)   NOT NULL AUTO_INCREMENT,
    branch_id     BIGINT(20)   NOT NULL,
    xid           VARCHAR(100) NOT NULL,
    context       VARCHAR(128) NOT NULL,
    rollback_info LONGBLOB     NOT NULL,
    log_status    INT(11)      NOT NULL,
    log_created   DATETIME     NOT NULL,
    log_modified  DATETIME     NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY ux_undo_log (xid, branch_id)
) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8;

CREATE TABLE `tbl_account` (
    `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `user_id` bigint(11) NOT NULL COMMENT '用户ID',
    `user_name` varchar(20) NOT NULL DEFAULT '' COMMENT '用户名',
    `nick_name` varchar(20) NOT NULL DEFAULT '' COMMENT '昵称',
    `address` varchar(1024) NOT NULL DEFAULT '' COMMENT '地址',
    `total` decimal(10,2) DEFAULT NULL COMMENT '总金额',
    `used` decimal(10,2) DEFAULT NULL COMMENT '使用金额',
    `residue` decimal(10,2) DEFAULT NULL COMMENT '剩余金额',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

