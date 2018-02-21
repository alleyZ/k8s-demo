#!/bin/bash

R_HOST=${REDIS_HOST}
R_PORT=${REDIS_PORT}
R_PASSWORD=${REDIS_PWD}
R_DB_IDX=${REDIS_DB_IDX}

sed -i "s/%REDIS_HOST%/${R_HOST}/" /usr/local/tomcat/conf/context.xml
sed -i "s/%REDIS_PORT%/${R_PORT}/" /usr/local/tomcat/conf/context.xml
sed -i "s/%REDIS_PWD%/${R_PASSWORD}/" /usr/local/tomcat/conf/context.xml
sed -i "s/%REDIS_DB_IDX%/${R_DB_IDX}/" /usr/local/tomcat/conf/context.xml

/usr/local/tomcat/bin/catalina.sh run