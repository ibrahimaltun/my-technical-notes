- Javada değerleri tutan değişkenler ve referansları tutan değişkenler vardır.

**Değerleri tutan değişkenler**
- Örneğin 11 değerini tutan integer tipinde Num1 isimli değişken
- Bu bir referans tutmaz değer tutar.
- Eğer num2'yi num1'e eşitlersek, num2'de 11 olacaktır.
- Buradaki eşitleme işlemi değerin başka bir değişkene atanması demektir. Daha sonra num1'e 22 değerini atarsanız num2 değerinde bir değişiklik olmaz ve en son atanan num1 değeri olan 11'i tutmaya devam eder.

```java
int num1 = 11;
int num2 = num1;
```

Referans Tutan Değişkenler
- map1 adında bir değişkenimiz var ve onu hashmap'e eşitledik.
- map1 aslında bu karma haritaya eşit bir değer tutmaz, bunun yerine hashmap'i işaret eden bir adres tutar. Yani bir referans tutar.
```java
map1 = {
		"value"=11
	   }
```
- Eğer aşağıdaki gibi bir eşitlik yazarsak, asla map2 map1'in eşitlendiği hashmap'e eşit olmaz, yani map2 = {"value": 11} **değildir.**
```java
map2 = map1;
```
- Aslında olan şey map2'nin map1'in adresinin referansını almasıdır. Yani map2'de map1'in gösterdiğini gösterir.
- Burada map1 için 11 değerini 22'ye eşitlersek, map2 de artık value için 22 değerini gösterecektir, çünkü aynı hashmap'i işaret etmektedir.
- Şimdi map3 tanımlayalım ve map2'te eşitleyelim.
```java
map3 = {
		"value"=57
	   }

map2 = map3;
```
- Böylecek map2 artık map3'ün HashMap'ini işaret edecektir.
- Şimdi map1'i de map3 atayalım. Böylecek map1 de map3'ün işaret ettiği HashMap'i gösterecektir. Ve başta tanımli value=11 HashMap boşta kalacaktır. Yani hiçbir değişken buna işaret etmemektedir. Bu bellekte bir yer kaplar ve Java bu tarz değerleri sürekli kontrol eden yapısı Garbage Collection ile bunu temizler.

- Bu yapıyı LinkedList içinde node'lara işaret etme de kullanacağız.