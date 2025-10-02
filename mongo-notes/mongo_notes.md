
### mongodump

```
mongodump --host localhost:27017 --gzip --db <veritabanı adı> --out ./<veritabanının dump edileceği dizin>/
```

> [!Example]
> **mongodump --host localhost:27017 --gzip --db plus_database --out ./Desktop/**


### mongorestore


```
mongorestore --host=127.0.0.1:27017 --db=<veritabanı adı> --gzip ./<bson.gz dosya yolu>
```

> [!Example]
> **mongorestore --host=127.0.0.1:27017 --db=plus_database --gzip ./raw_frames.bson.gz**


### mongosh

- veritabanlarini gor

``` bash
$ show dbs
```

- veritabani sec

```
$ use <veritabani_adi>
```

- koleksiyonlari gor

```
$ show collections
```

- koleksiyondan istedegin sayi kadar veri satiri getir

```
$ db.<koleksiyon_adi>.find().limit(2)
```

- 