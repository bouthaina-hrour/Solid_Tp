package com.example.pokedex;

import controllers.PokemonController;
import models.Pokemon;
import services.ApiPokemonService;
import services.DbPokemonService;
import services.PokemonService;
import utilities.ConsoleLogUtility;
import utilities.FileLogUtility;
import views.PokemonView;
import java.io.IOException;


public class Pokedex {

    public static void main(String[] args) throws  IOException {
        /**
         * output for html representation
         */
        String outputFile="output.html";
        System.out.println("It's working !");
        if (args.length > 0) {
            System.out.println("Vous avez fourni l'argument " + args[0]);
        }
        PokemonService pokemonService = null;
        switch (args.length){
            /**
             * if the user give just the id of pokemon it instantiates a {@link ApiPokemonService}
             */
            case 1:
                pokemonService=new ApiPokemonService();
                break;
            /**
             * if the user enters an id and a file
             */
            case 2:
                /**
                 * it make sure it is an sqlite file and instantiates a {@link DbPokemonService}
                 */
                if(args[1].endsWith(".sqlite"))
                    pokemonService=new DbPokemonService(args[1]);
                break;
        }
        PokemonController pokemonController=new PokemonController(pokemonService);
        /**
         * the controller gets an instance of {@link Pokemon}
         */
        Pokemon pokemon=pokemonController.getPokemon(Integer.valueOf(args[0]));
        PokemonView pokemonView=new PokemonView(pokemon);
        /**
         * shows infos of pokemon at the console
         */
        ConsoleLogUtility.logTextToConsole(pokemonView);
        /**
         * shows infos of pokemon at an html file
         */
        FileLogUtility.logHtmlToFile(outputFile,pokemonView);

    }
    public String getName(){
        return "Hello";
    }
}





