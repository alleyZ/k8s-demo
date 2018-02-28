FROM data-cube.com:5000/hollycrm/jdk-oracle:8

MAINTAINER alleyz@126.com

ENV SONARQUBE_HOME=/opt/sonarqube \
    SONAR_VERSION=7.0 \
    SONARQUBE_JDBC_USERNAME=sonar \
    SONARQUBE_JDBC_PASSWORD=sonar \
    SONARQUBE_WEB_CONTEXT="/sonarqube" \
    SONARQUBE_JDBC_URL=""

EXPOSE 9000 9092

RUN addgroup -S sonarqube && adduser -S -G sonarqube sonarqube && mkdir /opt

COPY sonarqube-$SONAR_VERSION.zip /opt/sonarqube-$SONAR_VERSION.zip
COPY run.sh /run.sh

RUN set -x \
    && apk add --no-cache su-exec unzip \
    && cd /opt \
    && unzip sonarqube-$SONAR_VERSION.zip \
    && mv sonarqube-$SONAR_VERSION sonarqube \
    && chown -R sonarqube:sonarqube sonarqube \
    && rm sonarqube-$SONAR_VERSION.zip \
    && rm -rf $SONARQUBE_HOME/bin/* \
#    && rm -rf $SONARQUBE_HOME/bin/jsw-license \
#    && rm -rf $SONARQUBE_HOME/bin/linux-x86-32 \
#    && rm -rf $SONARQUBE_HOME/bin/macosx-universal-64 \
#    && rm -rf $SONARQUBE_HOME/bin/windows-x86-32 \
#    && rm -rf $SONARQUBE_HOME/bin/windows-x86-64 \
#    && rm -rf $SONARQUBE_HOME/lib/jdbc/h2 \
#    && rm -rf $SONARQUBE_HOME/lib/jdbc/mssql \
#    && rm -rf $SONARQUBE_HOME/lib/jdbc/postgresql \
    && chmod 777 /run.sh \
    && mv /run.sh $SONARQUBE_HOME/bin/

VOLUME "$SONARQUBE_HOME/data"
VOLUME "$SONARQUBE_HOME/extensions/plugins"
WORKDIR $SONARQUBE_HOME
ENTRYPOINT ["./bin/run.sh"]