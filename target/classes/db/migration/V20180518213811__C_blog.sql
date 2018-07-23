/*博客表*/
CREATE TABLE blog (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  title varchar(255) NOT NULL COMMENT '标题',
  html mediumtext NOT NULL  COMMENT 'html原文',
  text mediumtext NOT NULL  COMMENT '文字内容',
  abstract_content varchar(255) NOT NULL DEFAULT '' COMMENT '摘要',
  thumbnail_url varchar(255) DEFAULT  '' COMMENT '缩略图url',
  created_by varchar(255)  NOT NULL COMMENT '由谁创建',
  created_date datetime  NOT NULL COMMENT '创建日期',
  last_modified_by varchar(255)  NOT NULL COMMENT '最后由谁修改',
  last_modified_date datetime  NOT NULL COMMENT '最后修改日期',
  user_id int(11) NOT NULL,
  PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COLLATE = utf8_bin;