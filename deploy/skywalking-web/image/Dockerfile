FROM alleyz.com:5000/alpine-jre8:oracle

MAINTAINER alleyz@126.com

COPY skywalking-web.tar.gz /usr/local/skywalking-web.tar.gz
COPY run.sh /run.sh

RUN tar xf /usr/local/skywalking-web.tar.gz -C /usr/local/ \
    && rm -rf /usr/local/skywalking-web.tar.gz \
    && chmod u+x /run.sh
COPY web-service.sh /usr/local/skywalking-web/bin/web-service.sh

RUN chmod u+x  /usr/local/skywalking-web/bin/web-service.sh

EXPOSE 8080

CMD ["/run.sh"]

