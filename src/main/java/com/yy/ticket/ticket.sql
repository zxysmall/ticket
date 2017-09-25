CREATE TABLE `busi_ticket_order` (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `single_num` int(12) DEFAULT NULL COMMENT '单票数',
  `single_num_privilege` int(12) DEFAULT NULL COMMENT '单优票数',
  `double_num` int(12) DEFAULT NULL COMMENT '双票数',
  `double_num_privilege` int(12) DEFAULT NULL COMMENT '双优票数',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '状态（0：已出；1：未出）',
  `ticket_num` varchar(32) DEFAULT NULL COMMENT '出票号',
  `ticket_person` varchar(32) NOT NULL COMMENT '取票人姓名',
  `ticket_person_identity` varchar(32) NOT NULL COMMENT '取票人身份证',
  `ticket_person_phone` varchar(16) DEFAULT NULL COMMENT '取票人电话',
  `create_userid` int(12) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_userid` int(12) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2025 DEFAULT CHARSET=utf8 COMMENT='订单表';

CREATE TABLE `user_info_detail` (
  `id` bigint(12) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(12) DEFAULT NULL COMMENT '用户ID',
  `gender` varchar(5) DEFAULT NULL COMMENT '性别（male:男，woman:女）',
  `email` varchar(32) DEFAULT NULL COMMENT '电子邮箱',
  `contact_number` varchar(12) DEFAULT NULL COMMENT '联系电话',
  `mobile_phone` bigint(12) DEFAULT NULL COMMENT '手机',
  `qq` bigint(16) DEFAULT NULL COMMENT 'QQ号',
  `create_userid` bigint(12) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_userid` bigint(12) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9999 DEFAULT CHARSET=utf8  COMMENT='用户详情表';