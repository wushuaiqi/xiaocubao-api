create table `tb_user` (
    `id` bigint not null primary key comment '用户id',
    `username` varchar(64) not null comment '用户名',
    `nickname` varchar(64) null comment '用户昵称',
    `password` varchar(64) not null comment '加密后的密码',
    `email` varchar(100) not null comment '用户邮箱',
    `as_username` varchar(64) null comment '关联的账号',
    `locked` tinyint(1) default 0 not null comment '是否锁定，1-是，0-否',
    `enabled` tinyint(1) default 1 not null comment '是否可用，1-是，0否',
    `version` int not null default 1 comment '乐观锁',
    `deleted` int not null default 0 comment '逻辑删除',
    `created_time` datetime(6) not null comment '创建时间',
    `updated_time` datetime(6) not null comment '修改时间',
    constraint uk_user_name unique (username)
) comment '用户表'