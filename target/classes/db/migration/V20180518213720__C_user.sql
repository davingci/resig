/*用户表*/
CREATE TABLE user (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  username varchar(255)  NOT NULL COMMENT '用户名',
  password varchar(255)  NOT NULL COMMENT '密码',
  salt varchar(255)  NOT NULL COMMENT '加密盐值',
  profile_picture_url varchar(255)  DEFAULT '' COMMENT '图像url地址',
  created_by varchar(255)  NOT NULL COMMENT '由谁创建',
  created_date datetime  NOT NULL COMMENT '创建日期',
  last_modified_by varchar(255)  NOT NULL COMMENT'最后由谁修改',
  last_modified_date datetime  NOT NULL COMMENT '最后修改日期',
  PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COLLATE = utf8_bin;