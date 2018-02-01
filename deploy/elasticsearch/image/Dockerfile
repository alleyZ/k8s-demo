FROM alleyz.com:5000/alpine-jre8:oracle

MAINTAINER alleyz@126.com


RUN adduser -h /elasticsearch elasticsearch -D \
    && swapoff -a

COPY run.sh /elasticsearch/run.sh

RUN chmod u+x /elasticsearch/run.sh

USER elasticsearch

COPY elasticsearch-5.6.5.tar.gz /elasticsearch/elasticsearch-5.6.5.tar.gz

RUN tar xf /elasticsearch/elasticsearch-5.6.5.tar.gz -C /elasticsearch \
    && mv /elasticsearch/elasticsearch-5.6.5 /elasticsearch/elasticsearch \
    && rm -rf /elasticsearch/elasticsearch-5.6.5.tar.gz \
    && mkdir -p /elasticsearch/data \
    && mkdir -p /elasticsearch/logs


EXPOSE 9300 9200

CMD ["/elasticsearch/run.sh"]