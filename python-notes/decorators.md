
### 1. @staticmethod

`@staticmethod`, Python'da bir sınıfın içinde tanımlanan ama **ne sınıfın kendisine (**`cls`**) ne de örneğine (**`self`**) ihtiyaç duymayan** metotları belirtmek için kullanılan bir dekoratördür. Bu metotlar, sınıfla **mantıksal olarak ilişkili** olabilir ama teknik olarak sınıfın durumuna erişmezler.

- Sınıfın bir örneğine ihtiyaç duymadan çalıştırılabilen yardımcı fonksiyonlar tanımlamak için kullanılır.
- Kodun **daha düzenli ve anlamlı** olmasını sağlar: Fonksiyon sınıfla ilgiliyse ama örnekle ilgili değilse, onu sınıfın içinde tutmak mantıklıdır.
- **Modül seviyesindeki fonksiyonlar** gibi çalışır ama sınıfın içinde tanımlanır.

```python
class Geometri:
    @staticmethod
    def daire_alan(r):
        return 3.14159 * r * r
```

Bu metodu şu şekilde çağırabilirsin:
```
Geometri.daire_alan(5)  # 78.53975
```

```
g = Geometri()
g.daire_alan(5)  # Aynı sonucu verir
```

| Durum                                                           | `@staticmethod` Kullanımı   |
| --------------------------------------------------------------- | --------------------------- |
| Sınıfla mantıksal ilişkili ama `self` veya `cls` kullanmıyorsan | ✅ Evet                      |
| Fonksiyon tamamen bağımsızsa ve sınıfla ilgisi yoksa            | ❌ Modül seviyesinde tanımla |
| Fonksiyon sınıfın durumuna erişiyorsa (`self`)                  | ❌ `@staticmethod` kullanma  |
| Fonksiyon sınıfın yapısına erişiyorsa (`cls`)                   | ❌ `@classmethod` kullan     |

**🎯 Gerçek Hayattan Örnek**
``` python
class Koordinat:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    @staticmethod
    def mesafe(p1, p2):
        return ((p1.x - p2.x)**2 + (p1.y))
```


### 2. @classmethod

`@classmethod`, Python'da bir sınıfın **kendisine (**`cls`**) bağlı** olan metotları tanımlamak için kullanılan bir dekoratördür. Bu metotlar, sınıfın örneğine (`self`) değil, doğrudan sınıfın kendisine erişim sağlar. Yani sınıfın genel durumunu değiştirmek veya sınıf düzeyinde işlem yapmak istiyorsak `@classmethod` bu is icin uygundur.

- Sınıfın **class-level attribute**'larına erişmek ve değiştirmek için kullanılır.
- Sınıfın kendisini parametre olarak alır (`cls`), böylece alt sınıflarla da uyumlu çalışır.
- Genellikle **alternatif constructor** (örneğin `from_dict`, `from_json`) gibi yapılar için tercih edilir.

``` python
class Gemi:
    gemi_sayisi = 0

    def __init__(self, isim):
        self.isim = isim
        Gemi.gemi_sayisi += 1

    @classmethod
    def toplam_gemi(cls):
        return cls.gemi_sayisi
```

``` python
print(Gemi.toplam_gemi())  # Sınıf örneği olmadan çağrılabilir
```

| Durum                                                           | Kullanım                             |
| --------------------------------------------------------------- | ------------------------------------ |
| Sınıfın genel durumunu değiştirmek istiyorsan                   | ✅ `@classmethod`                     |
| Alternatif yapıcı (constructor) tanımlamak istiyorsan           | ✅ `@classmethod`                     |
| Sınıf örneğiyle çalışıyorsan (`self`)                           | ❌ `@classmethod` değil, normal metot |
| Sınıfla mantıksal ilişkili ama `cls` veya `self` kullanmıyorsan | ❌ `@staticmethod` daha uygun         |

**ORNEK**
``` python
class Nokta:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    @classmethod
    def from_tuple(cls, tup):
        return cls(tup[0], tup[1])
```

``` python
p = Nokta.from_tuple((3, 4))
```


### 3. @abstractmethod

@abstractmethod, Python'da soyut (abstract) metot tanımlamak için kullanılan bir dekoratördür. abc (Abstract Base Class) modülünden gelir. Bu yapı, nesne yönelimli programlamada zorunlu davranışları tanımlamak ve tutarlılığı sağlamak için kullanılır.
 
- Bir sınıfın alt sınıflarının mutlaka belirli metotları tanımlamasını zorunlu kılar.
- Kodun standart bir arayüzle çalışmasını sağlar.
- DRY (Don't Repeat Yourself) prensibini destekler: Aynı işlevi tekrar tekrar yazmak yerine ortak bir soyut sınıfta tanımlarsın.

 ``` python
from abc import ABC, abstractmethod

class Arac(ABC):
    @abstractmethod
    def hareket_et(self):
        pass
 ```
Bu örnekte Arac soyut bir sınıftır ve hareket_et metodu soyut metottur. Bu sınıftan türeyen her sınıf mutlaka hareket_et metodunu tanımlamalıdır.

``` python
class Araba(Arac):
    def hareket_et(self):
        print("Araba ilerliyor")

class Gemi(Arac):
    def hareket_et(self):
        print("Gemi yüzüyor")
```
 
Ne Olmaz?

- Soyut sınıflar doğrudan örneklenemez:

```
a = Arac()  # TypeError: Can't instantiate abstract class
```

Alt sınıf soyut metodu tanımlamazsa yine hata alırsın.

Ne İçin Kullanılır?
- Ortak davranışları zorunlu kılmak için (örneğin tüm taşıtlar hareket_et yapmalı).
- Kodun genişletilebilirliğini ve okunabilirliğini artırmak için.
- Polimorfizm ile birlikte kullanıldığında, farklı sınıfların aynı arayüzü paylaşmasını sağlar.

