FROM java:8
VOLUME /tmp
RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo "Asia/Shanghai" > /etc/timezone
COPY target/admin-1.0.0-SNAPSHOT.jar admin.jar
RUN bash -c "touch /admin.jar"
EXPOSE 30000
ENTRYPOINT ["java","-Xms256m","-Xmx256m","-jar","admin.jar"]