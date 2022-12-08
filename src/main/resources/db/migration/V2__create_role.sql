create table `tb_role` (
    `id` bigint not null primary key comment '角色ID',
    `name` varchar(128) null comment '角色名称',
    `title` varchar(128) null comment '角色标识',
    `created_time` datetime(6) not null comment '创建时间',
    `updated_time` datetime(6) not null comment '更新时间'
) comment '角色表'
;
