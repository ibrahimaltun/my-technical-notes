- PySpark, Apache Spark için Python API'dir. Python kullanarak, dağıtık ortamlarda gerçek-zamanlı, büyük-ölçekli veri işleme olanağı sağlar. Ayrıca kendine ait sheel ile etkileşimli veri analizi sunar.
- PySpark, Python'un kolay öğrenme ve kullanmasını Apache Spark'ın gücü ile birleştirir. Böylece Pyhona aşina olan herkesin her boyuttan veriyi işleyebilme ve analiz edebilmesini sağlar.
- PySpark, Spark SQL, DataFrames, Structured Streaming, Machine Learning(MLlib) ve Spark Core gibi tüm Spark özelliklerini destekler.

#### PySpark Kurulum


##### PyPI Kullanarak

```
$ pip install pyspark
```

##### Conda Kullanarak

```
conda create -n pyspark_env
conda activate pyspark_env
conda install -c conda-forge pyspark  # can also add "python=3.9 some_package [etc.]" here
```

##### Elle İndirme ve Kurulum

- PySpark için Apache Spark internet sayfasında dağıtımlar bulunabilir.
- Siteden istenen dağıtım indirilebilir. Ardından sıkıştırılmış dosya çıkartılır. Çıkartılan dosya ise Spark'ı çalıştırmak istediğimiz dizine koyulur.

https://spark.apache.org/downloads.html
veya
https://archive.apache.org/dist/spark/
sayfalarından istenen sürümler indirilir.

=> sürüme göre *release*  parametresini güncelle

```
$ tar xzvf spark-\ |release|\-bin-hadoop3.tgz
```

- Bundan sonra **SPARK_HOME** ortam değişkeni önceki adımda dışarı çıkartılan tar dosyasının olduğu dizini göstermesi gerekmektedir.
- **PYTHONPATH** ortam değişkeni ise **SPARK_HOME/python/lib** dizini altında PySpark ve Py4J'i bulabilmek için güncellenmelidir.

```
$ cd spark-\ |release|\-bin-hadoop3

$ export SPARK_HOME=`pwd`

$ export PYTHONPATH=$(ZIPS=("$SPARK_HOME"/python/lib/*.zip); IFS=:; echo "${ZIPS[*]}"):$PYTHONPATH
```

#### Hızlı Başlangıç: DataFrame

PySpark uygulaması **SparkSession** başlatılmasıyla başlar. Bu PySpark'ın giriş noktasıdır.

``` python
from pyspark.sql import SparkSession
spark = SparkSession.builder.getOrCreate()
```

##### DataFrame Oluşturma

``` python
from datetime import datetime, date
import pandas as pd
from pyspark.sql import Row

df = spark.createDataFrame([
    Row(a=1, b=2., c='string1', d=date(2000, 1, 1), e=datetime(2000, 1, 1, 12, 0)),
    Row(a=2, b=3., c='string2', d=date(2000, 2, 1), e=datetime(2000, 1, 2, 12, 0)),
    Row(a=4, b=5., c='string3', d=date(2000, 3, 1), e=datetime(2000, 1, 3, 12, 0))
])

# Açıklamalı şema ile
df = spark.createDataFrame([
    (1, 2., 'string1', date(2000, 1, 1), datetime(2000, 1, 1, 12, 0)),
    (2, 3., 'string2', date(2000, 2, 1), datetime(2000, 1, 2, 12, 0)),
    (3, 4., 'string3', date(2000, 3, 1), datetime(2000, 1, 3, 12, 0))
], schema='a long, b double, c string, d date, e timestamp')

# pandas dataframe'den oluşturma
pandas_df = pd.DataFrame({
    'a': [1, 2, 3],
    'b': [2., 3., 4.],
    'c': ['string1', 'string2', 'string3'],
    'd': [date(2000, 1, 1), date(2000, 2, 1), date(2000, 3, 1)],
    'e': [datetime(2000, 1, 1, 12, 0), datetime(2000, 1, 2, 12, 0), datetime(2000, 1, 3, 12, 0)]
})
df = spark.createDataFrame(pandas_df)

```

##### DataFrame Görüntüleme ve Detaylar

``` python
df.show()
df.printSchema()
df.columns
df.show(1)
df.select("a", "b", "c").describe().show()
df.collect()
```

##### Veri Seçme ve Belirli Verilere Erişme

``` python
df.a
# sonuc:
Column<b'a'>

# -----------------------------------
from pyspark.sql import Column
from pyspark.sql.functions import upper

type(df.c) == type(upper(df.c)) == type(df.c.isNull())
# sonuc:
True

# -----------------------------------
df.select(df.c).show()

# sonuc:
+-------+
|      c|
+-------+
|string1|
|string2|
|string3|

# -----------------------------------
df.withColumn('upper_c', upper(df.c)).show()
# sonuc:
+---+---+-------+----------+-------------------+-------+
|  a|  b|      c|         d|                  e|upper_c|
+---+---+-------+----------+-------------------+-------+
|  1|2.0|string1|2000-01-01|2000-01-01 12:00:00|STRING1|
|  2|3.0|string2|2000-02-01|2000-01-02 12:00:00|STRING2|
|  3|4.0|string3|2000-03-01|2000-01-03 12:00:00|STRING3|
+---+---+-------+----------+-------------------+-------+

# -----------------------------------
df.filter(df.a == 1).show()
# sonuc:
+---+---+-------+----------+-------------------+
|  a|  b|      c|         d|                  e|
+---+---+-------+----------+-------------------+
|  1|2.0|string1|2000-01-01|2000-01-01 12:00:00|
+---+---+-------+----------+-------------------+

```

##### Veriye Fonksiyon Uygulama

``` python
import pandas as pd
from pyspark.sql.functions import pandas_udf

@pandas_udf('long')
def pandas_plus_one(series: pd.Series) -> pd.Series:
    # Simply plus one by using pandas Series.
    return series + 1

df.select(pandas_plus_one(df.a)).show()

# sonuc:
+------------------+
|pandas_plus_one(a)|
+------------------+
|                 2|
|                 3|
|                 4|
+------------------+
```

##### Veriyi Gruplama

``` python

df = spark.createDataFrame([
    ['red', 'banana', 1, 10], ['blue', 'banana', 2, 20], ['red', 'carrot', 3, 30],
    ['blue', 'grape', 4, 40], ['red', 'carrot', 5, 50], ['black', 'carrot', 6, 60],
    ['red', 'banana', 7, 70], ['red', 'grape', 8, 80]], schema=['color', 'fruit', 'v1', 'v2'])
df.show()

# sonuc:
+-----+------+---+---+
|color| fruit| v1| v2|
+-----+------+---+---+
|  red|banana|  1| 10|
| blue|banana|  2| 20|
|  red|carrot|  3| 30|
| blue| grape|  4| 40|
|  red|carrot|  5| 50|
|black|carrot|  6| 60|
|  red|banana|  7| 70|
|  red| grape|  8| 80|
+-----+------+---+---+
```

- Veriyi grupla ve avg fonksiyonunu uygula

``` python 
df.groupby('color').avg().show()

# sonuc:
+-----+-------+-------+
|color|avg(v1)|avg(v2)|
+-----+-------+-------+
|  red|    4.8|   48.0|
|black|    6.0|   60.0|
| blue|    3.0|   30.0|
+-----+-------+-------+
```

##### DataFrame Kaydet

``` python

df.write.csv('foo.csv', header=True)
spark.read.csv('foo.csv', header=True).show()

# sonuc:
+-----+------+---+---+
|color| fruit| v1| v2|
+-----+------+---+---+
|  red|banana|  1| 10|
| blue|banana|  2| 20|
|  red|carrot|  3| 30|
| blue| grape|  4| 40|
|  red|carrot|  5| 50|
|black|carrot|  6| 60|
|  red|banana|  7| 70|
|  red| grape|  8| 80|
+-----+------+---+---+
```


