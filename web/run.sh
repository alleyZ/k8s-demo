#!/bin/bash


ZK_HOSTS=${ZK_HOST}


sed -i "s/%zk_host%/$ZK_HOSTS}/" /usr/local/tomcat/webapps/web/WEB-INF/classes/configure.properties

/start.sh