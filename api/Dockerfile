FROM java:8
VOLUME /tmp
RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo "Asia/Shanghai" > /etc/timezone
COPY target/api-1.0.0-SNAPSHOT.jar api.jar
RUN bash -c "touch /api.jar"
EXPOSE 41000
ENTRYPOINT ["java","-Xms256m","-Xmx256m","-jar","api.jar"]