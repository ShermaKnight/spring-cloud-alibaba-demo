create database if not exists seata_storage default character set utf8mb4;

use seata_storage;
CREATE TABLE seata_storage.undo_log
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

CREATE TABLE `tbl_storage` (
    `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `product_id` bigint(11) NOT NULL COMMENT '产品ID',
    `price` decimal(11,2) NOT NULL COMMENT '单价',
    `total` int(11) DEFAULT NULL COMMENT '总库存',
    `used` int(11) DEFAULT NULL COMMENT '使用库存',
    `residue` int(11) DEFAULT NULL COMMENT '剩余库存',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

