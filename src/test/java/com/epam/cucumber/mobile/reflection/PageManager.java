package com.epam.cucumber.mobile.reflection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public final class PageManager {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private static Map<String, Object> mapOfPages;

    private PageManager() {
    }

    public static <T> T getPage(final Class<T> clazz) {
        if (mapOfPages == null) {
            mapOfPages = new HashMap<>();
        }
        if (mapOfPages.get(clazz.getName()) == null) {
            mapOfPages.put(clazz.getName(), createPageObject(clazz));
        }
        return (T) mapOfPages.get(clazz.getName());
    }

    private static <T> T createPageObject(final Class<T> clazz) {
        T pageObject = null;
        try {
            pageObject = clazz.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException
                         | NoSuchMethodException | InvocationTargetException e) {
            LOGGER.error(e.getMessage());
        }
        return pageObject;
    }
}
