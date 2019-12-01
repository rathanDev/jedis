Locate a file in mac 
sudo find / -name mongod
> /usr/local/bin/mongod

Start mongo 
janarthan$ cd /usr/local/bin
janarthan$ ./mongod --dbpath /usr/local/var/mongodb/

Start redis server 
brew services start redis

Connect to redis
redis-cli -h localhost -p 6379
redis-cli ping
redis-cli shutdown
;
-- Get all keys
KEYS *
KEYS a*
-- Get a key with value
SET aKey aVal
