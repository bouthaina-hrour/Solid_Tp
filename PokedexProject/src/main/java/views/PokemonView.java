package views;

import controllers.PokemonController;
import models.Pokemon;
import models.AdvancedPokemon;

import java.sql.SQLException;

public class PokemonView {

    //this class depends on the pokemon controller which instantiate our model
    PokemonController pokemonController;

    public PokemonView(PokemonController pokemonController) {
        this.pokemonController = pokemonController;
    }
   // representations for the final user
    public void showPokemon(int id) throws SQLException {

        Pokemon pokemon ;
        pokemon=pokemonController.getPokemon(id);

        System.out.println("Pokemon name " + pokemon.getName());
        System.out.println("Pokemon : weight (" +
                pokemon.getWeight()+
                "), height (" +
                pokemon.getHeight() +
                ")"
        );
    if(pokemon instanceof AdvancedPokemon){
            System.out.println("Pokemon description " + ((AdvancedPokemon) pokemon).getDescription());
        }
    }
}
