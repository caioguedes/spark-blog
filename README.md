# How to run this?
In the project folder run this

```
touch development.sqlite
```

```
sqlite3 development.sqlite
.read src/main/resources/database/database-schema.sql
```

```
./gradlew run
```

The server will start at `http://localhost:4567`