#!/bin/bash

function launch_master() {
    echo -e "\nrequirepass ${PASSWORD}\n" >> /redis.conf
    redis-server /redis.conf --protected-mode no
}

function launch_slave() {
    echo -e "\nrequirepass ${PASSWORD}\n" >> /redis.conf
    echo -e "slaveof ${MASTER_IP} 6379\n" >> /redis.conf
    echo -e "masterauth ${PASSWORD}\n" >> /redis.conf

    redis-server /redis.conf --protected-mode no
}

if [[ "${MASTER}" == "true" ]]; then
  launch_master
  exit 0
fi
launch_slave