create database if not exists seata_order default character set utf8mb4;

use seata_order;
CREATE TABLE seata_order.undo_log
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

CREATE TABLE `tbl_order` (
    `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `user_id` bigint(11) NOT NULL COMMENT '用户ID',
    `product_id` bigint(11) NOT NULL COMMENT '产品ID',
    `count` int(11) NOT NULL COMMENT '数量',
    `money` decimal(11,2) NOT NULL DEFAULT '0.00' COMMENT '金额',
    `status` int(1) NOT NULL DEFAULT '0' COMMENT '状态 0表示初始化 1表示已付款',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

