package test.automation.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class HelperMethods {
    public static final String EMAIL =
            new Random().ints(8, 0, 36)
                    .mapToObj(i -> i < 26 ? (char)('a' + i) : (char)('0' + i - 26))
                    .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                    .toString() + "@ibsu.edu.ge";

    public static String createFile(String fileName, String content) {
        File file = new File(System.getProperty("java.io.tmpdir"), fileName);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file.getAbsolutePath();
    }

}
