create table `tb_user_role` (
    `user_id` bigint not null comment '用户给ID',
    `role_id` bigint not null comment '角色ID',
    constraint c_user_id foreign key (user_id) references tb_user (id),
    constraint c_role_id foreign key (role_id) references tb_role (id)
) comment '用户角色表'
;
