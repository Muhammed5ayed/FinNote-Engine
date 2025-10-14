package app;

import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.ConversionService;

import java.math.BigDecimal;

@SpringBootTest
class TestConversion {

    @Autowired
    ConversionService service;

    @Test
    void contextLoads() {
        Assertions.assertTrue(service.canConvert(Byte.class, BigDecimal.class));
        Assertions.assertTrue(service.canConvert(Short.class, BigDecimal.class));
        Assertions.assertTrue(service.canConvert(Integer.class, BigDecimal.class));
        Assertions.assertTrue(service.canConvert(Long.class, BigDecimal.class));
        Assertions.assertTrue(service.canConvert(Float.class, BigDecimal.class));
        Assertions.assertTrue(service.canConvert(Double.class, BigDecimal.class));
        Assertions.assertTrue(service.canConvert(Boolean.class, BigDecimal.class));
        Assertions.assertTrue(service.canConvert(String.class, BigDecimal.class));

        Assertions.assertTrue(service.canConvert(BigDecimal.class, Byte.class));
        Assertions.assertTrue(service.canConvert(BigDecimal.class, Short.class));
        Assertions.assertTrue(service.canConvert(BigDecimal.class, Integer.class));
        Assertions.assertTrue(service.canConvert(BigDecimal.class, Long.class));
        Assertions.assertTrue(service.canConvert(BigDecimal.class, Float.class));
        Assertions.assertTrue(service.canConvert(BigDecimal.class, Double.class));
        Assertions.assertTrue(service.canConvert(BigDecimal.class, Boolean.class));
        Assertions.assertTrue(service.canConvert(BigDecimal.class, String.class));
    }


}
