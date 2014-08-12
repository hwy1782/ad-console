##### grails 学习

1. 本地必须创建一个数据库建表语句

```
use weigou_ad;
CREATE TABLE `user` (
  `userid` bigint(20) unsigned NOT NULL COMMENT '用户id',
  `name` varchar(128) NOT NULL COMMENT '用户名',
  `state` varchar(20) NOT NULL COMMENT '用户状态：AUDITING 审核中， NORMAL 正常， NO_RESOURCE 用户账面为0 ，AUDIT_FAILED  审核未通过',
  `accountstate` varchar(20) NOT NULL COMMENT '账户状态：NORMAL 正常 NO_RESOURCE  余额不足',
  `signstate` int(10) unsigned NOT NULL COMMENT '暂无用处',
  `updatetime` datetime NOT NULL COMMENT '更新时间',
  `createtime` datetime NOT NULL COMMENT '创建时间',
  `deleted` tinyint(3) unsigned NOT NULL COMMENT '逻辑删除',
  `id` bigint(20) NOT NULL,
  `version` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='推广用户';
```



