
* comando docker para criar o banco utilizado

docker run --name mysql-db -e MYSQL_ROOT_PASSWORD=123456 -p 3306:3306 -d mysq