## Big-O

- Benzer işleri gerçekleştiren kodların olduğunu varsayalım. Bu 2 kod birbirlerine göre nasıl karşılaştırılırlar? Kod 1 daha iyi okunabilir olabilir bu yüzden daha iyidir denebilir ya da  kod 2 daha kesin iş yapıyordur bu yüzden daha iyi olabilir.
- Tam olarak bu noktada **Big-O** devreye girer ve matematiksel olarak hangi kodun daha **verimli** çalıştığını birbirine göre karşılaştırmanın bir yolunu sağlar.
- Diyelim ki bir stopwatch'ımız var. Kod 1'i çalıştırırz ve kronometreyi başlatırız, 15sn sürer. Ardından stopwatch'ımızı resetleriz ve Kod 2'yi çalıştırırız 1dk sürer. Bu sonuçlara göre Kod 1, Kod2'den daha iyi diyebilirsiniz. Bu **Time Complexity** olarak adlandırılır. İlgi çekici bir şeydir ve zamanla ölçülmez. Aslında kodun zamanını ölçebiliriz. Bu daha çok çalışan bilgisayarın hızını ifade eder. Biz daha çok kod içinde gerçekleşen işlemlerin zamanını merak ediyoruz.
- Bir de **Space Complexity** kavramımız vardır. Diyelim ki Kod 1 çok hızlı çalıştı fakat çalıştığı süre zarfında bellekte çok yer kullandı. Kod 2 ise tamamlanması uzun sürmüş olsa da bellekte daha az yer kullandi.
- Bellekte kullanilan yer en önemli önceliğimiz ise ve kodun uzun sürede tamamlanması önemli değilse Kod 2 çok daha iyidir denebilir.

* Time ve Space Complexity'ler ile ilgilenirken 3 yunan harfi göreceğiz. 
Omega: **Ω**
Theta: **Θ**
Omicron: **O**

Bu karakterleri bir örnekle açıklayalım. Bir array üzerinde bir for döngüsü kullanıyoruz varsayalım,

| 1   | 2   | 3   | 4   | 5   | 6   | 7   |
| --- | --- | --- | --- | --- | --- | --- |


for döngüsü 1'den 7'ye doğru olacaktir ve benim aradığım değere göre durumlarım değişecektir. 

Best case'im 1'dir çünkü döngünün ilk değerini aıyorumdur ve ilk iteration da bulurum
Worst case'ım ise 7'dir çünkü tüm döngünün sonunda 7'yi bulurum.
Average case'im ise 4'tür çünkü döngünün orta noktasıdır.

Big-O Best Case için Omega: **Ω**,
Big-O Average Case için Theta: **Θ**,
Worst Case için Omicron: **O** kullanırız. 

**İnsanlar ne zaman average big-o ve best big-o söyleyceksin diye sorabilirler. Aslında telnik olarak average case ve best case yoktur**

> Big-O average case theta olacaktır. Big-O best case ise omega olacaktır.
> İnsanlar bu şekilde söylemek isteyecektir. Fakat teknik olarak **Big-O** her zaman **Worst Case**'dir.

### Big-O Notations

#### O(n)

En verimli ya da en az verimli olmadigindan bunula başladık. Ayrıca anlaması en basit olandır.

Bu notasyonu/gosterimi basit bir kod ile anlamaya calisalim.

Aşağıdaki kod bir method içerir, bu method bir n tam sayı değeri alır ve 0'dan n'e kadar sayıları ekrana yazdırır. Yani n=10 verirsek 0'dan 9'a kadar olan rakamları ekrana yazdırır.

``` java
public class Main {  
      
    public static void main(String []args) {  
        printItems(10);  
    }  
  
    public static void printItems(int n) {  
        for (int j=0; j<n; j++) {  
            System.out.println(j);  
        }  
    }  
}
```

* Bu yüzden bu kod **O(n)**'dir deriz. Çünkü n tane değerimiz vardır ve for döngümüzde 10 tane işlem gerçekleştiririz. Bunu bir grafiğe döksek n, x eksenini ifade ederken, y eksenimiz ise işlem sayımızı ifade eder. Bu grafikte her zaman O(n) bir doğru şeklinde olacaktır. Buna proportional(orantılılık) denir.

![Pasted image 20250908113836.png](/images_for_notes/Pasted%20image%2020250908113836.png)


#### Drop Constants

Diyelimki kodumuzu aşağıdaki şekilde güncelledik ve for döngü sayımızı 2 tane yaptık böyle olunca 0-9 arasındaki rakamları 2 defa ekrana basacaktır. 

``` java
public class Main {  
      
    public static void main(String []args) {  
        printItems(3);  
    }  
  
    public static void printItems(int n) {  
        for (int i=0; i<=n; i++) {  
            System.out.println(i);  
        }  
  
        for (int j=0; j<=n; j++) {  
            System.out.println(j);  
        }  
    }  
}
```

* Burada her bir for döngümüz için n işlem vardır. Toplamda n + n = 2n işlem vardır ve Big-O gösterimimiz O(2n) olmasını bekleriz. Fakat bunu basitleştirmek için constant olan 2 değerini düşürüyoruz. Böylece sadece O(n) olur.
* Burada sabitin kaç olduğunun önemi yoktur. 2, 10 veya 100 olsa bile sabiti kaldırırız. O(n) kalır.
* Basitleştirmenin ilk kuralı budur: **Drop Constant**


#### O(n^2)

Önceki kodumuzu O($n^2$) yapmak için bir for loop'u diğerinin içine alırız.

i ve j yi toplama yapmayıp gerçek çıktıyı görmek için araya boş bir String ifade ekleyelim.

``` java
public class Main {  
      
    public static void main(String []args) {  
        printItems(3);  
    }  
  
    public static void printItems(int n) {  
        for (int i=0; i<=n; i++) {
	        for (int j=0; j<=n; j++) {
                System.out.println(i + " " + j);
            }
        } 
    }  
}
```

Çıktıya baktığımız zaman önce ilk i değeri 0 ve sonra tüm j değerleri şeklinde bir yapı ilerler.

* Buradan yola çıkarak döngüler n * n = $n^2$ şeklinde çalışır.
* Diyelimki n'e 10 değerini verdik çıktımızda 100 satırımız olacaktır.

![Pasted image 20250916093409.png](/images_for_notes/Pasted%20image%2020250916093409.png)


* O(n) ile kıyaslandığında çok çok hızlı bir şekilde büyüdüğünü görüyoruz. Time Complexity açısından bunun anlamı daha az verimli demektir.
* Eğer O($n^2$) olan bir kodunuz varsa ve bu kodu yeniden yazabiliyorsanız, kodunuzu O(n) yapmak devasa bir verim kazancı sağlayacaktır.



#### Drop Non-Dominants

- Big-O'yu basitleştirmek için diğer bir yol
- O($n^2$) deki nested for döngülerimizi düşünelim. Bu kodumuza bir tane daha ayrık ve bağımsız bir for loop eklediğimizi düşünelim.
``` java
public class Main {  
      
    public static void main(String []args) {  
        printItems(3);  
    }  
  
    public static void printItems(int n) {  
        for (int i=0; i<n; i++) {
	        for (int j=0; j<n; j++) {
                System.out.println(i + " " + j);
            }
        } 
		for (int k=0; k<n; k++) {
            System.out.println(k);
        }
    }  
}
```

- Önceki çıktıya ilaveten en sonunda 0'dan 9'a rakamları ekrana basacaktır.
- Şimdi bunun Time Complexity sine bakalım. 
	- Nested for loop kısmı O(n^2) dir.
	- Sonradan eklediğimiz k değişkenli olan döngü ise O(n) dir.
- Toplam işem sayısını almak istediğimizde bunları toplarız: O(n^2) + O(n) = O(n^2 + n)
- Burada n'e bir değer verdiğimizde n^2 çok hızlı büyüyecektir. Örneğin n=100 dersek n^2 10.000 işlem oalcak ve bağımsız for döngüsü ise 100 işlem olacaktır.
- Burada n^2 dominant terimi ve n ise dominant olmayan terimdir.
- Çünkü n^2 çok çok büyük bir değer oldu ki n değeri n^2 değerinin yanında çok alakasız kaldı.
- Bu yüzden n değerini düşürürüz bu da bir diğer basitleştirme kuralıdır.


#### O(1)

- Aşağıdaki gibi bir kodumuz olduğunu varsayalım
 
``` java
public class Main {  
      
    public static void main(String []args) {  
        addItems(3);  
    }  
  
    public static int addItems(int n) {  
        return n + n;
    }
}
```

- Burada n ister 5 olsun istersek 1 milyar olsun farketmeyecektir. Nihayetinde 1 tane toplama işlemidir. Bu yüzden O(1) olarak ifade edilir.
- Diğer notasyonlarda olduğu gibi burada rakamın artmasıyla işlem artmayacaktır. n değeri artsa bile yapılan işlem sayısı aynıdır.
- Diyelim ki kodu aşağıdaki şekilde güncelledik. 
``` java
    public static int addItems(int n) {  
        return n + n + n;
    }
```
- Artık 2 tane işlemimiz oldu. 2 tane toplama işlemi ve Big-O için O(2) diyebiliriz.
- Unutmayalım burada drop constant basitleştirme kuralımızdan yine O(1) olacaktır.
- O(1) ayrıca **constant time** olarak adlandırılır.
- Bu yalnızca bir işlem olacağı anlamına gelmez. Bu n büyüse bile işlem sayısının sabit kalacağı anlamına gelmektedir.
- **O(1) en verimli Big-O'dur.**
- Eğer bir şeyleri O(1) zamanında yapabilirsek bu diğer her şeyden daha verimli olacaktır.
![[Pasted image 20250916142050.png]]

#### O(log n)

| 1   | 2   | 3   | 4   | 5   | 6   | 7   | 8   |
| --- | --- | --- | --- | --- | --- | --- | --- |

Bunu açıklamak için sıralanmış bir array'i ele alalım. Diyelim ki bu array'de belirli bir rakamı arıyoruz. 1 değerini arayalım. Bu değeri bu array'de bulmak için en hızlı yol nedir?

1. Array'i ortadan ikiye böleriz ve 1 değeri sol kısımda kalır, sağ kısımda kalan değerlere ihtiyacım yoktur ve kaldırırız.

| 1   | 2   | 3   | 4   |
| --- | --- | --- | --- |

2. Aynı işlemi tekrarlarız. 1 olan kısmı al ve kalanı yoksay

| 1   | 2   |
| --- | --- |

3. Sonra tekrar yap ve puff 1 değerini bulduk. 

| 1   |
| --- |

* Şimdi array'deki tüm öğeleri düşünelim ve kaç adımda istediğimiz değeri bulduk: **3 adım** ve öğe sayımız ise 8'dir buradan şöyle bir eşitlik elde ederiz. **2^3=8**
* Şimdi bunu logaritmaya çevirelim: $log_28=3$
* Bu eşitlikten şunu söyleyebiliriz 2'nin hangi üs değeri 8'e eşittir. Yani   $2^?=8$  ya da $log_28=?$
* ~~Diğer bir deyişle 8 sayısını kaç kez yarıya bölerseniz 2'ye eşit olur. cevap:3~~ 

> Bu işlem belki 8 öğeli bir dizide verimli gözükmeyebilir fakat 1 milyondan fazla öğe olduğunu düşünün!

Peki çok daha büyük bir sayıyla uğraşmamız gerekirse, örneğin $log_21,073,741,824$
* Bu sayıyı kaç kez bölmeniz gerekir ki 1 tane öğeye ulaşabilesiniz? **31**
* Milyarlarca öğeye sahip bir array'iniz olabilir, burada herhangi bir öğeyi bulmak için sadece 31 adım gereklidir. İşte bu O($log_2n$)'in gücüdür. Aşağıda grafiği vardır.

![[Pasted image 20250924140809.png]]

- Oldukça düz ve verimlidir. O(1) kadar verimli olmasa da ondan sonraki en iyisidir.
- Bu eğitimde bu **4 adet Big-O gösterimleri** kullanılacaktır.
- Bunlara ilave olarak bir de O(n logn) vardır ve bazı sıralama algoritmalarıyla kullanılmıştır. Bunları quicksort ve mergesort ile birlikte göreceğiz.
- Bunlar dışındaki hepsi sadece 4 tanedir: **O(n), O($n^2$), O(1) ve O($log_2n$)**



#### Different Terms for Inputs
- Big-O'daki sonraki önemli kuralımız, girdi için farklı terimlerin analizi.
- Önceden gördüğümüz kodlar üzerinden bu durumu izah edelim.
``` java
public static void printItems(int n) {  
	for (int i=0; i<=n; i++) {  
		System.out.println(n);  
	}  

	for (int j=0; j<=n; j++) {  
		System.out.println(n);  
	}  
}  
```
* Her iki döngü için O(n) deriz ve toplamı O(2n) olur drop constant kuralımızdan bu metot için O(n) deriz.

PEKİ methodumuz aşağıdaki gibi 2 girdi alırsa ne olacak? (Bu popular bir mülakat sorusudur.)

``` java
public static void printItems(int a, int b) {  
	for (int i=0; i<=a; i++) {  
		System.out.println(a);  
	}  

	for (int j=0; j<=b; j++) {  
		System.out.println(b);  
	}  
}  
```
- O(n) + O(n) = O(2n) burdanda O(n) mi? **HAYIR** bu şekilde olmaz çünkü ne a ne de b kendi başlarına n'e eşit değildir.
- Bundan dolayı ilk döngü O(a) ve ikinci döngü O(b) olacaktır. Bu ise O(a+b) olur. Çünkü a değeri milyon ve b değeri ise milyar olabilir. Bu 2 değer for döngümüz için birbirinden oldukça farklıdır. Buradan bir methodun herbir değerinin ne kadar Time Complexity'si olacağını anlayabiliriz.

Diyelim ki bu 2 değer alan method içinde iç içe for loop'lar var. O zaman ise O(a * b) olacaktır.
``` java
public static void printItems(int a, int b) {  
	for (int i=0; i<=a; i++) {
		for (int j=0; j<=b j++) {
			System.out.println(a + " " + b);
		}
	} 
}  
```

![[Pasted image 20250916142150.png]]
#### Array Listesi için Big-O 
#### Big-O Wrap Up
