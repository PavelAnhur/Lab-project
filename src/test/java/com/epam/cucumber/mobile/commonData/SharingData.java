package com.epam.cucumber.mobile.commonData;

import lombok.Getter;

import java.util.HashMap;

public class SharingData {

    @Getter
    private HashMap<String, String> dataForTest;

    public void addDataToMap(final String key, final String value) {
        if (dataForTest == null) {
            dataForTest = new HashMap<>();
        }
        dataForTest.put(key, value);
    }
}
