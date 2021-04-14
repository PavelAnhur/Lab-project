package com.epam.core.utilities.service;

import java.io.File;

public final class JsonService {
    private static final String PATH_TO_JSON_FILES = "src/test/resources/json/";

    private JsonService() {
    }

    public static File getJsonFile(final String fileName) {
        return new File(PATH_TO_JSON_FILES + fileName);
    }
}
