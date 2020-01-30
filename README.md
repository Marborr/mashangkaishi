## 码上开始

##质料

##工具
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate
mysql -u root -p
set global time_zone = '+8:00';
flush privileges;
##项目启动虚拟机配置
-Dspring.profiles.active=production          
（启动项目）java -jar -Dspring.profiles.active=production target/demo-0.0.1-SNAPSHOT.jar
##更新项目
ps -aux | grep java（查看进程）
git pull(git拉代码)
mvn package
（启动项目）java -jar -Dspring.profiles.active=production target/demo-0.0.1-SNAPSHOT.jar
##mysql密码更改（ip地址变更时需重新更改密码）
进入mysql库进行修改：
update user set password="*6BB4837EB74329105EE4568DDA7DC67ED2CA2AD9" where host="%";
