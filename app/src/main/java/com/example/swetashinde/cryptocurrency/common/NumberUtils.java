package com.example.swetashinde.cryptocurrency.common;

import java.util.Arrays;

/**
 * Created by swetashinde on 4/29/18.
 */

public class NumberUtils {
    public static final String formatTo(float receiver, int numberOfDecimals) {
        String temp = "%." + numberOfDecimals + 'f';
        Object[] objects = new Object[]{Float.valueOf(receiver)};
        String result = String.format(temp, Arrays.copyOf(objects, objects.length));
        return result;
    }
}
