- Veri Yapılarını oluşturmak istediğimizde sınıflar çok önemli konular haline gelir.
- Class'lar bir Cookie Kesiciye benzerler. Cookie kesici aslında bir cookie değildir. Fakat cookie kesici kullanarak bir cookie oluşturabiliriz.
- Şimdi aşağıda bir Cookie isimli class oluşturalım. Class'lar, class değişkenlerine sahiptir.
- Burada değişkenler için private yapmak best practice'dir.
- Sınıflarımız içinde metotlarımız vardır. İlk methodumuzu constructor ismiyle oluştururuz. Bu method bize cookie cutter kullanarak yeni bir cookie oluşturmamıza yardımcı olacak.
- Constructor Method her zaman class adını alır. Bundan dolayı Cookie olarak adlandıracağız ve constructor çalştırdığımızda color parametresini bu methoda geçireceğiz. Bu color'ın ne olduğunu bize söyleyecek. Aşağıdaki şekilde atamayı tamamlayacağız.

```java
public class Cookie {
	private String color;
	
	public Cookie(String color) {
		this.color = color;
	}
}
```

- Bir kez bu class'ı oluşturduğumuzda, tipi Cookie olan yeni bir değişkeni aşağıdaki şekilde oluşturabiliriz.
- Aşağıdaki örnekte Cookie sınıfının instance'ı, cookieOne olarak adlandırılır.
- Bu instance'ın tipi Cookie sınıfındadır.
- Burada new keyword'ü kullanılmıştır. new, constructor'ı çalıştırma işlemini yapmaya yarar.
- Bu constructor'a green rengi verilmiştir. Ve böylece bize yeşil bir cookie oluşturacaktır.

``` java
Cookie cookieOne = new Cookie("green");
```

* Bu class içine başka method'lar da tanımlayabiliriz. Örneğin belirli bir cookie instance'ının rengini dönen bir metot.
* Ayrıca başka bir metot olan setColor metodunu da sahip olabiliriz. Bu metot da verilen color değerini göre ilgili cookie instance'ına ait rengi değiştirecektir.

```java
public class Cookie {
	private String color;
	
	public Cookie(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
}
```

* Bu tanımlamaların çıktısını görmek için aşağıdaki şekilde instance oluşturabiliriz.

```java
Cookie cookieOne = new Cookie("red");
Cookie cookieTwo = new Cookie("blue");

System.out.println(cookieOne.getColor());
System.out.println(cookieTwo.getColor());

cookieOne.setColor("black");
System.out.println(cookieOne.getColor());

```
