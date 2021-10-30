package com.example.pokedex;


import controllers.PokemonController;
import services.ApiPokemonService;
import services.PokemonService;
import views.PokemonView;

import java.sql.SQLException;

public class Pokedex {

    public static void main(String[] args) throws SQLException {
        int size = args.length;
        System.out.println("It's working !");
        if (args.length > 0) {
            System.out.println("Vous avez fourni l'argument " + args[0]);
        }
        PokemonService pokemonService = null;
        PokemonController pokemonController=new PokemonController(pokemonService,size);
        PokemonView pokemonView=new PokemonView(pokemonController);
        pokemonView.showPokemon(Integer.valueOf(args[0]));
    }
    public String getName(){
        return "Hello";
    }
    }




