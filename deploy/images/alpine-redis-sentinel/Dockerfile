FROM data-cube.com:5000/hollycrm/alpine-36:basic

MAINTAINER alleyz@126.com

RUN apk add --no-cache redis=3.2.11-r0 sed

COPY redis-master.conf /redis-master/redis.conf
COPY redis-slave.conf /redis-slave/redis.conf
COPY run.sh /run.sh

CMD [ "/run.sh" ]

ENTRYPOINT [ "bash", "-c" ]