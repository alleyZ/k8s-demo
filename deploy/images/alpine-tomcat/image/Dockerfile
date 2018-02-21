FROM alleyz.com:5000/alpine-jre8:oracle

MAINTAINER alleyz@126.com

COPY apache-tomcat-8.0.47.tar.gz /apache-tomcat-8.0.47.tar.gz

RUN mkdir -p /usr/local/tomcat/ \
    && tar xf /apache-tomcat-8.0.47.tar.gz -C /usr/local/tomcat/ \
    && rm -rf /apache-tomcat-8.0.47.tar.gz \
    && chmod -R u+x /usr/local/tomcat/bin/

EXPOSE 8080
