FROM adoptopenjdk:11-jre-hotspot

ADD src/main/docker/entrypoint.sh entrypoint.sh
ADD src/main/docker/logstash.crt logstash.crt
ADD src/main/docker/conf.yaml  conf.yaml
COPY target/fizzbuzz-*.jar application.jar

CMD chmod +x /entrypoint.sh && sync && /entrypoint.sh

