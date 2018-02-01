#!/usr/bin/env bash


PRG="$0"
PRGDIR=`dirname "$PRG"`
[ -z "$WEB_HOME" ] && WEB_HOME=`cd "$PRGDIR/.." >/dev/null; pwd`

WEB_LOGS_DIR="${WEB_HOME}/logs"
JAVA_OPTS=" -Xms256M -Xmx512M"

if [ ! -d "${WEB_HOME}/logs" ]; then
    mkdir -p "${WEB_LOGS_DIR}"
fi


CLASSPATH="$WEB_HOME/config:$CLASSPATH"
for i in "$WEB_HOME"/libs/*.jar
do
    CLASSPATH="$i:$CLASSPATH"
done

WEBUI_OPTIONS=" -Dwebui.logDir=${WEB_LOGS_DIR}"

echo "Starting web service...."
java ${JAVA_OPTS} ${WEBUI_OPTIONS} -classpath $CLASSPATH org.skywalking.apm.ui.ApplicationStartUp