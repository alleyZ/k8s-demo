FROM alleyz.com:5000/alpine-jre8:oracle

MAINTAINER alleyz@126.com

COPY dubbo-monitor-simple-2.5.8-assembly.tar.gz /usr/local/dubbo-monitor-simple-2.5.8-assembly.tar.gz
COPY run.sh /run.sh

RUN tar xf /usr/local/dubbo-monitor-simple-2.5.8-assembly.tar.gz -C /usr/local/ \
    && rm -rf /usr/local/dubbo-monitor-simple-2.5.8-assembly.tar.gz \
    && rm -rf /usr/local/dubbo-monitor-simple-2.5.8/conf/dubbo.properties \
    && rm -rf /usr/local/dubbo-monitor-simple-2.5.8/bin/start.sh \
    && chmod u+x /run.sh

COPY dubbo.properties /usr/local/dubbo-monitor-simple-2.5.8/conf/dubbo.properties
COPY start.sh /usr/local/dubbo-monitor-simple-2.5.8/bin/start.sh

RUN chmod u+x /usr/local/dubbo-monitor-simple-2.5.8/bin/start.sh

CMD ["/run.sh"]