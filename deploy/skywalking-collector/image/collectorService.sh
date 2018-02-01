#!/usr/bin/env sh

PRG="$0"
PRGDIR=`dirname "$PRG"`
[ -z "$COLLECTOR_HOME" ] && COLLECTOR_HOME=`cd "$PRGDIR/.." >/dev/null; pwd`

COLLECT_LOG_DIR="${COLLECTOR_HOME}/logs"
JAVA_OPTS=" -Xms256M -Xmx512M"

if [ ! -d "${COLLECTOR_HOME}/logs" ]; then
    mkdir -p "${COLLECT_LOG_DIR}"
fi

CLASSPATH="$COLLECTOR_HOME/config:$CLASSPATH"
for i in "$COLLECTOR_HOME"/libs/*.jar
do
    CLASSPATH="$i:$CLASSPATH"
done

COLLECTOR_OPTIONS=" -Dcollector.logDir=${COLLECT_LOG_DIR}"

java ${JAVA_OPTS} ${COLLECTOR_OPTIONS} -classpath $CLASSPATH org.skywalking.apm.collector.boot.CollectorBootStartUp


