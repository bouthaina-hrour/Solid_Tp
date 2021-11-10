package controllers;

import models.Pokemon;
import models.AdvancedPokemon;
import services.PokemonService;

import java.sql.SQLException;
import java.util.Map;


public class PokemonController {
    //my controller depends on the service abstraction and not the implementation
    public PokemonService pokemonService;


    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    // this function use the pokemonService class to get raw data then instantiate pokemonModel
    public Pokemon getPokemon(int id) throws SQLException {

        Pokemon pokemon=new Pokemon();
        Map<String ,Object> datas=pokemonService.getPokemonData(id);

        pokemon.setId(id);
        pokemon.setName(""+datas.get("name"));
        pokemon.setHeight(Integer.valueOf((""+ datas.get("height"))));
        pokemon.setWeight(Integer.valueOf(""+ datas.get("weight")));
        if(datas.containsKey("description")){
            pokemon= new AdvancedPokemon();
            pokemon.setId(id);
            pokemon.setName(""+datas.get("name"));
            pokemon.setHeight(Integer.valueOf((""+ datas.get("height"))));
            pokemon.setWeight(Integer.valueOf(""+ datas.get("weight")));

            ((AdvancedPokemon)pokemon).setDescription(""+datas.get("description"));
        }








        return pokemon;
    }


}
