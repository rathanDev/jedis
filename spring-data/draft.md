Install Redis:
brew install redis

localhost:8090/add-name?key=m&value=milo
localhost:8090/add-dog?key=3&value=germanShepherd

localhost:8090/find-all

localhost:8090/get-name?id=m
localhost:8090/get-dog?id=m




GET http://localhost:8090/get-dog?id=3
Accept: */*
Cache-Control: no-cache

###



POST http://localhost:8090/add-dog?key=4&value=goldenRetriever
Accept: */*
Cache-Control: no-cache

###


GET http://localhost:8090/find-all
Accept: */*
Cache-Control: no-cache

###



POST http://localhost:8090/chase-out?id=m
Accept: */*
Cache-Control: no-cache

###
