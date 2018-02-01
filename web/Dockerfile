FROM alleyz.com:5000/tomcat-alpine-redis:8.0

MAINTAINER alleyz@126.com

COPY target/web.war /usr/local/tomcat/webapps/
COPY run.sh /run.sh

RUN mkdir -p /usr/local/tomcat/webapps/web \
    && unzip -oq /usr/local/tomcat/webapps/web.war -d /usr/local/tomcat/webapps/web \
    && rm -rf /usr/local/tomcat/webapps/web.war \
    && chmod u+x /run.sh

CMD ["/run.sh"]