### PySpark & MongoDB

https://mvnrepository.com/artifact/org.mongodb/mongodb-driver-sync/4.2.3
https://mvnrepository.com/artifact/org.mongodb.spark/mongo-spark-connector_2.12/3.0.1
https://mvnrepository.com/artifact/org.mongodb/bson/4.2.3
https://mvnrepository.com/artifact/org.mongodb/mongodb-driver-core/4.2.3

Files	pom (3 KB)  jar (539 KB)  View All
Bu satir icinden jar dosyasinda tikla ve indir.

Yukaridaki 4 link indirildikten sonra (ki bunlar spark 3.2.1 surumune uyumludur) bunlari /usr/local/spark/jars altina eklemek gereklidir. 
SparkSession icine spark.jars seklindetanimlamadan da alianbiliyor. hata vermiyor. 30.09.2025


### Modlar

| Mod                 | Açıklama                                                                          |
| ------------------- | --------------------------------------------------------------------------------- |
| **Local Mode**      | Tek makinede, tek JVM içinde çalışır. Küçük testler için uygundur.                |
| **Standalone Mode** | Spark kendi başına bir cluster yönetir. Master + Worker mimarisi vardır.          |
| **Cluster Mode**    | Spark, YARN, Mesos veya Kubernetes gibi harici bir cluster yöneticisiyle çalışır. |





 