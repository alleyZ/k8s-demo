#!/usr/bin/env bash

sed -i "s/127\.0\.0\.1\:10800/${COLLECTOR_SVC}/" /usr/local/skywalking-web/config/collector_config.properties

sed -i "s/debug/info/" /usr/local/skywalking-web/config/log4j2.xml

 /usr/local/skywalking-web/bin/web-service.sh start