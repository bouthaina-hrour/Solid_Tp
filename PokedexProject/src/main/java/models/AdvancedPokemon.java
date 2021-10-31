package models;

public class AdvancedPokemon extends Pokemon{
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AdvancedPokemon() {
    }

    public AdvancedPokemon(String description) {

        this.description = description;
    }
}
