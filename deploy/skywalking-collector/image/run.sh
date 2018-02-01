#!/bin/bash

sed -i "s/%zk_host%/${ZK_HOST}/" /usr/local/skywalking-collector/config/application.yml
sed -i "s/%es_cluster_name%/${ES_CLUSTER_NAME}/" /usr/local/skywalking-collector/config/application.yml
sed -i "s/%es_cluster_node%/${ES_CLUSTER_NODE}/" /usr/local/skywalking-collector/config/application.yml

/usr/local/skywalking-collector/bin/collectorService.sh start