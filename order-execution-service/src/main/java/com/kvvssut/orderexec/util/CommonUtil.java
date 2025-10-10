package com.kvvssut.orderexec.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class CommonUtil {

    public static final int PRECISION = 2;

    private CommonUtil() { }

    public static BigDecimal parseBigDecimal(String value) {
        return new BigDecimal(value).setScale(2, RoundingMode.HALF_UP);
    }
}
