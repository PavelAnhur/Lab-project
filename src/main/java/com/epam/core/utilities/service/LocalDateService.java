package com.epam.core.utilities.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class LocalDateService {

    private LocalDateService() {
    }

    public static List<LocalDate> getLocalDatesFromStringDates(final List<String> datesAsString) {
        List<LocalDate> dateList = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        datesAsString.forEach(dateAsString -> {
            LocalDate date = LocalDate.parse(dateAsString, formatter);
            dateList.add(date);
        });
        return dateList;
    }

    public static String getCurrentDateAndTime(final String dateTimePattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateTimePattern);
        LocalDateTime now = LocalDateTime.now();
        return dateTimeFormatter.format(now);
    }
}
