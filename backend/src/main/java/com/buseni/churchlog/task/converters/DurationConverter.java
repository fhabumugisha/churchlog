package com.buseni.churchlog.task.converters;


import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Converter(autoApply = true)
@Slf4j
public class DurationConverter implements AttributeConverter<Duration, Long> {

    @Override
    public Long convertToDatabaseColumn(Duration attribute) {
        log.info("Convert to Long");
        if(null !=  attribute){
            return attribute.toMinutes();
        }
        return null;
    }

    @Override
    public Duration convertToEntityAttribute(Long duration) {
        log.info("Convert to Duration");
        if(duration != null){
            return Duration.of(duration, ChronoUnit.MINUTES);
        }
       return null;
    }
}
