package com.kkb.flink.stream.util;

import lombok.Getter;

/**
 * @author taochanglian
 * @since 2020-08-11 16:48
 */
@Getter
public enum TableTypeEnum {
    HIVE(1,"HIVE"),
    KAFKA(2,"KAFKA");

    public final Integer type;
    public final String value;

    TableTypeEnum(Integer type, String value) {
        this.type = type;
        this.value = value;

    }

}
