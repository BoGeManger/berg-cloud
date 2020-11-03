@echo off
title maiyoucard20005
echo 您输入了部署文件名:%1%
java -jar %1% --server.port=20005 --snowflake.id.worker.workerId=0 --snowflake.id.worker.datacenterId=2 --spring.profiles.active=dev 2>&1 &