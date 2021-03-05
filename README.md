The issue with changing GraphQL queries to string that can be added to RestAssured is a long pain in testing community. 

This:
```graphql
{
  characters {
    results {
      name
      status
      type
    }
  }
}
```

must be changed to this:
```json
{"query":"{\n  characters {\n    results {\n      name\n      status\n      type\n    }\n  }\n}","variables":{}}
```

This project is supposed to allow you to keep `.graphql` files in some folders, and don't care about all the transformations that needs to happen.