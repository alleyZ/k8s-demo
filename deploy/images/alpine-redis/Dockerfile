FROM data-cube.com:5000/hollycrm/alpine-36:basic

MAINTAINER alleyz@126.com

RUN apk add --no-cache redis=3.2.11 sed

COPY redis.conf /redis.conf
COPY run.sh /run.sh

RUN chmod u+x /run.sh

CMD ["/run.sh"]

ENTRYPOINT ["bash", "-c"]