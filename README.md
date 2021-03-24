# umi

#### 介绍
一个可以进行资源分享的bbs论坛，使用ssml框架+mysql开发。jdk1.8  tomcat 7.0.49
 **论坛功能** ：
1.登录
![输入图片说明](https://images.gitee.com/uploads/images/2021/0324/121052_a0545c2e_8843053.png "屏幕截图.png")
2.注册  手机短信注册--需要先注册阿里云短息服务
![输入图片说明](https://images.gitee.com/uploads/images/2021/0324/121132_ca4328bc_8843053.png "屏幕截图.png")
3.资源搜索
![输入图片说明](https://images.gitee.com/uploads/images/2021/0324/120932_cc1445e0_8843053.jpeg "主页.jpg")
![输入图片说明](https://images.gitee.com/uploads/images/2021/0324/120952_f5e701e0_8843053.jpeg "搜索页面.jpg")
4.求资源
![输入图片说明](https://images.gitee.com/uploads/images/2021/0324/121310_d9ea0a61_8843053.png "屏幕截图.png")
5.用户中心
![输入图片说明](https://images.gitee.com/uploads/images/2021/0324/121630_6a8d4796_8843053.png "屏幕截图.png")

登录入口：  /umi

#### 安装教程

1.  创建service数据库，运行service.sql文件(放在了config文件夹下)
2.  修改db.properties文件
3.  注册阿里云短信服务，修改config.properties文件

### 数据库说明

3.1.1 数据存储设计
用户表（user）：
列名	类型及精度
userId	bigint(20)
username	varchar(50)
password	varchar(20)
phoneNum	varchar(11)
userIcon	varchar(100)
userSex	char(4)
regDate	timestamp
mail	varchar(50)
exp	big(int)
intro	varchar(300)
freePoint	int(11)
payPoint	int(11)

帖子表（post）:
列名	类型及精度
postId	bigint(20)
userId	bigint(20)
displayInfo	text
hiddenInfo	text
postName	text
likeNum	bigint(20)
hateNum	bigint(20)
browseNum	bigint(20)
time	timestamp
checkTime	timestamp
adminId	bigint(20)
sortId	int(11)
point	int(11)
source	bigint(20)




评论表（comment）:
列名	类型及精度
commId	bigint(20)
postID	bigint(20)
comm	text
fkCommId	bigint(20)
userId	bigint(20)
sendTime	timestamp
reportNum	bigint(20)
likeNum	bigint(20)
hateNum	bigint(20)

用户求资源表（request）:
列名	类型及精度
requestId	bigint(20)
usersId	bigint(20)
title	text
descInfo	text
time	timestamp
accpet	bigint(20)
finish	int(11)

