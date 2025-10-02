
##### 100GB boyuta sahip bir veriyi nasil verimli bir sekilde nasil isleyebiliriz?


**Gerekli Executor Core Sayısı**

- Spark’ta varsayılan bir partition boyutu: **128MB**
- 100GB = 102400MB → 102400 / 128 = **800 partition**
- Yani **800 executor core** gerekir (her core bir partition işler)

**Gerekli Executor Sayısı**

- Genelde bir executor’da **2–5 core** olması önerilir
- Diyelim ki her executor’da 4 core var → 800 / 4 = **200 executor**

**Executor Belleği**

- Her core için önerilen bellek: **4 × 128MB = 512MB**
- 4 core’lu bir executor için: 4 × 512MB = **2GB**
- 200 executor × 2GB = **400GB toplam bellek**

**🕒 İşlem Süresi**

- Tüm görevler paralel çalışırsa, her biri 5 dakikada bitiyorsa → **100GB veri 5 dakikada işlenir!**

**Driver Belleği**

- Eğer `df.collect()` yapıyorsan → **100GB driver belleği** gerekebilir
- Sadece çıktıyı diske yazıyorsan → **4GB yeterli** (2 × executor belleği)