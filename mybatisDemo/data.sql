
CREATE DATABASE ssmdemo;   --创建数据库

use ssmdemo;               --进入数据库

-- 建表
CREATE TABLE tb_user (
     id char(32) NOT NULL,
     user_name varchar(32) DEFAULT NULL,
     password varchar(32) DEFAULT NULL,
     name varchar(32) DEFAULT NULL,
     age int(10) DEFAULT NULL,
     sex int(2) DEFAULT NULL,
     birthday date DEFAULT NULL,
     created datetime DEFAULT NULL,
     updated datetime DEFAULT NULL,
     PRIMARY KEY (id)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 插入数据
insert into tb_user(id, user_name, password, name, age, sex, birthday, created, updated) values(1, 'zmz', '123456', '张麻子', 25, 1, '1990-09-02', sysdate(), sysdate());
insert into tb_user(id, user_name, password, name, age, sex, birthday, created, updated) values(2, 'wmz', '654321', '王麻子', 22, 0, '1995-03-05', sysdate(), sysdate());
insert into tb_user(id, user_name, password, name, age, sex, birthday, created, updated) values(3, 'zwj', '135760', '张无忌', 25, 1, '1795-04-09', sysdate(), sysdate());
insert into tb_user(id, user_name, password, name, age, sex, birthday, created, updated) values(4, 'lhc', '233464', '令狐冲', 28, 1, '1956-04-11', sysdate(), sysdate());
insert into tb_user(id, user_name, password, name, age, sex, birthday, created, updated) values(5, 'wyy', '654321', '王语嫣', 22, 0, '1995-03-05', sysdate(), sysdate());



-- 建表
 CREATE TABLE `tb_order` (
            `id` int(11) PRIMARY KEY AUTO_INCREMENT,
             `user_id` int(11) DEFAULT NULL,
             `order_number` varchar(255) DEFAULT NULL,
             `created` datetime DEFAULT NULL,
             `updated` datetime DEFAULT NULL
             ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 插入数据
insert into tb_order(id,user_id,order_number,created,updated) values(1,401,201809010001,sysdate(),sysdate());
INSERT INTO tb_order VALUES ('2', '402', '201807010001', '2018-07-01 19:38:35', '2018-07-01 19:38:40');



-- 下面测试一对一，一对多，多对一
-- 教师表：
CREATE TABLE `tb_teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `t_no` varchar(20) DEFAULT NULL,
  `t_name` varchar(20) DEFAULT NULL,
  `position_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

insert  into `tb_teacher`(`id`,`t_no`,`t_name`,`position_id`) values
(1,'163314001','张文远',1),
(2,'163314002','赵传智',1),
(3,'163314003','风清扬',2),
(4,'163314004','王汇智',2),
(5,'163314005','汪思远',3);


-- 学生表：
CREATE TABLE `tb_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `t_stu_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

insert  into `tb_student`(`id`,`t_stu_name`) values
(1,'赵依'),
(2,'钱迩'),
(3,'张山'),
(4,'李石'),
(5,'王武'),
(6,'马柳');


-- 职位表：
CREATE TABLE `tb_position` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `t_pos_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

insert  into `tb_position`(`id`,`t_pos_name`) values
(1,'教授'),
(2,'副教授'),
(3,'讲师');


-- 教师学生关系表：
CREATE TABLE `tb_stu_teach` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `t_stu_id` int(11) DEFAULT NULL,
  `t_teach_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

insert  into `tb_stu_teach`(`id`,`t_stu_id`,`t_teach_id`) values
(1,1,1),
(2,1,2),
(3,1,3),
(4,2,2),
(5,2,3),
(6,2,4),
(7,3,3),
(8,3,4),
(9,3,5),
(10,4,4),
(11,4,5),
(12,4,1);
