#!/bin/bash
echo "begin"

pid0=`netstat -nlp | grep -w 20000 | sed -r 's#.* (.*)/.*#\1#'`
pid1=`netstat -nlp | grep -w 20001 | sed -r 's#.* (.*)/.*#\1#'`

echo "kill pid" $pid0
kill $pid0
sleep 1
echo "run 20000" $1
nohup java -jar ./$1 --server.port=20000 --snowflake.id.worker.workerId=0 --snowflake.id.worker.datacenterId=0 --spring.profiles.active=prod >/dev/null 2>&1 &

sleep 1
echo "kill pid" $pid1
kill $pid1
sleep 1
echo "run 20001" $1
nohup java -jar ./$1 --server.port=20001 --snowflake.id.worker.workerId=0 --snowflake.id.worker.datacenterId=1 --spring.profiles.active=prod >/dev/null 2>&1 &

netstat -nplt
