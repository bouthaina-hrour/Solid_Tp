package com.example.pokedex;



import controllers.PokemonController;
import models.AdvancedPokemon;
import models.Pokemon;
import org.junit.Assert;
import org.junit.Test;
import services.PokemonService;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class PokemonsControllerTest {

    /**
     * Ce test vérifie que la méthode `getPokemon` de la classe {@link PokemonController}
     * renvoie bien une instance de la classe {@link AdvancedPokemon}, dans le cas où le service
     * qui implémente l'interface {@link PokemonService} renvoit bien des données qui comprennent
     * une description de pokémon.
     * (dans le cas contraire, c'est une instance de la classe {@link Pokemon} qui serait renvoyée).
     *
     * Pour celà nous implémentons un service mock, qui implémente l'interface {@link PokemonService}
     * et qui renvoit un jeu de données de test, comprenant une description de pokémon.
     *
     * Le test vérifie ensuite que l'instance AdvancedPokemon a bien tous les attributs
     * aux valeurs attendues, compte tenu des données de tests renvoyées par notre mock.
     */
    @Test
    public void getPokemon() {
        PokemonController pokemonsController = new PokemonController(new PokemonFetcherMock());
        Pokemon pokemon = null;

        try {
            pokemon = pokemonsController.getPokemon(2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * The fetcher returned a description, test that the controller returns an instance
         * of AdvancedPokemon
         */
        Assert.assertTrue(pokemon instanceof AdvancedPokemon);
        AdvancedPokemon advancedPokemon = (AdvancedPokemon) pokemon;

        /**
         * Test that the controller created the pokemon instance with all
         * the correct data
         */
        Assert.assertEquals(2, pokemon.getId());
        Assert.assertEquals("Poketest", pokemon.getName());
        Assert.assertEquals(22, pokemon.getHeight());
        Assert.assertEquals(33, pokemon.getWeight());
        Assert.assertEquals("Poke test description", advancedPokemon.getDescription());

    }

    class PokemonFetcherMock implements PokemonService {
        @Override
        public Map<String, Object> getPokemonData(int id) {
            Map<String,Object> datas =new HashMap<String,Object>();
            datas.put("id",id);
            datas.put("name","Poketest");
            datas.put("height",22);
            datas.put("weight",33);
            datas.put("description","Poke test description");
            return datas;
        }
        // TODO
    }
}