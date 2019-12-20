## 码上开始

##质料

##工具
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate
mysql -u root -p
set global time_zone = '+8:00';
flush privileges;
##项目启动虚拟机配置
-Dspring.profiles.active=production          
java -jar -Dspring.profiles.active=production target/demo-0.0.1-SNAPSHOT.jar
##更新项目
ps -aux | grep java（查看进程）
git pull(git拉代码)
mvn package
