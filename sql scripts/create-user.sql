CREATE USER 'david'@'localhost' IDENTIFIED BY 'dragon';

GRANT ALL PRIVILEGES ON * . * TO 'david'@'localhost';

ALTER USER 'david'@'localhost' IDENTIFIED WITH mysql_native_password BY 'dragon';