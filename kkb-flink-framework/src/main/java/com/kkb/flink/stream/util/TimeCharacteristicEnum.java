package com.kkb.flink.stream.util;

import lombok.Getter;

@Getter
public enum TimeCharacteristicEnum {
    EVENTTIME(1,"eventTime"),
    INGESTIONTIME(2,"ingestionTime"),
    PROCESSINGTIME(3,"processingTime");

    public final Integer type;
    public final String value;

    TimeCharacteristicEnum(Integer type, String value) {
        this.type = type;
        this.value = value;

    }
}
