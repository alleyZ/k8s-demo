#!/bin/bash


deploy_dir=$(cd `dirname $0`;cd ..; pwd)

#配置文件目录
conf_dir=${deploy_dir}/conf

server_name=`hostname`

#jar包目录
lib_dir=${deploy_dir}/lib
#将jar包用:拼接起来
lib_jars=`ls ${lib_dir} | grep .jar | awk '{print "'${lib_dir}'/"$0}' | tr "\n" ":"`

#公司服务环境配置
java_option="-server -Xmx2g -Xms2g -Xmn256m  -Xss256k -XX:+DisableExplicitGC -XX:+UseConcMarkSweepGC -XX:+CMSParallelRemarkEnabled -XX:LargePageSizeInBytes=128m -XX:+UseFastAccessorMethods -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=70 "


echo "use JAVA_OPTION=${java_option}"
echo -e "* Start the $server_name ...\c"

#运行java类
java ${java_option} -classpath ${conf_dir}:${lib_jars} com.alleyz.k8s.UserApplication
