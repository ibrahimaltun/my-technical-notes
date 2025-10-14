
*Bir veri kümesinde normalden sapma gösteren olağandışı durumları tespit etme sürecidir. Bu yöntem, özellikle büyük veri sistemlerinde, beklenmeyen olayları veya hataları erkenden fark etmek için kullanılır.* 

### Anomali Türleri

1. **Point Anomaly (Noktasal Anomali)**  

Tek bir veri noktası normalden sapar. Örnek: CPU kullanımının aniden %95’e çıkması.

2. **Contextual Anomaly (Bağlamsal Anomali)**  

Veri, bulunduğu bağlamda anormaldir. Örnek: Gece saatlerinde web trafiğinin aniden artması.

3. **Collective Anomaly (Kolektif Anomali)**

Bireysel olarak normal görünen veri noktaları, birlikte değerlendirildiğinde anormal bir örüntü oluşturur. Örnek: Birden fazla servisin ardışık olarak yavaş yanıt vermesi


### Methods for Anomaly Detection

#### Isolation Forest

IF implementation steps
1. Random Partitioning
2. Isolation Path
3. Ensemble of Trees


#### Facebook Prophet

https://facebook.github.io/prophet/
https://pypi.org/project/prophet/



####  ARIMA (AutoRegressive Integrated Moving Average)




----
### Difference Between crucial keywords

#### 🔮 Forecasting

- **Definition**: Forecasting is the process of projecting future values based on historical data.
- **Example**: “Forecast next month’s electricity demand using past 5 years of hourly data.”
(Geçtiğimiz 5 yılın saatlik verilerini kullanarak gelecek ayın elektrik talebini)

#### 🎯 Prediction
- **Definition**: Prediction is about determining an unknown outcome based on input features, regardless of time.
- **Example**: “Predict whether a customer will churn based on their usage behavior.”
(Bir müşterinin kullanım davranışına göre vazgeçip vazgeçmeyeceğini)

#### 📏 Estimation

- **Definition**: Estimation refers to inferring parameters or values, often during model training.
- **Example**: “Estimate the slope of the line that best fits the data.”
(Verilere en uygun çizginin eğimini)

------
