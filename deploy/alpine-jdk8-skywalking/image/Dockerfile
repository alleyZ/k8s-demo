FROM alleyz.com:5000/alpine-jre8:oracle

MAINTAINER alleyz@126.com

COPY skywalking-agent.tar.gz /usr/local/skywalking-agent.tar.gz

COPY run.sh /run.sh

RUN tar xf /usr/local/skywalking-agent.tar.gz -C /usr/local/skywalking-agent \
    && rm -rf /usr/local/skywalking-agent.tar.gz \
    && chmod u+x /run.sh

CMD ["/run.sh"]