@echo off
setlocal

:: Stop existing container if exists
docker stop my_postgres_db || goto :CONTINUE
docker rm my_postgres_db || goto :CONTINUE

:CONTINUE

:: Start PostgreSQL container
docker run --name my_postgres_db -e POSTGRES_PASSWORD=mysecretpassword -p 5432:5432 -d postgres

:: Wait for PostgreSQL to initialize
echo Waiting for PostgreSQL to initialize...
timeout /t 10 /nobreak

:: Create new database
docker exec -it my_postgres_db psql -U postgres -c "CREATE DATABASE recipe_db;"

:: Create tables
docker exec -it my_postgres_db psql -U postgres -d recipe_db -c "CREATE TABLE recipe (id BIGSERIAL PRIMARY KEY, name VARCHAR(255), description TEXT);"
docker exec -it my_postgres_db psql -U postgres -d recipe_db -c "CREATE TABLE ingredient (id BIGSERIAL PRIMARY KEY, name VARCHAR(255), amount VARCHAR(255));"
docker exec -it my_postgres_db psql -U postgres -d recipe_db -c "CREATE TABLE recipe_ingredient (recipe_id BIGINT NOT NULL, ingredient_id BIGINT NOT NULL, PRIMARY KEY (recipe_id, ingredient_id));"

:: Add foreign key constraints
docker exec -it my_postgres_db psql -U postgres -d recipe_db -c "ALTER TABLE recipe_ingredient ADD CONSTRAINT fk_recipe FOREIGN KEY (recipe_id) REFERENCES recipe(id);"
docker exec -it my_postgres_db psql -U postgres -d recipe_db -c "ALTER TABLE recipe_ingredient ADD CONSTRAINT fk_ingredient FOREIGN KEY (ingredient_id) REFERENCES ingredient(id);"

echo Database and tables created successfully.

endlocal
