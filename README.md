
```
$ ./gradlew bootRun
```

```
$ curl -X POST http://localhost:8080/graphql -H "Content-Type: application/json"  -d '{ "query": "{ case(id: 7) { name, id }}" }'
```

```
{ "query": "{ case(id: 17001) { name, id, startedBy { id, userName } }}" }
```

```
{ "query": "{ case(id: 17004) { name, id, startedBy { id, userName }, archivedTasks { id }  }}" }
```