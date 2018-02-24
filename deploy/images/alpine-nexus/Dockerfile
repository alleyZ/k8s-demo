FROM data-cube.com:5000/hollycrm/jdk-oracle:8

MAINTAINER alleyz@126.com

LABEL vendor=Sonatype \
  com.sonatype.license="Apache License, Version 2.0" \
  com.sonatype.name="Nexus Repository Manager base image"

ARG NEXUS_VERSION=3.8.0-02


# configure java runtime
ENV JAVA_HOME=/usr/lib/jvm/default-jvm \
  JAVA_VERSION_MAJOR=8 \
  JAVA_VERSION_MINOR=161 \
  JAVA_VERSION_BUILD=12

# configure nexus runtime
ENV SONATYPE_DIR=/opt/sonatype
ENV NEXUS_HOME=${SONATYPE_DIR}/nexus \
  NEXUS_DATA=/nexus-data \
  NEXUS_CONTEXT='nexus' \
  SONATYPE_WORK=${SONATYPE_DIR}/sonatype-work

COPY nexus-${NEXUS_VERSION}-unix.tar.gz /nexus-${NEXUS_VERSION}-unix.tar.gz

# install nexus
RUN mkdir -p ${NEXUS_HOME} \
  && tar xf /nexus-${NEXUS_VERSION}-unix.tar.gz -C ${NEXUS_HOME} --strip-components 1 \
  && rm -rf /nexus-${NEXUS_VERSION}-unix.tar.gz \
  && chown -R root:root ${NEXUS_HOME}

# configure nexus
RUN sed \
    -e '/^nexus-context/ s:$:${NEXUS_CONTEXT}:' \
    -i ${NEXUS_HOME}/etc/nexus-default.properties

RUN adduser -S -u 200 -D -H -h "${NEXUS_DATA}" -s /bin/false nexus nexus \
  && mkdir -p ${NEXUS_DATA}/etc ${NEXUS_DATA}/log ${NEXUS_DATA}/tmp ${SONATYPE_WORK} \
  && ln -s ${NEXUS_DATA} ${SONATYPE_WORK}/nexus3 \
  && chown -R nexus ${NEXUS_DATA}

VOLUME ${NEXUS_DATA}

EXPOSE 8081
USER nexus
WORKDIR ${NEXUS_HOME}

ENV JAVA_MAX_MEM=1200m \
  JAVA_MIN_MEM=1200m \
  EXTRA_JAVA_OPTS=""

CMD ["bin/nexus", "run"]