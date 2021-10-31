package services;

import org.json.simple.JSONObject;

import java.util.Map;

public interface PokemonService {
    public Map<String,Object> getPokemonData(int id);
}
