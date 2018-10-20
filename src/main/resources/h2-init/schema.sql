DROP TABLE t_user;
CREATE TABLE IF NOT EXISTS t_user(
	id BIGINT (15) NOT NULL AUTO_INCREMENT COMMENT 'id',
	`name` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'name',
	password VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'password',
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;