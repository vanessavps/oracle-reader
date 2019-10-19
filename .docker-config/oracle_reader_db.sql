CREATE DATABASE IF NOT EXISTS oracle_reader;

USE oracle_reader;

CREATE TABLE IF NOT EXISTS user
(
  id       int(11) NOT NULL AUTO_INCREMENT,
  name     varchar(80) DEFAULT NULL,
  email    varchar(50) DEFAULT NULL,
  password varchar(80) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE (id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8;


CREATE TABLE IF NOT EXISTS customer
(
  id        int(11) NOT NULL AUTO_INCREMENT,
  name      varchar(50) DEFAULT NULL,
  email     varchar(50) DEFAULT NULL,
  phone     varchar(25) DEFAULT NULL,
  birthdate date        DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


CREATE TABLE IF NOT EXISTS card
(
  id          int(11) NOT NULL AUTO_INCREMENT,
  name        varchar(80) DEFAULT NULL,
  description mediumtext,
  detail      mediumtext,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


CREATE TABLE IF NOT EXISTS deck
(
  id          int(11) NOT NULL AUTO_INCREMENT,
  name        varchar(80) DEFAULT NULL,
  author      varchar(80) DEFAULT NULL,
  illustrator varchar(80) DEFAULT NULL,
  publisher   varchar(50) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


CREATE TABLE IF NOT EXISTS card_spread
(
  id          int(11) NOT NULL AUTO_INCREMENT,
  name        varchar(80) DEFAULT NULL,
  description text,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS deck_card
(
  id          int(11) NOT NULL AUTO_INCREMENT,
  card_number int(11) DEFAULT NULL,
  deck_id     int(11) NOT NULL,
  card_id     int(11) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE (id),
  KEY deck_id_idx (deck_id),
  KEY card_id_idx (card_id),
  CONSTRAINT card_id FOREIGN KEY (card_id) REFERENCES card (id),
  CONSTRAINT deck_id FOREIGN KEY (deck_id) REFERENCES deck (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


CREATE TABLE IF NOT EXISTS question
(
  id       int(11) NOT NULL AUTO_INCREMENT,
  question varchar(80) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


CREATE TABLE IF NOT EXISTS answer
(
  id           int(11) NOT NULL AUTO_INCREMENT,
  deck_card_id int(11) NOT NULL,
  meaning      text,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE (id),
  KEY deck_card_id_idx (deck_card_id),
  CONSTRAINT deck_card_id FOREIGN KEY (deck_card_id) REFERENCES deck_card (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


CREATE TABLE IF NOT EXISTS reading
(
  id             int(11)   NOT NULL AUTO_INCREMENT,
  user_id        int(11)   NOT NULL,
  customer_id    int(11)   NOT NULL,
  date           timestamp NULL DEFAULT NULL,
  card_spread_id int(11)   NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE (id),
  KEY user_id_idx (user_id),
  KEY customer_id_idx (customer_id),
  KEY card_spread_id_idx (card_spread_id),
  CONSTRAINT card_spread_id FOREIGN KEY (card_spread_id) REFERENCES card_spread (id),
  CONSTRAINT customer_id FOREIGN KEY (customer_id) REFERENCES customer (id),
  CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES user (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


CREATE TABLE IF NOT EXISTS reading_detail
(
  id              int(11) NOT NULL AUTO_INCREMENT,
  read_id         int(11) NOT NULL,
  answer_id       int(11) NOT NULL,
  question_number int(11) DEFAULT NULL,
  question_id     int(11) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE (id),
  KEY read_id_idx (read_id),
  KEY answer_id_idx (answer_id),
  KEY question_id_idx (question_id),
  CONSTRAINT answer_id FOREIGN KEY (answer_id) REFERENCES answer (id),
  CONSTRAINT question_id FOREIGN KEY (question_id) REFERENCES question (id),
  CONSTRAINT read_id FOREIGN KEY (read_id) REFERENCES reading (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;




