#!/bin/bash

sed -i "s/%zk_host%/${ZK_HOST}/" /usr/local/dubbo-monitor-simple-2.5.8/conf/dubbo.properties

/usr/local/dubbo-monitor-simple-2.5.8/bin/start.sh