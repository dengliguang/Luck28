# 数据库 
#创建数据库
DROP DATABASE IF EXISTS luck28_db;
CREATE DATABASE luck28_db;

#使用数据库 
use luck28_db;

#创建账户表 
CREATE TABLE acount_tb(
acount_id int(11) NOT NULL AUTO_INCREMENT COMMENT '账户id',
phone varchar(255) COMMENT '电话',
email varchar(255) COMMENT 'email',
password varchar(255) COMMENT '密码',
create_date datetime COMMENT '创建时间',
login_date datetime COMMENT '登陆时间',
PRIMARY KEY (acount_id)
)ENGINE = InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='账户表';

#创建北京表 
CREATE TABLE beijing_tb(
beijing_id int(11) NOT NULL COMMENT '北京id',
one int(11) DEFAULt 0 COMMENT '第一个数字',
two int(11) DEFAULt 0 COMMENT '第二个数字',
three int(11) DEFAULt 0 COMMENT '第三个数字',
code int(11) DEFAULt 0 COMMENT '总和',
time datetime COMMENT '创建时间',
PRIMARY KEY (beijing_id)
)ENGINE = InnoDB DEFAULT CHARSET=utf8 COMMENT='北京表';
#创建加拿大表 
CREATE TABLE jianada_tb(
jianada_id int(11) NOT NULL COMMENT '加拿大id',
one int(11) DEFAULt 0 COMMENT '第一个数字',
two int(11) DEFAULt 0 COMMENT '第二个数字',
three int(11) DEFAULt 0 COMMENT '第三个数字',
code int(11) DEFAULt 0 COMMENT '总和',
time datetime COMMENT '创建时间',
PRIMARY KEY (jianada_id)
)ENGINE = InnoDB DEFAULT CHARSET=utf8 COMMENT='加拿大表';



#设置初始管理员密码MD5加密123456
INSERT IGNORE INTO acount_tb (phone,email,password,create_date,login_date) 
VALUES ("15111336587","278076304@qq.com","11874bb6149dd45428da628c9766b252",now(),now()); 
