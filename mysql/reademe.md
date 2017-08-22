1. create mysql db: test
2. config mysql in test/JpaConfigureation set url, username, password
3. run/debug MysqlTest with JUnit

##
MySql DB add a user:

grant all privileges on *.* to 'root'@'localhost'  identified by '12345678' with grant option;
