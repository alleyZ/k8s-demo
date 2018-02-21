FROM alpine:3.6

MAINTAINER alleyz@126.com

#  set apk mirror = ustc
#  set timezone = Asia/Shanghai

RUN echo "http://mirrors.ustc.edu.cn/alpine/v3.6/main" > /etc/apk/repositories \
     && echo "http://mirrors.ustc.edu.cn/alpine/v3.6/community" >> /etc/apk/repositories \
     && apk update && apk add --no-cache bash curl tzdata \
     && cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
     && rm -rf /var/cache/apk/*

CMD ["/bin/bash"]
