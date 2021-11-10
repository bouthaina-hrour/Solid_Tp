package views;


import models.Pokemon;
import models.AdvancedPokemon;

/**The view class generates representations for the final user
 * implements two interfaces that are two different representations (Text and Html)
 **/


public class PokemonView implements HtmlGeneratorInterface,TextGeneratorInterface {
    //depends on the pokemon model
    Pokemon pokemon;

    public PokemonView(Pokemon pokemon) {
        this.pokemon = pokemon;
    }
    /**generates html document showing infos of pokemon**/
    @Override
    public String generateHtml() {
        String text ="<h1>"+pokemon.getName()+"</h1>\n" +
                "<ul>\n" +
                "<li> Id: "+pokemon.getId()+"</li>\n" +
                "<li>Height :"+ pokemon.getHeight()+"</li>\n" +
                "<li>Weight : "+pokemon.getWeight()+"</li>\n" ;
        //adds description or not based on the instance of pokemon(advanced or not)
        if(pokemon instanceof AdvancedPokemon){
            text+="<li>Description : " + ((AdvancedPokemon) pokemon).getDescription()+"</ul>";
        }
        else
            text+="</ul>";
        return text;
    }
    /**generates text description showing infos of pokemon**/
    @Override
    public String generateText() {
        String text ="name " + pokemon.getName()+"\n weight (" +
                pokemon.getWeight()+
                "), \nheight (" +
                pokemon.getHeight() +
                ")";
        /**adds description or not based on the instance of pokemon(advanced or not)**/

        if(pokemon instanceof AdvancedPokemon){
            text+="\nPokemon description :" + ((AdvancedPokemon) pokemon).getDescription();
        }

        return text;
    }
}
