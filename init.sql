CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL COMMENT '主键',
  `username`  varchar(32) NOT NULL DEFAULT '',
  `password` varchar(32) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL COMMENT '主键',
  `name`  varchar(32) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sys_role_user` (
  `id` int(11) NOT NULL COMMENT '主键',
  `sys_user_id` int(11) NOT NULL,
  `sys_role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL COMMENT '主键',
  `name` varchar(32) NOT NULL DEFAULT '',
  `description` varchar(500) NOT NULL DEFAULT '',
  `url` varchar(255) NOT NULL DEFAULT '',
  `pid` int(11),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sys_permission_role` (
  `id` int(11) NOT NULL COMMENT '主键',
  `sys_role_id` int(11) NOT NULL,
  `sys_permission_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


insert into SYS_USER (id,username, password) values (1,'admin', 'admin');
insert into SYS_USER (id,username, password) values (2,'abel', 'abel');

insert into SYS_ROLE(id,name) values(1,'ROLE_ADMIN');
insert into SYS_ROLE(id,name) values(2,'ROLE_USER');

insert into SYS_ROLE_USER(SYS_USER_ID,ROLES_ID) values(1,1);
insert into SYS_ROLE_USER(SYS_USER_ID,ROLES_ID) values(2,2);

INSERT INTO `Sys_permission` VALUES ('1', 'ROLE_HOME', 'home', '/', null), ('2', 'ROLE_ADMIN', 'ABel', '/admin', null);
INSERT INTO `Sys_permission_role` VALUES ('1', '1', '1'), ('2', '1', '2'), ('3', '2', '1');