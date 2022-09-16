DROP TABLE IF EXISTS recipe;

CREATE TABLE recipe (
                        id bigint(5) NOT NULL AUTO_INCREMENT,
                        link VARCHAR(50),
                        title VARCHAR(50),
                        temperature VARCHAR(10),
                        culture VARCHAR(30),
                        meal_type VARCHAR(20),
                        PRIMARY KEY (id)
);