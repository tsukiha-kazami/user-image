package com.kkb.bigdata.sparkestag.etl;

import com.kkb.bigdata.sparkestag.support.SparkUtils;
import com.kkb.bigdata.sparkestag.support.date.DateStyle;
import com.kkb.bigdata.sparkestag.support.date.DateUtil;
import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class WowEtl {


    /**
     * reg count wow (week on week/  M O M)
     *
     * @param session
     */
    public static List<Reg> regCount(SparkSession session) {

        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate now = LocalDate.of(2019, Month.NOVEMBER, 30);
        Date nowDaySeven = Date.from(now.atStartOfDay(zoneId).toInstant());
        Date nowDayOne = DateUtil.addDay(nowDaySeven, -7);
        Date lastDaySeven = DateUtil.addDay(nowDayOne, -7);

        // lastDaySeven nowDaySeven

        // date_format(日期字段,'yyyy-MM-dd')
        String sql = "select date_format(create_time,'yyyy-MM-dd') as day," +
                " count(id) as regCount from i_member.t_member where create_time >='%s' " +
                " and create_time < '%s' group by date_format(create_time,'yyyy-MM-dd')";
        sql = String.format(sql, DateUtil.DateToString(lastDaySeven, DateStyle.YYYY_MM_DD_HH_MM_SS),
                DateUtil.DateToString(nowDaySeven, DateStyle.YYYY_MM_DD_HH_MM_SS));
        Dataset<Row> dataset = session.sql(sql);
        List<String> list = dataset.toJSON().collectAsList();
        List<Reg> collect = list.stream().map(str -> JSON.parseObject(str, Reg.class)).collect(Collectors.toList());
        return collect;
    }

    /**
     * order count wow
     *
     * @param session
     * @return
     */
    public static List<Order> orderCount(SparkSession session) {
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate now = LocalDate.of(2019, Month.NOVEMBER, 30);
        Date nowDaySeven = Date.from(now.atStartOfDay(zoneId).toInstant());
        Date nowDayOne = DateUtil.addDay(nowDaySeven, -7);
        Date lastDaySeven = DateUtil.addDay(nowDayOne, -7);
        // i_order.t_order

        String sql = "select date_format(create_time,'yyyy-MM-dd') as day," +
                " count(order_id) as orderCount from i_order.t_order where create_time >='%s' and create_time < '%s' " +
                " group by date_format(create_time,'yyyy-MM-dd')";
        sql = String.format(sql, DateUtil.DateToString(lastDaySeven, DateStyle.YYYY_MM_DD_HH_MM_SS),
                DateUtil.DateToString(nowDaySeven, DateStyle.YYYY_MM_DD_HH_MM_SS));
        Dataset<Row> dataset = session.sql(sql);

        List<String> list = dataset.toJSON().collectAsList();
        List<Order> collect = list.stream().map(str -> JSON.parseObject(str, Order.class)).collect(Collectors.toList());
        return collect;

    }


    public static void main(String[] args) {
        SparkSession session = SparkUtils.initSession();
        List<Reg> regs = regCount(session);
        List<Order> orders = orderCount(session);
        System.out.println("======" + regs);
        System.out.println("======" + orders);

    }


    @Data
    static class Reg {
        private String day;
        private Integer regCount;
    }

    @Data
    static class Order {
        private String day;
        private Integer orderCount;
    }


}
