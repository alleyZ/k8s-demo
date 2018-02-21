FROM alleyz.com:5000/alpine:3.6-b

MAINTAINER alleyz@126.com

RUN apk add --no-cache redis sed

COPY redis-master.conf /redis-master/redis.conf
COPY redis-slave.conf /redis-slave/redis.conf
COPY run.sh /run.sh

RUN chmod u+x /run.sh

CMD ["/run.sh"]

ENTRYPOINT ["bash", "-c"]
