
### Spark özelliklerini 4 temel yöntemle yönetebiliriz:

1. **Configuration dosyaları**

*$SPARK_HOME* dizini altında (spark'ı nereye indirip kurduysanız) conf klasörü içerisinde bulunan klasörler yardımıyla yapılır. Bu dosyalar;

- `conf/spark-defaults.conf.template`
- `conf/log4j.properties.template`
- `conf/spark-env.sh.template`

İstenilen ayarlar bu dosyalar üzerinde yapıldıktan sonra *.template* uzantısı olmadan aynı dizine kaydedilir. Böylece Spark'a yeni yapılandırma talimatları verilmiş olacaktır.

2. **spark-submit komutları**

* spark-submit komutuyla --conf parametresine ayarlar iletilebilir

``` shell
$ spark-submit --conf spark.executor.memory=4g --conf spark.executor.cores=2
```


3. **spark-shell**

**Scala:**

``` shell
spark-shell --conf spark.executor.memory=4g --conf spark.executor.cores=2
```

**Python:**

``` shell
pyspark --conf spark.executor.memory=4g --conf spark.executor.cores=2
```


4. **spark session code**
* PySpark kodu içerisinden de config atamaları yapılabilir.

  
``` python
from pyspark.sql import SparkSession  
  
spark = SparkSession.builder \  
    .appName("MyApp") \  
    .config("spark.executor.memory", "4g") \  
    .config("spark.executor.cores", "2") \  
    .getOrCreate()
```

ÖNEMLİ NOT: Kod içinden yapılan yapılandırmalarda ilgili parametrenin düzenlenebilir olması gereklidir. Bunu doğrulamak için aşağıdaki komut kullanılabilir. Eğer *true* dönerse düzenlenebilirdir aksine *false* dönerse değildir.

``` python
spark.conf.isModifiable("<config_name>")
```

#### Konfigürasyonları Görüntülemek

1. spark-shell üzerinden
Scala:

``` scala
scala> spark.conf.getAll.foreach(println)
```
Python:

``` python
for item in spark.conf.getAll().items():  
    print(item)
```

2. kod içerisinden

``` python
app_name = spark.conf.get("spark.app.name")  
print(f"Application Name: {app_name}")  
  
from pyspark.sql import SparkSession  
  
def print_configs(session):  
    # Get conf  
    mconf = session.conf.getAll()  
    # Print them  
    for k, v in mconf.items():  
        print(f"{k} -> {v}\n") 

print_configs(spark)
```

3. Spark UI
Spark Uygulaması çalışırken *Environment* menüsü altından

![[Pasted image 20251003104846.png]]


---

## spark-env.sh

### spark-env.sh conf dosyasini tam aktif etmek icin

- bazi durumlarda Spark UI'da guncellemlerin gelmedigi gorulmustur bu yuzden bu isleme ihtiyac dogmustur.

```
$ pkill -f 'org.apache.spark.deploy.worker.Worker'

$ SPARK_HOME/sbin/stop-all.sh

$ SPARK_HOME/sbin/start-all.sh
```



## SparkSession icin conf

**Bellek ve CPU Ayarları**

| Ayar                       | Açıklama                                                                                                     |
| -------------------------- | ------------------------------------------------------------------------------------------------------------ |
| `spark.executor.memory`    | Her executor için ayrılacak RAM miktarı. Örnek: `"8g"` → 8 GB.                                               |
| `spark.driver.memory`      | Driver için ayrılacak RAM miktarı. Driver, Spark uygulamasını yöneten ana süreçtir.                          |
| `spark.executor.cores`     | Her executor için kullanılacak CPU çekirdeği sayısı. Daha fazla çekirdek, daha fazla paralel görev demektir. |
| `spark.executor.instances` | Toplam kaç executor oluşturulacağını belirler. Örneğin 4 executor × 8 core = 32 paralel görev.               |

**Performans ve Shuffle Ayarları**

| Ayar                                   | Açıklama                                                                                                   |
| -------------------------------------- | ---------------------------------------------------------------------------------------------------------- |
| `spark.sql.shuffle.partitions`         | `groupBy`, `join` gibi işlemlerde veri nasıl bölünecek. Varsayılan 200’dür. Büyük veri için 500+ önerilir. |
| `spark.sql.autoBroadcastJoinThreshold` | Küçük tabloların otomatik olarak broadcast edilmesini sağlar. Varsayılan 10 MB. Büyükse artırılabilir.     |
| `spark.default.parallelism`            | RDD işlemlerinde kullanılacak varsayılan partition sayısı. Genellikle executor core sayısına eşitlenir.    |

 **Uygulama ve Cluster Ayarları**

|Ayar|Açıklama|
|---|---|
|`spark.master`|Spark’ın hangi modda çalışacağını belirtir. Örnek: `'local[*]'`, `'spark://host:port'`, `'yarn'`.|
|`spark.app.name`|Uygulamanın adı. Spark UI’da görünür.|
|`spark.submit.deployMode`|`'client'` veya `'cluster'`. Cluster modunda driver bir worker node’da çalışır.|

**Temizlik ve Bellek Yönetimi**

|Ayar|Açıklama|
|---|---|
|`spark.storage.memoryFraction`|Belleğin ne kadarının cache için ayrılacağını belirler. (Spark 2.x’ten sonra deprecated oldu.)|
|`spark.memory.fraction`|Toplam belleğin ne kadarının execution ve storage için kullanılacağını belirler.|
|`spark.memory.storageFraction`|Belleğin ne kadarının sadece storage (cache/persist) için ayrılacağını belirler.|
 
 **Dosya ve I/O Ayarları**

|Ayar|Açıklama|
|---|---|
|`spark.sql.files.maxPartitionBytes`|Okunan dosyaların partition boyutunu belirler. Küçükse daha fazla paralellik.|
|`spark.sql.files.openCostInBytes`|Dosya açma maliyeti. Partition sayısını etkiler.|
|`spark.sql.parquet.filterPushdown`|Parquet dosyalarında filtreleme işlemini hızlandırır. Genellikle `true` olmalı.|
 
 **Gelişmiş Ayarlar**

| Ayar                              | Açıklama                                                                               |
| --------------------------------- | -------------------------------------------------------------------------------------- |
| `spark.speculation`               | Görevler yavaşsa aynı işi başka executor’da tekrar başlatır. Yüksek gecikmeyi azaltır. |
| `spark.dynamicAllocation.enabled` | Executor sayısını otomatik olarak artırıp azaltır. Kaynakları daha verimli kullanır.   |
| `spark.local.dir`                 | Geçici dosyaların yazılacağı dizin. SSD olan bir dizin seçilirse performans artar.     |

---

