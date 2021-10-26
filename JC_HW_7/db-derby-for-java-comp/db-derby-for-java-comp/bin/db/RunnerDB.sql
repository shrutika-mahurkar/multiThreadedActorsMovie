CONNECT 'jdbc:derby:RunnerDB;create=true';

CREATE TABLE RunnerStats
(
     Name  VARCHAR(20),
     RunnerSpeed DOUBLE,
     RestPercentage DOUBLE
);


INSERT INTO RunnerStats
VALUES ('Tortoise',10,0);

INSERT INTO RunnerStats
VALUES ('Hare',100,90);

INSERT INTO RunnerStats
VALUES ('Dog',50,40);

INSERT INTO RunnerStats
VALUES ('Cat',30,75);


