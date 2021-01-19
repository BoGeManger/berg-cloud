FROM java:8
VOLUME /tmp
RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo "Asia/Shanghai" > /etc/timezone
COPY target/gateway-1.0.0-SNAPSHOT.jar gateway.jar
RUN bash -c "touch /gateway.jar"
EXPOSE 40000
ENTRYPOINT ["java","-Xms256m","-Xmx256m","-jar","gateway.jar"]