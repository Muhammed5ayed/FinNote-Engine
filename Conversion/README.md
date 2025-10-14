# conversion
<p dir="rtl">
الهدف من هذا المشروع هو انشاء محول يدعم التحويلات اللازمة للعمليات الحسابية الاساسية
</p>

1. String --> Double
2. Byte --> BigDecimal
3. Short --> BigDecimal
4. Integer --> BigDecimal
5. Long --> BigDecimal
6. Float --> BigDecimal
7. Double --> BigDecimal
8. Boolean --> BigDecimal
9. String --> BigDecimal
10. BigDecimal --> Byte
11. BigDecimal --> Short
12. BigDecimal --> Integer
13. BigDecimal --> Long
14. BigDecimal --> Float
15. BigDecimal --> Double
16. BigDecimal --> Boolean
17. BigDecimal --> String

<p dir="rtl">
اذا لم يوجد اى Conversion سيقوم بانشاء واحد باسم app.conversion.MathConversion.conversion وحقنه فى ال Application Context
</p>

<p dir="rtl">
ملحوظة لا تستخدم لامبدا او اى طرق اختصار الكود لانشاء Conversion فكافة هذه الطرق تسبب ارتباك ل JVM فيعجز عن تفسير النوع الصحيح
</p>
<h3 dir="rtl">
الطريقة الصحيحة لانشاء Conversion
</h3>

```java
import org.springframework.core.convert.converter.Converter;

Converter<String, Double> converter = new Converter<String, Double>() {
    @Override
    public Double convert(String source) {
        return 0.0;
    }
};
```

<p dir="rtl">
ستلاحظ انه لم يتم استخدام اى طرق من طرق اختصار الكود
</p>