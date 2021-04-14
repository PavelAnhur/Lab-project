package com.epam.core.utilities.service;

import java.security.SecureRandom;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class StringService {
    private static final String REGEXP = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final SecureRandom RANDOM = new SecureRandom();

    private StringService() {
    }

    public static String getRandomString(final int len) {
        StringBuilder builder = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            builder.append(REGEXP.charAt(RANDOM.nextInt(REGEXP.length())));
        }
        return builder.toString();
    }

    public static String getFirstWordFromString(final String string, final String regex) {
        String[] wordsFromString = string.split(regex);
        return wordsFromString[0];
    }

    public static List<String> getWordsFromString(final String stringForParsing) {
        return Arrays.asList(stringForParsing.split(" "));
    }

    public static String getCapitalizedWord(final String word) {
        String firstLetterInWordToUpperCase = word.substring(0, 1).toUpperCase();
        return firstLetterInWordToUpperCase + word.substring(1);
    }

    public static long getNumberOfEqualWordsInStrings(final String firstString, final String secondString) {
        List<String> wordsFromFirstString = getWordsFromString(firstString.toLowerCase());
        List<String> wordsFromSecondString = getWordsFromString(secondString.toLowerCase());
        return wordsFromFirstString.stream().filter(wordsFromSecondString::contains).count();
    }

    public static String getCurrentTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }

    public static long getCountWords() {
        String string = "Write a Java program to compare a given string to another string ignoring case considerations";
        String[] words = string.split(" ");
        return Arrays.stream(words).filter(word -> word.contains("string")).count();
    }

    public static void removeDuplicates() {
        Integer[] ints = {1, 2, 5, 7, 2, 4, 5, 8, 0, 5};
        Arrays.stream(ints).distinct().forEach(System.out::println);
    }

    public static void main(String[] args) {
        removeDuplicates();
    }
}
