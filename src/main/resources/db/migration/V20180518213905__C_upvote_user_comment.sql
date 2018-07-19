/*评论点赞表*/
CREATE TABLE upvote_user_comment (
  user_id int(11) NOT NULL  COMMENT '联合主键',
  comment_id int(11) NOT NULL COMMENT '联合主键',
  PRIMARY KEY (user_id,comment_id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COLLATE = utf8_bin;