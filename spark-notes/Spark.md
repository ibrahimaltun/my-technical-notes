### conf dosyasini tam aktif etmek icin

$ **pkill -f 'org.apache.spark.deploy.worker.Worker'**
$ **SPARK_HOME/sbin/stop-all.sh**
$ **SPARK_HOME/sbin/start-all.sh**

### Modlar

| Mod                 | Açıklama                                                                          |
| ------------------- | --------------------------------------------------------------------------------- |
| **Local Mode**      | Tek makinede, tek JVM içinde çalışır. Küçük testler için uygundur.                |
| **Standalone Mode** | Spark kendi başına bir cluster yönetir. Master + Worker mimarisi vardır.          |
| **Cluster Mode**    | Spark, YARN, Mesos veya Kubernetes gibi harici bir cluster yöneticisiyle çalışır. |


### ⚙️ Spark Konfigürasyonları: Detaylı Açıklamalar

### 🔥 Bellek ve CPU Ayarları

|Ayar|Açıklama|
|---|---|
|`spark.executor.memory`|Her executor için ayrılacak RAM miktarı. Örnek: `"8g"` → 8 GB.|
|`spark.driver.memory`|Driver için ayrılacak RAM miktarı. Driver, Spark uygulamasını yöneten ana süreçtir.|
|`spark.executor.cores`|Her executor için kullanılacak CPU çekirdeği sayısı. Daha fazla çekirdek, daha fazla paralel görev demektir.|
|`spark.executor.instances`|Toplam kaç executor oluşturulacağını belirler. Örneğin 4 executor × 8 core = 32 paralel görev.|

### 🚀 Performans ve Shuffle Ayarları

|Ayar|Açıklama|
|---|---|
|`spark.sql.shuffle.partitions`|`groupBy`, `join` gibi işlemlerde veri nasıl bölünecek. Varsayılan 200’dür. Büyük veri için 500+ önerilir.|
|`spark.sql.autoBroadcastJoinThreshold`|Küçük tabloların otomatik olarak broadcast edilmesini sağlar. Varsayılan 10 MB. Büyükse artırılabilir.|
|`spark.default.parallelism`|RDD işlemlerinde kullanılacak varsayılan partition sayısı. Genellikle executor core sayısına eşitlenir.|

### 🧠 Uygulama ve Cluster Ayarları

|Ayar|Açıklama|
|---|---|
|`spark.master`|Spark’ın hangi modda çalışacağını belirtir. Örnek: `'local[*]'`, `'spark://host:port'`, `'yarn'`.|
|`spark.app.name`|Uygulamanın adı. Spark UI’da görünür.|
|`spark.submit.deployMode`|`'client'` veya `'cluster'`. Cluster modunda driver bir worker node’da çalışır.|

### 🧹 Temizlik ve Bellek Yönetimi

|Ayar|Açıklama|
|---|---|
|`spark.storage.memoryFraction`|Belleğin ne kadarının cache için ayrılacağını belirler. (Spark 2.x’ten sonra deprecated oldu.)|
|`spark.memory.fraction`|Toplam belleğin ne kadarının execution ve storage için kullanılacağını belirler.|
|`spark.memory.storageFraction`|Belleğin ne kadarının sadece storage (cache/persist) için ayrılacağını belirler.|

### 📦 Dosya ve I/O Ayarları

|Ayar|Açıklama|
|---|---|
|`spark.sql.files.maxPartitionBytes`|Okunan dosyaların partition boyutunu belirler. Küçükse daha fazla paralellik.|
|`spark.sql.files.openCostInBytes`|Dosya açma maliyeti. Partition sayısını etkiler.|
|`spark.sql.parquet.filterPushdown`|Parquet dosyalarında filtreleme işlemini hızlandırır. Genellikle `true` olmalı.|

### 🧪 Gelişmiş Ayarlar

| Ayar                              | Açıklama                                                                               |
| --------------------------------- | -------------------------------------------------------------------------------------- |
| `spark.speculation`               | Görevler yavaşsa aynı işi başka executor’da tekrar başlatır. Yüksek gecikmeyi azaltır. |
| `spark.dynamicAllocation.enabled` | Executor sayısını otomatik olarak artırıp azaltır. Kaynakları daha verimli kullanır.   |
| `spark.local.dir`                 | Geçici dosyaların yazılacağı dizin. SSD olan bir dizin seçilirse performans artar.     |




 