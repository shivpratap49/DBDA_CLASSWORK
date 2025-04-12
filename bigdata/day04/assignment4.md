1. Upload busstops.json data into HDFS directory. Then create hive external table to fetch data using JsonSerDe.
    ```
    {"_id":{"$oid":"5a0720b478597fc11004d951"},"stop":"Non-BRTS","code":"103B-D-04","seq":4.0,"stage":1.0,"name":"Aranyeshwar Corner","location":{"type":"Point","coordinates":[73.857675,18.486381]}}
    ```
    ``` 
    location STRUCT<type:STRING, coordinates:ARRAY<DOUBLE>>
    ```
    ```
    When column-name have special charatcters like _ or $, they should be encapsulated in `back-quotes`.
    ```

2. Execute following queries on MySQL emp database using Recursive CTEs (not supported in Hive 3.x).
    1. Find years in range 1975 to 1985, where no emps were hired.
    2. Display emps with their level in emp hierarchy. Level employee is Level of his manager + 1.
    3. Create a "newemp" table with foreign constraints enabled for "mgr" column. Also enable DELETE ON CASCADE for the same. Insert data into the table from emp table. Hint: You need to insert data levelwise to avoid FK constraint error.
    4. From "newemp" table, delete employee KING. What is result?

3. Load Fire data into Hive in a staging table "fire_staging".

4. Implement Movie recommendation system.
    * Example Input Data
        ```
        userId,movieId,rating,rtime
        17,70,3,0
        35,21,1,0
        49,19,2,0
        49,21,1,0
        49,70,4,0
        87,19,1,0
        87,21,2,0
        98,19,2,0
        ```
    * Create pairs of movies rated by same user.
        ```
        userId,movie1,rating1,movie2,rating2
        49,21,1.0,70,4.0
        49,19,2.0,21,1.0
        49,19,2.0,70,4.0
        87,19,1.0,21,2.0
        ```
    * Create correlation table.
        ```
        movie1,movie2,cnt,cor
        19,21,2,-1.0
        19,70,1,0.0
        21,70,1,0.0
        ```
    * Predict Similar movies for given movie Id. Get the recommended movies titles from movies table.
    * Hints
        * Start with above small data tables to test accuracy of the steps.
        * You will need to create new intermediate tables to store results of earlier queries.
        * For main data use ORC format to speed-up the queries.
        * You may need to change reducer tasks memory for quicker execution and avoid OutOfMemory errors.
            * SET mapreduce.reduce.memory.mb = 4096;
            * SET mapreduce.reduce.java.opts = -Xmx4096m;
    * Input movie id in Python/Java application and show related 5 movies.
