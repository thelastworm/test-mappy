#!/bin/sh

apt update
apt install wget
apt install gnupg -y
wget -qO - https://artifacts.elastic.co/GPG-KEY-elasticsearch | apt-key add -
apt-get install apt-transport-https
echo "deb https://artifacts.elastic.co/packages/oss-7.x/apt stable main" | tee -a /etc/apt/sources.list.d/elastic-7.x.list
apt update && apt-get install filebeat

mkdir -p /etc/pki/tls/client/
cp logstash.crt /etc/pki/tls/client/
mv conf.yaml /etc/filebeat/

filebeat -c conf.yaml -e &

echo "Starting binary   ========"
exec java -jar application.jar

