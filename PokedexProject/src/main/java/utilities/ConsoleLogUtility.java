package utilities;

import views.PokemonView;
import views.TextGeneratorInterface;

public class ConsoleLogUtility {
    public static void logTextToConsole(TextGeneratorInterface generator) {
        System.out.println(generator.generateText());
    }
}