* ***LSTM**'deki Short ifadesi bir önceki sinir hücrelerinden çıkışını ifade ederken, Long ifadesi RNN yapısından gradayn kaybolmasını(**Vanishing Gradient**) çözmek için geliştiirlmiştir. **RNN** problmeini çözen bir sonraki adımıdır. 
* LSTM genelde sekans verilerinin tahmininde kullanılır. Sekans verilerinden gelen veri her zaman bir önceki veriye bağlıdır. Bu ilişkiyi kaybetmemek gerektiğinden dolayı **LSTM** geliştirilmiştir.
* Zaman serisi, ardışık verilerde, metin üretiminde, müzik besteleme gibi alanlarda kullanılır.
* Geleneksel RNN'lerdeki kısa süreli hafıza sorununa uzun süreli hafıza tekniğiyle yaklaşır.
* LSTM bir nevi hafıza görevi gören özel hücreler kullanır. Bu hücreler hangi verilerin saklanacağını veya unutulacağına karar verir.
* LSTM input gate, forget gate, output gate olarak adlandırılan 3 kapı sayesinde bilgi akışını dinamik olarak yönetir. Bu sayede model önemli bilgileri hatırlarken gereksiz bilgileri unutur.

**C**: Önceki tüm girişlerden gelen veriler
**h**: Bir önceki sinir hücresinden gelen veri
**X**: girdi

---

**Geleneksel Yöntemler**:
1. Doğrusal Modeller(ARMA, ARIMA),
2. Doğrusal Olmayan Modeller(ARCH, GARCH, TAR, NAR, NARX)

**Makine Öğrenme Yöntemleri**: SVM, ANN, DT
**Derin Öğrenme Yöntemleri**: RNN, LSTM, GRU

 
**Zaman Serilerinde Çerçeveleme**

Karar verilmesi gerekenler
- Tahmin adım sayısı(Kaç sonraki veri tahmin edilecek)
- Çıktının boyut sayısı
- Multivariate vs Univariate
- Zaman gecikmesi(kac önceki veri ile tahmin yapılacak)

Zaman Serilerini diğer tabular verilerden ayıran en önemli fark verilerin sıralı bir şekilde önceki noktalara bağlı olmasıdır.

**C**: Cell State
**h**: Hidden State



