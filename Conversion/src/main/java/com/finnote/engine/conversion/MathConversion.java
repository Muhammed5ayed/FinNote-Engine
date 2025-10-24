package com.finnote.engine.conversion;

import org.springframework.beans.BeansException;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.GenericConversionService;

import java.math.BigDecimal;

@Configuration("com.finnote.conversion.MathConversion")
public class MathConversion {

    @Bean("com.finnote.conversion.MathConversion.conversion")
    ConversionService install(ApplicationContext context) {
        try {
            ConversionService service = context.getBean(ConversionService.class);
            if (service instanceof GenericConversionService)
                installMath((GenericConversionService) service);
            return null;
        } catch (BeansException e) {
            ApplicationConversionService service = new ApplicationConversionService();
            installMath(service);
            return service;
        }
    }

    void installMath(GenericConversionService service) {
        Converter<String, Double> converter = new Converter<String, Double>() {
            @Override
            public Double convert(String source) {
                return Double.valueOf(source);
            }
        };
        service.addConverter(new Converter<Byte, BigDecimal>() {
            @Override
            public BigDecimal convert(Byte val) {
                return new BigDecimal(val);
            }
        });
        service.addConverter(new Converter<Short, BigDecimal>() {
            @Override
            public BigDecimal convert(Short val) {
                return new BigDecimal(val);
            }
        });
        service.addConverter(new Converter<Integer, BigDecimal>() {
            @Override
            public BigDecimal convert(Integer val) {
                return new BigDecimal(val);
            }
        });
        service.addConverter(new Converter<Long, BigDecimal>() {
            @Override
            public BigDecimal convert(Long val) {
                return new BigDecimal(val);
            }
        });
        service.addConverter(new Converter<Float, BigDecimal>() {
            @Override
            public BigDecimal convert(Float val) {
                return new BigDecimal(val);
            }
        });
        service.addConverter(new Converter<Double, BigDecimal>() {
            @Override
            public BigDecimal convert(Double val) {
                return new BigDecimal(val);
            }
        });
        service.addConverter(new Converter<Boolean, BigDecimal>() {
            @Override
            public BigDecimal convert(Boolean v) {
                return v ? new BigDecimal(1) : new BigDecimal(0);
            }
        });
        service.addConverter(new Converter<String, BigDecimal>() {
            @Override
            public BigDecimal convert(String val) {
                return new BigDecimal(val);
            }
        });


        service.addConverter(new Converter<BigDecimal, Byte>() {
            @Override
            public Byte convert(BigDecimal bigDecimal) {
                return bigDecimal.byteValue();
            }
        });
        service.addConverter(new Converter<BigDecimal, Short>() {
            @Override
            public Short convert(BigDecimal bigDecimal) {
                return bigDecimal.shortValue();
            }
        });
        service.addConverter(new Converter<BigDecimal, Integer>() {
            @Override
            public Integer convert(BigDecimal bigDecimal) {
                return bigDecimal.intValue();
            }
        });
        service.addConverter(new Converter<BigDecimal, Long>() {
            @Override
            public Long convert(BigDecimal bigDecimal) {
                return bigDecimal.longValue();
            }
        });
        service.addConverter(new Converter<BigDecimal, Float>() {
            @Override
            public Float convert(BigDecimal bigDecimal) {
                return bigDecimal.floatValue();
            }
        });
        service.addConverter(new Converter<BigDecimal, Double>() {
            @Override
            public Double convert(BigDecimal bigDecimal) {
                return bigDecimal.doubleValue();
            }
        });
        service.addConverter(new Converter<BigDecimal, Boolean>() {
            @Override
            public Boolean convert(BigDecimal v) {
                return (v.intValue() % 2) == 1;
            }
        });
        service.addConverter(new Converter<BigDecimal, String>() {
            @Override
            public String convert(BigDecimal bigDecimal) {
                return bigDecimal.toString();
            }
        });

    }

}
