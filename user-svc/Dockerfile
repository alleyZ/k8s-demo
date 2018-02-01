FROM alleyz.com:5000/alpine-jre8:oracle

MAINTAINER alleyz@126.com


COPY target/user-svc-app.tar.gz /usr/local/user-svc-app.tar.gz

COPY run.sh /usr/local/run.sh


RUN  tar xf /usr/local/user-svc-app.tar.gz -C /usr/local/ \
     && rm -f /usr/local/user-svc-app.tar.gz  \
     && chmod u+x /usr/local/run.sh

CMD ["/usr/local/run.sh"]