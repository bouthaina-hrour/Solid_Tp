package controllers;

import models.Pokemon;
import models.PokemonWithDesc;
import org.json.simple.JSONObject;
import services.ApiPokemonService;
import services.DbPokemonService;
import services.PokemonService;

import java.sql.ResultSet;
import java.sql.SQLException;


public class PokemonController {
    //my controller depends on the service abstraction and not the implementation
    public PokemonService pokemonService;
    int size;



    public PokemonController(PokemonService pokemonService,int size) {
        this.size=size;
        this.pokemonService = pokemonService;
    }


    // this function use the pokemonService class to get raw data then instantiate pokemonModel
    public Pokemon getPokemon(int id) throws SQLException {
        Pokemon pokemon=null;
        if(size==1){
            pokemon =new Pokemon();
            pokemonService=new ApiPokemonService();
            JSONObject pokemonObj= (JSONObject) pokemonService.getPokemon(id);
            pokemon.setId(id);
            pokemon.setName(""+pokemonObj.get("name"));
            pokemon.setHeight(Integer.valueOf((""+ pokemonObj.get("height"))));
            pokemon.setWeight(Integer.valueOf(""+ pokemonObj.get("weight")));

    }else if(size==2){
            pokemon= new PokemonWithDesc();
            pokemonService=new DbPokemonService();
            ResultSet pokemonresult= (ResultSet) pokemonService.getPokemon(id);
            pokemon.setId(id);
            pokemon.setName(pokemonresult.getString("name"));
            ((PokemonWithDesc)pokemon).setDescription(pokemonresult.getString("description"));
            pokemon.setHeight(pokemonresult.getInt("height"));
            pokemon.setWeight(pokemonresult.getInt("weight"));

        }
        return pokemon;
    }


}
