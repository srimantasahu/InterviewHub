package com.kvvssut.orderexec.helper;

import com.kvvssut.orderexec.bean.Order;
import com.kvvssut.orderexec.bean.Side;

import java.util.Arrays;

public class OrderParser {

    private static final String VALUES_DELIMITER = ",";
    private static final int NUM_COLUMNS = 5;
    private static final int SIDE_COLUMN_IDX = 1;

    public Order parseOrderText(String text) {
        String[] values = text.split(VALUES_DELIMITER);

        if (values.length != NUM_COLUMNS) {
            System.out.println("Invalid order: " + text);
            return null;
        }

        try {
            Side side = Side.valueOf(values[SIDE_COLUMN_IDX].trim());

            return new Order(values[0].trim(), side, Double.parseDouble(values[2].trim()), Integer.parseInt(values[3].trim()), Long.parseLong(values[4].trim()));
        } catch (Exception e) {
            System.out.println("Invalid order values: " + Arrays.toString(values));
        }

        return null;
    }

}
