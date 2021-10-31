package com.example.pokedex;


import controllers.PokemonController;
import services.ApiPokemonService;
import services.DbPokemonService;
import services.PokemonService;
import views.PokemonView;

import java.sql.SQLException;

public class Pokedex {

    public static void main(String[] args) throws SQLException {

        System.out.println("It's working !");
        if (args.length > 0) {
            System.out.println("Vous avez fourni l'argument " + args[0]);
        }
        PokemonService pokemonService = null;
        switch (args.length){
            case 1:
                pokemonService=new ApiPokemonService();
                break;
            case 2:
                if(args[1].endsWith(".sqlite"))
                    pokemonService=new DbPokemonService(args[1]);
                break;
        }
        PokemonController pokemonController=new PokemonController(pokemonService);
        PokemonView pokemonView=new PokemonView(pokemonController);
        pokemonView.showPokemon(Integer.valueOf(args[0]));
    }
    public String getName(){
        return "Hello";
    }
}





