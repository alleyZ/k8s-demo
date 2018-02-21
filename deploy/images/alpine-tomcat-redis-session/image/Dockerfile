FROM alleyz.com:5000/tomcat-cn:8.0

MAINTAINER alleyz@126.com

ADD commons-pool2-2.2.jar jedis-2.9.0.jar tomcat-session-manager.jar /usr/local/tomcat/lib/

ADD context.xml /usr/local/tomcat/conf/context.xml

ADD start.sh /start.sh

RUN chmod u+x /start.sh

EXPOSE 8080

CMD ["/start.sh"]