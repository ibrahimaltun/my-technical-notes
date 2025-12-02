
### Sprint Nedir?

**Tanım:** Agile/Scrum metodolojisinde sprint, belirli bir zaman araliginda (genellikle 1–4 hafta) içinde yapılacak işlerin planlandığı ve tamamlandığı döngüdür.

**Başlangıcı (Sprint Planning):** Takım, backlog’daki işleri seçer ve sprint hedefini belirler.

**Süreci:** Günlük kısa toplantılar (daily stand‑up) yapılır, ilerleme takip edilir.

**Sonu (Sprint Review & Retrospective):** Yapılan işler gösterilir, eksikler tartışılır, süreç iyileştirmeleri konuşulur.

#### Örnek Sprint (2 hafta)

**Sprint Hedefi:** Kullanıcı giriş modülünü tamamlamak.
**Seçilen işler:**
    
- Login ekranı tasarımı
- Backend API entegrasyonu
- Hata mesajları ve validasyon
- Test senaryoları yazımı

**Süre:** 14 gün
 **Sonunda:** Demo yapılır, takım retrospektifte “ne iyi gitti, ne geliştirilebilir” diye tartışır.


----

### Backlog Nedir?

**Tanım:** Agile/Scrum metodolojisinde backlog, yapılacak işlerin, görevlerin ve geliştirmelerin **önceliklendirilmiş bir listesidir**.

#### Türleri

- **Product Backlog:** Ürünün tüm ihtiyaçlarını, özelliklerini ve geliştirme fikirlerini içerir. Örneğin: “Kullanıcı giriş ekranı”, “Şifre sıfırlama özelliği”, “Performans optimizasyonu”.

- **Sprint Backlog:** Sadece o sprintte (örneğin 2 hafta) yapılacak işleri içerir. Product backlog’dan seçilen maddeler sprint backlog’a taşınır.

#### Özellikleri

- Dinamik bir listedir, sürekli güncellenir.
- Öncelik sırasına göre düzenlenir (en kritik işler en üstte).
- Her madde genellikle “user story” formatında yazılır: _“Bir kullanıcı olarak, giriş yapabilmek için e‑posta ve şifre girmek istiyorum.”_

#### Örnek Sprint Raporu Tablosu

| Görev                       | Durum        | Sorumlu  | Notlar                        |
| --------------------------- | ------------ | -------- | ----------------------------- |
| Login ekranı tasarımı       | Tamamlandı   | Ali      | UI onaylandı                  |
| Backend API entegrasyonu    | Devam ediyor | Sen      | %60 tamamlandı, test bekliyor |
| Hata mesajları & validasyon | Tamamlandı   | Ayşe     | QA’dan geçti                  |
| Test senaryoları yazımı     | Devam ediyor | Sen      | 5/10 senaryo hazır            |
| Demo hazırlığı              | Planlandı    | Tüm ekip | Sprint sonunda yapılacak      |

----

### MoSCoW Yöntemi Nedir?

MoSCoW, backlog’daki işleri önem derecesine göre sınıflandırmak için kullanılan bir yöntemdir. Adı, kategorilerin baş harflerinden gelir: **Must, Should, Could, Won’t**.


#### Must (Kesin yapılmalı)

- Sprint veya proje başarısı için **olmazsa olmaz** işlerdir.
- Örnek: _“Kullanıcı giriş ekranı”_ → Ürün çalışmazsa giriş yapılamaz, bu yüzden kesin yapılmalı.

#### Should (Yapılmalı)

- Önemli ama kritik olmayan, yapılması faydalı işlerdir.
- Örnek: _“Şifre sıfırlama özelliği”_ → Kullanıcı deneyimi için gerekli ama giriş ekranı kadar kritik değil.

#### Could (Yapılabilir)

- Zaman ve kaynak kalırsa yapılacak, **ekstra değer katan** işlerdir.
- Örnek: _“Kullanıcı avatar yükleme özelliği”_ → Ürün çalışması için şart değil ama kullanıcı deneyimini artırır.

#### Won’t (Bu sprintte yapılmayacak)

- Şu an için yapılmayacak, ileride değerlendirilebilecek işlerdir.
- Örnek: _“Sosyal medya ile giriş”_ → İleride planlanabilir ama bu sprintte öncelikli değil.


#### Örnek Backlog Önceliklendirme Tablosu (MoSCoW)

| Backlog Maddesi          | Kategori | Açıklama                                      |
| ------------------------ | -------- | --------------------------------------------- |
| Kullanıcı giriş ekranı   | Must     | Ürünün çalışması için kritik                  |
| Şifre sıfırlama özelliği | Should   | Kullanıcı deneyimini artırır                  |
| Avatar yükleme           | Could    | Ekstra değer, zaman kalırsa yapılacak         |
| Sosyal medya ile giriş   | Won’t    | Bu sprintte yapılmayacak, ileride düşünülecek |















