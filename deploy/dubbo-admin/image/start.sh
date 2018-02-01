#!/bin/bash


sed -i "s/%zk_host%/${ZK_HOST}/" /usr/local/tomcat/webapps/ROOT/WEB-INF/dubbo.properties
sed -i "s/%root_pwd%/${ROOT_PWD}/" /usr/local/tomcat/webapps/ROOT/WEB-INF/dubbo.properties
sed -i "s/%guest_pwd%/${GUEST_PWD}/" /usr/local/tomcat/webapps/ROOT/WEB-INF/dubbo.properties

/usr/local/tomcat/bin/catalina.sh run
