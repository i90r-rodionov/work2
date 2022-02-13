package org.homework.igorr.api.config;

import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.homework.igorr.api.RestScanMarker;
import org.homework.igorr.core.utils.DateTimeUtils;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.format.DateTimeFormatter;

@Configuration
@ComponentScan(basePackageClasses = RestScanMarker.class)
//@ComponentScan(basePackages = {
//        "org.homework.igorr.api.advice",
//        "org.homework.igorr.api.controller"
//})
public class RestConfig {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jacksonCustomizer() {
        return builder -> {
            builder.serializerByType(Long.class, new ToStringSerializer());
            builder.serializerByType(long.class, new ToStringSerializer());
            //
            builder.serializerByType(BigDecimal.class, new ToStringSerializer());
            builder.serializerByType(BigInteger.class, new ToStringSerializer());
            //
            builder.serializers(new LocalDateSerializer(DateTimeFormatter.ISO_LOCAL_DATE));
            builder.serializers(new LocalDateTimeSerializer(DateTimeUtils.TIME_FORMAT));


        };
    }
}
