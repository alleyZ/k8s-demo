#!/bin/bash

sed -i "s/%zk_host%/${ZK_HOST}/" /usr/local/user-svc/conf/application.yaml
sed -i "s/%jdbc_url%/${JDBC_URL}/" /usr/local/user-svc/conf/application.yaml
sed -i "s/%db_name%/${DB_NAME}/" /usr/local/user-svc/conf/application.yaml
sed -i "s/%db_password%/${DB_PASSWORD}/" /usr/local/user-svc/conf/application.yaml

/usr/local/user-svc/bin/start.sh