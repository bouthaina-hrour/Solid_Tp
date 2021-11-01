package utilities;

import views.HtmlGeneratorInterface;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileLogUtility {
    public static void logHtmlToFile(String filePath, HtmlGeneratorInterface htmlGenerator) throws IOException {
        Files.write(Paths.get(filePath), htmlGenerator.generateHtml().getBytes(StandardCharsets.UTF_8));
    }
}