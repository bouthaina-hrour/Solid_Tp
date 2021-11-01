package views;

import controllers.PokemonController;
import models.Pokemon;
import models.AdvancedPokemon;

import java.sql.SQLException;
//this class depends on the pokemon controller which instantiate our model
public class PokemonView implements HtmlGeneratorInterface,TextGeneratorInterface {
    Pokemon pokemon;


    public PokemonView(Pokemon pokemon) {
        this.pokemon = pokemon;
    }
   // representations for the final user
    /*public void showPokemon(int id) throws SQLException {


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
    }*/

    @Override
    public String generateHtml() {
        String text ="<h1>"+pokemon.getName()+"</h1>\n" +
                "<ul>\n" +
                "<li> Id: "+pokemon.getId()+"</li>\n" +
                "<li>Height :"+ pokemon.getHeight()+"</li>\n" +
                "<li>Weight : "+pokemon.getWeight()+"</li>\n" ;
        if(pokemon instanceof AdvancedPokemon){
            text+="<li>Description : " + ((AdvancedPokemon) pokemon).getDescription()+"</ul>";
        }
        else
            text+="</ul>";

        return text;
    }

    @Override
    public String generateText() {
        String text ="name " + pokemon.getName()+"\n weight (" +
                pokemon.getWeight()+
                "), \nheight (" +
                pokemon.getHeight() +
                ")";
        if(pokemon instanceof AdvancedPokemon){
            text+="\nPokemon description :" + ((AdvancedPokemon) pokemon).getDescription();
        }

        return text;
    }
}
