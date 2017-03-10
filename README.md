
# Let's give a try to graphql-java

## Launch
- Start bonita portal
- Edit application.properties and set bonita server base url  (without /bonita)
- Launch embedded tomcat
```
$ ./gradlew bootRun
```

## Query
```
$ curl -X POST http://localhost:8080/graphql -H "Content-Type: application/json"  -d '{ "query": "{ case(id: 7) { name, id }}" }'
```

```
{ "query": "{ case(id: 17001) { name, id, startedBy { id, userName } }}" }
```

```
{ "query": "{ case(id: 17004) { name, id, startedBy { id, userName }, archivedTasks { id }  }}" }
```

```
{ "query": "{ case(id: 17004) { name, id, startedBy { id, lastName, jobTitle, userName }, archivedTasks { id, name, state, executedBy { userName, title } } }}" }
```

## TODO
- https://github.com/graphql-java/graphql-java-annotations
- mutations
- Unit tests ?
- Swagger like ?
- ...