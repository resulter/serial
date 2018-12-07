# serial
流水号生成器高级
数据源MySQL
```mysql
CREATE TABLE `sequence_value` (
  `name` varchar(100) NOT NULL COMMENT '表名称',
  `id` bigint(20) NOT NULL DEFAULT '0' COMMENT '自增加id',
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```
测试地址：http://localhost:9090/swagger-ui.html#/code-controller/testUsingGET

功能	平台区分	业务编码	发生系统	发生服务	终端类型	时间	序号

位数	1	5	1	2	2	6	8

取值范围	1	随意	01-08	随意	1-5	自动计算	自动计算
