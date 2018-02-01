FROM alleyz.com:5000/alpine-jre8:oracle

MAINTAINER alleyz@126.com

ENV ZK_DATA_DIR=/var/lib/zookeeper/data \
    ZK_DATA_LOG_DIR=/var/lib/zookeeper/log \
    ZK_LOG_DIR=/var/log/zookeeper

ARG ZK_DIST=zookeeper-3.4.11


COPY ${ZK_DIST}.tar.gz /opt/${ZK_DIST}.tar.gz

RUN mkdir -p /opt/zookeeper && \
    tar -xf /opt/${ZK_DIST}.tar.gz -C /opt/zookeeper && \
    rm -rf /${ZK_DIST}.tar.gz

COPY zkGenConfig.sh zkOk.sh zkMetrics.sh /opt/zookeeper/bin/

RUN set -x \
    && chmod -R 777 /opt/zookeeper/bin/ \
    && mkdir -p $ZK_DATA_DIR $ZK_DATA_LOG_DIR $ZK_LOG_DIR /usr/share/zookeeper /tmp/zookeeper /usr/etc/ \
    && ln -s /opt/zookeeper/conf/ /usr/etc/zookeeper \
    && ln -s /opt/zookeeper/bin/* /usr/bin \
    && ln -s /opt/zookeeper/$ZK_DIST.jar /usr/share/zookeeper/ \
    && ln -s /opt/zookeeper/lib/* /usr/share/zookeeper

EXPOSE 2181