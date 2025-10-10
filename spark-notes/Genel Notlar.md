### Apache Spark Nedir?

- Büyük Verisetlerinde Makine Öğrenmesi ve Büyük Veri görevlerini gerçekleştirmek için kullanılan dağıtık bir işleme sistemidir.(Distributed Processing System)
- Apache Spark ile kullanıcılar, cihazlarında mümkün olan petabyte'lar seviyesinde veriler üzerinde makine öğrenmesi iş akışlarını ve sorguları çalıştırabilirler.
- Bu framework *Hadoop*  gibi önceki veri işleme motorlarından bile hızlıdır ve popülerliği gittikçe artmaktadır.

### PySpark nedir?

* PySpark Pythonda Apache Spark için bir interface'dir. PySpark ile birlikte, dağıtık işleme ortamlarında Python ve SQL gibi komutları kullanarak veriyi manipüle ve analiz edebiliriz. Ayrıca Veri Bilimciler PySpark'ı, veriyi manipüle etmek makine öğrenmesi pipeline'ı kurmak ve modelleri tune etmek için kullanılır.

### Neden PySpark?

* Şirketler tarafından PySpark gibi bir framework seçimi, Verilerimizi ne kadar hızlı işleyebiliriz sorusundan ortaya çıkmıştır. Çünkü Pandas ve Dask gibi kitaplıklardan çok daha hızlıdır ve devasa miktarda verileri işleyebilir. Petabyte'lar seviyesinde verimiz varsa Pandas ve Dask fail edecektir fakat PySpark bunu kolay bir şekilde ele alabilir.
* Şirketler Hadoop üzerinde python kodu yazmak yerine çok hızlı olması ve gerçek zamanlı veri işlemesinden dolayı Spark ve PySpark API tercih ederler.
* Aslında Apache Flink ve PyFlink API ile birlikte performans açısından Sparktan daha iyidir fakat Apache Spark daha uzun dönemdir yayındadır ve daha iyi topluluk desteği vardır. Bu onu daha güvenilir yapar. Üstelik PySpark hata toleransı sağlar bunun anlamı bir hata meydana geldiğinde kaybı geri getirme kabileyetine sahip olmasıdır.
* Bu framework ayrıca bellekte depolamaya ve bellekte hesaplamaya sahiptir. Hard-drive ya da SSD yüklü olmayan bir makine de çalışabilir.


### PySpark nasıl yüklenir?

#### Prerequisites

- [Java 11 or later (Java 17 recommended)](https://www.datacamp.com/doc/java/installing-java)
- [Python 3.7 or later](https://www.datacamp.com/tutorial/python-developer-set-up)
- [Jupyter Notebook](https://www.datacamp.com/tutorial/installing-jupyter-notebook)

```
!pip install pyspark
```

### PySpark Tutorial

#### SparkSession oluşturma

* SparkSession, Spark'ta tüm işlevsellikler ve bir dataframe oluşturmak için gerekli bir başlangıç noktasıdır.

``` python
from pyspark.sql import SparkSession  # add this import


spark = (
    SparkSession.builder
    .appName("Pyspark Tutorial")
    .config("spark.memory.offHeap.enabled", "true")
    .config("spark.memory.offHeap.size", "10g")
    .getOrCreate()
)
```

Bu kod ile sırasıyla;
- bir spark oturumu oluştururuz,
- bu oturuma bir isim ataması yaparız,
- veriler doğrudan diske kaydedilmesin diye heap-dışı belleği önbelleğe alırız,
- son olarak da bu bellek miktarını belirtiriz.

#### DataFrame oluşturma
* Herhangi bir verisetini okuyabiliriz.

``` python
df = spark.read.csv("ecommerce.csv", header=True, escape='"', inferSchema=True)
```

#### Veriyi Keşfetmek (Exploratory Data Analysis)

- Bu satırla birlikte dataframe'in ilk 10 satırını görebiliriz.
``` python
df.show(10)
```

* DataFrame kaç satır veriye sahip görmek için;

``` python
df.count()
```






### PySpark & MongoDB

https://mvnrepository.com/artifact/org.mongodb/mongodb-driver-sync/4.2.3
https://mvnrepository.com/artifact/org.mongodb.spark/mongo-spark-connector_2.12/3.0.1
https://mvnrepository.com/artifact/org.mongodb/bson/4.2.3
https://mvnrepository.com/artifact/org.mongodb/mongodb-driver-core/4.2.3

*Files	pom (3 KB)  jar (539 KB)  View All*
Bu satir icinden jar dosyasinda tikla ve indir.

Yukaridaki 4 link indirildikten sonra (ki bunlar spark 3.2.1 surumune uyumludur) bunlari /usr/local/spark/jars altina eklemek gereklidir ya da spark nerede kuruluysa.

SparkSession icine spark.jars seklinde tanimlamadan da alianbiliyor. hata vermiyor. 30.09.2025


### Modlar

| Mod                         | Açıklama                                                                          |
| --------------------------- | --------------------------------------------------------------------------------- |
| **Local Mode**              | Tek makinede, tek JVM içinde çalışır. Küçük testler için uygundur.                |
| **Standalone(Client) Mode** | Spark kendi başına bir cluster yönetir. Master + Worker mimarisi vardır.          |
| **Cluster Mode**            | Spark, YARN, Mesos veya Kubernetes gibi harici bir cluster yöneticisiyle çalışır. |

Source: https://medium.com/@sephinreji98/understanding-spark-cluster-modes-client-vs-cluster-vs-local-d3c41ea96073





 