## 🛠️ **conf/spark-defaults.conf**


The file located at `$SPARK_HOME/conf/spark-defaults.conf` is a **configuration file** used by Apache Spark to define default settings for Spark applications. It allows you to set key-value pairs that Spark will automatically apply when launching jobs, without needing to specify them manually each time.

---

**Purpose of `spark-defaults.conf`**

This file acts like a global preferences sheet for Spark. It’s read by Spark components (like `spark-submit`, `pyspark`, `spark-shell`) to apply consistent settings across all jobs.

---

**Common Settings You Might See**

Here are typical entries you might include:

```properties
spark.master                     local[*]
spark.app.name                   MySparkApp
spark.executor.memory            4g
spark.driver.memory              2g
spark.sql.shuffle.partitions     8
spark.eventLog.enabled           true
spark.eventLog.dir               file:/tmp/spark-events
```

**What Each Setting Means**

|Setting|Description|
|---|---|
|`spark.master`|Defines the cluster manager (e.g., `local[*]`, `yarn`, `spark://host:port`)|
|`spark.app.name`|Default name for Spark applications|
|`spark.executor.memory`|Memory allocated per executor|
|`spark.driver.memory`|Memory allocated to the driver process|
|`spark.sql.shuffle.partitions`|Number of partitions used during shuffle operations|
|`spark.eventLog.enabled`|Enables logging of Spark events|
|`spark.eventLog.dir`|Directory where event logs are stored|

 **How to Use It**

1. Create or edit the file:
```bash
nano $SPARK_HOME/conf/spark-defaults.conf
```

2. Add your preferred settings.
3. **Restart Spark services if running in cluster mode.**

---

## 🛠️ conf/spark-env.sh

The `$SPARK_HOME/conf/spark-env.sh` file is a **shell script** used to configure environment variables for Spark's runtime behavior. Unlike `spark-defaults.conf`, which sets Spark application properties, `spark-env.sh` controls **system-level settings** like memory, CPU cores, and paths used by Spark daemons (master, workers, history server, etc.).

 **Purpose of `spark-env.sh`**

- You want to **set up Spark infrastructure** (e.g., memory per worker, Java path).
- You're configuring a **cluster or daemon behavior**.

It sets environment variables that affect:

- Spark master and worker processes
- Logging
- Resource allocation
- JVM options
- Hadoop integration


**Example `spark-env.sh` Settings**

```bash
export JAVA_HOME=/usr/lib/jvm/java-11-openjdk
export SPARK_MASTER_HOST=localhost
export SPARK_WORKER_CORES=4
export SPARK_WORKER_MEMORY=4g
export SPARK_DRIVER_MEMORY=2g
export SPARK_EXECUTOR_MEMORY=2g
export SPARK_LOG_DIR=/opt/spark/logs
export SPARK_PID_DIR=/opt/spark/pids
```

==**What Each Variable Does**==

| Variable                | Description                         |
| ----------------------- | ----------------------------------- |
| `JAVA_HOME`             | Path to your Java installation      |
| `SPARK_MASTER_HOST`     | Hostname for Spark master node      |
| `SPARK_WORKER_CORES`    | ==Number of CPU cores per worker==  |
| `SPARK_WORKER_MEMORY`   | ==Memory allocated to each worker== |
| `SPARK_DRIVER_MEMORY`   | Memory for the driver process       |
| `SPARK_EXECUTOR_MEMORY` | Memory for each executor            |
| `SPARK_LOG_DIR`         | Directory for Spark logs            |
| `SPARK_PID_DIR`         | Directory for PID files             |

**How to Use It**

1. Copy the template:
```bash
cp $SPARK_HOME/conf/spark-env.sh.template $SPARK_HOME/conf/spark-env.sh
```

2. Edit the file:
```bash
nano $SPARK_HOME/conf/spark-env.sh
```

3. Make it executable:

```bash
chmod +x $SPARK_HOME/conf/spark-env.sh
```

--- 
## 🛠️  conf/log4j.properties
.
.
.

---

## 🛠️  SparkSession.builder.config() vs spark-env.sh

Understanding the difference between `SparkSession.builder.config()` and the `spark-env.sh` file is key to mastering how Spark behaves at both the **application** and **system** levels.

| Feature      | `SparkSession.builder.config()`                             | `spark-env.sh`                                           |
| ------------ | ----------------------------------------------------------- | -------------------------------------------------------- |
| Scope        | **Application-level** settings                              | **System-level** environment variables                   |
| Purpose      | Customize Spark behavior for a specific job or session      | Configure Spark daemons (master, worker, history server) |
| Format       | Python method calls (used in code)                          | Bash shell script (used by Spark services)               |
| Location     | Inside your PySpark or Scala code                           | `$SPARK_HOME/conf/spark-env.sh`                          |
| Examples     | `spark.builder.config("spark.sql.shuffle.partitions", "8")` | `export SPARK_WORKER_MEMORY=4g`                          |
| When Applied | At runtime when SparkSession is created                     | When Spark daemons start up                              |
| Affects      | Only the current SparkSession                               | All Spark processes on the node                          |


Use `SparkSession.builder.config()` When…

- You want to **tune settings per job** (e.g., memory, shuffle partitions, app name).
- You're writing PySpark code and need **dynamic configuration**.
- Example:
```python
spark = SparkSession.builder \
	.appName("MyApp") \
	.config("spark.executor.memory", "2g") \
	.config("spark.sql.shuffle.partitions", "8") \
	.getOrCreate()
```

 **Use `spark-env.sh` When…**

- You want to **set up Spark infrastructure** (e.g., memory per worker, Java path).
- You're configuring a **cluster or daemon behavior**.

Example:
```bash
export JAVA_HOME=/usr/lib/jvm/java-11-openjdk
export SPARK_WORKER_CORES=4
export SPARK_WORKER_MEMORY=4g
```

**Summary**

- `SparkSession.builder.config()` is for **fine-tuning your job**.
- `spark-env.sh` is for **setting up your Spark environment**.

---



