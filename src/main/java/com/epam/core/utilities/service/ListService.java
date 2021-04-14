package com.epam.core.utilities.service;

import java.util.List;

public final class ListService {

    private ListService() {
    }

    public static boolean isListDoubleInDescendingOrder(final List<Double> elements, final double maxValue) {
        double value = maxValue;
        for (double element : elements) {
            if (element <= value) {
                value = element;
            } else {
                return false;
            }
        }
        return true;
    }
}
