#!/bin/sh
export MAVEN_OPTS="-Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=4000,server=y,suspend=n -Xms512m -Xmx1024m -XX:PermSize=256m -XX:MaxPermSize=512m"

mvn jetty:run $*
