FROM alleyz.com:5000/alpine-jre8:oracle

MAINTAINER alleyz@126.com

COPY skywalking-collector.tar.gz /usr/local/skywalking-collector.tar.gz

COPY run.sh /run.sh

RUN tar xf /usr/local/skywalking-collector.tar.gz -C /usr/local \
    && rm -rf /usr/local/skywalking-collector.tar.gz \
    && chmod u+x /run.sh

COPY application.yml /usr/local/skywalking-collector/config/application.yml
COPY collectorService.sh /usr/local/skywalking-collector/bin/collectorService.sh

RUN chmod u+x /usr/local/skywalking-collector/bin/collectorService.sh

EXPOSE 10800
EXPOSE 11800
EXPOSE 12800

CMD ["/run.sh"]