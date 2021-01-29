package com.kkb.flink.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.flink.table.annotation.DataTypeHint;

/**
 * @author taochanglian
 * @since 2020-07-31 16:29
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestRecord {
    private Integer num;
    private Long ts;
    private String vin;
    private StatusKeyValueMap statusKeyValueMap;
}


