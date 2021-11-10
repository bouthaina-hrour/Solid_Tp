package services;
import java.util.Map;
/**This interface is the abstraction of services to access to source of data
 * It respect the open-closed principle
 */

public interface PokemonService {
    /**It have one method to get unmodeled data in map format
     * Keys represents attributes of a pokemon (Id ,height,...) and values are correspending values
     */

     Map<String,Object> getPokemonData(int id);
}
