/*user agent table*/
CREATE TABLE user_agent (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  username varchar(255)  NOT NULL COMMENT '用户名',
  login_ip varchar(255)  NOT NULL COMMENT '登录ip',
  login_location varchar(255)  NOT NULL COMMENT '登录地理位置',
  client_os varchar(255)  NOT NULL COMMENT '登录操作系统',
  client_os_version varchar(255) NOT NULL COMMENT '登录操作系统版本',
  client_cpu varchar(255) NOT NULL COMMENT '登录系统cpu',
  PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COLLATE = utf8_bin;
