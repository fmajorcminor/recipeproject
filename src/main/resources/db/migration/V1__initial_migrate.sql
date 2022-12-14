DROP TABLE IF EXISTS recipe;
CREATE TABLE recipe (
                        recipe_id SERIAL PRIMARY KEY,
                        link VARCHAR(100),
                        title VARCHAR(50),
                        temperature VARCHAR(10),
                        culture VARCHAR(30),
                        meal_type VARCHAR(20),
                        favorite BOOLEAN

);

DROP TABLE IF EXISTS ingredient;
CREATE TABLE ingredient (
                            ingredient_id SERIAL PRIMARY KEY,
                            ingredient_name VARCHAR(30),
                            running_out BOOLEAN,
                            completely_out BOOLEAN,
                            common_vegan_substitute VARCHAR(30)

);

DROP TABLE IF EXISTS weekly_planner;
CREATE TABLE weekly_planner (
                        week_id SERIAL PRIMARY KEY,
                        starting_week_date DATE UNIQUE,
                        week_is_planned BOOLEAN

);

