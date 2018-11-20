Redis client of Java -> Jedis

Redis is 
Open source, in memory, key - value data store 
Used as database, cache and message broker
Fast, coz written in C
Supports rich data sets
    String
    Hashes
    Lists
    Sets
    Sorted Sets
operations are atomic

redis-cli -h localhost -p 6379 -a pola
CONFIG GET *

redis-cli ping
redis-cli shutdown

##### -------------------------------------------------------------------------------------------------- #####

Reference:
https://redis.io/clients#java \n
https://javapointers.com/tutorial/use-redis-java-using-jedis/
https://www.baeldung.com/spring-data-redis-tutorial
https://dzone.com/articles/intro-to-redis-with-spring-boot
https://www.javacodegeeks.com/2017/11/intro-redis-spring-boot.html
