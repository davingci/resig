/*评论表*/
CREATE TABLE comment (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  content mediumtext NOT NULL  COMMENT '内容',
  created_by varchar(255)  NOT NULL COMMENT '由谁创建',
  created_date datetime  NOT NULL COMMENT '创建日期',
  last_modified_by varchar(255)  NOT NULL COMMENT '最后由谁修改',
  last_modified_date datetime  NOT NULL COMMENT '最后修改日期',
  parent_id int(11) DEFAULT null COMMENT '父评论id',
  user_id int(11) NOT NULL COMMENT '发表评论的用户id',
  blog_id int(11) NOT NULL COMMENT '评论对应的博客id',
  PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COLLATE = utf8_bin;