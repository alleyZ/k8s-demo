#!/bin/bash

#/sbin/sysctl -w vm.max_map_count=262144

#su - elasticsearch
#sed -i "s/#cluster\.name\:\ my-application/cluster.name: ${CLUSTER_NAME}/" \
 #   /elasticsearch/config/elasticsearch.yml

#sed -i "s/#node\.name\:\ node-1/node.name: ${NODE_NAME}/" \
#    /elasticsearch/config/elasticsearch.yml

[ -z "${CLUSTER_NAME}" ] && CLUSTER_NAME="my_es_cluster"

[ -z "${NODE_NAME}" ] && NODE_NAME="es_`hostname`"

[ -z "${MIN_MASTER_NODE}" ] && MIN_MASTER_NODE=1

if [ -z "${ES_ROLE}" ]; then
    NODE_MASTER=true;
    NODE_DATA=true;
elif [ "${ES_ROLE}" = "master" ]; then
    NODE_MASTER=true
    NODE_DATA=false
elif [ "${ES_ROLE}" = "data" ]; then
    NODE_MASTER=false
    NODE_MASTER=true
else
    NODE_DATA=false
    NODE_MASTER=false
fi


echo -e "\ncluster.name: ${CLUSTER_NAME} \n" >>  /elasticsearch/elasticsearch/config/elasticsearch.yml


echo -e "node.name: ${NODE_NAME} \n" >>  /elasticsearch/elasticsearch/config/elasticsearch.yml


echo -e "path.data: /elasticsearch/data \n" >>  /elasticsearch/elasticsearch/config/elasticsearch.yml


echo -e "path.logs: /elasticsearch/logs \n" >>  /elasticsearch/elasticsearch/config/elasticsearch.yml


echo -e "network.host: 0.0.0.0 \n" >>  /elasticsearch/elasticsearch/config/elasticsearch.yml


#echo -e "discovery.zen.ping.unicast.hosts: ${MASTER_HOST} \n" >>  /elasticsearch/elasticsearch/config/elasticsearch.yml
#echo -e "discovery.zen.ping.multicast.enabled: true\n" >>  /elasticsearch/elasticsearch/config/elasticsearch.yml
echo -e "discovery.zen.minimum_master_nodes: ${MIN_MASTER_NODE} \n" >>  /elasticsearch/elasticsearch/config/elasticsearch.yml

echo -e "discovery.zen.ping.unicast.hosts: ${DISCOVERY_SERVICE} \n" >>  /elasticsearch/elasticsearch/config/elasticsearch.yml

echo -e "discovery.zen.ping_timeout: 150s \n" >>  /elasticsearch/elasticsearch/config/elasticsearch.yml


echo -e "node.master: ${NODE_MASTER} \n" >> /elasticsearch/elasticsearch/config/elasticsearch.yml


echo -e "node.data: ${NODE_DATA} \n" >> /elasticsearch/elasticsearch/config/elasticsearch.yml


echo -e "thread_pool.bulk.queue_size: 1000 \n" >> /elasticsearch/elasticsearch/config/elasticsearch.yml

/elasticsearch/elasticsearch/bin/elasticsearch