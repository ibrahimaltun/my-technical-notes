- Bir array listesi ile linked listesi arasındaki farklara bakacağız. Bu iki liste yaygın olarak birbiriyle kıyaslanırlar. 
- Linked listeleri de Array listeleri gibi dinamik uzunluktadır. Halbuki array'lerin uzunluğu sabittir.

| 87  | 56  | 11  | 190 | 10  | 1   | 55  |
| --- | --- | --- | --- | --- | --- | --- |
| 1   | 2   | 3   | 4   | 5   | 6   | 7   |
- Linked Listeler üste gösterilmiş ve indekse sahip değildir.
![[Screenshot from 2025-11-04 14-49-24.png]]
**Fark1**: Bu 2 liste arasındaki ilk fark Linked listesinde index olmamasıdır. Array listeleri ise öğeleri için bir indekslemeye sahiptir.

![[Screenshot from 2025-11-04 14-49-24.png]]

**Fark2**: Diğer fark ise Linked listeleri bellekte yayılmış şekilde tutulurlar. Array'ler gibi sıralı tutulmazlar.

- Array aşağıdaki gibi bellekte yerleşir.
![[Screenshot from 2025-11-04 14-48-27.png]]

- Linked Listelerinde ilk node'u gösteren **head** ve son node'u gösteren **tail** değişkenleri vardır. Bu 2 değişken de **pointer** olarak ifade edilebilir.
- Her node'un pointer'ı olacaktır ve bir sonraki node'u işaret edecektir ve o da bir sonrakini ve bu şekilde devam eder. Ta ki sona gelen kadar. 
- Son node da bir pointer'a sahiptir. Fakat son node sadece bir null ifadeyi gösterir yani hiçbir şeyi. Fakat yine de bir değişkene sahiptir.
- Linked listeler bellekte aşağıdaki gibi bir yerleşime sahiptirler.

![[Screenshot from 2025-11-04 14-47-47.png]]


