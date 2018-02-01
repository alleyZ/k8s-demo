FROM alleyz.com:5000/tomcat-cn:8.0

MAINTAINER alleyz@126.com

COPY dubbo-admin-2.5.8.war /usr/local/tomcat/webapps/dubbo-admin-2.5.8.war

COPY  start.sh /start.sh

RUN mkdir -p /usr/local/tomcat/webapps/ROOT \
    && unzip -oq /usr/local/tomcat/webapps/dubbo-admin-2.5.8.war -d /usr/local/tomcat/webapps/ROOT \
    && rm -rf /usr/local/tomcat/webapps/dubbo-admin-2.5.8 \
    && rm -rf /usr/local/tomcat/webapps/dubbo-admin-2.5.8.war \
    && rm -rf /usr/local/tomcat/webapps/ROOT/WEB-INF/dubbo.properties \
    && chmod u+x /start.sh

COPY dubbo.properties /usr/local/tomcat/webapps/ROOT/WEB-INF/dubbo.properties

CMD ["/start.sh"]