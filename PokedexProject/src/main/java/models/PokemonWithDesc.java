package models;

public class PokemonWithDesc extends Pokemon{
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PokemonWithDesc() {
    }

    public PokemonWithDesc(String description) {

        this.description = description;
    }
}
