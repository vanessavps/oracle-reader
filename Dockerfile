FROM mysql:5.7.15
MAINTAINER Vanessa Pereira "vanessa.vps29@gmail.com"

ENV MYSQL_DATABASE=oracle_reader \
    MYSQL_ROOT_PASSWORD=1234

ADD schema.sql /docker-entrypoint-initdb.d

EXPOSE 3306
