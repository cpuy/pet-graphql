
```
$ ./gradlew bootRun
```

```
$ curl -X POST http://localhost:8080/graphql -H "Content-Type: application/json"  -d '{ "query": "{ case(id: 7) { name, id }}" }'
```