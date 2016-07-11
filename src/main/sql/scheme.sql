create database seckill;
use seckill;
DROP TABLE IF EXISTS `secgoods`;
create table secgoods(
secgoodid bigint not null AUTO_INCREMENT,
name      varchar(120),
number   int,
starttime datetime,
endtime datetime,
createtime datetime not null default current_timestamp,
primary key(secgoodid),
key idx_starttime(starttime),
key idx_endtime(endtime)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
##--初始化数据
insert into
        secgoods(name,number,starttime,endtime)
    values
        ('1000元秒杀iphone6',100,'2016-07-06 00:00:00','2016-07-07 00:00:00'),
         ('500元秒杀ipd2',200,'2016-07-06 00:00:00','2016-07-07 00:00:00'),
          ('300元秒杀小米4',300,'2016-07-06 00:00:00','2016-07-07 00:00:00'),
           ('200元秒杀红米2',400,'2016-07-06 00:00:00','2016-07-07 00:00:00');
##---秒杀成功明细表
##---用户表
DROP TABLE IF EXISTS `success_killed`;
create table success_killed(
secgoodid bigint not null comment '秒杀商品id',
userphone varchar(30) not null,
state tinyint not null default -1 comment '-1无效 0成功 1 已付款 2已发货',
createtime datetime not null,
primary key (secgoodid,userphone),
key idx_createtime(createtime)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
