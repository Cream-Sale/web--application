package com.creamsale.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class FileUtils {

    /**
     * @param relativeFilePath the relative path to the file in the resources folder
     * @return String content of the file
     */
    public static String readFromResourceFile(String relativeFilePath) {
        String string = "";
        ClassLoader classLoader = FileUtils.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream(relativeFilePath);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(resourceAsStream))) {
            string = br.lines().collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            throw new RuntimeException("The data that was necessary for the tests hasn't been read from the file because of the error \r\n"
                    + e.getLocalizedMessage());
        }
        return string;
    }
}
